# TASK 4 – Design Classes, Objects and Constructors

## 1. Class Design

The Campus Smart-Parking System uses multiple classes to represent real-world entities.

| Class | Fields | Methods |
|---|---|---|
| Vehicle | regNo, vehicleType | getRegNo(), calculateFee() |
| Car | regNo, rate | calculateFee() |
| TwoWheeler | regNo, rate | calculateFee() |
| ElectricCar | regNo, chargingRate | calculateFee(), chargingFee() |
| ParkingFacility | slots, floors | allocate(), release() |
| ParkingSlot | slotNumber, isOccupied | occupy(), release() |
| ParkingTicket | ticketNumber, vehicleNo, entryTime, floor, slot | getTicketNumber(), getEntryTime() |
| ParkingPass | passNumber, validity | validatePass() |
| User | userId, name, userType | getUserType() |

Each class maintains its own data and provides methods to perform related operations.

## 2. Types of Constructors

### Default Constructor

A constructor without parameters is called a default or no-argument constructor.

It initializes an object with predefined default values.

### Parameterised Constructor

A parameterised constructor accepts values when an object is created.

For example, a ParkingTicket object can receive a ticket number, vehicle number, entry time, floor and slot.

### Constructor Overloading

Constructor overloading means defining multiple constructors in the same class with different parameter lists.

It provides flexibility when creating objects with different amounts of information.

## 3. Use of this Keyword and Constructor Chaining

The `this` keyword refers to the current object.

It is used to:
- Distinguish instance variables from constructor parameters.
- Call another constructor in the same class.
- Avoid repeating initialization statements.

Constructor chaining uses `this()` to call another constructor of the same class.

This reduces code duplication and ensures consistent initialization.

## 4. Copy Constructor

A copy constructor creates an object using the values of another object.

A separate copy constructor is not necessary for ParkingTicket because every ticket must have a unique ticket number.

Copying an existing ticket without generating a new identity could create duplicate ticket records.

If ticket details need to be copied, a new unique ticket number must be assigned.

## 5. Object Creation and Memory Management

Java objects are generally created using the `new` keyword.

- Reference variables are commonly stored in stack frames.
- Objects and their instance fields are stored in heap memory.
- Methods access objects through references.
- When an object is no longer reachable, it becomes eligible for garbage collection.

For example, a ParkingTicket object is created when a vehicle enters the parking facility.

After the vehicle exits, the ticket can be removed from active ticket storage. If no references remain, the object becomes eligible for garbage collection.

## 6. Alternative Concept – Setter-Based Creation and Static Factory Methods

### A. Default Constructor Followed by Setters

An object can be created using a default constructor and initialized using setter methods.

This allows fields to be assigned after object creation. However, the object may temporarily contain incomplete or invalid information.

### B. Static Factory Methods

A static factory method creates and returns an object through a named method.

It can validate input before returning the object and provide better control over object creation.

### Comparison

| Feature | Constructors | Setter-Based Creation | Static Factory Methods |
|---|---|---|---|
| Initialization | During creation | After creation | During creation |
| Validation | Can validate immediately | Must validate in setters | Can validate before returning |
| Object validity | Can ensure valid initialization | May temporarily be invalid | Can ensure valid initialization |
| Flexibility | Constructor overloading | High flexibility | High flexibility |
| Code maintenance | Good | May require repeated setter calls | Good |

## 7. Time and Space Complexity

Let n represent the number of ParkingTicket objects created.

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Constructors | O(n) total | O(n) |
| Default constructor and setters | O(n) total | O(n) |
| Static factory methods | O(n) total | O(n) |

Each object requires a constant amount of initialization work, so creating n objects takes O(n) total time.

All three approaches require O(n) space to store n ticket objects, assuming a fixed number of fields per ticket.

## 8. Conclusion

Constructors and constructor overloading provide a structured way to create ParkingTicket objects. Constructor chaining using `this()` avoids repeated initialization code. Static factory methods offer an alternative when object creation requires additional validation. The constructor-based approach is selected because it provides simple and consistent object initialization.