# TASK 6 – Design the Inheritance Hierarchy

## 1. Introduction

Inheritance is an Object-Oriented Programming concept that allows one class to acquire the properties and methods of another class.

In the Campus Smart-Parking System, inheritance is used to represent different vehicle categories and user types. It reduces code duplication and improves code reusability.

## 2. Vehicle Inheritance Hierarchy

The superclass is Vehicle, which contains common vehicle information.

The subclasses are:

- TwoWheeler: Represents two-wheeler vehicles and uses a specific parking rate.
- Car: Represents cars and uses a car-specific parking rate.
- ElectricCar: Inherits the properties and methods of Car and supports additional electric vehicle charging functionality.

### Type of Inheritance

**Hierarchical Inheritance:**

Vehicle acts as a superclass for TwoWheeler and Car.

**Multilevel Inheritance:**

ElectricCar extends Car, and Car extends Vehicle.

## 3. Inherited and Additional Properties

| Class | Inherited Properties | Additional Properties |
|---|---|---|
| Vehicle | None | registration number |
| TwoWheeler | registration number | two-wheeler parking rate |
| Car | registration number | car parking rate |
| ElectricCar | registration number, car parking rate | charging capability |

## 4. User Inheritance Hierarchy

A separate User superclass can represent common user information.

Its subclasses are:

- Student: Contains student-specific information and monthly pass eligibility.
- Staff: Contains staff-specific information and monthly pass eligibility.
- Visitor: Represents visitors who pay the applicable parking fee.

This hierarchy avoids duplicating common user information.

## 5. Use of super Keyword

The `super` keyword refers to the immediate parent class.

It is used for:

1. Accessing parent class fields.
2. Calling parent class methods.
3. Calling parent class constructors.

For example, the Car constructor calls the Vehicle constructor using `super(regNo)`.

The ElectricCar constructor calls the Car constructor using `super(regNo)`.

This ensures that common vehicle information is initialized through the inheritance hierarchy.

## 6. Constructor Execution Order

When an ElectricCar object is created, constructors execute from the topmost superclass to the lowest subclass.

Execution sequence:

1. Vehicle constructor executes.
2. Car constructor executes.
3. ElectricCar constructor executes.

This happens because every subclass constructor invokes its immediate superclass constructor using `super()` or an implicit superclass constructor call.

## 7. UML Class Diagram

The vehicle hierarchy contains one superclass and three vehicle categories, with ElectricCar extending Car.

The user hierarchy separately contains User, Student, Staff and Visitor.

## 8. Alternative Concept – Composition Instead of Inheritance

Instead of using inheritance, the system could use a single Vehicle class containing a VehicleType object.

The VehicleType object would store the vehicle category and its applicable parking rate.

For example:
- TwoWheelerType: Rs. 10 per hour.
- CarType: Rs. 30 per hour.
- ElectricCarType: Car parking rate with charging capability.

### Comparison

| Feature | Inheritance | Composition |
|---|---|---|
| Structure | Parent and child classes | Vehicle has a VehicleType object |
| Adding a vehicle type | Create a new subclass | Create a new VehicleType implementation |
| Code reuse | Through inheritance | Through composition |
| Flexibility | Less flexible for changing types at runtime | More flexible |
| Fee calculation | Overridden methods | Delegated to VehicleType |
| Time complexity | O(1) | O(1) |
| Space complexity | O(1) per vehicle with fixed fields | O(1) per vehicle, with an additional reference and type object if separately allocated |

## 9. Complexity Analysis

Both approaches calculate the parking fee in O(1) time when the applicable rate is directly available.

Inheritance stores vehicle-specific data in subclasses, while composition stores a reference to a VehicleType object.

If VehicleType objects are shared between vehicles, composition can reduce repeated storage of common pricing information.

## 10. Conclusion

Inheritance is selected for the initial Campus Smart-Parking System because different vehicle categories share common properties but have different parking behaviours.

The hierarchy reduces code duplication and supports method overriding and runtime polymorphism. Composition is a suitable alternative when vehicle types or pricing behaviours need to change dynamically.