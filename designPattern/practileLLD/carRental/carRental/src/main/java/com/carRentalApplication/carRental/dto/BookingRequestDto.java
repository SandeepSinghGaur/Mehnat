package com.carRentalApplication.carRental.dto;

import com.carRentalApplication.carRental.enums.CarCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {
    private CarCategory carCategory;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
