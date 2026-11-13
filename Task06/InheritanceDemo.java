
package Task06;

public class InheritanceDemo {

    public static void main(String[] args) {

        System.out.println("CREATING TWO WHEELER");
        TwoWheeler bike = new TwoWheeler("TN01AB1111");

        System.out.println("\nCREATING CAR");
        Car car = new Car("TN02CD2222");

        System.out.println("\nCREATING ELECTRIC CAR");
        ElectricCar ev = new ElectricCar("TN03EF3333");

        System.out.println("\nVEHICLE DETAILS");

        System.out.println(
                bike.getRegNo() + " Rate: Rs. " +
                bike.ratePerHour());

        System.out.println(
                car.getRegNo() + " Rate: Rs. " +
                car.ratePerHour());

        System.out.println(
                ev.getRegNo() + " Rate: Rs. " +
                ev.ratePerHour());
    }
}
