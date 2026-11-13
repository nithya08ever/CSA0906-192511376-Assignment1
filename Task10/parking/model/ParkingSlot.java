
package Task10.parking.model;

public class ParkingSlot {

    private final int slotNumber;
    private String vehicleNo;

    public ParkingSlot(int slotNumber) {

        if (slotNumber <= 0) {
            throw new IllegalArgumentException(
                "Slot number must be positive"
            );
        }

        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public boolean isOccupied() {
        return vehicleNo != null;
    }

    public void occupy(String vehicleNo) {

        if (vehicleNo == null || vehicleNo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Invalid vehicle number"
            );
        }

        if (isOccupied()) {
            throw new IllegalStateException(
                "Parking slot is already occupied"
            );
        }

        this.vehicleNo = vehicleNo;
    }

    public void release() {

        if (!isOccupied()) {
            throw new IllegalStateException(
                "Parking slot is already free"
            );
        }

        vehicleNo = null;
    }
}
