public class Chambre {
    private int numero;
    private double tarifParNuitée;

    public Chambre(int numero, double tarifParNuitée) {
        this.numero = numero;
        this.tarifParNuitée = tarifParNuitée;
    }

    public int getNumero() {
        return numero;
    }

    public double getTarifParNuitée() {
        return tarifParNuitée;
    }
}
