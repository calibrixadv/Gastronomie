import java.util.ArrayList;

public final class Mancare extends Produs{
    private ArrayList<String> ingrediente;
    private boolean isCalda;
    private ArrayList<String> alergeni;

    public Mancare(){
        this.ingrediente = new ArrayList<>();
        this.isCalda = false;
        this.alergeni = new ArrayList<>();
    }

    public Mancare( ArrayList<String> ingrediente ){}

}


