# Clothing Store Simulation with Semaphores (Java)

This project simulates the operation of a clothing store using multithreading and semaphores in Java.  
The goal is to model synchronization and mutual exclusion under specific capacity constraints.

Customers enter the store, try on clothes in gender-specific fitting rooms, and finally proceed to checkout.

## 📚 Information
- Course: PLH 47
- Assignment: Store Simulation with Synchronization
- Language: Java

## 📝 Description

The simulation follows these rules:

- At most **40 customers** may be inside the store simultaneously.
- There are two fitting areas:
  - One for women
  - One for men  
  Each fitting area contains **5 individual fitting rooms**.
- There is **one cash register**, and due to COVID restrictions, no more than **10 customers** may wait in the queue.
- The gender distribution of customers is assumed to be **50% male / 50% female**.
- Each customer spends **3–10 seconds** in the fitting room before going to the cashier.
- Checkout service time is fixed (e.g., **5 seconds**).
- A new customer arrives every **2–5 seconds**.

All timing values can be adjusted to test system behavior more quickly.

Semaphores are used to enforce:

- Maximum store capacity
- Fitting room availability per gender
- Cashier queue limit
- Mutual exclusion where required

Each customer is modeled as a separate thread.

## 🛠️ Technologies
- Java
- Java Threads
- Semaphores (`java.util.concurrent.Semaphore`)
- Thread synchronization
