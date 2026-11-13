# TASK 12 – Re-evaluate and Adapt the Design

## 1. Introduction

The original Campus Smart-Parking System was designed to support two-wheelers, cars and electric cars. The university introduced new requirements, including e-bikes, delivery vans, visitor one-day passes and an expansion to five floors.

The existing design was evaluated and modified to support these requirements while retaining reusable classes.

## 2. A. Impact Analysis

### Changes in Requirements

| Original Requirement | New Requirement |
|---|---|
| Two-wheelers and cars | E-bikes and delivery vans added |
| Normal hourly pricing | E-bike flat fee and delivery van special pricing |
| Monthly passes | Visitor one-day pass introduced |
| Original floor configuration | Five floors with different slot counts |

### Affected Classes and Methods

| Class | Impact |
|---|---|
| Vehicle | Modified to support pricing rules and passes |
| EBike | New class for flat-fee parking |
| DeliveryVan | New class for time-dependent pricing |
| ParkingPass | New interface for pass validation |
| VisitorDayPass | New class for one-day passes |
| PricingRule | New interface for pricing strategies |
| ParkingSystemV2 | Modified for five-floor allocation |
| ParkingSlot | Retained with its existing responsibilities |

### Why a Jagged Array Is Required

Different floors have different numbers of parking slots. A rectangular two-dimensional array would allocate the same number of slots to every floor, potentially wasting space.

A jagged array allows each floor to have its own slot count.

Example:

`new int[]{3, 4, 2, 5, 3}`

This represents five floors containing 3, 4, 2, 5 and 3 slots respectively.

Total slots = 3 + 4 + 2 + 5 + 3 = 17.

## 3. B. Evaluation of the Original Design

The original inheritance design supports adding new vehicle categories through subclasses. However, pricing rules can become difficult to maintain when they are implemented separately inside every vehicle class.

The modified design introduces the PricingRule interface to separate pricing behaviour from vehicle information.

The ParkingPass interface separates pass validation from vehicle categories.

Existing classes such as ParkingSlot and ParkingTicket can retain their core responsibilities. Vehicle and ParkingSystem require modifications to support the new features.

## 4. C. Adaptation or Redesign

### Design Decision: Modify

The existing design is modified rather than completely redesigned.

### Revised Class Structure

| Component | Responsibility |
|---|---|
| Vehicle | Abstract base class for vehicles |
| TwoWheeler | Existing two-wheeler category |
| Car | Existing car category |
| ElectricCar | Existing electric vehicle category |
| EBike | New e-bike category |
| DeliveryVan | New delivery van category |
| PricingRule | Defines the pricing calculation contract |
| HourlyPricingRule | Calculates normal hourly charges |
| EBikePricingRule | Applies a flat fee |
| DeliveryVanPricingRule | Applies double car rate during the specified hours |
| ParkingPass | Defines pass validation |
| VisitorDayPass | Implements one-day visitor pass |
| ParkingSystemV2 | Manages parking operations and five floors |

### New Pricing Rules

**E-bike**

- Flat fee: ₹20 per parking session.
- Zero-minute parking has no charge.

**Delivery van**

- Normal car rate: ₹30 per hour.
- Between 9 AM and 5 PM: ₹60 per hour.
- The implementation applies the rate based on each billable hour.

**Visitor one-day pass**

- Assumed pass price: ₹100.
- Valid for the day on which it was purchased.
- Parking fee is waived when both entry and exit occur on the valid day.

These prices are implementation assumptions because the assignment does not prescribe exact amounts.

### Five-Floor Configuration

The implementation uses:

`new int[]{3, 4, 2, 5, 3}`

This creates five floors with a total capacity of 17 vehicles.

## 5. D. Evidence-Based Defence

### Classes Modified and Added

The original Vehicle and parking-system management logic were modified. New classes and interfaces were introduced for e-bikes, delivery vans, pricing strategies and visitor passes.

ParkingSlot and the basic ticket structure retain their responsibilities.

### Ease of Future Extension

A new vehicle category can be introduced by creating another Vehicle subclass and providing an appropriate PricingRule implementation.

The parking system does not need a separate allocation algorithm for every vehicle category.

### Testing Table

| Test ID | Test Scenario | Expected Result | Actual Result |
|---|---|---|---|
| TC01 | Create five-floor parking facility | Five floors initialized | Pending execution |
| TC02 | Allocate vehicle to a free slot | Ticket generated | Pending execution |
| TC03 | E-bike parking | Flat fee ₹20 | Pending execution |
| TC04 | Delivery van during 9 AM–5 PM | ₹60 per billable hour | Pending execution |
| TC05 | Visitor with valid one-day pass | Parking fee ₹0 | Pending execution |
| TC06 | Electric car charging | ₹12 per unit | Pending execution |
| TC07 | Validate fifth floor, third slot | Returns true | Pending execution |
| TC08 | Validate sixth floor | Returns false | Pending execution |

### Trade-offs

The modified design improves extensibility by separating pricing and pass validation from the vehicle hierarchy.

However, it introduces additional classes and interfaces. The delivery van pricing implementation also uses a simplified billable-hour calculation, and the visitor pass is limited to the same calendar day.

## 6. Conclusion

The original Campus Smart-Parking System was modified to satisfy the university's changed requirements.

The revised design supports e-bikes, delivery vans, visitor one-day passes and five floors with different slot capacities.

The use of inheritance, interfaces, abstraction, encapsulation and separate pricing strategies makes the system easier to extend and maintain.

The modified design is more suitable for future expansion than the original implementation.