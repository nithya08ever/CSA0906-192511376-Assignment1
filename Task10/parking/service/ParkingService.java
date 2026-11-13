
package Task10.parking.service;

import Task10.parking.model.Vehicle;
import Task10.parking.model.ParkingSlot;

public class ParkingService {

    public double calculateFee(Vehicle vehicle, int minutes) {

        if (vehicle == null) {
            throw new IllegalArgumentException(
                "Vehicle cannot be null"
            );
        }

        if (minutes < 0) {
            throw new IllegalArgumentException(
                "Parking duration cannot be negative"
            );
        }

        int hours = minutes == 0 ? 0 : (minutes + 59) / 60;

        double rate;

        switch (vehicle.getVehicleType().toLowerCase()) {

            case "twowheeler":
                rate = 10;
                break;

            case "car":
                rate = 30;
                break;

            case "electriccar":
                rate = 30;
                break;

            default:
                throw new IllegalArgumentException(
                    "Unknown vehicle type"
                );
        }

        return hours * rate;
    }

    public void displaySlot(ParkingSlot slot) {

        System.out.println(
            "Slot Number: " + slot.getSlotNumber()
        );

        System.out.println(
            "Occupied: " + slot.isOccupied()
        );

        System.out.println(
            "Vehicle: " + slot.getVehicleNo()
        );
    }
}
