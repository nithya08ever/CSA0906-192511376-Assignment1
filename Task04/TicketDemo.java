
    
package Task04;

public class TicketDemo {

    public static void main(String[] args) {

        // Using default constructor
        ParkingTicket ticket1 = new ParkingTicket();

        // Using parameterised constructor
        ParkingTicket ticket2 =
                new ParkingTicket(
                        "TKT001",
                        "TN01AB1111",
                        0,
                        1
                );

        // Using overloaded constructor with entry time
        ParkingTicket ticket3 =
                new ParkingTicket(
                        "TKT002",
                        "TN02CD2222",
                        java.time.LocalDateTime.now(),
                        1,
                        2
                );

        System.out.println("DEFAULT CONSTRUCTOR");
        ticket1.displayTicket();

        System.out.println("PARAMETERISED CONSTRUCTOR");
        ticket2.displayTicket();

        System.out.println("OVERLOADED CONSTRUCTOR");
        ticket3.displayTicket();
    }
}


