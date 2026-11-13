
package Task09;

// First interface
interface Chargeable {

    double chargingFee(int kWh);

    // Default method
    default void chargingDescription() {
        System.out.println("Charging facility available");
    }

    // Static method
    static double standardChargingRate() {
        return 12.0;
    }
}

// Second interface
interface Payable {
    void makePayment(double amount);
}

// Abstract superclass
abstract class Vehicle {

    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    abstract double ratePerHour();

    public double calculateFee(int minutes) {

        if (minutes <= 0) {
            return 0;
        }

        int hours = (minutes + 59) / 60;

        return hours * ratePerHour();
    }
}

// Two-wheeler
class TwoWheeler extends Vehicle {

    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 10;
    }
}

// Car
class Car extends Vehicle {

    Car(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 30;
    }
}

// Electric car implements two interfaces
class ElectricCar extends Car implements Chargeable, Payable {

    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double chargingFee(int kWh) {
        return kWh * Chargeable.standardChargingRate();
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment processed: Rs. " + amount);
    }
}
