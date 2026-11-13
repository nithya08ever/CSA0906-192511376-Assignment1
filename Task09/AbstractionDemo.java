
package Task09;

public class AbstractionDemo {

    public static void main(String[] args) {

        Vehicle bike = new TwoWheeler("TN01AB1111");
        Vehicle car = new Car("TN02CD2222");
        ElectricCar ev = new ElectricCar("TN03EF3333");

        System.out.println("ABSTRACTION DEMONSTRATION");

        System.out.println(
            bike.getRegNo() + " Parking Fee: Rs. "
            + bike.calculateFee(130)
        );

        System.out.println(
            car.getRegNo() + " Parking Fee: Rs. "
            + car.calculateFee(130)
        );

        System.out.println("\nELECTRIC CAR DETAILS");

        double parkingFee = ev.calculateFee(130);
        double chargingFee = ev.chargingFee(10);

        System.out.println("Registration: " + ev.getRegNo());

        ev.chargingDescription();

        System.out.println("Parking Fee: Rs. " + parkingFee);
        System.out.println("Charging Fee: Rs. " + chargingFee);

        ev.makePayment(parkingFee + chargingFee);

        System.out.println(
            "Standard Charging Rate: Rs. "
            + Chargeable.standardChargingRate()
            + " per kWh"
        );
    }
}
