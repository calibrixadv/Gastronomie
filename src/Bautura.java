import java.util.ArrayList;

public final class Bautura extends Produs {
    private boolean isCarbogazoasa;
    private boolean isAlcoolica;
    private ArrayList<String> ingrediente;  // listă dinamică


    public Bautura() {
        super();
        isCarbogazoasa = false;
        isAlcoolica = false;
        ingrediente = new ArrayList<>();
    }


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
    public Bautura(Bautura other) {
        super(other.getNume(), other.getPret(), other.getKcal(), other.getCategorie());
        this.isCarbogazoasa = other.isCarbogazoasa;
        this.isAlcoolica = other.isAlcoolica;
        // clonare profundă a listei de ingrediente
        this.ingrediente = new ArrayList<>();
        for (String ingr : other.ingrediente) {
            this.ingrediente.add(ingr);
        }
    }

    public void adaugaIngredient(String ingredient) {
        ingrediente.add(ingredient);
    }


    public void stergeIngredient(int index) {
        if (index >= 0 && index < ingrediente.size()) {
            ingrediente.remove(index);
        } else {
            System.out.println("Index invalid!");
        }
    }


    public void afiseazaIngrediente() {
        System.out.println("Ingrediente: " + ingrediente);
    }



    public int getNumarIngrediente() {
        return ingrediente.size();
    }


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


    @Override
    public String toString() {
        return super.toString() +
                " | Carbogazoasă: " + (isCarbogazoasa ? "Da" : "Nu") +
                " | Alcoolică: " + isAlcoolica +
                " | Ingrediente: " + ingrediente;
    }
}
