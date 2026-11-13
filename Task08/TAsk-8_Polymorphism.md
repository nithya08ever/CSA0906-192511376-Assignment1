# TASK 8 – Apply Polymorphism

## 1. Introduction

Polymorphism is an Object-Oriented Programming concept that allows the same method name or reference to represent different behaviours.

In the Campus Smart-Parking System, polymorphism allows different vehicle categories to calculate parking fees through a common interface.

Java supports two main types of polymorphism: compile-time polymorphism and runtime polymorphism.

## 2. Compile-Time Polymorphism

Compile-time polymorphism is achieved through method overloading.

Method overloading means defining multiple methods with the same name but different parameter lists.

Example:

- calculateFee(int minutes)
- calculateFee(LocalTime entryTime, LocalTime exitTime)

The compiler selects the appropriate method based on the arguments supplied.

For example, calculateFee(130) invokes the method that accepts minutes, while calculateFee(entry, exit) invokes the method that accepts two LocalTime arguments.

## 3. Runtime Polymorphism

Runtime polymorphism is achieved through method overriding and dynamic method dispatch.

A single array of Vehicle references can store objects of different subclasses.

Example:

- TwoWheeler object.
- Car object.
- ElectricCar object.

All three objects can be stored in a Vehicle array through upcasting.

When calculateFee() is called, the appropriate implementation of the overridden ratePerHour() method is selected according to the actual object type at runtime.

## 4. Dynamic Method Dispatch

Consider the following statement:

Vehicle v = new TwoWheeler("TN01A1");

Here:

- Declared reference type: Vehicle.
- Actual object type: TwoWheeler.
- Executed method: TwoWheeler's ratePerHour().

When v.calculateFee(130) is executed, the inherited calculateFee() method calls ratePerHour().

Java dynamically selects the TwoWheeler implementation and applies the two-wheeler rate.

## 5. Advantages of Polymorphism

1. Reduces lengthy if-else statements.
2. Improves code reusability.
3. Supports extensibility.
4. Allows different objects to be handled through a common superclass.
5. Makes the system easier to maintain.

## 6. Explanation of the equals() Result

The provided Vehicle class overrides equals() to compare vehicle registration numbers.

Therefore, the following objects are considered equal:

- Car("TN02B2")
- ElectricCar("TN02B2")

The result is true because both objects contain the same registration number.

This behaviour is consistent with the assignment's implementation, which defines vehicle equality using registration number alone.

In the actual parking system, registration numbers should be unique so that the same vehicle cannot be registered as two separate active vehicles.

## 7. Alternative Concept – instanceof and Casting

Instead of using dynamic method dispatch, the system could use instanceof checks and type casting to identify each vehicle category.

For example:
- Check whether the vehicle is a TwoWheeler.
- Check whether the vehicle is a Car.
- Check whether the vehicle is an ElectricCar.
- Calculate the appropriate fee for each category.

### Comparison

| Feature | Dynamic Method Dispatch | instanceof and Casting |
|---|---|---|
| Method selection | Runtime polymorphism | Explicit type checking |
| Code structure | Cleaner | More conditional statements |
| Extensibility | Better | Requires modifying existing conditions |
| Maintenance | Easier | More complex |
| Dispatch complexity | O(1) for direct virtual dispatch | Up to O(k) for sequential checks |

Here, k represents the number of vehicle categories.

## 8. Complexity Analysis

**Dynamic Method Dispatch:**
- Method selection: O(1) under normal JVM virtual dispatch assumptions.
- Fee calculation: O(1).

**instanceof Approach:**
- Sequential type checks can take up to O(k) time.
- Fee calculation after identifying the type: O(1).

Both approaches require O(1) additional space for a single fee calculation, excluding the vehicle objects.

## 9. Conclusion

Polymorphism allows the Campus Smart-Parking System to process different vehicle categories through a common Vehicle reference. Method overloading demonstrates compile-time polymorphism, while method overriding and dynamic method dispatch demonstrate runtime polymorphism. This approach reduces conditional logic and makes future vehicle extensions easier.