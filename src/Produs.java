public class Produs {
    private int id;
    private String nume;
    private double pret;
    private String categorie;
    private int kcal;

    private static int nextId = 1;

    public Produs() {
        this.id = nextId++;
        this.nume = "none";
        this.pret = 0.0;
        this.categorie = "none";
        this.kcal = 0;
    }

    public Produs(String nume, double pret, int kcal, String categorie) {
        this.id = nextId++;
        this.nume = nume;
        this.pret = pret;
        this.categorie = categorie;
        this.kcal = kcal;
    }

    public Produs(Produs other){
        this.id = nextId++;
        this.nume = other.nume;
        this.pret = other.pret;
        this.categorie = other.categorie;
        this.kcal = other.kcal;
    }

    public String getNume() { return nume; }
    public double getPret() { return pret; }
    public int getCalorii() { return kcal; }
    public String getCategorie() { return categorie; }
    public int getKcal() { return kcal; }

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