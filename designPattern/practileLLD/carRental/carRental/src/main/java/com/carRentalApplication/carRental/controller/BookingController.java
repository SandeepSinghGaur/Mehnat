package com.carRentalApplication.carRental.controller;

import com.carRentalApplication.carRental.dto.BookingRequestDto;
import com.carRentalApplication.carRental.dto.BookingResponseDto;
import com.carRentalApplication.carRental.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<BookingResponseDto> bookRide(@RequestBody BookingRequestDto bookingRequestDto) {
        return ResponseEntity.ok(bookingService.bookRide(bookingRequestDto));
    }
}
