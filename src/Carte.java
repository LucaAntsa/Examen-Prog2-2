import java.util.ArrayList;
import java.util.List;

public class Carte {
    private List<Parc> parcs;
    private List<Hotel> hotels;

    public Carte(List<Parc> parcs, List<Hotel> hotels) {
        this.parcs = parcs;
        this.hotels = hotels;
    }

    public List<AvisDesClients> getAllReviews() {
        List<AvisDesClients> allReviews = new ArrayList<>();
        for (Place place : getAllPlaces()) {
            allReviews.addAll(place.getReviews());
        }
        return allReviews;
    }

    public Hotel findBestHotel() {
        Hotel bestHotel = null;
        int maxParcs = 0;
        for (Hotel hotel : hotels) {
            int parcsCount = 0;
            for (Parc parc : parcs) {
                if (parc.getNearbyHotels().contains(hotel)) {
                    parcsCount++;
                }
            }
            if (parcsCount > maxParcs) {
                maxParcs = parcsCount;
                bestHotel = hotel;
            } else if (parcsCount == maxParcs) {

            }
        }
        return bestHotel;
    }

    public List<Place> getAllPlacesInside(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude) {
        List<Place> placesInside = new ArrayList<>();
        for (Place place : getAllPlaces()) {
            Coordinates coords = place.getCoordinates();
            if (coords.getLatitude() >= minLatitude && coords.getLatitude() <= maxLatitude &&
                    coords.getLongitude() >= minLongitude && coords.getLongitude() <= maxLongitude) {
                placesInside.add(place);
            }
        }
        return placesInside;
    }

    public double findCheapestHotelPrice(List<Parc> parcsToVisit) {
        double totalMinPrice = 0;
        for (Parc parc : parcsToVisit) {
            double minPrice = Double.MAX_VALUE;
            for (Hotel hotel : parc.getNearbyHotels()) {
                for (Chambre chambre : hotel.getChambres()) {
                    if (chambre.getTarifParNuitée() < minPrice) {
                        minPrice = chambre.getTarifParNuitée();
                    }
                }
            }
            totalMinPrice += minPrice;
        }
        return totalMinPrice;
    }

    public List<Place> getAllReviewedItems() {
        List<Place> reviewedItems = new ArrayList<>();
        for (Place place : getAllPlaces()) {
            if (!place.getReviews().isEmpty()) {
                reviewedItems.add(place);
            }
        }
        return reviewedItems;
    }

    private List<Place> getAllPlaces() {
        List<Place> allPlaces = new ArrayList<>();
        allPlaces.addAll(hotels);
        allPlaces.addAll(parcs);
        return allPlaces;
    }
}
