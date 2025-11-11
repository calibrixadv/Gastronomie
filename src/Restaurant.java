
public class Restaurant extends LocalCulinar {
    private String tipBucatarie;
    private int numarLocuri;
    private boolean acceptaRezervari;
    private boolean livrareLaDomiciliu;

    public Restaurant(){
        this.tipBucatarie = "none";
        this.numarLocuri = 0;
        this.acceptaRezervari = false;
        this.livrareLaDomiciliu = false;
    }

    public Restaurant(String tipBucatarie, int numarLocuri, boolean acceptaRezervari, boolean livrareLaDomiciliu){
        this.tipBucatarie = tipBucatarie;
        this.numarLocuri = numarLocuri;
        this.acceptaRezervari = acceptaRezervari;
        this.acceptaRezervari = acceptaRezervari;
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
