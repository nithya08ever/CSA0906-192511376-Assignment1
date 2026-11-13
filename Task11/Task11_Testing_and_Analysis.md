# TASK 11 – Implement, Test and Defend the Design

## 1. Introduction

The Campus Smart-Parking System is implemented in Java using object-oriented programming concepts. It manages vehicle entry, parking slot allocation, ticket generation, vehicle exit and fee calculation.

The system supports two-wheelers, cars and electric cars. It also provides free parking for valid monthly pass holders and calculates EV charging fees separately.

## 2. Class Design

| Class | Responsibility |
|---|---|
| Vehicle | Abstract base class containing common vehicle details and fee calculation |
| TwoWheeler | Represents two-wheelers with a rate of ₹10 per hour |
| Car | Represents cars with a rate of ₹30 per hour |
| ElectricCar | Extends Car and calculates separate charging fees |
| ParkingSlot | Maintains slot number, floor number and occupancy status |
| ParkingTicket | Stores ticket number, vehicle, allocated slot and entry time |
| ParkingSystem | Manages vehicle entry, exit, ticket lookup, slot allocation and collection |

## 3. Business Rules

1. Every vehicle must have a valid registration number.
2. Duplicate registration numbers cannot be parked simultaneously.
3. Each vehicle must receive a unique parking ticket number.
4. An occupied slot cannot be allocated to another vehicle.
5. A vehicle cannot exit before its recorded entry time.
6. Monthly pass holders receive free parking.
7. Electric vehicle charging fees are calculated separately.
8. Parking duration is converted into billable hours using ceiling calculation.
9. Negative parking duration and charging units are rejected.

## 4. Test Cases

The following table contains the expected results. Actual results should be filled in after executing the Java program.

| Test ID | Test Scenario | Expected Result | Actual Result |
|---|---|---|---|
| TC01 | Two-wheeler entry | Ticket generated and slot allocated | Pending execution |
| TC02 | Car entry | Ticket generated and slot allocated | Pending execution |
| TC03 | Electric car entry | Ticket generated and slot allocated | Pending execution |
| TC04 | Monthly pass holder | Parking fee ₹0 | Pending execution |
| TC05 | Two-wheeler parks for 60 minutes | Fee ₹10 | Pending execution |
| TC06 | Car parks for 120 minutes | Fee ₹60 | Pending execution |
| TC07 | Electric car parks for 60 minutes and charges 2 units | Total fee ₹54 | Pending execution |
| TC08 | Duplicate registration | Entry rejected | Pending execution |
| TC09 | Unknown vehicle type | Vehicle creation rejected | Pending execution |
| TC10 | Invalid slot number (9,9) | Returns false | Pending execution |
| TC11 | Zero-minute parking | Parking fee ₹0 | Pending execution |
| TC12 | Last available slot | Entry succeeds | Pending execution |
| TC13 | Parking facility full | Additional entry rejected | Pending execution |

## 5. Manual Daily Collection Calculation

The program executes four vehicle parking operations.

| Vehicle | Parking Duration | Parking Fee | Charging Fee |
|---|---:|---:|---:|
| Two-wheeler | 60 minutes | ₹10 | ₹0 |
| Car | 120 minutes | ₹60 | ₹0 |
| Electric car | 60 minutes | ₹30 | ₹24 |
| Student with monthly pass | 60 minutes | ₹0 | ₹0 |
| **Total** | | **₹100** | **₹24** |

Total collection:

₹10 + ₹60 + ₹30 + ₹24 + ₹0 = **₹124**

The expected program output is:

`DAILY COLLECTION: Rs. 124.0`

The zero-minute parking test is executed after this collection is printed and does not affect the displayed total.

## 6. Object-Oriented Concepts Used

### Encapsulation

Fields such as registration number, monthly pass status, slot occupancy and ticket details are private. Public methods control access to the data.

### Inheritance

TwoWheeler and Car inherit from Vehicle. ElectricCar inherits from Car, allowing code reuse.

### Polymorphism

The `getHourlyRate()`, `getType()` and fee calculation methods are overridden in subclasses. The system invokes the appropriate implementation through Vehicle references.

### Abstraction

Vehicle is an abstract class. It defines common properties and abstract methods that individual vehicle types implement.

## 7. Limitation of the Design

The current system uses integer minutes from a common starting point instead of actual date and time values. Therefore, it is a simplified model and does not directly handle real-world overnight parking or multiple-day stays.

The current vehicle factory also requires modification when a new vehicle category is introduced.

## 8. Alternative Data Structure Analysis

The current implementation stores active tickets in a fixed-size array.

### Array

- Finding a ticket requires sequential searching.
- Exit processing takes O(n) time in the worst case.
- Storage complexity is O(n).
- Capacity is fixed when the parking system is created.

### ArrayList

- Tickets can be added and removed dynamically.
- Finding a ticket still requires sequential searching.
- Exit processing takes O(n) time.
- Storage complexity is O(n).
- Capacity can grow dynamically.

### HashMap

- Tickets can be stored using registration number as the key.
- A ticket can be found directly using its registration number.
- Average lookup time is O(1).
- Worst-case lookup time can be O(n).
- Storage complexity is O(n).

### Comparison Table

| Data Structure | Ticket Search | Space Complexity | Capacity |
|---|---|---|---|
| Array | O(n) | O(n) | Fixed |
| ArrayList | O(n) | O(n) | Dynamic |
| HashMap | O(1) average | O(n) | Dynamic |

A HashMap would be more efficient for ticket lookup when the number of parked vehicles increases. However, the array implementation is retained for this task because it demonstrates array-based ticket management and supports the required comparison.

## 9. Overall Evaluation

The implementation demonstrates the main object-oriented principles through separate classes and inheritance relationships. Private fields help protect object data, while overridden methods support different vehicle fee calculations.

Testing covers normal operations, boundary conditions and invalid inputs. The manually calculated daily collection of ₹124 provides an additional check against the program's output.

The current array-based approach is suitable for a small fixed-capacity parking facility. A HashMap would be a better choice for faster registration-number-based ticket lookup in a larger system.

## 10. Conclusion

The Campus Smart-Parking System successfully demonstrates an object-oriented approach to parking management. It supports vehicle registration, slot allocation, ticket generation, fee calculation and vehicle exit.

The implementation also demonstrates the use of encapsulation, inheritance, polymorphism, abstraction and array-based data management. The design can be further improved by using a HashMap for ticket lookup and actual date-time values for parking duration.