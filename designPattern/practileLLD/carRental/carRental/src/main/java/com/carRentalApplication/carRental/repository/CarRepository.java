package com.carRentalApplication.carRental.repository;

import com.carRentalApplication.carRental.entity.Car;

import com.carRentalApplication.carRental.enums.CarCategory;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c " +
            "JOIN c.branch b " +
            "JOIN Pricing p ON p.branch = b AND p.carType = c.carCategory " +
            "WHERE c.carCategory = :category " +
            "AND c.carID NOT IN (" +
            "  SELECT bs.car.carID FROM BookingStatus bs " +
            "  WHERE bs.timeOfBooking < :endTime AND bs.tillTimeOfBooked > :startTime" +
            ") " +
            "ORDER BY p.perHourPrice ASC, b.branchName ASC, c.carID ASC")
    List<Car> findAvailableCars(@Param("category") CarCategory category,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM Car c WHERE c.carID = :id")
    Optional<Car> findByIdWithLock(@Param("id") Long id);
}
