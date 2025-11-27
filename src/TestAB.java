import java.util.ArrayList;
import java.util.Arrays;

public class TestAB {

    // =======================
    // METODE PENTRU VECTORI
    // =======================

    public static Produs[] getVectorProduse() {
        Produs[] v = new Produs[10];

        v[0] = new Produs("Cafea mica", 7.0, 5, "Bautura");
        v[1] = new Produs("Cafea mare", 10.0, 8, "Bautura");
        v[2] = new Produs("Ceai verde", 9.5, 0, "Bautura");
        v[3] = new Produs("Suc natural", 13.0, 150, "Bautura");
        v[4] = new Produs("Croissant", 8.0, 320, "Desert");
        v[5] = new Produs("Cheesecake", 18.0, 500, "Desert");
        v[6] = new Produs("Salata Caesar", 24.0, 380, "Mancare");
        v[7] = new Produs("Pizza Margherita", 28.0, 900, "Mancare");
        v[8] = new Produs("Apa plata 0.5L", 5.0, 0, "Bautura");
        v[9] = new Produs("Limonada", 12.0, 120, "Bautura");

        return v;
    }

    public static Mancare[] getVectorMancaruri() {
        Mancare[] v = new Mancare[10];

        // ingrediente
        ArrayList<String> ingCaesar     = new ArrayList<>(Arrays.asList("Salata", "Pui", "Crutoane", "Parmezan"));
        ArrayList<String> ingMargherita = new ArrayList<>(Arrays.asList("Faina", "Apa", "Mozzarella", "Rosii"));
        ArrayList<String> ingCarbonara  = new ArrayList<>(Arrays.asList("Paste", "Smantana", "Bacon", "Parmezan"));
        ArrayList<String> ingGreceasca  = new ArrayList<>(Arrays.asList("Salata", "Rosii", "Castraveti", "Masline"));
        ArrayList<String> ingSupa       = new ArrayList<>(Arrays.asList("Morcov", "Telina", "Cartof"));
        ArrayList<String> ingBurger     = new ArrayList<>(Arrays.asList("Chifla", "Carne vita", "Cascaval"));
        ArrayList<String> ingWedges     = new ArrayList<>(Arrays.asList("Cartofi", "Ulei", "Condimente"));
        ArrayList<String> ingWrap       = new ArrayList<>(Arrays.asList("Lipie", "Pui", "Legume"));
        ArrayList<String> ingBruschete  = new ArrayList<>(Arrays.asList("Paine", "Rosii", "Usturoi"));
        ArrayList<String> ingTiramisu   = new ArrayList<>(Arrays.asList("Piscoturi", "Mascarpone", "Cafea"));

        // alergeni
        ArrayList<String> algCaesar     = new ArrayList<>(Arrays.asList("Lactoza"));
        ArrayList<String> algMargherita = new ArrayList<>(Arrays.asList("Gluten"));
        ArrayList<String> algCarbonara  = new ArrayList<>(Arrays.asList("Lactoza", "Gluten"));
        ArrayList<String> algGreceasca  = new ArrayList<>();
        ArrayList<String> algSupa       = new ArrayList<>();
        ArrayList<String> algBurger     = new ArrayList<>(Arrays.asList("Gluten", "Lactoza"));
        ArrayList<String> algWedges     = new ArrayList<>();
        ArrayList<String> algWrap       = new ArrayList<>(Arrays.asList("Gluten"));
        ArrayList<String> algBruschete  = new ArrayList<>(Arrays.asList("Gluten"));
        ArrayList<String> algTiramisu   = new ArrayList<>(Arrays.asList("Lactoza", "Gluten"));

        v[0] = new Mancare("Salata Caesar",        24.0, 380, "Mancare", ingCaesar,     true,  algCaesar);
        v[1] = new Mancare("Pizza Margherita",     28.0, 900, "Mancare", ingMargherita, true,  algMargherita);
        v[2] = new Mancare("Paste Carbonara",      26.0, 850, "Mancare", ingCarbonara,  true,  algCarbonara);
        v[3] = new Mancare("Salata Greceasca",     20.0, 250, "Mancare", ingGreceasca,  false, algGreceasca);
        v[4] = new Mancare("Supa crema de legume", 18.0, 200, "Mancare", ingSupa,       true,  algSupa);
        v[5] = new Mancare("Burger Vita",          32.0, 950, "Mancare", ingBurger,     true,  algBurger);
        v[6] = new Mancare("Cartofi wedges",       14.0, 400, "Mancare", ingWedges,     true,  algWedges);
        v[7] = new Mancare("Wrap pui",             22.0, 600, "Mancare", ingWrap,       true,  algWrap);
        v[8] = new Mancare("Bruschete",            16.0, 320, "Mancare", ingBruschete,  false, algBruschete);
        v[9] = new Mancare("Tiramisu",             19.0, 500, "Desert",  ingTiramisu,   false, algTiramisu);

        return v;
    }

    public static Restaurant[] getVectorRestaurante() {
        Restaurant[] v = new Restaurant[10];

        v[0] = new Restaurant("La Bunica",      "Str. Principala 1",     4.6,  "Traditionala",    80,  true,  true);
        v[1] = new Restaurant("Pizza Max",      "Bd. Unirii 25",         4.2,  "Italiana",        60,  true,  true);
        v[2] = new Restaurant("Burger House",   "Str. Libertatii 10",    4.8,  "FastFood",        40,  true,  true);
        v[3] = new Restaurant("Vegan Spot",     "Str. Verde 5",          4.4,  "Vegana",          30,  false, true);
        v[4] = new Restaurant("Coffee Corner",  "Str. Mihai 7",          4.1,  "Cafea & Desert",  25,  false, false);
        v[5] = new Restaurant("Steak House",    "Bd. Independentei 15",  4.9,  "Steak",           100, true,  false);
        v[6] = new Restaurant("Sushi Bar",      "Str. Japoniei 3",       4.7,  "Japoneza",        35,  true,  true);
        v[7] = new Restaurant("Casa Mare",      "Str. Larga 20",         3.9,  "Romanesca",       120, true,  false);
        v[8] = new Restaurant("Express Lunch",  "Str. Rapida 8",         4.0,  "FastFood",        20,  false, true);
        v[9] = new Restaurant("Fine Dine",      "Str. Eleganta 2",       4.95, "Gourmet",         50,  true,  true);

        return v;
    }

    // =======================
    // METODE DE TEST / AFISARE
    // =======================

    public static void main(String[] args) {

        // 1) Cel putin 3 instante din fiecare clasa, folosind TOTI constructorii

        System.out.println("=== TEST CONSTRUCTORI PRODUS ===");
        Produs pDefault = new Produs();
        Produs pParam   = new Produs("Sandwich", 15.5, 450, "FastFood");
        Produs pCopy    = new Produs(pParam);

        printHeaderProduse();
        printProdusRow(0, pDefault, "default");
        printProdusRow(1, pParam,   "param");
        printProdusRow(2, pCopy,    "copie");
        System.out.println();

        System.out.println("=== TEST CONSTRUCTORI MANCARE ===");
        ArrayList<String> ingEx = new ArrayList<>(Arrays.asList("Paine", "Sunca", "Cascaval"));
        ArrayList<String> algEx = new ArrayList<>(Arrays.asList("Gluten", "Lactoza"));
        Mancare mDefault = new Mancare();
        Mancare mParam   = new Mancare("Burger", 22.0, 700, "FastFood", ingEx, true, algEx);
        Mancare mCopy    = new Mancare(mParam);

        printHeaderMancare();
        printMancareRow(0, mDefault, "default");
        printMancareRow(1, mParam,   "param");
        printMancareRow(2, mCopy,    "copie");
        System.out.println();

        System.out.println("=== TEST CONSTRUCTORI RESTAURANT ===");
        Restaurant rDefault = new Restaurant();
        Restaurant rParam   = new Restaurant("La Bunica", "Str. Exemplu 10", 4.6,
                "Traditionala", 80, true, true);
        Restaurant rCopy    = new Restaurant(rParam);

        printHeaderRestaurante();
        printRestaurantRow(0, rDefault, "default");
        printRestaurantRow(1, rParam,   "param");
        printRestaurantRow(2, rCopy,    "copie");
        System.out.println();

        // 2) Vector de 10 elemente pentru fiecare clasa + afisare

        Produs[]     vectorProduse     = getVectorProduse();
        Mancare[]    vectorMancaruri   = getVectorMancaruri();
        Restaurant[] vectorRestaurante = getVectorRestaurante();

        System.out.println("=== VECTOR PRODUSE (10 elemente) ===");
        printHeaderProduse();
        for (int i = 0; i < vectorProduse.length; i++) {
            printProdusRow(i, vectorProduse[i], "vector");
        }
        System.out.println();

        System.out.println("=== VECTOR MANCARE (10 elemente) ===");
        printHeaderMancare();
        for (int i = 0; i < vectorMancaruri.length; i++) {
            printMancareRow(i, vectorMancaruri[i], "vector");
        }
        System.out.println();

        System.out.println("=== VECTOR RESTAURANTE (10 elemente) ===");
        printHeaderRestaurante();
        for (int i = 0; i < vectorRestaurante.length; i++) {
            printRestaurantRow(i, vectorRestaurante[i], "vector");
        }
        System.out.println();

        // 3) Afisare pe baza a DOUA conditii combinate (cerinta sapt. 3–5.12)

        // Produs: pret > 10 SI kcal > 0
        System.out.println("=== PRODUSE cu pret > 10 si Kcal > 0 ===");
        printHeaderProduse();
        for (int i = 0; i < vectorProduse.length; i++) {
            Produs p = vectorProduse[i];
            if (p.getPret() > 10.0 && p.getKcal() > 0) {
                printProdusRow(i, p, "filtrat");
            }
        }
        System.out.println();

        // Mancare: este calda SI are cel putin 1 alergen
        System.out.println("=== MANCARE calda si cu cel putin 1 alergen ===");
        printHeaderMancare();
        for (int i = 0; i < vectorMancaruri.length; i++) {
            Mancare m = vectorMancaruri[i];
            int nrAlg = (m.getListaAlergeni() != null) ? m.getListaAlergeni().size() : 0;
            if (m.getisCalda() && nrAlg > 0) {
                printMancareRow(i, m, "filtrat");
            }
        }
        System.out.println();

        // Restaurant: rating >= 4.5 SI livrare la domiciliu
        System.out.println("=== RESTAURANTE cu rating >= 4.5 si livrare la domiciliu ===");
        printHeaderRestaurante();
        for (int i = 0; i < vectorRestaurante.length; i++) {
            Restaurant r = vectorRestaurante[i];
            if (r.getRating() >= 4.5 && r.getisLivrareLaDomiciliu()) {
                printRestaurantRow(i, r, "filtrat");
            }
        }
        System.out.println();
    }

    // ==========================
    // FUNCTII AUXILIARE – PRODUSE
    // ==========================

    private static void printHeaderProduse() {
        System.out.printf("%-3s | %-8s | %-20s | %-12s | %8s | %8s%n",
                "Nr", "Tip", "Nume", "Categorie", "Pret", "Kcal");
        System.out.println("----+----------+----------------------+--------------+----------+----------");
    }

    private static void printProdusRow(int idx, Produs p, String tip) {
        if (p == null) return;
        System.out.printf("%-3d | %-8s | %-20s | %-12s | %8.2f | %8d%n",
                idx,
                tip,
                p.getNume(),
                p.getCategorie(),
                p.getPret(),
                p.getKcal()
        );
    }

    // ==========================
    // FUNCTII AUXILIARE – MANCARE
    // ==========================

    private static void printHeaderMancare() {
        System.out.printf("%-3s | %-8s | %-20s | %-6s | %-12s | %-12s | %-12s | %8s | %8s%n",
                "Nr", "Tip", "Nume", "Calda", "NrIngred.", "NrAlerg.", "Categorie", "Pret", "Kcal");
        System.out.println("----+----------+----------------------+--------+--------------+--------------+--------------+----------+----------");
    }

    private static void printMancareRow(int idx, Mancare m, String tip) {
        if (m == null) return;
        int nrIng = (m.getListaIngrediente() != null) ? m.getListaIngrediente().size() : 0;
        int nrAlg = (m.getListaAlergeni() != null) ? m.getListaAlergeni().size() : 0;

        System.out.printf("%-3d | %-8s | %-20s | %-6s | %-12d | %-12d | %-12s | %8.2f | %8d%n",
                idx,
                tip,
                m.getNume(),
                m.getisCalda() ? "DA" : "NU",
                nrIng,
                nrAlg,
                m.getCategorie(),
                m.getPret(),
                m.getKcal()
        );
    }

    // ==========================
    // FUNCTII AUXILIARE – RESTAURANTE
    // ==========================

    private static void printHeaderRestaurante() {
        System.out.printf("%-3s | %-8s | %-20s | %-22s | %8s | %-15s | %8s | %-10s | %-10s%n",
                "Nr", "Tip", "Nume", "Locatie", "Rating", "Tip bucatarie", "Locuri", "Rezervari", "Livrare");
        System.out.println("----+----------+----------------------+----------------------+----------+-----------------+----------+------------+------------");
    }

    private static void printRestaurantRow(int idx, Restaurant r, String tip) {
        if (r == null) return;
        System.out.printf("%-3d | %-8s | %-20s | %-22s | %8.2f | %-15s | %8d | %-10s | %-10s%n",
                idx,
                tip,
                r.getDenumire(),
                r.getLocatie(),
                r.getRating(),
                r.getTipBucatarie(),
                r.getNumarLocuri(),
                r.getisAcceptaRezervari() ? "DA" : "NU",
                r.getisLivrareLaDomiciliu() ? "DA" : "NU"
        );
    }
}
