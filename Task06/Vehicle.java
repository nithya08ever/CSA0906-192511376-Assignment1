
package Task06;

// Parent class
abstract class Vehicle {

    protected String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
        System.out.println("Vehicle constructor executed");
    }

    public String getRegNo() {
        return regNo;
    }

    abstract double ratePerHour();
}

// Child class 1
class TwoWheeler extends Vehicle {

    TwoWheeler(String regNo) {
        super(regNo);
        System.out.println("TwoWheeler constructor executed");
    }

    @Override
    double ratePerHour() {
        return 10;
    }
}

// Child class 2
class Car extends Vehicle {

    Car(String regNo) {
        super(regNo);
        System.out.println("Car constructor executed");
    }

    @Override
    double ratePerHour() {
        return 30;
    }
}

// Child class of Car
class ElectricCar extends Car {

    ElectricCar(String regNo) {
        super(regNo);
        System.out.println("ElectricCar constructor executed");
    }
}

// User parent class
class User {

    protected String userId;
    protected String name;

    User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

class Student extends User {

    Student(String id, String name) {
        super(id, name);
    }
}

class Staff extends User {

    Staff(String id, String name) {
        super(id, name);
    }
}

class Visitor extends User {

    Visitor(String id, String name) {
        super(id, name);
    }
}
