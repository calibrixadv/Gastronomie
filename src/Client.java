public class Client extends Persoana
{
    private int puncteFidelitate;
    private boolean abonatNewsletter;

    // 1) Constructor default
    public Client() {
        super();
        this.puncteFidelitate = 0;
        this.abonatNewsletter = false;
    }

    // 2) Constructor cu toți parametrii
    public Client(String nume, String email, String telefon,
                  int puncteFidelitate, boolean abonatNewsletter) {
        super(nume, email, telefon);
        this.puncteFidelitate = puncteFidelitate;
        this.abonatNewsletter = abonatNewsletter;
    }

    // 3) Constructor de copiere
    public Client(Client other) {
        super(other);
        this.puncteFidelitate = other.puncteFidelitate;
        this.abonatNewsletter = other.abonatNewsletter;
    }

    @Override
    public String toString() {
        return "Client{" +
                "persoana=" + super.toString() +
                ", puncteFidelitate=" + puncteFidelitate +
                ", abonatNewsletter=" + abonatNewsletter +
                '}';
    }
}