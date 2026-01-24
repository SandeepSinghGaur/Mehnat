package com.carRentalApplication.carRental.repository;

import com.carRentalApplication.carRental.entity.BookingStatus;
import com.carRentalApplication.carRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long> {

    @Query("SELECT COUNT(bs) > 0 FROM BookingStatus bs " +
            "WHERE bs.car = :car " +
            "AND (bs.timeOfBooking < :endTime AND bs.tillTimeOfBooked > :startTime)")
    boolean existsByCarAndOverlap(@Param("car") Car car,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);
}
