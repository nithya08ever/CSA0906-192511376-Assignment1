# TASK 5 – Apply Static Members and the Object Life Cycle

## 1. Static Variables

Static variables belong to the class rather than individual objects.

In the Campus Smart-Parking System, a static ticket counter is required to generate unique ticket numbers.

Example:

`private static int ticketCounter = 1000;`

Whenever a new parking ticket is created, the counter is incremented to generate the next ticket number.

An instance variable would be inappropriate for this purpose because every ParkingTicket object would maintain a separate counter, which could result in duplicate ticket numbers.

Other possible static variables include:
- Total number of issued tickets.
- Total number of vehicles parked.
- Global parking configuration values.

## 2. Static Methods and Static Blocks

**Static Methods:**

Static methods can be called using the class name without creating an object.

Example:
- generateTicketNumber()
- getTotalTickets()
- getTotalOccupancy()

These methods are useful for operations involving shared class-level information.

**Static Block:**

A static block executes once when the class is initialized.

It can be used to initialize shared configuration values or static counters.

## 3. Object Life Cycle and Garbage Collection

A ParkingTicket object is created when a vehicle enters the parking facility.

The object stores:
- Ticket number.
- Vehicle registration number.
- Entry time.
- Allocated floor and slot.

When the vehicle exits, its ticket is removed from the active parking records.

If no references to the ticket object remain, it becomes eligible for garbage collection.

Java automatically manages memory through its garbage collector.

Garbage collection does not necessarily happen immediately when an object becomes unreachable.

## 4. Passing and Returning Objects

Java allows object references to be passed as method arguments and returned from methods.

For example:

- A ParkingTicket object can be passed to a method that records vehicle entry.
- A method can return a newly created ParkingTicket object after ticket generation.
- A Vehicle object can be passed to a fee calculation method.

This improves modularity and allows different classes to communicate with each other.

## 5. Alternative Concept – Instance Counter vs Static Counter

Suppose the university operates two parking facilities: North Gate and South Gate.

If the ticket counter is an instance variable of ParkingFacility, each facility maintains its own counter.

This can produce duplicate ticket numbers when both facilities generate tickets independently.

For example:
- North Gate generates ticket 1001.
- South Gate also generates ticket 1001.

Using a static counter solves this problem because the counter is shared by all ParkingFacility objects within the same running application.

Example:

- North Gate generates ticket 1001.
- South Gate generates ticket 1002.

## 6. Complexity Analysis

Let:
- k = Number of ParkingFacility objects.
- n = Number of ParkingTicket objects.

| Feature | Static Counter | Instance Counter |
|---|---|---|
| Counter storage | O(1) | O(k) |
| Ticket creation | O(1) | O(1) |
| Counter access | O(1) | O(1) |
| Duplicate prevention across facilities | Shared counter | Requires additional coordination |

Both approaches require O(n) space for n ticket objects.

A static counter requires only O(1) additional space regardless of the number of facility objects, while an instance counter requires O(k) space.

## 7. Conclusion

Static members are useful for maintaining information shared across all objects. A static ticket counter ensures sequential ticket generation across multiple parking facilities in the same application. Java garbage collection automatically manages unreachable objects, reducing the need for manual memory management.