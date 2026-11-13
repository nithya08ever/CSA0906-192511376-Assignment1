
package Task07;

public class OverrideDemo {

    public static void main(String[] args) {

        Vehicle bike = new TwoWheeler("TN01AB1111");
        Vehicle car = new Car("TN02CD2222");
        Vehicle ev = new ElectricCar("TN03EF3333");

        System.out.println("PARKING FEE DETAILS");

        System.out.println(
            bike + " -> Rs. " + bike.calculateFee(130)
        );

        System.out.println(
            car + " -> Rs. " + car.calculateFee(130)
        );

        System.out.println(
            ev + " -> Rs. " + ev.calculateFee(130)
        );

        System.out.println("\nEQUALS METHOD TEST");

        Car car1 = new Car("TN02CD2222");
        ElectricCar car2 = new ElectricCar("TN02CD2222");

        System.out.println("Are vehicles equal? " +
                car1.equals(car2));

        System.out.println("Hash codes equal? " +
                (car1.hashCode() == car2.hashCode()));

        System.out.println("\nTOSTRING METHOD TEST");

        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }
}
