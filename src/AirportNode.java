public class AirportNode {
    private final String airport;
    private final int distance;

    public AirportNode(String airport, int distance) {
        this.airport = airport;
        this.distance = distance;
    }

    public String getAirport() {
        return airport;
    }

    public int getDistance() {
        return distance;
    }
}
