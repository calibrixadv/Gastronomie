public class Produs {
    private int id;
    private String nume;
    private double pret;
    private String categorie;
    private int kcal;

    private static int nextId = 1;

    // Constructor fara parametri
    public Produs() {
        this.id = nextId++;
        this.nume = "none";
        this.pret = 0.0;
        this.categorie = "none";
        this.kcal = 0;
    }

    // Constructor cu toti parametrii
    public Produs(String nume, double pret, int kcal, String categorie) {
        this.id = nextId++;
        this.nume = nume;
        this.pret = pret;
        this.categorie = categorie;
        this.kcal = kcal;
    }

    // Constructor de copiere
    public Produs(Produs other) {
        // copie cu ID nou; daca vrei acelasi id, pune this.id = other.id;
        this.id = nextId++;
        this.nume = other.nume;
        this.pret = other.pret;
        this.categorie = other.categorie;
        this.kcal = other.kcal;
    }

    // Getteri / setteri

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getKcal() {
        return kcal;
    }

    // alias, daca profesorul foloseste "calorii" prin curs
    public int getCalorii() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                ", kcal=" + kcal +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
