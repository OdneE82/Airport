import java.util.*;

public class FlightFinder {
    private final AirportGraph airportGraph;

    public FlightFinder() {
        airportGraph = new AirportGraph();
    }

    public AirportGraph getAirportGraph() {
        return airportGraph;
    }

    public void findShortestPath(String departure, String arrival) {
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(departure);
        parentMap.put(departure, null);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            if(current.equals(arrival)) {
                List<String> path = reconstructPath(parentMap, arrival);
                if(path != null) {
                    printPath(path);
                    return;
                }
            }

            List<String> neighbors = airportGraph.getNeighbors(current);
            for(String neighbor : neighbors) {
                if(!parentMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        System.out.println("No path found between " + departure + " and " + arrival);
    }

    private List<String> reconstructPath(Map<String, String> parentMap, String current) {
        List<String> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    private void printPath(List<String> path) {
        System.out.print("Your travel is : ");
        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if(i < path.size() - 1) {
                System.out.print("-");
            }
        }
        System.out.println("\nThank you for flying with Widerøe!");
    }
}
