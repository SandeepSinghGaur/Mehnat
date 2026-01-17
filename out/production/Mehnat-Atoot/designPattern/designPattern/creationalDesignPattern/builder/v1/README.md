# Builder Design Pattern – UserExam Example

## 📌 Overview
The **Builder Design Pattern** is used to construct complex objects step by step.  
It is especially useful when an object has many attributes, requires validation during creation, or needs to remain immutable after construction.

This project demonstrates a **custom Builder implementation** without using Lombok or Spring Boot.

---

## 🧠 Why Use Builder Pattern?
- Avoids constructor telescoping
- Improves code readability
- Supports optional parameters
- Enables validation before object creation
- Helps create immutable objects

---

## 🏗️ Design Structure

### Main Components
- **`UserExam`** – Main class representing the final object
- **`UserBuilder`** – Static inner builder class used to construct `UserExam`

---

## 🔹 Key Characteristics

- `UserExam` and `UserBuilder` usually contain the same attributes
- `UserExam` exposes a static `getBuilder()` method
- Builder setter methods return `this` to enable **method chaining**
- The `build()` method:
    - Validates required attributes
    - Creates and returns a `UserExam` instance

---

## 🧪 Example Usage

```java
UserExam exam = UserExam.getBuilder()
        .setName("Sandeep")
        .setAge(22)
        .setEmail("sandeep@gmail.com")
        .setSubject("Java")
        .setPaid(true)
        .build();
