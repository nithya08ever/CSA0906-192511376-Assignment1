
package Task12;

public class ParkingSystemV2 {

    // PASS ABSTRACTION
    interface ParkingPass {
        boolean isValid(int entryMinute, int exitMinute);
        double getPassPrice();
    }

    static class VisitorDayPass implements ParkingPass {
        private final int validDay;

        VisitorDayPass(int validDay) {
            this.validDay = validDay;
        }

        public boolean isValid(int entryMinute, int exitMinute) {
            return entryMinute / 1440 == validDay
                    && exitMinute / 1440 == validDay;
        }

        public double getPassPrice() {
            return 100.0;
        }
    }

    // PRICING STRATEGY
    interface PricingRule {
        double calculateFee(int entryMinute, int durationMinutes);
    }

    static class HourlyPricingRule implements PricingRule {
        private final double rate;

        HourlyPricingRule(double rate) {
            this.rate = rate;
        }

        public double calculateFee(int entryMinute, int durationMinutes) {
            if (durationMinutes < 0) {
                throw new IllegalArgumentException("Invalid duration");
            }

            int hours = (durationMinutes + 59) / 60;
            return hours * rate;
        }
    }

    static class EBikePricingRule implements PricingRule {
        public double calculateFee(int entryMinute, int durationMinutes) {
            if (durationMinutes < 0) {
                throw new IllegalArgumentException("Invalid duration");
            }

            return durationMinutes == 0 ? 0 : 20;
        }
    }

    static class DeliveryVanPricingRule implements PricingRule {
        private final double carRate = 30;

        public double calculateFee(int entryMinute, int durationMinutes) {
            if (durationMinutes < 0) {
                throw new IllegalArgumentException("Invalid duration");
            }

            double total = 0;
            int remaining = durationMinutes;
            int currentMinute = entryMinute;

            while (remaining > 0) {
                int billableMinutes = Math.min(60, remaining);
                int hourOfDay = (currentMinute / 60) % 24;

                double rate = (hourOfDay >= 9 && hourOfDay < 17)
                        ? carRate * 2
                        : carRate;

                total += rate;
                currentMinute += billableMinutes;
                remaining -= billableMinutes;
            }

            return total;
        }
    }

    // VEHICLE ABSTRACTION
    static abstract class Vehicle {
        private final String registrationNumber;
        private final PricingRule pricingRule;
        private final ParkingPass pass;

        Vehicle(String regNo, PricingRule pricingRule, ParkingPass pass) {
            if (regNo == null || regNo.isBlank()) {
                throw new IllegalArgumentException(
                        "Invalid registration number");
            }

            if (pricingRule == null) {
                throw new IllegalArgumentException(
                        "Pricing rule is required");
            }

            this.registrationNumber = regNo;
            this.pricingRule = pricingRule;
            this.pass = pass;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public abstract String getType();

        public double calculateParkingFee(int entryMinute, int exitMinute) {
            if (exitMinute < entryMinute) {
                throw new IllegalArgumentException(
                        "Invalid parking duration");
            }

            if (pass != null && pass.isValid(entryMinute, exitMinute)) {
                return 0;
            }

            return pricingRule.calculateFee(
                    entryMinute, exitMinute - entryMinute);
        }

        public double getPassPrice() {
            return pass == null ? 0 : pass.getPassPrice();
        }
    }

    // VEHICLE TYPES
    static class TwoWheeler extends Vehicle {
        TwoWheeler(String regNo, ParkingPass pass) {
            super(regNo, new HourlyPricingRule(10), pass);
        }

        public String getType() {
            return "TwoWheeler";
        }
    }

    static class Car extends Vehicle {
        Car(String regNo, ParkingPass pass) {
            super(regNo, new HourlyPricingRule(30), pass);
        }

        public String getType() {
            return "Car";
        }
    }

    static class ElectricCar extends Vehicle {
        ElectricCar(String regNo, ParkingPass pass) {
            super(regNo, new HourlyPricingRule(30), pass);
        }

        public String getType() {
            return "ElectricCar";
        }

        public double calculateChargingFee(double units) {
            if (units < 0) {
                throw new IllegalArgumentException(
                        "Invalid charging units");
            }

            return units * 12;
        }
    }

    static class EBike extends Vehicle {
        EBike(String regNo, ParkingPass pass) {
            super(regNo, new EBikePricingRule(), pass);
        }

        public String getType() {
            return "EBike";
        }
    }

    static class DeliveryVan extends Vehicle {
        DeliveryVan(String regNo, ParkingPass pass) {
            super(regNo, new DeliveryVanPricingRule(), pass);
        }

        public String getType() {
            return "DeliveryVan";
        }
    }

    // PARKING SLOT
    static class ParkingSlot {
        private final int floor;
        private final int slotNumber;
        private boolean occupied;

        ParkingSlot(int floor, int slotNumber) {
            this.floor = floor;
            this.slotNumber = slotNumber;
        }

        public boolean isOccupied() {
            return occupied;
        }

        public void occupy() {
            if (occupied) {
                throw new IllegalStateException("Slot already occupied");
            }

            occupied = true;
        }

        public void release() {
            if (!occupied) {
                throw new IllegalStateException("Slot already free");
            }

            occupied = false;
        }

        public String getLocation() {
            return "Floor " + floor + ", Slot " + slotNumber;
        }
    }

    // PARKING TICKET
    static class ParkingTicket {
        private final int ticketNumber;
        private final Vehicle vehicle;
        private final ParkingSlot slot;
        private final int entryMinute;

        ParkingTicket(int number, Vehicle vehicle,
                      ParkingSlot slot, int entryMinute) {
            this.ticketNumber = number;
            this.vehicle = vehicle;
            this.slot = slot;
            this.entryMinute = entryMinute;
        }
    }

    // PARKING SYSTEM
    private final ParkingSlot[][] floors;
    private final ParkingTicket[] activeTickets;

    private int nextTicketNumber = 2001;
    private double totalCollection = 0;

    ParkingSystemV2(int[] slotsPerFloor) {
        if (slotsPerFloor == null || slotsPerFloor.length != 5) {
            throw new IllegalArgumentException(
                    "The facility must contain exactly five floors");
        }

        floors = new ParkingSlot[5][];
        int totalSlots = 0;

        for (int f = 0; f < 5; f++) {
            if (slotsPerFloor[f] <= 0) {
                throw new IllegalArgumentException(
                        "Invalid slot count");
            }

            floors[f] = new ParkingSlot[slotsPerFloor[f]];
            totalSlots += slotsPerFloor[f];

            for (int s = 0; s < slotsPerFloor[f]; s++) {
                floors[f][s] = new ParkingSlot(f + 1, s + 1);
            }
        }

        activeTickets = new ParkingTicket[totalSlots];
    }

    private int findTicket(String regNo) {
        for (int i = 0; i < activeTickets.length; i++) {
            if (activeTickets[i] != null
                    && activeTickets[i].vehicle
                    .getRegistrationNumber().equals(regNo)) {
                return i;
            }
        }

        return -1;
    }

    // VEHICLE ENTRY
    public int enter(Vehicle vehicle, int entryMinute) {
        if (vehicle == null || entryMinute < 0) {
            throw new IllegalArgumentException(
                    "Invalid entry details");
        }

        if (findTicket(vehicle.getRegistrationNumber()) != -1) {
            throw new IllegalArgumentException(
                    "Duplicate registration number");
        }

        int index = -1;

        for (int i = 0; i < activeTickets.length; i++) {
            if (activeTickets[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalStateException(
                    "Parking facility is full");
        }

        ParkingSlot selected = null;

        for (ParkingSlot[] floor : floors) {
            for (ParkingSlot slot : floor) {
                if (!slot.isOccupied()) {
                    selected = slot;
                    break;
                }
            }

            if (selected != null) {
                break;
            }
        }

        if (selected == null) {
            throw new IllegalStateException("No free slot");
        }

        selected.occupy();

        int ticketNo = nextTicketNumber++;

        activeTickets[index] = new ParkingTicket(
                ticketNo, vehicle, selected, entryMinute);

        // Collect visitor pass price at entry.
        totalCollection += vehicle.getPassPrice();

        System.out.println(
                "ENTRY: " + vehicle.getRegistrationNumber()
                + " | " + vehicle.getType()
                + " | Ticket: " + ticketNo
                + " | " + selected.getLocation());

        return ticketNo;
    }

    // VEHICLE EXIT
    public double exit(String regNo, int exitMinute,
                       double chargingUnits) {

        int index = findTicket(regNo);

        if (index == -1) {
            throw new IllegalArgumentException(
                    "Active ticket not found");
        }

        ParkingTicket ticket = activeTickets[index];

        if (exitMinute < ticket.entryMinute) {
            throw new IllegalArgumentException(
                    "Exit before entry");
        }

        double parkingFee = ticket.vehicle.calculateParkingFee(
                ticket.entryMinute, exitMinute);

        double chargingFee = 0;

        if (ticket.vehicle instanceof ElectricCar) {
            chargingFee = ((ElectricCar) ticket.vehicle)
                    .calculateChargingFee(chargingUnits);
        }

        double total = parkingFee + chargingFee;

        System.out.println("Ticket Number: " + ticket.ticketNumber);

        ticket.slot.release();
        activeTickets[index] = null;

        totalCollection += total;

        System.out.println(
                "EXIT: " + regNo
                + " | Parking: Rs. " + parkingFee
                + " | Charging: Rs. " + chargingFee
                + " | Total: Rs. " + total);

        return total;
    }

    // FIVE-FLOOR SLOT VALIDATION
    public boolean isValidSlot(int floor, int slot) {
        return floor >= 1 && floor <= floors.length
                && slot >= 1
                && slot <= floors[floor - 1].length;
    }

    public double getTotalCollection() {
        return totalCollection;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        System.out.println("CAMPUS SMART-PARKING SYSTEM V2");
        System.out.println("--------------------------------");

        ParkingSystemV2 system =
                new ParkingSystemV2(new int[]{3, 4, 2, 5, 3});

        Vehicle bike =
                new TwoWheeler("TN01AA1111", null);

        Vehicle car =
                new Car("TN02BB2222", null);

        Vehicle ebike =
                new EBike("TN03CC3333", null);

        Vehicle van =
                new DeliveryVan("TN04DD4444", null);

        Vehicle ev =
                new ElectricCar("TN05EE5555", null);

        // Visitor one-day pass costs Rs. 100.
        ParkingPass visitorPass = new VisitorDayPass(0);

        Vehicle visitor =
                new Car("TN06FF6666", visitorPass);

        // Entry times in minutes from midnight.
        system.enter(bike, 8 * 60);
        system.enter(car, 9 * 60);
        system.enter(ebike, 10 * 60);
        system.enter(van, 10 * 60);
        system.enter(ev, 11 * 60);
        system.enter(visitor, 12 * 60);

        System.out.println("\nEXIT AND FEE CALCULATION");

        system.exit("TN01AA1111", 9 * 60, 0);
        system.exit("TN02BB2222", 11 * 60, 0);
        system.exit("TN03CC3333", 12 * 60, 0);
        system.exit("TN04DD4444", 11 * 60, 0);
        system.exit("TN05EE5555", 12 * 60, 2);
        system.exit("TN06FF6666", 13 * 60, 0);

        System.out.println(
                "\nTOTAL COLLECTION: Rs. "
                + system.getTotalCollection());

        System.out.println("\nFIVE-FLOOR VALIDATION");

        System.out.println(
                "Floor 5, Slot 3: " + system.isValidSlot(5, 3));

        System.out.println(
                "Floor 6, Slot 1: " + system.isValidSlot(6, 1));
    }
}
