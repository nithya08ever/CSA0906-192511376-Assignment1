# TASK 9 – Introduce Abstraction

## 1. Introduction

Abstraction is an Object-Oriented Programming concept that hides implementation details and exposes only essential functionality.

In the Campus Smart-Parking System, abstraction is implemented using abstract classes and interfaces.

## 2. Abstract Class – Vehicle

The Vehicle class is designed as an abstract class because a generic vehicle should not be instantiated directly.

It contains common vehicle information and behaviour.

Fields and methods include:
- Registration number.
- getRegNo().
- ratePerHour().
- calculateFee().

The ratePerHour() method is declared abstract because each vehicle category has its own parking rate.

Subclasses such as TwoWheeler and Car provide their own implementations.

## 3. Interface – Chargeable

The Chargeable interface represents the capability of an electric vehicle to use charging facilities.

It declares a chargingFee() method that must be implemented by classes providing charging functionality.

ElectricCar implements Chargeable and calculates charging fees based on electricity consumption.

## 4. Abstract Class vs Interface

| Feature | Abstract Class | Interface |
|---|---|---|
| Purpose | Represents common identity and behaviour | Represents a capability or contract |
| Constructors | Supported | Not supported |
| Instance fields | Supported | Only public static final constants |
| Abstract methods | Supported | Supported |
| Concrete methods | Supported | Supported through default and static methods |
| Inheritance | A class can extend one class | A class can implement multiple interfaces |

An abstract class is selected for Vehicle because all vehicles share common state, such as registration number.

An interface is selected for Chargeable because charging is an additional capability that may be supported by different vehicle categories.

## 5. Multiple Interfaces

Java allows a class to implement multiple interfaces.

For example, an ElectricCar can implement:
- Chargeable – Provides charging functionality.
- Payable – Represents payment-related functionality.

This allows a class to obtain multiple capabilities without inheriting from multiple classes.

## 6. Default and Static Methods in Interfaces

**Default Method:**

A default method provides a reusable implementation inside an interface.

For example, Chargeable could provide a default method called chargingDescription() that returns information about charging availability.

**Static Method:**

A static interface method belongs to the interface itself and can be called using its interface name.

For example, Chargeable.standardChargingRate() could return the standard charging rate.

These methods allow interfaces to provide reusable utility behaviour.

## 7. Alternative Concept – Replacing Abstract Class and Interface

The original design uses:
- Vehicle as an abstract class.
- Chargeable as an interface.

An alternative design could use Vehicle as an interface and Chargeable as an abstract class.

However, this changes the structure and limitations of the system.

### What Changes?

1. A Vehicle interface cannot have ordinary instance fields to store individual registration numbers.
2. Interfaces cannot have constructors.
3. Vehicle state must be stored separately in implementing classes.
4. Chargeable as an abstract class can contain constructors and instance fields.
5. A class cannot extend both a Vehicle class and a Chargeable abstract class because Java supports only single class inheritance.
6. Multiple interfaces can still be implemented by the same class.

### Comparison

| Feature | Original Design | Alternative Design |
|---|---|---|
| Vehicle | Abstract class | Interface |
| Chargeable | Interface | Abstract class |
| Vehicle state | Stored in superclass | Stored in implementing classes |
| Constructors | Available in Vehicle | Not available in Vehicle interface |
| Multiple inheritance | Multiple interfaces supported | Multiple interfaces supported, but only one class can be extended |
| Code reuse | Common vehicle state and behaviour | Requires additional composition or duplication |

## 8. Complexity Analysis

Both designs can perform fee calculation in O(1) time when the applicable rate is directly available.

For n vehicle objects:
- Object storage requires O(n) space, assuming a fixed number of fields per object.
- Method execution requires O(1) additional space for a simple calculation.
- The alternative design may require repeated state storage in subclasses, increasing practical memory usage.

There is no inherent significant execution-time difference between the two designs for simple method calls.

## 9. Conclusion

The combination of an abstract Vehicle class and a Chargeable interface provides a suitable abstraction model for the Campus Smart-Parking System.

The abstract class maintains common vehicle information and behaviour, while the interface defines additional capabilities. This separation improves reusability, flexibility and maintainability.