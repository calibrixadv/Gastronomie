import java.util.ArrayList;

public final class Desert extends Produs {
    private String tip;
    private ArrayList<String> ingrediente;
    private int portii;

    public Desert() {
        super();
        this.tip = "Necunoscut";
        this.ingrediente = new ArrayList<>();
        this.portii = 1;
    }


    public Desert(String nume, double pret, int kcal, String categorie,
                  String tip, String[] ingredienteArray, int portii) {
        super(nume, pret, kcal, categorie);
        this.tip = tip;
        this.ingrediente = new ArrayList<>();
        for (String ingr : ingredienteArray) {
            this.ingrediente.add(ingr);
        }
        this.portii = portii;
    }


    public Desert(Desert other) {
        super(other.getNume(), other.getPret(), other.getKcal(), other.getCategorie());
        this.tip = other.tip;
        this.ingrediente = new ArrayList<>();
        for (String ingr : other.ingrediente) {
            this.ingrediente.add(ingr);
        }
        this.portii = other.portii;
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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public ArrayList<String> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(ArrayList<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getPortii() {
        return portii;
    }

    public void setPortii(int portii) {
        this.portii = portii;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Tip: " + tip +
                " | Portii: " + portii +
                " | Ingrediente: " + ingrediente;
    }
}
