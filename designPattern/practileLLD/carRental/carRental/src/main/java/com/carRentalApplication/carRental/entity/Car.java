package com.carRentalApplication.carRental.entity;

import com.carRentalApplication.carRental.enums.CarCategory;
import com.carRentalApplication.carRental.enums.CarStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carID;

    private String carName;

    @Enumerated(EnumType.STRING)
    private CarCategory carCategory;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Enumerated(EnumType.STRING)
    private CarStatus currentStatus;
}
