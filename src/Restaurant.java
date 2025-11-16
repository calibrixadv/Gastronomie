
public class Restaurant extends LocalCulinar {
    private String tipBucatarie;
    private int numarLocuri;
    private boolean acceptaRezervari;
    private boolean livrareLaDomiciliu;

    public Restaurant()
    {

        super();

        this.tipBucatarie = "none";
        this.numarLocuri = 0;
        this.acceptaRezervari = false;
        this.acceptaRezervari = false;
    }


    public Restaurant(
            String nume, String locatie, double rating,
            String tipBucatarie, int numarLocuri, boolean acceptaRezervari, boolean livrareLaDomiciliu)
    {

        super(nume, locatie, rating);

        this.tipBucatarie = tipBucatarie;
        this.numarLocuri = numarLocuri;
        this.acceptaRezervari = acceptaRezervari;
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
