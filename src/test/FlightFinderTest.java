package test;

import org.junit.jupiter.api.Test;

import main.FlightFinder;

import java.util.List;
import java.util.Random;

public class FlightFinderTest {

    private static final List<String> AIRPORT_CODES = List.of("ANX","BDU","BGO","BVG","BOO","BNN","BJF","FDE","HFT","EVE","HAA","HAU","HVG","KKN","KRS","KSU","LKL","LKN","MEH","MQN","MOL","MJF","OSY","OSL","RRS","RVK","RET","SDN","TRF","SSJ","SOG","SVG","SKN","SVJ","SOJ","TOS","TRD","VDS","VAW","HOV","AES");
    private static final Random RANDOM = new Random();

    @Test
    public void testFindShortestPath() {
        FlightFinder flightFinder = new FlightFinder();

        for (int i = 0; i < 20; i++) {
            String departure = getRandomAirportCode();
            String arrival = getRandomAirportCode();

            testRoute(flightFinder, departure, arrival);
        }
    }

    private String getRandomAirportCode() {
        int index = RANDOM.nextInt(AIRPORT_CODES.size());
        return AIRPORT_CODES.get(index);
    }

    private void testRoute(FlightFinder flightFinder, String departure, String arrival) {
        System.out.println("\nFinding route from " + departure + " to " + arrival);
        flightFinder.findShortestPath(departure, arrival);
    }
}
