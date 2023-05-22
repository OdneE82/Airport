package main;

/**
 * Represents a node in the airport graph with an airport and its distance.
 */

public class AirportNode {
    private final String airport;
    private final int distance;

    /**
     * Constructs an java.AirportNode object with the specified airport and distance
     * @param airport the airport code
     * @param distance the distanec from the source airport to this airport
     */

    public AirportNode(String airport, int distance) {
        this.airport = airport;
        this.distance = distance;
    }

    /**
     * Returns the airport code
     * @return the airport code
     */

    public String getAirport() {
        return airport;
    }

    /**
     * Returns the distance from the source airport to this airport.
     * @return the distance from source airport to this airport
     */

    public int getDistance() {
        return distance;
    }
}
