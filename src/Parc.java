import java.util.List;

public class Parc extends GeoLocation {
    private String description;
    private List<Hotel> nearbyHotels;

    public Parc(String name, double latitude, double longitude, String description, List<Hotel> nearbyHotels) {
        super(name, latitude, longitude);
        this.description = description;
        this.nearbyHotels = nearbyHotels;
    }

    public String getDescription() {
        return description;
    }

    public List<Hotel> getNearbyHotels() {
        return nearbyHotels;
    }
}
