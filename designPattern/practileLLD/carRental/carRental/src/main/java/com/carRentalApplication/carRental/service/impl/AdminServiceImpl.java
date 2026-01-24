package com.carRentalApplication.carRental.service.impl;

import com.carRentalApplication.carRental.dto.BranchDto;
import com.carRentalApplication.carRental.dto.CarDto;
import com.carRentalApplication.carRental.dto.PricingDto;
import com.carRentalApplication.carRental.entity.Branch;
import com.carRentalApplication.carRental.entity.Car;
import com.carRentalApplication.carRental.entity.Pricing;
import com.carRentalApplication.carRental.enums.CarStatus;
import com.carRentalApplication.carRental.repository.BranchRepository;
import com.carRentalApplication.carRental.repository.CarRepository;
import com.carRentalApplication.carRental.repository.PricingRepository;
import com.carRentalApplication.carRental.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final BranchRepository branchRepository;
    private final CarRepository carRepository;
    private final PricingRepository pricingRepository;

    @Override
    public Branch addBranch(BranchDto branchDto) {
        Branch branch = Branch.builder()
                .branchName(branchDto.getBranchName())
                .build();
        return branchRepository.save(branch);
    }

    @Override
    public Car addCar(CarDto carDto) {
        Branch branch = branchRepository.findById(carDto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found with ID: " + carDto.getBranchId()));

        Car car = Car.builder()
                .carName(carDto.getCarName())
                .carCategory(carDto.getCarCategory())
                .branch(branch)
                .currentStatus(CarStatus.FREE) // Default status
                .build();
        return carRepository.save(car);
    }

    @Override
    public Pricing addPricing(PricingDto pricingDto) {
        Branch branch = branchRepository.findById(pricingDto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found with ID: " + pricingDto.getBranchId()));

        Pricing pricing = Pricing.builder()
                .carType(pricingDto.getCarType())
                .perHourPrice(pricingDto.getPerHourPrice())
                .branch(branch)
                .build();
        return pricingRepository.save(pricing);
    }
}
