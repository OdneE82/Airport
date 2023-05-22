import java.util.List;

public class Airport {
    private final String code;
    private final List<String> neighbors;

    public Airport(String code, List<String> neighbors) {
        this.code = code;
        this.neighbors = neighbors;
    }

    public String getCode() {
        return code;
    }

    public List<String> getNeighbors() {
        return neighbors;
    }
}
