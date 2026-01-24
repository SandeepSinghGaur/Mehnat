package com.carRentalApplication.carRental.service;

import com.carRentalApplication.carRental.dto.BranchDto;
import com.carRentalApplication.carRental.dto.CarDto;
import com.carRentalApplication.carRental.dto.PricingDto;
import com.carRentalApplication.carRental.entity.Branch;
import com.carRentalApplication.carRental.entity.Car;
import com.carRentalApplication.carRental.entity.Pricing;

public interface AdminService {
    Branch addBranch(BranchDto branchDto);

    Car addCar(CarDto carDto);

    Pricing addPricing(PricingDto pricingDto);
}
