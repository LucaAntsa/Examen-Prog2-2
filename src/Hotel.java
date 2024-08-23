import java.util.List;

public class Hotel extends GeoLocation {
    private String telephoneNumber;
    private String email;
    private List<Chambre> chambres;

    public Hotel(String name, double latitude, double longitude, String telephoneNumber, String email, List<Chambre> chambres) {
        super(name, latitude, longitude);
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.chambres = chambres;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }
}
