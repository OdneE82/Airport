package main;

import java.util.List;

/**
 *  Represents an airport with its code and neighboring airports
 */

public class Airport {
    private final String code;
    private final List<String> neighbors;

    /**
     * Constructs an java.Airport object with the specified airport code and neighboring airports.
     * @param code The code of the airport.
     * @param neighbors The list of the neighboring airports.
     */

    public Airport(String code, List<String> neighbors) {
        this.code = code;
        this.neighbors = neighbors;
    }

    /**
     * Returns the code of the airport
     * @return the code of the airport
     */

    public String getCode() {
        return code;
    }

    /**
     * Returns the list of neighboring airports
     * @return The list of neighboring airports
     */

    public List<String> getNeighbors() {
        return neighbors;
    }
}
