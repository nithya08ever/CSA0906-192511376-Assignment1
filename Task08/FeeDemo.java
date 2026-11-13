
package Task08;

import java.time.LocalTime;
import java.time.Duration;

// Interface for electric vehicle charging
interface Chargeable {
    double chargingFee(int kWh);
}

// Abstract parent class
abstract class Vehicle {

    private final String regNo;

    protected Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    protected abstract double ratePerHour();

    // Method 1: Calculate fee using minutes
    public double calculateFee(int minutes) {

        if (minutes <= 0) {
            return 0;
        }

        // Ceiling division using integer arithmetic
        int hours = (minutes + 59) / 60;

        return hours * ratePerHour();
    }

    // Method 2: Overloaded method using LocalTime
    public double calculateFee(LocalTime in, LocalTime out) {

        long minutes = Duration.between(in, out).toMinutes();

        if (minutes < 0) {
            minutes += 24 * 60;
        }

        return calculateFee((int) minutes);
    }

    @Override
    public boolean equals(Object o) {

        return o instanceof Vehicle
                && regNo.equals(((Vehicle) o).regNo);
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }
}

// Two-wheeler subclass
class TwoWheeler extends Vehicle {

    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    protected double ratePerHour() {
        return 10;
    }
}

// Car subclass
class Car extends Vehicle {

    Car(String regNo) {
        super(regNo);
    }

    @Override
    protected double ratePerHour() {
        return 30;
    }
}

// Electric car subclass
class ElectricCar extends Car implements Chargeable {

    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double chargingFee(int kWh) {
        return kWh * 12;
    }
}

// Main class
public class FeeDemo {

    public static void main(String[] args) {

        Vehicle[] parked = {
            new TwoWheeler("TN01A1"),
            new Car("TN02B2"),
            new ElectricCar("TN03C3")
        };

        for (Vehicle v : parked) {

            double fee = v.calculateFee(130);

            if (v instanceof Chargeable c) {
                fee += c.chargingFee(10);
            }

            System.out.println(
                v.getClass().getSimpleName() + " "
                + v.getRegNo() + " -> Rs " + fee
            );
        }

        System.out.println(
            new Car("TN02B2").equals(
                new ElectricCar("TN02B2")
            )
        );
    }
}
