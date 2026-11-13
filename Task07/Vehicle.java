
package Task07;

import java.util.Objects;

// Abstract parent class
abstract class Vehicle {

    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    protected abstract double ratePerHour();

    public abstract double calculateFee(int minutes);

    @Override
    public String toString() {
        return "Vehicle Registration: " + regNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Vehicle)) {
            return false;
        }

        Vehicle other = (Vehicle) obj;

        return Objects.equals(regNo, other.regNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo);
    }
}

// Two-wheeler
class TwoWheeler extends Vehicle {

    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    protected double ratePerHour() {
        return 10;
    }

    @Override
    public double calculateFee(int minutes) {
        int hours = minutes <= 0 ? 0 : (minutes + 59) / 60;
        return hours * ratePerHour();
    }
}

// Car
class Car extends Vehicle {

    Car(String regNo) {
        super(regNo);
    }

    @Override
    protected double ratePerHour() {
        return 30;
    }

    @Override
    public double calculateFee(int minutes) {
        int hours = minutes <= 0 ? 0 : (minutes + 59) / 60;
        return hours * ratePerHour();
    }
}

// Electric car
class ElectricCar extends Car {

    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee(int minutes) {
        return super.calculateFee(minutes);
    }

    @Override
    public String toString() {
        return "ElectricCar Registration: " + getRegNo();
    }
}
