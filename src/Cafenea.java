import java.time.LocalTime;

public class Cafenea extends LocalCulinar {
    private int capacitate;          // număr de locuri
    private boolean areTerasa;
    private LocalTime oraDeschidere;
    private LocalTime oraInchidere;

    // 1) Constructor fără parametri
    public Cafenea() {
        super(); // denumire="Necunoscut", locatie="Necunoscută", rating=0.0
        this.capacitate = 0;
        this.areTerasa = false;
        this.oraDeschidere = null;
        this.oraInchidere = null;
    }

    // 2) Constructor cu toți parametrii (inclusiv cei din LocalCulinar)
    public Cafenea(String denumire, String locatie, double rating,
                   int capacitate, boolean areTerasa,
                   LocalTime oraDeschidere, LocalTime oraInchidere) {
        super(denumire, locatie, rating);
        this.capacitate = capacitate;
        this.areTerasa = areTerasa;
        this.oraDeschidere = oraDeschidere;
        this.oraInchidere = oraInchidere;
    }

    // 3) Constructor de copiere
    public Cafenea(Cafenea other) {
        super(other);
        this.capacitate = other.capacitate;
        this.areTerasa = other.areTerasa;
        this.oraDeschidere = other.oraDeschidere;
        this.oraInchidere = other.oraInchidere;
    }

    @Override
    public String toString() {
        return "Cafenea{" +
                "local=" + super.toString() +
                ", capacitate=" + capacitate +
                ", areTerasa=" + areTerasa +
                ", oraDeschidere=" + oraDeschidere +
                ", oraInchidere=" + oraInchidere +
                '}';
    }
}
