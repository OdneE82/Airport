import java.util.Scanner;

public class Main {

    static String[] BOO = {"BGO", "OSL"};
    static String[] BGO = {"BGO", "BOO", "FRO"};
    static String[] OSL = {"BGO", "BOO", "FRO"};
    static String[] FRO = {"BGO", "OSL"};

    public static void main(String[] args) {

        Scanner IATA = new Scanner(System.in);

        String airport = IATA.nextLine();

        System.out.println("From " + airport + " you can travel to: ");

        if(airport.equals("BOO")) {
            printDestination(BOO);
        } else if (airport.equals("BGO")) {
            printDestination(BGO);
        } else if (airport.equals("OSL")) {
            printDestination(OSL);
        } else if (airport.equals("FRO")) {
            printDestination(FRO);
        }

        System.out.println("Choose your destination");

        String destination = IATA.nextLine();

        checkDestination(airport, destination);
    }

    private static void printDestination(String[] Airport) {
        for (String dest : Airport) {
            System.out.println(dest);
        }
    }

    private static void checkDestination(String airport, String destination) {
        String[] destinations = null;
        if(airport.equals("BOO")) {
            destinations = BOO;
        } else if (airport.equals("BGO")) {
            destinations = BGO;
        } else if (airport.equals("OSL")) {
            destinations = OSL;
        } else if (airport.equals("FRO")) {
            destinations = FRO;
        }

        if (destinations != null) {
            boolean found = false;
            for (String dest : destinations) {
                if (dest.equals(destination)) {
                    found = true;
                    break;
                }
            }
            if(found) {
                System.out.println("Your travel from " + airport + " to " + destination + " is confirmed.");
            } else {
                System.out.println("Route not found, try again");
            }
        } else {
            System.out.println("Invalid airport, try again");
        }
    }
}