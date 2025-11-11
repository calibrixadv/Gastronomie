import java.time.LocalDate;

public class Angajat extends Persoana
{
    private String functie;
    private double salariu;
    private LocalDate dataAngajarii;

    // 1) Default
    public Angajat() {
        super();
        this.functie = "";
        this.salariu = 0.0;
        this.dataAngajarii = null;
    }

    // 2) Full-args (fără id)
    public Angajat(String nume, String email, String telefon,
                   String functie, double salariu, LocalDate dataAngajarii) {
        super(nume, email, telefon);
        this.functie = functie;
        this.salariu = salariu;
        this.dataAngajarii = dataAngajarii;
    }

    // 3) Copy
    public Angajat(Angajat other) {
        super(other);
        this.functie = other.functie;
        this.salariu = other.salariu;
        this.dataAngajarii = other.dataAngajarii;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "persoana=" + super.toString() +
                ", functie='" + functie + '\'' +
                ", salariu=" + salariu +
                ", dataAngajarii=" + dataAngajarii +
                '}';
    }
}