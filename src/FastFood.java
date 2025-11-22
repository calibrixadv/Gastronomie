import java.util.Arrays;

public class FastFood extends LocalCulinar {
    private String tipBucatarie;
    private int numarProduse;
    private String[] listaSandwichuri;

    // Constructor fără parametri
    public FastFood() {
        super(); // apelează constructorul fără parametri din LocalCulinar
        this.tipBucatarie = "Internațional";
        this.numarProduse = 0;
        this.listaSandwichuri = new String[0];
    }

    // Constructor cu parametri
    public FastFood(String denumire, String locatie, double rating,
                    String tipBucatarie, int numarProduse, String[] listaSandwichuri) {
        super(denumire, locatie, rating); // apelează constructorul cu parametri din LocalCulinar
        this.tipBucatarie = tipBucatarie;
        this.numarProduse = numarProduse;
        this.listaSandwichuri = listaSandwichuri;
    }

    // Constructor de copiere
    public FastFood(FastFood other) {
        super(other); // copiază atributele din clasa părinte
        this.tipBucatarie = other.tipBucatarie;
        this.numarProduse = other.numarProduse;
        this.listaSandwichuri = other.listaSandwichuri.clone();
    }

    public String getTipBucatarie() {
        return tipBucatarie;
    }

    public void setTipBucatarie(String tipBucatarie) {
        this.tipBucatarie = tipBucatarie;
    }

    public int getNumarProduse() {
        return numarProduse;
    }

    public void setNumarProduse(int numarProduse) {
        this.numarProduse = numarProduse;
    }

    public String[] getListaSandwichuri() {
        return listaSandwichuri;
    }

    public void setListaSandwichuri(String[] listaSandwichuri) {
        this.listaSandwichuri = listaSandwichuri;
    }

    @Override
        public String toString() {
            return super.toString() +
                    " | Tip bucătărie: " + tipBucatarie +
                    " | Număr produse: " + numarProduse +
                    " | Lista sandwich-uri: " + Arrays.toString(listaSandwichuri);
        }
}
