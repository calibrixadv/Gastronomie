public class Restaurant extends LocalCulinar {
    private String tipBucatarie;
    private int numarLocuri;
    private boolean acceptaRezervari;
    private boolean livrareLaDomiciliu;

    // Constructor fara parametri
    public Restaurant() {
        super();
        this.tipBucatarie = "none";
        this.numarLocuri = 0;
        this.acceptaRezervari = false;
        this.livrareLaDomiciliu = false;
    }

    // Constructor cu toti parametrii (inclusiv cei din LocalCulinar)
    public Restaurant(String nume,
                      String locatie,
                      double rating,
                      String tipBucatarie,
                      int numarLocuri,
                      boolean acceptaRezervari,
                      boolean livrareLaDomiciliu) {

        super(nume, locatie, rating);

        this.tipBucatarie = tipBucatarie;
        this.numarLocuri = numarLocuri;
        this.acceptaRezervari = acceptaRezervari;
        this.livrareLaDomiciliu = livrareLaDomiciliu;
    }

    // Constructor de copiere
    public Restaurant(Restaurant other) {
        // copiem si partea de LocalCulinar
        super(other.getDenumire(), other.getLocatie(), other.getRating());

        this.tipBucatarie = other.tipBucatarie;
        this.numarLocuri = other.numarLocuri;
        this.acceptaRezervari = other.acceptaRezervari;
        this.livrareLaDomiciliu = other.livrareLaDomiciliu;
    }

    // Getteri / setteri

    public String getTipBucatarie() {
        return tipBucatarie;
    }

    public void setTipBucatarie(String tipBucatarie) {
        this.tipBucatarie = tipBucatarie;
    }

    public int getNumarLocuri() {
        return numarLocuri;
    }

    public void setNumarLocuri(int numarLocuri) {
        this.numarLocuri = numarLocuri;
    }

    public boolean getisAcceptaRezervari() {
        return acceptaRezervari;
    }

    public void setAcceptaRezervari(boolean acceptaRezervari) {
        this.acceptaRezervari = acceptaRezervari;
    }

    public boolean getisLivrareLaDomiciliu() {
        return livrareLaDomiciliu;
    }

    public void setLivrareLaDomiciliu(boolean livrareLaDomiciliu) {
        this.livrareLaDomiciliu = livrareLaDomiciliu;
    }

    @Override
    public String toString() {
        return "Restaurant{base=" + super.toString() +
                ", tipBucatarie='" + tipBucatarie + '\'' +
                ", numarLocuri=" + numarLocuri +
                ", acceptaRezervari=" + acceptaRezervari +
                ", livrareLaDomiciliu=" + livrareLaDomiciliu +
                '}';
    }
}
