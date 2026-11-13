
package Task10.parking.app;

import Task10.parking.model.Vehicle;
import Task10.parking.model.ParkingSlot;
import Task10.parking.service.ParkingService;

public class EncapsulationDemo {

    public static void main(String[] args) {

        ParkingService service = new ParkingService();

        System.out.println("ENCAPSULATION DEMONSTRATION");

        // Creating vehicle object
        Vehicle car = new Vehicle(
            "TN01AB1111",
            "Car"
        );

        System.out.println(car);

        // Creating parking slot
        ParkingSlot slot = new ParkingSlot(1);

        slot.occupy(car.getRegNo());

        service.displaySlot(slot);

        // Parking fee calculation
        double fee = service.calculateFee(car, 130);

        System.out.println("Parking Fee: Rs. " + fee);

        // Wrapper class and autoboxing
        Integer slotA = 1000;
        Integer slotB = 1000;

        System.out.println(
            "Integer using == : " + (slotA == slotB)
        );

        System.out.println(
            "Integer using equals(): " +
            slotA.equals(slotB)
        );

        // Invalid input demonstration
        try {
            service.calculateFee(car, -30);
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Validation: " + e.getMessage()
            );
        }

        // Release parking slot
        slot.release();

        System.out.println(
            "Slot released: " + !slot.isOccupied()
        );
    }
}
