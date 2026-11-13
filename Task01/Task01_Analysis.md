# TASK 1 – Understand the Problem and Identify the Objects

## 1. Problem Description

The Campus Smart-Parking System is designed to manage vehicles entering and leaving a university parking facility. It supports two-wheelers, cars and electric vehicles. The system allocates available parking slots, generates unique parking tickets, records entry and exit times, and calculates parking fees based on vehicle type and parking duration.

## 2. Inputs and Outputs

**Inputs:**
- Vehicle registration number.
- Vehicle type.
- User category (Student, Staff or Visitor).
- Entry and exit time.
- Number of floors and slots.
- Monthly parking pass validity.

**Outputs:**
- Allocated floor and slot number.
- Unique parking ticket number.
- Parking entry and exit details.
- Total parking duration.
- Calculated parking fee.
- Slot availability status.

## 3. Candidate Classes and Responsibilities

| Candidate Class | Responsibility |
|---|---|
| ParkingFacility | Manages floors, parking slots and vehicle allocation. |
| Vehicle | Stores common vehicle information. |
| TwoWheeler | Represents two-wheeler vehicles. |
| Car | Represents cars. |
| ElectricCar | Represents electric vehicles with charging capability. |
| ParkingTicket | Stores ticket number, vehicle details and entry time. |
| ParkingSlot | Represents an individual parking slot and its availability. |
| ParkingPass | Maintains monthly pass details and validity. |
| User | Stores user information and category. |

Each class represents a specific entity in the parking system. Dividing responsibilities between classes improves modularity, maintainability and code reusability.

## 4. Inputs and Methods (Nouns and Verbs)

**Nouns – Candidate classes:**
Vehicle, Car, TwoWheeler, ElectricCar, ParkingFacility, ParkingSlot, ParkingTicket, User and ParkingPass.

**Verbs – Candidate methods:**
- allocateSlot()
- releaseSlot()
- generateTicket()
- calculateFee()
- recordEntry()
- recordExit()
- checkAvailability()
- validatePass()

## 5. Business Rules

1. A parking slot cannot accommodate more than one vehicle at a time.
2. A vehicle must receive a unique parking ticket number.
3. A vehicle cannot be allocated an occupied slot.
4. A vehicle must have a valid registration number.
5. A parking slot must be released when the vehicle exits.
6. Parking fees depend on vehicle type and parking duration.
7. Valid monthly pass holders belonging to staff or student categories park free of charge.
8. Visitors must pay the applicable parking fee.
9. Electric vehicles may use charging slots, and charging fees are calculated separately.
10. Invalid floor and slot numbers must be rejected.

## 6. Assumptions

1. Each vehicle has a unique registration number.
2. Parking fees are calculated based on the total parking duration.
3. Every vehicle entering the facility receives one parking ticket.
4. The parking facility may have different numbers of slots on different floors.
5. Monthly passes are valid only for their specified validity period.
6. Charging fees are separate from normal parking fees.
7. The system uses a fixed parking allocation policy, selecting the first available suitable slot.

## 7. Alternative Concept – Objects vs Parallel Arrays

In an object-oriented design, every vehicle is represented as a separate Vehicle object containing its registration number, type and entry time.

Alternatively, vehicles can be stored using parallel arrays:

- regNo[] – Stores registration numbers.
- type[] – Stores vehicle types.
- entryTime[] – Stores entry times.

### Comparison

| Feature | Vehicle Objects | Parallel Arrays |
|---|---|---|
| Data organisation | Stored together in objects | Stored in separate arrays |
| Searching | O(n) | O(n) |
| Adding a new attribute | Add a field to Vehicle | Create and maintain another array |
| Data maintenance | Easier | More complex |
| Extensibility | Better | Limited |
| Space complexity | O(n) | O(n) |

### Time Complexity

Searching for a vehicle by registration number requires checking vehicles one by one in both approaches.

Therefore, the time complexity is O(n), where n represents the number of parked vehicles.

### Space Complexity

Both approaches require O(n) space for storing n vehicles.

However, the object-oriented approach groups related information together, while parallel arrays require careful synchronisation between corresponding indexes.

### Conclusion

The object-oriented approach is more suitable for the Campus Smart-Parking System because it provides better encapsulation, modularity, reusability and extensibility. New vehicle attributes and behaviours can be added more easily without modifying multiple parallel arrays.