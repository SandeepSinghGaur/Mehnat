package com.carRentalApplication.carRental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rideID;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime time;

    private Double amount;
}
