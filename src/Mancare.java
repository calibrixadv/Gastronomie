import java.util.ArrayList;

public final class Mancare extends Produs {
    private ArrayList<String> ingrediente;
    private boolean isCalda;
    private ArrayList<String> alergeni;

    // Constructor fara parametri
    public Mancare() {
        super();
        this.ingrediente = new ArrayList<>();
        this.isCalda = false;
        this.alergeni = new ArrayList<>();
    }

    // Constructor cu toti parametrii (inclusiv cei din Produs)
    public Mancare(String nume,
                   double pret,
                   int kcal,
                   String categorie,
                   ArrayList<String> ingrediente,
                   boolean isCalda,
                   ArrayList<String> alergeni) {

        super(nume, pret, kcal, categorie);

        this.ingrediente = (ingrediente != null)
                ? new ArrayList<>(ingrediente)
                : new ArrayList<>();

        this.isCalda = isCalda;

        this.alergeni = (alergeni != null)
                ? new ArrayList<>(alergeni)
                : new ArrayList<>();
    }

    // Constructor de copiere
    public Mancare(Mancare other) {
        super(other);

        this.isCalda = other.isCalda;

        if (other.ingrediente != null) {
            this.ingrediente = new ArrayList<>(other.ingrediente);
        } else {
            this.ingrediente = new ArrayList<>();
        }

        if (other.alergeni != null) {
            this.alergeni = new ArrayList<>(other.alergeni);
        } else {
            this.alergeni = new ArrayList<>();
        }
    }

    // Getteri / setteri

    public ArrayList<String> getListaIngrediente() {
        return ingrediente;
    }

    public void setListaIngrediente(ArrayList<String> ingrediente) {
        this.ingrediente = (ingrediente != null)
                ? new ArrayList<>(ingrediente)
                : new ArrayList<>();
    }

    public boolean getisCalda() {
        return isCalda;
    }

    public void setCalda(boolean calda) {
        isCalda = calda;
    }

    public ArrayList<String> getListaAlergeni() {
        return alergeni;
    }

    public void setListaAlergeni(ArrayList<String> alergeni) {
        this.alergeni = (alergeni != null)
                ? new ArrayList<>(alergeni)
                : new ArrayList<>();
    }

    @Override
    public String toString() {
        String ing = (ingrediente == null || ingrediente.isEmpty())
                ? "[]"
                : "[" + String.join(", ", ingrediente) + "]";

        String alg = (alergeni == null || alergeni.isEmpty())
                ? "[]"
                : "[" + String.join(", ", alergeni) + "]";

        return "Mancare{base=" + super.toString() +
                ", ingrediente=" + ing +
                ", isCalda=" + isCalda +
                ", alergeni=" + alg +
                '}';
    }
}
