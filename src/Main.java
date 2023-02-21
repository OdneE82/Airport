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
        printArrivalStation(airports, departure);
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

        airports.put("ALF", new String[] {"BJF", "HFT", "HVG", "KKN", "MEH", "SOJ", "TOS", "VDS"});
        airports.put("ANX", new String[] {"BOO", "EVE", "SVJ", "TOS"});
        airports.put("BDU", new String[] {"OSL"});
        airports.put("BGO", new String[] {"FRO", "BOO", "EVE", "HAU", "KRS", "KSU", "MOL", "OSL", "SDN", "SVG", "TOS", "HOV", "AES"});
        airports.put("BVG", new String[] {"MEH", "VDS", "BJF", "HFT"});
        airports.put("BOO", new String[] {"BGO", "SFJ", "TOS", "TRD", "ANX", "LKN", "MQN"});
        airports.put("BNN", new String[] {"BOO", "OSL", "SSJ", "TRD"});
        airports.put("BJF", new String[] {"BVG", "HFT", "HVG", "KKN", "MEH", "TOS", "VDS", "VAW"});
        airports.put("FRO", new String[] {"BGO", "OSL"});
        airports.put("FDE", new String[] {"OSL"});
        airports.put("HFT", new String[] {"ALF", "BVG", "BJF", "HAA", "HVG", "KKN", "MEH", "TRF", "TOS", "VDS", "VAW"});
        airports.put("EVE", new String[] {"BGO", "BOO", "TRF", "TOS", "TRD", "ANX"});
        airports.put("HAA", new String[] {"TOS", "HFT", "HVG", "MEH", "VDS", "KKN"});
        airports.put("HAU", new String[] {"BGO"});
        airports.put("HVG", new String[] {"HFT", "KKN", "MEH", "TOS", "VDS"});
        airports.put("KKN", new String[] {"ALF", "TOS", "VDS", "VAW"});
        airports.put("KRS", new String[] {"BGO", "SVG", "TRD"});
        airports.put("KSU", new String[] {"BGO", "KRS", "MOL", "SVG", "TRD"});
        airports.put("LKL", new String[] {"TOS"});
        airports.put("LKN", new String[] {"BOO"});
        airports.put("MEH", new String[] {"BVG", "HFT", "HVG", "KKN", "TOS", "VDS"});
        airports.put("MQN", new String[] {"BOO", "OSL", "TRD"});
        airports.put("MOL", new String[] {"BGO", "KSU", "TRD"});
        airports.put("MJF", new String[] {"BOO", "OSL", "TRD"});
        airports.put("OSY", new String[] {"OSL", "RVK", "TRD"});
        airports.put("OSL", new String[] {"BGO", "BOO", "FDE", "RRS", "SDN", "SOG", "TOS", "TRD", "HOV"});
        airports.put("RRS", new String[] {"OSL"});
        airports.put("RVK", new String[] {"OSL", "TRD", "OSY"});
        airports.put("RET", new String[] {"BOO","LKN"});
        airports.put("SDN", new String[] {"BGO", "FDE", "OSL", "SOG", "HOV"});
        airports.put("TRF", new String[] {"BGO", "SVG", "TRD", "BOO", "EVE", "TOS"});
        airports.put("SSJ", new String[] {"BOO", "BNN", "OSL", "RVK", "TRD"});
        airports.put("SOG", new String[] {"BGO", "FDE", "OSL", "SDN", "HOV"});
        airports.put("SVG", new String[] {"BGO", "KRS", "TRF"});
        airports.put("SKN", new String[] {"BOO", "TOS"});
        airports.put("SVJ", new String[] {"BOO", "RET"});
        airports.put("SOJ", new String[] {"BVG", "HFT", "KKN", "MEH", "TOS", "VDS"});
        airports.put("TOS", new String[] {"ALF", "ANX", "BGO", "BVG", "BOO", "BJF", "HFT", "EVE", "EVE", "HAA", "HVG", "KKN", "KRS", "LKL", "LKN", "MEH", "SKN", "SOJ", "VDS", "VAW", "TRF", "SVJ"});
        airports.put("TRD", new String[] {"BOO", "BNN", "EVE", "KRS", "KSU", "MQN", "MJF", "OSY", "RVK", "TRF", "SSJ", "TOS", "AES"});
        airports.put("VDS", new String[] {"ALF", "BVG", "BJF", "HFT", "HVG", "KKN", "MEH", "SOJ", "TOS", "VAW"});
        airports.put("VAW", new String[] {"BVG", "BFJ", "HFT", "KKN", "TOS", "VGS"});
        airports.put("HOV", new String[] {"BGO", "OSL", "SOG"});
        airports.put("AES", new String[] {"BGO", "KSU", "TRD"});

        return airports;
    }

    private static void printDepartureStation(HashMap<String, String[]> airports) {
        String joinedDeparture = String.join(",",airports.keySet());
        System.out.println(joinedDeparture);
    }

    private static void printArrivalStation(HashMap<String, String[]> airports, String departure) {
        System.out.println("Please select your arrival airport");
        String[] arrivalAirports = airports.keySet().stream()
                .filter(airport -> !airport.equals(departure))
                .toArray(String[]::new);
        String joinedArrival = String.join(", ", arrivalAirports);
        System.out.println(joinedArrival);
    }

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