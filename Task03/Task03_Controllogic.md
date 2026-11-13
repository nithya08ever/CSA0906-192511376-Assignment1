# TASK 3 – Design the Control Logic

## 1. Slot Allocation Logic

The system searches each floor sequentially and checks every slot. When it finds the first free slot, it assigns the vehicle registration number and returns the floor and slot positions.

If all slots are occupied, the method returns null.

### Pseudocode – Allocate Slot

```text
ALGORITHM AllocateSlot(vehicleNo)

BEGIN
    FOR each floor f
        FOR each slot s in floor f
            IF slot[f][s] is NULL THEN
                slot[f][s] = vehicleNo
                RETURN {f, s}
            END IF
        END FOR
    END FOR

    RETURN NULL
END
```

## 2. Parking Fee Calculation Logic

The parking fee is calculated based on parking duration and the applicable hourly rate.

Every started hour is charged as a complete hour.

### Pseudocode – Calculate Fee

```text
ALGORITHM CalculateFee(minutes, rate)

BEGIN
    IF minutes <= 0 THEN
        RETURN 0
    END IF

    hours = (minutes + 59) / 60
    fee = hours * rate

    RETURN fee
END
```

Example:

Parking duration = 130 minutes.

Hourly rate = Rs. 30.

Billable hours = (130 + 59) / 60 = 3.

Total fee = 3 × 30 = Rs. 90.

## 3. Use of Control Statements

- **if-else:** Checks whether a parking slot is free and determines the applicable parking fee.
- **for loop:** Searches all floors and slots.
- **break:** Can stop a loop once a suitable slot is found.
- **continue:** Can skip occupied slots and check the next slot.
- **return:** Returns the allocated position or null when no slot is available.

If no suitable slot is available, the allocation method returns null.

## 4. Alternative Concept – Free Slot Stack

Instead of searching every slot sequentially, the system can maintain a stack of available slots for each floor and a count of free slots.

During allocation:
1. Check whether a floor has available slots.
2. Pop a free slot position from its stack.
3. Assign the vehicle to that position.
4. Decrease the free-slot count.

During release:
1. Validate the floor and slot.
2. Release the occupied slot.
3. Push its position back onto the corresponding free-slot stack.
4. Increase the free-slot count.

## 5. Complexity Analysis

Let F represent the number of floors and S represent the maximum number of slots per floor.

| Operation | Sequential Search | Free Slot Stack |
|---|---|---|
| Allocation | O(F × S) worst case | O(1) |
| Release | O(1) | O(1) |
| Extra space | O(F × S) for slot storage | O(F × S) for slot storage and free-slot stacks |

The stack approach requires additional bookkeeping and must prevent duplicate entries when slots are released.

## 6. Conclusion

Sequential searching is simple and suitable for a small parking facility. However, maintaining a stack of free slots improves allocation performance because it avoids scanning every floor and slot. Both approaches can support the parking system, but the stack approach is more efficient for larger facilities.