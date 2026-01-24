package com.carRentalApplication.carRental.controller;

import com.carRentalApplication.carRental.dto.BranchDto;
import com.carRentalApplication.carRental.dto.CarDto;
import com.carRentalApplication.carRental.dto.PricingDto;
import com.carRentalApplication.carRental.entity.Branch;
import com.carRentalApplication.carRental.entity.Car;
import com.carRentalApplication.carRental.entity.Pricing;
import com.carRentalApplication.carRental.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/branches")
    public ResponseEntity<Branch> addBranch(@RequestBody BranchDto branchDto) {
        return ResponseEntity.ok(adminService.addBranch(branchDto));
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody CarDto carDto) {
        return ResponseEntity.ok(adminService.addCar(carDto));
    }

    @PostMapping("/pricing")
    public ResponseEntity<Pricing> addPricing(@RequestBody PricingDto pricingDto) {
        return ResponseEntity.ok(adminService.addPricing(pricingDto));
    }
}
