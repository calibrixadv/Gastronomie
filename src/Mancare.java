import java.util.ArrayList;

public final class Mancare extends Produs {
    private ArrayList<String> ingrediente;
    private boolean isCalda;
    private ArrayList<String> alergeni;

    public Mancare() {
        super();
        this.ingrediente = new ArrayList<>();
        this.isCalda = false;
        this.alergeni = new ArrayList<>();
    }

    public Mancare(String nume, double pret, int kcal, String categorie,
                   ArrayList<String> ingrediente, boolean isCalda, ArrayList<String> alergeni) {

        super(nume, pret, kcal, categorie); // din Produs

        this.ingrediente = (ingrediente != null) ? new ArrayList<>(ingrediente) : new ArrayList<>();
        this.isCalda = isCalda;
        this.alergeni = (alergeni != null) ? new ArrayList<>(alergeni) : new ArrayList<>();
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



