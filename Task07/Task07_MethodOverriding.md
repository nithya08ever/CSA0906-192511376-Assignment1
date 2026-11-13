# TASK 7 – Override and Specialise Behaviour

## 1. Introduction

Method overriding allows a subclass to provide its own implementation of a method already defined in its superclass.

In the Campus Smart-Parking System, different vehicle categories have different parking rates. Therefore, the calculateFee() method is specialised for each vehicle type.

## 2. Methods Overridden

The following methods are overridden:

| Method | Purpose |
|---|---|
| calculateFee() | Calculates parking fees based on vehicle type. |
| toString() | Returns readable vehicle information. |
| equals() | Checks whether two vehicles have the same registration number. |
| hashCode() | Generates a hash value based on registration number. |

The @Override annotation indicates that a method is intended to override a superclass method. It helps the compiler detect incorrect method signatures.

## 3. Rules of Method Overriding

1. The subclass method must have the same method name and parameter list.
2. The return type must be the same or a compatible covariant return type.
3. The access level cannot be more restrictive than that of the overridden method.
4. Static methods are hidden rather than overridden.
5. Private methods cannot be overridden.
6. Final methods cannot be overridden.

## 4. Use of final Keyword

The final keyword prevents unwanted modification.

Examples:

- Final variable: The vehicle registration number cannot be reassigned after initialization.
- Final method: A method declared final cannot be overridden by subclasses.
- Final class: A class declared final cannot be extended.

In this system, the registration number is declared final because it must remain unchanged throughout the vehicle's lifecycle.

## 5. Object Class Method Overriding

### toString()

The toString() method returns meaningful vehicle information instead of the default object representation.

### equals()

The equals() method compares two Vehicle objects using their registration numbers.

Two vehicles with the same registration number are treated as equal.

### hashCode()

The hashCode() method generates a hash value based on the registration number.

Objects considered equal by equals() must return the same hash code. This is important when vehicles are stored in hash-based collections.

## 6. Alternative Concept – Switch-Based Fee Calculation

Instead of overriding calculateFee() in each subclass, a single calculateFee() method could use a switch statement based on the vehicle type.

For example:
- Two-wheeler: Rs. 10 per hour.
- Car: Rs. 30 per hour.
- Electric car: Rs. 30 per hour, excluding additional charging fees.

### Comparison

| Feature | Method Overriding | Switch-Based Approach |
|---|---|---|
| Fee calculation | Implemented in subclasses | Implemented in one method |
| Adding a new vehicle type | Add a subclass | Modify the switch method |
| Maintainability | Better separation | Centralised logic |
| Extensibility | Better | Limited |
| Time complexity | O(1) | O(1) for a fixed number of cases |
| Classes modified | Usually only new subclass | Existing calculation class must change |

## 7. Complexity Analysis

For k vehicle types:

**Method overriding:**
- Runtime method dispatch: O(1).
- Fee calculation: O(1).
- Adding a vehicle type does not require modifying existing vehicle subclasses.

**Switch-based approach:**
- A switch over a fixed number of vehicle types takes O(1) time.
- With a growing number of types, a sequential conditional implementation can require up to O(k) checks.
- Existing calculation logic must be modified when a new vehicle type is introduced.

Both approaches use O(1) additional space for a fee calculation, excluding stored vehicle objects.

## 8. Conclusion

Method overriding provides specialised fee calculations for different vehicle categories. Overriding toString(), equals() and hashCode() improves object representation and comparison. The overriding approach is preferred because it supports extensibility and reduces modifications to existing classes when new vehicle types are introduced.