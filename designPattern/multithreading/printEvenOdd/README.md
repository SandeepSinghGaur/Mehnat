# Print Odd and Even Numbers in Sequence Using Threads

## 📌 Overview
This example prints **odd and even numbers in sequence** using **two threads** in Java with proper synchronization.

---

## 🧠 Core Synchronization Logic

- A **shared object** holds:
    - A counter
    - A common lock
- **Odd and Even threads synchronize on the same lock**
- Only one thread executes at a time

---

## ⚠️ Important Rules (Must-Know)

- `wait()` must **always be used inside a `while` loop**, not `if`
    - Prevents **spurious wakeups**
- `wait()` and `notify()` must be called **inside a synchronized block**
- Both threads must use the **same lock object**
- Condition must be **rechecked after wake-up**
- `notify()` is called after printing to wake the other thread
- Avoid `Thread.sleep()` for synchronization
- No busy waiting is used

---

## 🔁 Execution Flow

1. If it is **not a thread’s turn**, it calls `wait()` and releases the lock
2. The correct thread prints the number
3. Counter is incremented
4. `notify()` wakes the waiting thread
5. Process repeats until the limit is reached

---

## ✅ Key Benefits

- Guaranteed ordered output
- Thread-safe execution
- CPU-efficient (no busy loops)
- Clean and interview-friendly approach

---

## 🎯 Example Output

```text
Odd  : 1
Even : 2
Odd  : 3
Even : 4
...
