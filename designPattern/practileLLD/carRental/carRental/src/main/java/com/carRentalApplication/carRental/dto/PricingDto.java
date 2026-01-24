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
public class PricingDto {
    private CarCategory carType;
    private Double perHourPrice;
    private Long branchId;
}
