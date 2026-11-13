package Task11;


public class ParkingSystemV2 {

    interface ParkingPass {
        boolean isValid(long entryMinute, long exitMinute);
        double getPrice();
    }

    static class VisitorDayPass implements ParkingPass {
        private final long validDay;

        VisitorDayPass(long validDay) {
            this.validDay = validDay;
        }

        public boolean isValid(long entryMinute, long exitMinute) {
            return entryMinute / 1440 == validDay
                    && exitMinute / 1440 == validDay;
        }

        public double getPrice() {
            return 100.0;
        }
    }

    interface PricingRule {
        double calculateFee(long entryMinute, long exitMinute);
    }

    static class HourlyPricingRule implements PricingRule {
        private final double hourlyRate;

        HourlyPricingRule(double hourlyRate) {
            this.hourlyRate = hourlyRate;
        }

        public double calculateFee(long entryMinute, long exitMinute) {
            long duration = Math.max(0, exitMinute - entryMinute);
            if (duration == 0) return 0;
            return Math.ceil(duration / 60.0) * hourlyRate;
        }
    }

    static class EBikePricingRule implements PricingRule {
        public double calculateFee(long entryMinute, long exitMinute) {
            return exitMinute > entryMinute ? 20.0 : 0.0;
        }
    }

    static class DeliveryVanPricingRule implements PricingRule {
        private final double carRate;

        DeliveryVanPricingRule(double carRate) {
            this.carRate = carRate;
        }

        public double calculateFee(long entryMinute, long exitMinute) {
            double fee = 0;

            for (long minute = entryMinute; minute < exitMinute; minute++) {
                long minuteOfDay = Math.floorMod(minute, 1440);
                int hour = (int) (minuteOfDay / 60);

                double rate = (hour >= 9 && hour < 17)
                        ? carRate * 2
                        : carRate;

                fee += rate / 60.0;
            }

            return Math.ceil(fee);
        }
    }

    static abstract class Vehicle {
        private final String registrationNumber;
        private final PricingRule pricingRule;
        private final ParkingPass parkingPass;

        Vehicle(String registrationNumber,
                PricingRule pricingRule,
                ParkingPass parkingPass) {
            this.registrationNumber = registrationNumber;
            this.pricingRule = pricingRule;
            this.parkingPass = parkingPass;
        }

        String getRegistrationNumber() {
            return registrationNumber;
        }

        double getPassPrice() {
            return parkingPass == null ? 0 : parkingPass.getPrice();
        }

        double calculateParkingFee(long entry, long exit) {
            if (parkingPass != null && parkingPass.isValid(entry, exit)) {
                return 0;
            }
            return pricingRule.calculateFee(entry, exit);
        }

        abstract String getVehicleType();
    }

    static class TwoWheeler extends Vehicle {
        TwoWheeler(String regNo) {
            super(regNo, new HourlyPricingRule(10), null);
        }

        String getVehicleType() {
            return "Two Wheeler";
        }
    }

    static class Car extends Vehicle {
        Car(String regNo) {
            super(regNo, new HourlyPricingRule(30), null);
        }

        String getVehicleType() {
            return "Car";
        }
    }

    static class ElectricCar extends Vehicle {
        private final double chargingUnits;

        ElectricCar(String regNo, double chargingUnits) {
            super(regNo, new HourlyPricingRule(30), null);
            this.chargingUnits = chargingUnits;
        }

        double getChargingFee() {
            return chargingUnits * 12;
        }

        String getVehicleType() {
            return "Electric Car";
        }
    }

    static class EBike extends Vehicle {
        EBike(String regNo) {
            super(regNo, new EBikePricingRule(), null);
        }

        String getVehicleType() {
            return "E-Bike";
        }
    }

    static class DeliveryVan extends Vehicle {
        DeliveryVan(String regNo) {
            super(regNo, new DeliveryVanPricingRule(30), null);
        }

        String getVehicleType() {
            return "Delivery Van";
        }
    }

    static class Visitor extends Vehicle {
        Visitor(String regNo, long validDay) {
            super(regNo, new HourlyPricingRule(30),
                    new VisitorDayPass(validDay));
        }

        String getVehicleType() {
            return "Visitor";
        }
    }

    static class ParkingSlot {
        private final int floor;
        private final int slotNumber;
        private Vehicle vehicle;

        ParkingSlot(int floor, int slotNumber) {
            this.floor = floor;
            this.slotNumber = slotNumber;
        }

        boolean isAvailable() {
            return vehicle == null;
        }

        void occupy(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        void release() {
            vehicle = null;
        }

        String getLocation() {
            return "Floor " + (floor + 1) + ", Slot " + (slotNumber + 1);
        }
    }

    static class ParkingTicket {
        final int ticketNumber;
        final Vehicle vehicle;
        final ParkingSlot slot;
        final long entryMinute;

        ParkingTicket(int ticketNumber, Vehicle vehicle,
                      ParkingSlot slot, long entryMinute) {
            this.ticketNumber = ticketNumber;
            this.vehicle = vehicle;
            this.slot = slot;
            this.entryMinute = entryMinute;
        }
    }

    private final ParkingSlot[][] floors;
    private final ParkingTicket[] activeTickets;
    private int ticketSequence = 1001;
    private double totalCollection = 0;

    ParkingSystemV2(int[] slotCounts) {
        floors = new ParkingSlot[slotCounts.length][];

        int totalSlots = 0;

        for (int i = 0; i < slotCounts.length; i++) {
            floors[i] = new ParkingSlot[slotCounts[i]];
            totalSlots += slotCounts[i];

            for (int j = 0; j < slotCounts[i]; j++) {
                floors[i][j] = new ParkingSlot(i, j);
            }
        }

        activeTickets = new ParkingTicket[totalSlots];
    }

    boolean enter(Vehicle vehicle, int floor,
                  int slotNumber, long entryMinute) {

        if (floor < 0 || floor >= floors.length
                || slotNumber < 0
                || slotNumber >= floors[floor].length) {
            System.out.println("Invalid parking slot");
            return false;
        }

        for (ParkingTicket ticket : activeTickets) {
            if (ticket != null &&
                    ticket.vehicle.getRegistrationNumber()
                            .equals(vehicle.getRegistrationNumber())) {
                System.out.println("Vehicle already parked");
                return false;
            }
        }

        ParkingSlot selected = floors[floor][slotNumber];

        if (!selected.isAvailable()) {
            System.out.println("Slot is occupied");
            return false;
        }

        int index = -1;

        for (int i = 0; i < activeTickets.length; i++) {
            if (activeTickets[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Parking facility is full");
            return false;
        }

        selected.occupy(vehicle);

        activeTickets[index] =
                new ParkingTicket(ticketSequence++, vehicle,
                        selected, entryMinute);

        totalCollection += vehicle.getPassPrice();

        System.out.println("Entry successful: Ticket "
                + activeTickets[index].ticketNumber
                + " | " + selected.getLocation());

        return true;
    }

    double exit(String registrationNumber, long exitMinute) {
        for (int i = 0; i < activeTickets.length; i++) {
            ParkingTicket ticket = activeTickets[i];

            if (ticket != null &&
                    ticket.vehicle.getRegistrationNumber()
                            .equals(registrationNumber)) {

                double fee = ticket.vehicle.calculateParkingFee(
                        ticket.entryMinute, exitMinute);

                if (ticket.vehicle instanceof ElectricCar) {
                    fee += ((ElectricCar) ticket.vehicle).getChargingFee();
                }

                totalCollection += fee;
                System.out.println("Ticket Number: " + ticket.ticketNumber);
                
                activeTickets[i] = null;

                System.out.println("Exit: " + registrationNumber
                        + " | Parking Fee: Rs. "
                        + fee);

                return fee;
            }
        }

        System.out.println("Active ticket not found");
        return -1;
    }

    void displayCollection() {
        System.out.println("TOTAL COLLECTION: Rs. " + totalCollection);
    }

    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM - VERSION 2");

        // Five floors with different slot counts: 3, 4, 2, 5, 3
        ParkingSystemV2 parking =
                new ParkingSystemV2(new int[]{3, 4, 2, 5, 3});

        long day = 20000;
        long base = day * 1440;

        Vehicle bike = new TwoWheeler("TN01AB1111");
        Vehicle car = new Car("TN02CD2222");
        Vehicle ebike = new EBike("TN03EF3333");
        Vehicle van = new DeliveryVan("TN04GH4444");
        Vehicle ev = new ElectricCar("TN05IJ5555", 2);
        Vehicle visitor = new Visitor("TN06KL6666", day);

        System.out.println("\nVEHICLE ENTRIES");

        parking.enter(bike, 0, 0, base + 600);
        parking.enter(car, 0, 1, base + 600);
        parking.enter(ebike, 1, 0, base + 600);
        parking.enter(van, 2, 0, base + 600);
        parking.enter(ev, 3, 0, base + 600);
        parking.enter(visitor, 4, 0, base + 600);

        System.out.println("\nVEHICLE EXITS");

        parking.exit("TN01AB1111", base + 660);
        parking.exit("TN02CD2222", base + 720);
        parking.exit("TN03EF3333", base + 660);
        parking.exit("TN04GH4444", base + 660);
        parking.exit("TN05IJ5555", base + 660);
        parking.exit("TN06KL6666", base + 720);

        System.out.println("\nINVALID SLOT TEST");
        parking.enter(new Car("TN07MN7777"), 8, 0, base + 700);

        System.out.println();
        parking.displayCollection();
    }
}
