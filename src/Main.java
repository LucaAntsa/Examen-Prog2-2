import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Création des chambres
        Chambre chambre1 = new Chambre(101, 50.0);
        Chambre chambre2 = new Chambre(102, 60.0);
        Chambre chambre3 = new Chambre(201, 55.0);
        Chambre chambre4 = new Chambre(202, 65.0);

        // Création des hôtels
        Hotel hotel1 = new Hotel("Hotel Mahamanina", -18.8792, 47.5079, "0341234567", "mahamanina@gmail.com", Arrays.asList(chambre1, chambre2));
        Hotel hotel2 = new Hotel("Hotel Andafiavaratra", -18.9137, 47.5361, "0347654321", "andafiavaratra@gmail.com", Arrays.asList(chambre3, chambre4));

        // Création des parcs
        Parc parc1 = new Parc("Parc National d'Andasibe", -18.9333, 48.4167, "Un magnifique parc avec des lémuriens", Arrays.asList(hotel1, hotel2));
        Parc parc2 = new Parc("Parc Ankarafantsika", -16.3167, 46.8167, "Un parc riche en biodiversité", Arrays.asList(hotel1));

        // Création des avis
        AvisDesClients avis1 = new AvisDesClients("Jessica Albert", "jessica@gmail.com", "Le service n'est pas de qualité", LocalDate.of(2024, 8, 18), 2);
        AvisDesClients avis2 = new AvisDesClients("Yangus", "yangus@gmail.com", "Excellent hôtel, bien situé", LocalDate.of(2024, 8, 20), 5);

        // Ajouter des avis à l'hôtel et au parc
        hotel1.addReview(avis1);
        parc1.addReview(avis2);

        // Création de la carte
        List<Parc> parcs = new ArrayList<>(Arrays.asList(parc1, parc2));
        List<Hotel> hotels = new ArrayList<>(Arrays.asList(hotel1, hotel2));
        Carte carte = new Carte(parcs, hotels);

        // Afficher tous les avis
        System.out.println("Tous les avis sur la carte :");
        for (AvisDesClients avis : carte.getAllReviews()) {
            System.out.println(avis.getReviewerName() + " a laissé un avis : " + avis.getDescription());
        }

        // Trouver le meilleur hôtel
        Hotel bestHotel = carte.findBestHotel();
        System.out.println("\nLe meilleur hôtel est : " + bestHotel.getName());

        // Trouver tous les endroits dans une zone spécifique
        List<Place> placesInside = carte.getAllPlacesInside(-19.0, -18.0, 47.0, 48.5);
        System.out.println("\nEndroits dans la zone spécifiée :");
        for (Place place : placesInside) {
            System.out.println(place.getName() + " (" + place.getCoordinates().getLatitude() + ", " + place.getCoordinates().getLongitude() + ")");
        }

        // Trouver le prix minimum pour rester une nuit dans chaque parc donné
        List<Parc> parcsToVisit = new ArrayList<>(Arrays.asList(parc1, parc2));
        double minPrice = carte.findCheapestHotelPrice(parcsToVisit);
        System.out.println("\nLe prix minimum total pour rester une nuit dans chaque parc : " + minPrice);

        // Afficher tous les endroits qui ont reçu des avis
        System.out.println("\nEndroits avec au moins un avis :");
        for (Place place : carte.getAllReviewedItems()) {
            System.out.println(place.getName());
        }
    }
}
