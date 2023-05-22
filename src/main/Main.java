package main;

import java.util.*;

/**
 * Little program to test HashMaps and other features.
 */

public class Main {

    /**
     * java.Main method starts the flight finder program
     */

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select your departure airport");
        printDepartureStations(flightFinder);
        String departure = scanner.nextLine().toUpperCase();

        System.out.println("Choose your destination");
        printArrivalStations(flightFinder, departure);
        String arival = scanner.nextLine().toUpperCase();

        flightFinder.findShortestPath(departure, arival);

        System.out.println("\nThank you for flying with Widerøe!");
    }

    /**
     * Prints the list of departure stations.
     * @param flightFinder the flightFinder object
     */

    private static void printDepartureStations(FlightFinder flightFinder) {
        System.out.println(String.join(", ", flightFinder.getAirportGraph().getAirportCodes()));
    }

    /**
     * Prints the list of arrival stations for the given departure station.
     *
     * @param flightFinder the java.FlightFinder object.
     * @param departure the departure airport code
     */

    private static void printArrivalStations(FlightFinder flightFinder, String departure) {
        List<String> airportCodes = flightFinder.getAirportGraph().getAirportCodes();
        airportCodes.remove(departure);
        System.out.println(String.join(", ", airportCodes));
    }
}