import java.time.LocalDate;

public class AvisDesClients {
    private String reviewerName;
    private String email;
    private String description;
    private LocalDate date;
    private int rating;

    public AvisDesClients(String reviewerName, String email, String description, LocalDate date, int rating) {
        this.reviewerName = reviewerName;
        this.email = email;
        this.description = description;
        this.date = date;
        this.rating = rating;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getRating() {
        return rating;
    }
}
