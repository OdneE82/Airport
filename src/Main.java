import java.util.HashMap;
import java.util.Scanner;

/**
 * Little program to test HashMaps and other features.
 */

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> airports = initializeAirports();

        System.out.println("Please select your departure airport");
        printDepartureStation(airports);

        Scanner IATA = new Scanner(System.in);
        String airport = IATA.nextLine().toUpperCase();
        System.out.println("From " + airport + " you can travel to: ");

        printDestination(airports.get(airport));

        System.out.println("Choose your destination");
        String destination = IATA.nextLine().toUpperCase();
        checkDestination(airports, airport, destination);
    }

    private static HashMap<String, String[]> initializeAirports() {
        HashMap<String, String[]> airports = new HashMap<>();

        airports.put("BOO", new String[] {"BGO", "OSL"});
        airports.put("BGO", new String[] {"BGO", "BOO", "FRO"});
        airports.put("OSL", new String[] {"BGO", "BOO", "FRO"});
        airports.put("FRO", new String[] {"BGO", "OSL"});

        return airports;
    }

    private static void printDepartureStation(HashMap<String, String[]> airports) {
        int i = 0;
        for (String key : airports.keySet()) {
            if (i == airports.size() - 1) {
                System.out.print(key);
            } else {
                System.out.print(key + ", ");
            }
            i++;
        }
        System.out.println();
    }

    private static void printDestination(String[] destinations) {
        for (int i = 0; i < destinations.length; i++) {
            if( i == destinations.length -1) {
                System.out.print(destinations[i]);
            } else {
                System.out.print(destinations[i] + ", ");
            }
        }
        System.out.println();
    }

    private static void checkDestination(HashMap<String, String[]> airports, String airport, String destination) {
        String[] destinations = airports.get(airport);
        boolean isValidDestination = false;
        for (String dest : destinations) {
            if (dest.equals(destination)) {
                isValidDestination = true;
                break;
            }
        }
        if (isValidDestination) {
            System.out.println("Your travel from " + airport + " to " + destination + " is confirmed.");
        } else {
            System.out.println("Invalid destination. Please choose a destination from the list above.");
        }
    }

}