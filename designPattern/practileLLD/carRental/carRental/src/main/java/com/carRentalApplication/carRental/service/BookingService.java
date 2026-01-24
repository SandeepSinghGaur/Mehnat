package com.carRentalApplication.carRental.service;

import com.carRentalApplication.carRental.dto.BookingRequestDto;
import com.carRentalApplication.carRental.dto.BookingResponseDto;

public interface BookingService {
    BookingResponseDto bookRide(BookingRequestDto bookingRequestDto);
}
