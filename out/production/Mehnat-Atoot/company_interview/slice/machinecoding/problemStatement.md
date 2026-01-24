
# Car Booking System (Single City)
## Problem Statement
Design and implement a backend system for booking cars within a single city. The city operates multiple branches, each managing its own fleet of cars.
## Domain Overview
### Branches
-   Each branch is uniquely identified by its **name**.
-   A branch owns a fleet of cars and maintains its own pricing configuration.
### Cars
-   Every car belongs to exactly **one branch**.
-   Supported car categories:
    -   `SEDAN`
    -   `SUV`
    -   `HATCHBACK`
-   Each car has a unique identifier within its branch (e.g., `carNumber`).
### Pricing Rules
-   Pricing is configured **per branch** and **per car category**.
-   Price is defined as **price per hour**.
-   All cars of the same category within a branch share the same price.
-   Pricing may change over time.
## Booking Rules
### User Request
A user requests a car by specifying:
-   **Car Category**
-   **Time Window** (`startDateTime`, `endDateTime`)
### Allocation Logic
The system must allocate **one available car** that satisfies the request using the following Priority:
1.  **Lowest Price**: Select the car with the lowest effective price for the duration.
2.  **Tie-Breaking**: If multiple cars have the same price, apply a deterministic rule:
    -   `branchName` (Alphabetical)
    -   `carNumber` (or ID)
### Constraints
-   A booking, once confirmed, **blocks** that car for the given time window.
-   **Overlapping bookings** for the same car are **not allowed**.
-   The system must ensure correctness even when multiple booking requests happen close together in time (Concurrency).
## Expectations
### Features
1.  **Onboarding**: Support adding new branches, cars, and pricing configurations.
2.  **Booking**: Users request bookings without needing to know which branch or specific car they are getting (System assigns the best match).

[//]: # (### Entities)

[//]: # (The following entities are identified for the implementation:)

[//]: # (-   **Branch**: `branchId`, `branchName`, `List<Car> cars`)

[//]: # (-   **Car**: `carID`, `carName`, `carCategory`, `branchId`)

[//]: # (    -   *CarStatus*: `Booked`, `Free`)

[//]: # (-   **Pricing**: `carType`, `perHourPrice`, `branchId`)

[//]: # (-   **Ride**: `rideID`, `carId`, `time`, `amount`)

[//]: # (-   **BookingStatus**: `carId`, `timeofbooking`, `tilltimeOFBooked`)