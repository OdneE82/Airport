import java.util.*;

/**
 * Little program to test HashMaps and other features.
 */

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> airports = initializeAirports();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select your departure airport");
        printDepartureStation(airports);
        String departure = scanner.nextLine().toUpperCase();

        System.out.println("Choose your destination");
        printArrivalStation(airports);
        String arrival = scanner.nextLine().toUpperCase();

        List<String> path = findShortestPath(airports, departure, arrival);

        if(path == null) {
            System.out.println("No path found between " + departure + " and " + arrival);
        }
        else {
            System.out.print("Your travel is: ");
            for(int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() -1) {
                    System.out.print("-");
                }
            }
            System.out.println("\nThank you for flying with Widerøe!");
        }
    }

    private static HashMap<String, String[]> initializeAirports() {
        HashMap<String, String[]> airports = new HashMap<>();

        airports.put("BOO", new String[] {"BGO", "OSL"});
        airports.put("BGO", new String[] {"OSL", "BOO", "FRO"});
        airports.put("OSL", new String[] {"BGO", "BOO", "FRO"});
        airports.put("FRO", new String[] {"BGO", "OSL"});
        airports.put("SVG", new String[] {"BGO", "OSL"});

        return airports;
    }

    private static void printDepartureStation(HashMap<String, String[]> airports) {
        String joinedDeparture = String.join(",",airports.keySet());
        System.out.println(joinedDeparture);
    }

    private static void printArrivalStation(HashMap<String, String[]> airports) {
        String joinedArrival = String.join(",",airports.keySet());
        System.out.println(joinedArrival);
    }

    /**
    private static void printDestination(String[] destinations) {
        String joinedDestination = String.join(",",destinations);
        System.out.println(joinedDestination);
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
     */

    private static List<String> findShortestPath(HashMap<String, String[]> airports, String departure, String arrival) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String, String> parentMap = new HashMap<>();

        queue.add(departure);
        parentMap.put(departure, null);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            if(current.equals(arrival)) {
                return reconstructPath(parentMap, arrival);
            }
            String[] neighbors = airports.get(current);
            if(neighbors != null) {
                for(String neighbor : neighbors) {
                    if(!parentMap.containsKey(neighbor)) {
                        queue.add(neighbor);
                        parentMap.put(neighbor, current);
                    }
                }
            }
        }

        return null;
    }

    private static List<String> reconstructPath(HashMap<String, String> parentMap, String current) {
        List<String> path = new ArrayList<>();
        while(current!=null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}