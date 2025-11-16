public abstract class Persoana
{
    private String nume;
    private String email;
    private String telefon;

    // 1) Constructor default
    public Persoana() {
        this("", "", "");
    }

    // 2) Constructor cu toti parametrii
    public Persoana(String nume, String email, String telefon) {
        this.nume = nume;
        this.email = email;
        this.telefon = telefon;
    }

    // 3) Constructor de copiere
    public Persoana(Persoana other) {
        this(other.nume, other.email, other.telefon);
    }

    // Getteri
    public String getNume() {
        return nume;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    // Setteri
    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
