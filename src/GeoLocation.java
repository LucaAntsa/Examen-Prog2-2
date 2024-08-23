import java.util.ArrayList;
import java.util.List;

public abstract class GeoLocation implements Place {
    private String name;
    private Coordinates coordinates;
    private List<AvisDesClients> reviews;

    public GeoLocation(String name, double latitude, double longitude) {
        this.name = name;
        this.coordinates = new Coordinates(latitude, longitude);
        this.reviews = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public List<AvisDesClients> getReviews() {
        return reviews;
    }

    @Override
    public void addReview(AvisDesClients review) {
        reviews.add(review);
    }
}
