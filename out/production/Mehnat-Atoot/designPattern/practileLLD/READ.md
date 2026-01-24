# System Design Problems – Requirements Document

This document lists popular **Low-Level Design (LLD)** problems frequently asked in **Flipkart, Uber, Swiggy, Upstox** interviews, along with clear functional and non-functional requirements.

---

## 1. Digital Wallet System (Flipkart)

### Functional Requirements
- User registration and authentication
- Add money to wallet
- Pay using wallet balance
- Transfer money between users
- View transaction history
- Refund support

### Non-Functional Requirements
- Consistency over availability
- Idempotent transactions
- High concurrency handling
- Secure transactions
- Audit logs

---

## 2. Rate Limiter (Uber, Flipkart)

### Functional Requirements
- Limit requests per user/IP/API key
- Support multiple strategies (Fixed window, Sliding window, Token bucket)
- Configurable rate limits
- Allow burst traffic

### Non-Functional Requirements
- Low latency
- Distributed support
- Fault tolerant
- Scalable

---

## 3. Concurrent In-Memory Publisher-Subscriber System (Uber)

### Functional Requirements
- Create topics
- Publish messages to topics
- Subscribe consumers to topics
- Asynchronous message delivery
- Offset management

### Non-Functional Requirements
- Thread-safe
- High throughput
- Non-blocking consumers
- In-memory only

---

## 4. Ride-Sharing Application (Flipkart)

### Functional Requirements
- User and driver onboarding
- Ride booking
- Driver matching
- Ride status tracking
- Fare calculation
- Ride cancellation

### Non-Functional Requirements
- Low latency matching
- High availability
- Location accuracy
- Scalable for peak hours

---

## 5. Coffee Machine (Flipkart)

### Functional Requirements
- Select beverage
- Manage ingredients
- Dispense drink
- Handle multiple outlets
- Refill ingredients

### Non-Functional Requirements
- Thread-safe dispensing
- Fast response
- Extensible for new drinks

---

## 6. Splitwise System (Swiggy, Flipkart, Upstox)

### Functional Requirements
- Create groups
- Add expenses
- Split equally or unequally
- Track balances
- Simplify debts

### Non-Functional Requirements
- Accurate calculations
- Idempotent operations
- Scalable for many users

---

## 7. In-Memory Task Scheduler Library (Uber)

### Functional Requirements
- Schedule tasks with delay
- Recurring tasks
- Cancel tasks
- Priority-based execution

### Non-Functional Requirements
- Thread-safe
- Accurate timing
- Low overhead
- In-memory only

---

## 8. Snakes & Ladders

### Functional Requirements
- Initialize board
- Add players
- Roll dice
- Move players
- Handle snakes and ladders
- Declare winner

### Non-Functional Requirements
- Deterministic behavior
- Extensible board size
- Simple design

---

## 9. Conference Room Management System (Flipkart)

### Functional Requirements
- Create meeting rooms
- Book rooms
- Cancel bookings
- Check room availability
- Conflict resolution

### Non-Functional Requirements
- Consistency
- Concurrent bookings handling
- Low latency

---

## 10. Online Coding Platform (Flipkart)

### Functional Requirements
- User authentication
- Problem listing
- Code submission
- Code execution
- Result evaluation
- Leaderboard

### Non-Functional Requirements
- Secure code execution
- Scalable judge system
- Low latency results

---

## 11. Movie Booking System

### Functional Requirements
- Browse movies
- Select seats
- Book tickets
- Payment processing
- Ticket cancellation

### Non-Functional Requirements
- Strong consistency (seat locking)
- High concurrency
- Fault tolerance

---

## 12. Parking Lot Design (Swiggy)

### Functional Requirements
- Add parking floors
- Park vehicle
- Remove vehicle
- Display availability
- Support multiple vehicle types

### Non-Functional Requirements
- Fast lookup
- Thread-safe operations
- Extensible design

---

## 13. Library Management System

### Functional Requirements
- Add books
- Issue books
- Return books
- Search catalog
- Fine calculation

### Non-Functional Requirements
- Data consistency
- Scalable inventory
- Reliable search

---

## Notes
- All systems should follow **OOP principles**
- Use **SOLID design**
- Prefer **interfaces and extensibility**
- Handle **concurrency where applicable**

---
