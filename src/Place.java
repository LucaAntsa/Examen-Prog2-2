import java.util.List;

public interface Place {
    String getName();
    Coordinates getCoordinates();
    List<AvisDesClients> getReviews();
    void addReview(AvisDesClients review);
}
