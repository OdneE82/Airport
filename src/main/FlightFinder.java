package main;

import java.util.*;

/**
 * java.FlightFinder is responsible for finding the shortest path between airports using Dijkstra's algorithm..
 */

public class FlightFinder {
    private final AirportGraph airportGraph;

    /**
     * Constructs a java.FlightFinder object
     */

    public FlightFinder() {
        airportGraph = new AirportGraph();
    }

    /**
     * Returns the airport graph used by the java.FlightFinder
     * @return the airport graph
     */

    public AirportGraph getAirportGraph() {
        return airportGraph;
    }

    /**
     * Finds the shortest path between the departure and arrival airports and prints the path.
     * @param departure the departure airport code
     * @param arrival the arrival airport code
     */

    public void findShortestPath(String departure, String arrival) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousAirports = new HashMap<>();
        PriorityQueue<AirportNode> queue = new PriorityQueue<>(Comparator.comparingInt(AirportNode::getDistance));
        Set<String> visited = new HashSet<>();

        for (String airport : airportGraph.getAirportCodes()) {
            distances.put(airport, Integer.MAX_VALUE);
        }
        distances.put(departure, 0);

        queue.offer(new AirportNode(departure, 0));

        while(!queue.isEmpty()) {
            AirportNode currentAirportNode = queue.poll();
            String currentAirport = currentAirportNode.getAirport();

            if (currentAirport.equals(arrival)) {
                List<String> path = reconstructPath(previousAirports, arrival);
                printPath(path);
                return;
            }

            if (visited.contains(currentAirport)) {
                continue;
            }

            visited.add(currentAirport);

            List<String> neighbors = airportGraph.getNeighbors(currentAirport);

            for (String neighbor : neighbors) {
                int distanceToNeighbor = distances.get(currentAirport) + 1; // assuming all edges have equal weight

                if (!distances.containsKey(neighbor) || distanceToNeighbor < distances.get(neighbor)) {
                    distances.put(neighbor, distanceToNeighbor);
                    previousAirports.put(neighbor, currentAirport);
                    queue.offer(new AirportNode(neighbor, distanceToNeighbor));
                }
            }
        }

        System.out.println("No path between " + departure + " and " + arrival);
    }


    /**
     * Prints the path of the shortest route.
     * @param path the list of airports in the shortest route.
     */
    private void printPath(List<String> path) {
        System.out.print("Your travel is: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() -1 ) {
                System.out.print("-");
            }
        }
    }

    /**
     * Reconstructs the path from the previousAirports map.
     *
     * @param previousAirports the map containing previous airports for each airport
     * @param current the current airport
     * @return The reconstructed path
     */

    private List<String> reconstructPath(Map<String, String> previousAirports, String current) {
        List<String> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = previousAirports.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    /*

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

     */
}
