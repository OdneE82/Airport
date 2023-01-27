import java.util.Scanner;


public class Main {

    static String [] BOO = {"BGO", "OSL"};
    static String [] BGO = {"BOO", "OSL"};
    static String [] OSL = {"BGO", "BOO"};

    public static void main(String[] args) {

        Scanner IATA = new Scanner(System.in);
        Scanner Destination = new Scanner(System.in);

        System.out.println("Enter Airport");
        String airport = IATA.nextLine();

        if (airport.equals("BOO")) {
            System.out.println("You chose BOO airport \nWhich destination would you like to travel to?");
            for(int i = 0; i<BOO.length; i++) {
                System.out.println(BOO[i]);
            }
            System.out.println("Choose your destination");
            String destination = Destination.nextLine();
            for (int i = 0; i < BOO.length; i++) {
                if (destination.equals(BOO[i])) {
                    System.out.println("Your travel from " + airport + " to " + destination + " has been confirmed. Thank you for flying with Wideroe!");
                }
                else {
                    System.out.println("Route not found, try again");
                }
            }
        }

        if(airport.equals("BGO")) {
            System.out.println("You chose BGO airport \nWhich destination would you like to travel to?");
            for(int i = 0; i<BGO.length; i++) {
                System.out.println(BGO[i]);
            }
            System.out.println("Choose your destination");
            String destination = Destination.nextLine();
            for (int i = 0; i < BGO.length; i++) {
                if (destination.equals(BGO[i])) {
                    System.out.println("Your travel from " + airport + " to " + destination + " has been confirmed. Thank you for flying with Wideroe!");
                }
                else {
                    System.out.println("Route not found, try again");
                }
            }
        }

        if (airport.equals("OSL")) {
            System.out.println("You chose OSL airport \nWhich destination would you like to travel to?");
            for (int i = 0; i < OSL.length; i++) {
                System.out.println(OSL[i]);
            }
            System.out.println("Choose your destination");
            String destination = Destination.nextLine();
            for (int i = 0; i < OSL.length; i++) {
                if (destination.equals(OSL[i])) {
                    System.out.println("Your travel from " + airport + " to " + destination + " has been confirmed. Thank you for flying with Wideroe!");
                }
                else {
                    System.out.println("Route not found, try again");
                }
            }
        }
    }
}