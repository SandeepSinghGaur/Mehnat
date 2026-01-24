package com.carRentalApplication.carRental.service.impl;

import com.carRentalApplication.carRental.dto.BookingRequestDto;
import com.carRentalApplication.carRental.dto.BookingResponseDto;
import com.carRentalApplication.carRental.entity.BookingStatus;
import com.carRentalApplication.carRental.entity.Car;
import com.carRentalApplication.carRental.entity.Pricing;
import com.carRentalApplication.carRental.entity.Ride;
import com.carRentalApplication.carRental.repository.BookingStatusRepository;
import com.carRentalApplication.carRental.repository.CarRepository;
import com.carRentalApplication.carRental.repository.PricingRepository;
import com.carRentalApplication.carRental.repository.RideRepository;
import com.carRentalApplication.carRental.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final CarRepository carRepository;
    private final BookingStatusRepository bookingStatusRepository;
    private final PricingRepository pricingRepository;
    private final RideRepository rideRepository;

    @Override
    @Transactional
    public BookingResponseDto bookRide(BookingRequestDto request) {
        // 1. Find all available cars sorted by price (asc), branch name (asc), car ID
        // (asc)
        List<Car> candidateCars = carRepository.findAvailableCars(
                request.getCarCategory(),
                request.getStartTime(),
                request.getEndTime());

        for (Car candidate : candidateCars) {
            // 2. Lock the car to prevent race conditions
            Car car = carRepository.findByIdWithLock(candidate.getCarID())
                    .orElseThrow(() -> new RuntimeException("Car not found: " + candidate.getCarID()));

            // 3. Double check availability after lock
            boolean isBooked = bookingStatusRepository.existsByCarAndOverlap(
                    car,
                    request.getStartTime(),
                    request.getEndTime());

            if (!isBooked) {
                // 4. Calculate Price
                // Finding pricing for the car's branch and category
                Pricing pricing = pricingRepository.findAll().stream()
                        .filter(p -> p.getBranch().getBranchId().equals(car.getBranch().getBranchId()) &&
                                p.getCarType() == car.getCarCategory())
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Pricing not found for car: " + car.getCarID()));

                long hours = Duration.between(request.getStartTime(), request.getEndTime()).toHours();
                // Ensure at least 1 hour charge if less than an hour, or handle per minute -
                // utilizing full hours for now as per "price per hour" spec
                if (hours == 0)
                    hours = 1;
                Double amount = pricing.getPerHourPrice() * hours;

                // 5. Create BookingStatus
                BookingStatus bookingStatus = BookingStatus.builder()
                        .car(car)
                        .timeOfBooking(request.getStartTime())
                        .tillTimeOfBooked(request.getEndTime())
                        .build();
                bookingStatusRepository.save(bookingStatus);

                // 6. Create Ride
                Ride ride = Ride.builder()
                        .car(car)
                        .time(request.getStartTime())
                        .amount(amount)
                        .build();
                Ride savedRide = rideRepository.save(ride);

                return BookingResponseDto.builder()
                        .rideId(savedRide.getRideID())
                        .carId(car.getCarID())
                        .branchName(car.getBranch().getBranchName())
                        .amount(amount)
                        .build();
            }
            // If booked, continue to next candidate
        }

        throw new RuntimeException("No cars available for the selected category and time.");
    }
}
