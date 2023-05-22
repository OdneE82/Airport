package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a graph of airports and their connections
 */

public class AirportGraph {
    private final Map<String, Airport> airports;

    /**
     * Constructs an java.AirportGraph object and initializes the airports and their connections
     */

    public AirportGraph() {
        airports = new HashMap<>();
        initializeAirports();
    }

    private void initializeAirports() {
        airports.put("ALF", new Airport("ALF", List.of("BJF", "HFT", "HVG", "KKN", "MEH", "SOJ", "TOS", "VDS")));
        airports.put("ANX", new Airport("ANX", List.of("BOO", "EVE", "SVJ", "TOS")));
        airports.put("BDU", new Airport("BDU", List.of("OSL")));
        airports.put("BGO", new Airport("BGO", List.of("FRO", "BOO", "EVE", "HAU", "KRS", "KSU", "MOL", "OSL", "SDN", "SVG", "TOS", "HOV", "AES")));
        airports.put("BVG", new Airport("BVG", List.of("MEH", "VDS", "BJF", "HFT")));
        airports.put("BOO", new Airport("BOO", List.of("BGO", "SFJ", "TOS", "TRD", "ANX", "LKN", "MQN")));
        airports.put("BNN", new Airport("BNN", List.of("BOO", "OSL", "SSJ", "TRD")));
        airports.put("BJF", new Airport("BJF", List.of("BVG", "HFT", "HVG", "KKN", "MEH", "TOS", "VDS", "VAW")));
        airports.put("FRO", new Airport("FRO", List.of("BGO")));
        airports.put("FDE", new Airport("FDE", List.of("OSL")));
        airports.put("HFT", new Airport("HFT", List.of("ALF", "BVG", "BJF", "HAA", "HVG", "KKN", "MEH", "TRF", "TOS", "VDS", "VAW")));
        airports.put("EVE", new Airport("EVE", List.of("BGO", "BOO", "TRF", "TOS", "TRD", "ANX")));
        airports.put("HAA", new Airport("HAA", List.of("TOS", "HFT", "HVG", "MEH", "VDS", "KKN")));
        airports.put("HAU", new Airport("HAU", List.of("BGO")));
        airports.put("HVG", new Airport("HVG", List.of("HFT", "KKN", "MEH", "TOS", "VDS")));
        airports.put("KKN", new Airport("KKN", List.of("ALF", "TOS", "VDS", "VAW")));
        airports.put("KRS", new Airport("KRS", List.of("BGO", "SVG", "TRD")));
        airports.put("KSU", new Airport("KSU", List.of("BGO", "KRS", "MOL", "SVG", "TRD")));
        airports.put("LKL", new Airport("LKL", List.of("TOS")));
        airports.put("LKN", new Airport("LKN", List.of("BOO")));
        airports.put("MEH", new Airport("MEH", List.of("BVG", "HFT", "HVG", "KKN", "TOS", "VDS")));
        airports.put("MQN", new Airport("MQN", List.of("BOO", "OSL", "TRD")));
        airports.put("MOL", new Airport("MOL", List.of("BGO", "KSU", "TRD")));
        airports.put("MJF", new Airport("MJF", List.of("BOO", "OSL", "TRD")));
        airports.put("OSY", new Airport("OSY", List.of("OSL", "RVK", "TRD")));
        airports.put("OSL", new Airport("OSL", List.of("BGO", "BOO", "FDE", "RRS", "SDN", "SOG", "TOS", "TRD", "HOV")));
        airports.put("RRS", new Airport("RRS", List.of("OSL")));
        airports.put("RVK", new Airport("RVK", List.of("OSL", "TRD", "OSY")));
        airports.put("RET", new Airport("RET", List.of("BOO","LKN")));
        airports.put("SDN", new Airport("SDN", List.of("BGO", "FDE", "OSL", "SOG", "HOV")));
        airports.put("TRF", new Airport("TRF", List.of("BGO", "SVG", "TRD", "BOO", "EVE", "TOS")));
        airports.put("SSJ", new Airport("SSJ", List.of("BOO", "BNN", "OSL", "RVK", "TRD")));
        airports.put("SOG", new Airport("SOG", List.of("BGO", "FDE", "OSL", "SDN", "HOV")));
        airports.put("SVG", new Airport("SVG", List.of("BGO", "KRS", "TRF")));
        airports.put("SKN", new Airport("SKN", List.of("BOO", "TOS")));
        airports.put("SVJ", new Airport("SVJ", List.of("BOO", "RET")));
        airports.put("SOJ", new Airport("SOJ", List.of("BVG", "HFT", "KKN", "MEH", "TOS", "VDS")));
        airports.put("TOS", new Airport("TOS", List.of("ALF", "ANX", "BGO", "BVG", "BOO", "BJF", "HFT", "EVE", "EVE", "HAA", "HVG", "KKN", "KRS", "LKL", "LKN", "MEH", "SKN", "SOJ", "VDS", "VAW", "TRF", "SVJ")));
        airports.put("TRD", new Airport("TRD", List.of("BOO", "BNN", "EVE", "KRS", "KSU", "MQN", "MJF", "OSY", "RVK", "TRF", "SSJ", "TOS", "AES")));
        airports.put("VDS", new Airport("VDS", List.of("ALF", "BVG", "BJF", "HFT", "HVG", "KKN", "MEH", "SOJ", "TOS", "VAW")));
        airports.put("VAW", new Airport("VAW", List.of("BVG", "BFJ", "HFT", "KKN", "TOS", "VGS")));
        airports.put("HOV", new Airport("HOV", List.of("BGO", "OSL", "SOG")));
        airports.put("AES", new Airport("AES", List.of("BGO", "KSU", "TRD")));
    }

    /**
     * Returns a list of all airport codes in the graph
     * @return a list of all airport codes.
     */

    public List<String> getAirportCodes() {
        return new ArrayList<>(airports.keySet());
    }

    /**
     * Returns a list of neighboring airports for the given airport code.
     * @param airportCode the airport code
     * @return a list of neighboring airport codes
     */

    public List<String> getNeighbors(String airportCode) {
        Airport airport = airports.get(airportCode);
        if(airport != null) {
            return airport.getNeighbors();
        }
        return new ArrayList<>();
    }
}
