package com.carRentalApplication.carRental.dto;

import com.carRentalApplication.carRental.enums.CarCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private String carName;
    private CarCategory carCategory;
    private Long branchId;
}
