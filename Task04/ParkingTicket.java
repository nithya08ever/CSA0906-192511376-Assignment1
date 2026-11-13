package Task04;

import java.time.LocalDateTime;

public class ParkingTicket {

    private String ticketNumber;
    private String vehicleNo;
    private LocalDateTime entryTime;
    private int floor;
    private int slot;

    // Default constructor
    public ParkingTicket() {
        this("NOT-ISSUED", "NOT-ASSIGNED",
             LocalDateTime.now(), -1, -1);
    }

    // Parameterised constructor
    public ParkingTicket(String ticketNumber,
                         String vehicleNo,
                         int floor,
                         int slot) {

        this(ticketNumber, vehicleNo,
             LocalDateTime.now(), floor, slot);
    }

    // Overloaded constructor
    public ParkingTicket(String ticketNumber,
                         String vehicleNo,
                         LocalDateTime entryTime,
                         int floor,
                         int slot) {

        this.ticketNumber = ticketNumber;
        this.vehicleNo = vehicleNo;
        this.entryTime = entryTime;
        this.floor = floor;
        this.slot = slot;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void displayTicket() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Entry Time: " + entryTime);
        System.out.println("Floor: " + floor);
        System.out.println("Slot: " + slot);
        System.out.println("----------------------");
    }
}

