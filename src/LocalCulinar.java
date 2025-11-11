public abstract class LocalCulinar {
    private String denumire;
    private String locatie;
    private double rating;

    // 🔸 Constructor fără parametri
    public LocalCulinar() {
        this.denumire = "Necunoscut";
        this.locatie = "Necunoscută";
        this.rating = 0.0;
    }

    // 🔸 Constructor cu toți parametrii
    public LocalCulinar(String denumire, String locatie, double rating) {
        this.denumire = denumire;
        this.locatie = locatie;
        this.rating = rating;
    }

    // 🔸 Constructor de copiere
    public LocalCulinar(LocalCulinar other) {
        this.denumire = other.denumire;
        this.locatie = other.locatie;
        this.rating = other.rating;
    }

    // 🔸 Getteri
    public String getDenumire() {
        return denumire;
    }

    public String getLocatie() {
        return locatie;
    }

    public double getRating() {
        return rating;
    }

    // 🔸 Setteri
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // 🔸 Metoda toString
    @Override
    public String toString() {
        return "Local: " + denumire +
                " | Locație: " + locatie +
                " | Rating: " + rating;
    }
}
