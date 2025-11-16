import java.util.ArrayList;

public final class Bautura extends Produs {
    private boolean isCarbogazoasa;
    private boolean isAlcoolica;
    private ArrayList<String> ingrediente;  // listă dinamică

    // 🔸 Constructor fără parametri
    public Bautura() {
        super();
        isCarbogazoasa = false;
        isAlcoolica = false;
        ingrediente = new ArrayList<>();
    }

    // 🔸 Constructor cu parametri
    public Bautura(String nume, double pret, int kcal, String categorie,
                   boolean isCarbogazoasa, boolean isAlcoolica, String[] ingredienteArray) {
        super(nume, pret, kcal, categorie);
        this.isCarbogazoasa = isCarbogazoasa;
        this.isAlcoolica = isAlcoolica;
        this.ingrediente = new ArrayList<>();
        for (String ingr : ingredienteArray) {
            this.ingrediente.add(ingr);
        }
    }

    // 🔸 Metodă pentru adăugarea unui ingredient
    public void adaugaIngredient(String ingredient) {
        ingrediente.add(ingredient);
    }

    // 🔸 Metodă pentru ștergerea unui ingredient după index (id)
    public void stergeIngredient(int index) {
        if (index >= 0 && index < ingrediente.size()) {
            ingrediente.remove(index);
        } else {
            System.out.println("Index invalid!");
        }
    }

    // 🔸 Metodă pentru afișarea listei de ingrediente
    public void afiseazaIngrediente() {
        System.out.println("Ingrediente: " + ingrediente);
    }

    // 🔸 Metodă pentru numarul de ingrediente

    public int getNumaIngrediente() {
        return ingrediente.size();
    }

    // 🔸 Getteri și setteri
    public boolean isCarbogazoasa() {
        return isCarbogazoasa;
    }

    public void setCarbogazoasa(boolean isCarbogazoasa) {
        this.isCarbogazoasa = isCarbogazoasa;
    }

    public boolean isAlcoolica() {
        return isAlcoolica;
    }

    public void setAlcoolica(boolean isAlcoolica) {
        this.isAlcoolica = isAlcoolica;
    }

    public ArrayList<String> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(ArrayList<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    // 🔸 Metoda toString()
    @Override
    public String toString() {
        return super.toString() +
                " | Carbogazoasă: " + (isCarbogazoasa ? "Da" : "Nu") +
                " | Alcoolică: " + isAlcoolica +
                " | Ingrediente: " + ingrediente;
    }
}
