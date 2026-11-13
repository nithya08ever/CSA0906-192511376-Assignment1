# TASK 2 – Choose the Data Representation

## 1. Selection of Java Data Types

The following Java data types are selected for storing parking system information.

| Field | Data Type | Reason |
|---|---|---|
| Floor number | int | Represents a whole number. |
| Slot number | int | Represents a whole number. |
| Vehicle registration number | String | Contains letters and numbers. |
| Vehicle type | String / enum | Identifies the category of vehicle. |
| Entry time | LocalDateTime | Stores the complete date and time. |
| Exit time | LocalDateTime | Stores the complete date and time. |
| Parking duration | long | Stores duration in minutes. |
| Parking fee | double | Represents monetary calculations with decimal values. |
| Ticket number | int | Stores a unique sequential ticket number. |
| Slot availability | boolean | Indicates whether a slot is occupied or free. |

## 2. Representation of Floors and Parking Slots

I have selected a two-dimensional jagged array to represent the parking facility.

Example:

String[][] slots = new String[3][];

slots[0] = new String[20];
slots[1] = new String[30];
slots[2] = new String[50];

Each row represents one floor, and each element represents a parking slot.

A null value indicates that the slot is free, while a registration number indicates that the slot is occupied.

### Why a Jagged Array?

- Different floors can contain different numbers of parking slots.
- Memory is allocated according to the actual number of slots.
- It is easy to access a particular floor and slot using two indexes.
- It supports future expansion of the parking facility.

## 3. Type Conversion and Casting

Type conversion is required when calculating parking duration and fees.

For example:
- Parking duration is calculated in minutes.
- Minutes are converted into billable hours.
- The hourly rate is multiplied by the billable hours.

To avoid losing precision, floating-point calculations must be used where appropriate.

### Example of Incorrect Integer Division

Suppose a vehicle is parked for 90 minutes and the hourly rate is Rs. 30.

Incorrect calculation:

int hours = 90 / 60;

This produces 1 hour because integer division removes the fractional part.

Incorrect fee = 1 × 30 = Rs. 30.

Correct calculation:

int hours = (90 + 59) / 60;

This produces 2 billable hours.

Correct fee = 2 × 30 = Rs. 60.

Therefore, ceiling-based integer arithmetic is used to charge every started hour in full.

## 4. Input Methods

The Scanner class is selected for reading user input from the keyboard.

It can read:
- Vehicle registration number.
- Vehicle category.
- Floor and slot information.
- Parking entry and exit details.

Scanner is suitable because it supports different input types such as String, int and double.

## 5. Alternative Concept – Different Array Representations

Instead of using a jagged array, the parking slots could be represented using:

**A. One-dimensional array**

All parking slots can be stored in a single array.

The index can be calculated using:

index = floor × slotsPerFloor + slot

This representation works easily when every floor contains the same number of slots.

However, when floors have different numbers of slots, additional offset calculations are required.

**B. ArrayList<String[]>**

An ArrayList can store separate String arrays for each floor.

Each floor can have a different number of slots. New floors can also be added dynamically.

### Comparison

| Feature | Jagged Array | One-Dimensional Array | ArrayList |
|---|---|---|---|
| Different floor sizes | Supported | Requires extra offset logic | Supported |
| Slot access | O(1) | O(1) with correct index calculation | O(1) by index |
| Adding floors | Requires array recreation | Requires array recreation | Easier |
| Memory | O(S) | O(S) | O(S) plus resizing overhead |
| Flexibility | Moderate | Limited | High |

Here, S represents the total number of parking slots.

## 6. Complexity Analysis

**Jagged Array:**
- Accessing a slot: O(1).
- Traversing all slots: O(S).
- Space complexity: O(S).

**One-Dimensional Array:**
- Accessing a slot with a calculated index: O(1).
- Traversing all slots: O(S).
- Space complexity: O(S).

**ArrayList<String[]>:**
- Accessing a floor and slot by index: O(1).
- Traversing all slots: O(S).
- Space complexity: O(S).

## 7. Conclusion

The jagged array is selected because the parking facility may contain different numbers of slots on different floors. It provides direct access to individual slots, efficient memory usage and a simple representation of the parking structure. Scanner is used for input, and ceiling-based integer arithmetic prevents incorrect parking fee calculations.