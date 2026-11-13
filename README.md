# Campus Smart-Parking System – OOP Assignment 1

## Student Details

- **Name:** Nithya D
- **Register Number:** 192511376
- **Subject:** CSA0906-JAVA
- **Java Version:** 26.0.2
- **Project:** Campus Smart-Parking System
- **Assignment:** Assignment 1 – Tasks 1 to 12

---

## 1. Project Overview

The Campus Smart-Parking System is a Java-based application developed to manage vehicle parking facilities within a campus.

The system supports different vehicle categories, parking slot allocation, ticket generation, parking fee calculation, vehicle entry and exit management, and collection tracking.

The project is developed progressively across 12 tasks, applying fundamental and advanced Object-Oriented Programming concepts.

## 2. Objectives

- Design an object-oriented model for a campus parking facility.
- Represent vehicles, parking slots, users and tickets using classes and objects.
- Implement vehicle entry and exit operations.
- Calculate parking fees based on vehicle type and parking duration.
- Apply inheritance, polymorphism, abstraction and encapsulation.
- Implement validation and exception handling.
- Extend the system to support additional vehicle categories and pricing rules.
- Evaluate the design and its extensibility.

## 3. Technologies Used

| Technology | Purpose |
|---|---|
| Java 26.0.2 | Programming language |
| JDK / Javac | Compilation |
| VS Code | Development environment |
| PowerShell | Command-line execution |
| Git | Version control |
| GitHub | Source code hosting |

## 4. Project Structure

```text
CampusSmartParking/
│
├── Task01/
│   ├── Task01_Analysis.md
│   └── README.md
│
├── Task02/
│   ├── Task02_DataRepresentation.md
│   └── README.md
│
├── Task03/
│   ├── ParkingFacility.java
│   ├── Task03_ControlLogic.md
│   ├── Task03_Output.png
│   └── README.md
│
├── Task04/
│   ├── ParkingTicket.java
│   ├── TicketDemo.java
│   ├── Task04_ClassDesign.md
│   ├── Task04_Output.png
│   └── README.md
│
├── Task05/
│   ├── Task05_StaticMembers.md
│   └── README.md
│
├── Task06/
│   ├── Vehicle.java
│   ├── InheritanceDemo.java
│   ├── Task06_Inheritance.md
│   ├── Task06_Output.png
│   └── README.md
│
├── Task07/
│   ├── Vehicle.java
│   ├── OverrideDemo.java
│   ├── Task07_MethodOverriding.md
│   └── README.md
│
├── Task08/
│   ├── FeeDemo.java
│   ├── Task08_Polymorphism.md
│   └── README.md
│
├── Task09/
│   ├── Vehicle.java
│   ├── AbstractionDemo.java
│   ├── Task09_Abstraction.md
│   └── README.md
│
├── Task10/
│   ├── parking/
│   │   ├── model/
│   │   │   ├── Vehicle.java
│   │   │   └── ParkingSlot.java
│   │   ├── service/
│   │   │   └── ParkingService.java
│   │   └── app/
│   │       └── EncapsulationDemo.java
│   ├── Task10_Encapsulation.md
│   └── README.md
│
├── Task11/
│   ├── ParkingSystem.java
│   ├── Task11_Testing_and_Analysis.md
│   ├── Task11_Output.png
│   └── README.md
│
├── Task12/
│   ├── ParkingSystemV2.java
│   ├── Task12_Design_Analysis.md
│   ├── Task12_Output.png
│   └── README.md
│
├── Report/
│
└── README.md
```

*Note: Add the remaining README files and screenshots as they are finalized.*

## 5. Task-wise Implementation

| Task | Description | Concepts Covered |
|---|---|---|
| Task 1 | Problem analysis and object identification | Object-oriented modelling |
| Task 2 | Data representation | Data types, arrays and collections |
| Task 3 | Parking facility control logic | Arrays, loops and conditions |
| Task 4 | Parking ticket class design | Classes, objects and constructors |
| Task 5 | Static members | Static variables, methods and blocks |
| Task 6 | Inheritance | Parent and child classes, `super` |
| Task 7 | Method overriding | Runtime method behaviour |
| Task 8 | Polymorphism | Method overloading and overriding |
| Task 9 | Abstraction | Abstract classes and interfaces |
| Task 10 | Encapsulation | Access modifiers, validation and packages |
| Task 11 | Complete parking system | OOP integration, testing and analysis |
| Task 12 | Extended parking system | Design modification and extensibility |

## 6. System Features

The final extended system supports:

- Multiple vehicle categories: TwoWheelers, Cars, Electric Cars, E-Bikes and Delivery Vans.
- Five parking floors with different slot capacities.
- Automatic parking slot allocation.
- Unique parking ticket generation.
- Duplicate vehicle registration validation.
- Vehicle entry and exit management.
- Hourly parking fee calculation.
- Flat-rate E-Bike parking fee.
- Special Delivery Van pricing between 9 AM and 5 PM.
- Visitor one-day parking passes.
- Separate electric vehicle charging fees.
- Total parking collection calculation.
- Parking floor and slot validation.

## 7. Final System Configuration

The extended parking facility uses five floors with different parking capacities.

| Floor | Number of Slots |
|---|---:|
| Floor 1 | 3 |
| Floor 2 | 4 |
| Floor 3 | 2 |
| Floor 4 | 5 |
| Floor 5 | 3 |
| **Total** | **17** |

## 8. Compilation and Execution

Open the project root directory in the VS Code terminal:

```powershell
cd CampusSmartParking
```

### Task 3

```powershell
javac Task03/ParkingFacility.java
java -cp . Task03.ParkingFacility
```

### Task 4

```powershell
javac Task04/ParkingTicket.java Task04/TicketDemo.java
java -cp . Task04.TicketDemo
```

### Task 6

```powershell
javac Task06/Vehicle.java Task06/InheritanceDemo.java
java -cp . Task06.InheritanceDemo
```

### Task 7

```powershell
javac Task07/Vehicle.java Task07/OverrideDemo.java
java -cp . Task07.OverrideDemo
```

### Task 8

```powershell
javac Task08/FeeDemo.java
java -cp . Task08.FeeDemo
```

### Task 9

```powershell
javac Task09/Vehicle.java Task09/AbstractionDemo.java
java -cp . Task09.AbstractionDemo
```

### Task 10

```powershell
javac -d . Task10/parking/model/Vehicle.java Task10/parking/model/ParkingSlot.java Task10/parking/service/ParkingService.java Task10/parking/app/EncapsulationDemo.java
java Task10.parking.app.EncapsulationDemo
```

### Task 11

```powershell
javac -d . Task11/ParkingSystem.java
java Task11.ParkingSystem
```

### Task 12

```powershell
javac -d . Task12/ParkingSystemV2.java
java Task12.ParkingSystemV2
```

Tasks 1, 2 and 5 primarily contain documentation and design analysis.

## 9. Final Task 12 Execution Result

The extended system was compiled and executed successfully.

```text
TOTAL COLLECTION: Rs. 304.0

FIVE-FLOOR VALIDATION
Floor 5, Slot 3: true
Floor 6, Slot 1: false
```

The execution verified vehicle fee calculations, electric vehicle charging charges, visitor pass collection and five-floor slot validation.

## 10. Object-Oriented Concepts Applied

The project demonstrates the following OOP principles:

**Encapsulation:** Data members are protected using access modifiers, with controlled access through methods.

**Inheritance:** Vehicle categories reuse common properties and behaviours from parent classes.

**Polymorphism:** Method overloading and overriding support different vehicle-specific behaviours.

**Abstraction:** Abstract classes and interfaces define common contracts for vehicles, pricing and payment-related operations.

**Composition:** The parking system manages parking slots and active parking tickets as associated objects.

## 11. Testing and Validation

The implementation was tested through different scenarios, including:

- Successful vehicle entry and exit.
- Parking fee calculation for different vehicle types.
- Electric vehicle charging fee calculation.
- Visitor pass validation and collection.
- Duplicate registration validation.
- Parking slot availability and validation.
- Invalid floor and slot handling.
- Total collection calculation.

Task-specific test cases and output evidence are maintained inside their respective task folders.

## 12. Conclusion

The Campus Smart-Parking System demonstrates the practical application of Object-Oriented Programming concepts through a progressively developed Java application.

The project begins with problem analysis and basic class design, then introduces inheritance, polymorphism, abstraction and encapsulation. The final implementation integrates these concepts into a parking management system with multiple vehicle categories, flexible pricing rules, visitor passes and a five-floor parking facility.

The successful execution of the final version demonstrates that the system can accommodate additional requirements through modifications to its object-oriented design.


