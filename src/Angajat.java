import java.time.LocalDate;

public class Angajat extends Persoana
{
    private String functie;
    private double salariu;
    private LocalDate dataAngajarii;

    // 1) Constructor default
    public Angajat() {
        super();
        this.functie = "";
        this.salariu = 0.0;
        // data default simpla
        this.dataAngajarii = LocalDate.now();
    }

    // 2) Constructor cu toti parametrii
    public Angajat(String nume, String email, String telefon,
                   String functie, double salariu, LocalDate dataAngajarii) {
        super(nume, email, telefon);
        this.functie = functie;
        this.salariu = salariu;
        this.dataAngajarii = dataAngajarii;
    }

    // 3) Constructor de copiere
    public Angajat(Angajat other) {
        super(other);
        this.functie = other.functie;
        this.salariu = other.salariu;
        this.dataAngajarii = other.dataAngajarii;
    }

    // Getteri
    public String getFunctie() {
        return functie;
    }

    public double getSalariu() {
        return salariu;
    }

    public LocalDate getDataAngajarii() {
        return dataAngajarii;
    }

    // Setteri
    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public void setDataAngajarii(LocalDate dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
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
