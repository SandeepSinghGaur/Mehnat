package com.carRentalApplication.carRental.entity;

import com.carRentalApplication.carRental.enums.CarCategory;
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
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CarCategory carType;

    private Double perHourPrice;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
