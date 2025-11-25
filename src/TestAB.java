import java.util.ArrayList;
import java.util.Arrays;

public class TestAB {

    public static void main(String[] args) {

        // ============================================
        // 1. Instante pentru fiecare clasa (toti constructorii)
        // ============================================

        System.out.println("=== TEST CONSTRUCTORI PRODUS ===");
        Produs produsDefault = new Produs(); // fara parametri
        Produs produsParam = new Produs("Sandwich", 15.5, 450, "FastFood"); // cu parametri
        Produs produsCopy = new Produs(produsParam); // de copiere

        printHeaderProduse();
        printProdusRow(0, produsDefault, "default");
        printProdusRow(1, produsParam, "param");
        printProdusRow(2, produsCopy, "copie");
        System.out.println();

        System.out.println("=== TEST CONSTRUCTORI MANCARE ===");
        ArrayList<String> ing1 = new ArrayList<>(Arrays.asList("Paine", "Sunca", "Cascaval"));
        ArrayList<String> alerg1 = new ArrayList<>(Arrays.asList("Gluten", "Lactoza"));

        Mancare mancareDefault = new Mancare(); // fara parametri
        Mancare mancareParam = new Mancare(
                "Burger",
                22.0,
                700,
                "FastFood",
                ing1,
                true,
                alerg1
        ); // cu parametri
        Mancare mancareCopy = new Mancare(mancareParam); // de copiere

        printHeaderMancare();
        printMancareRow(0, mancareDefault, "default");
        printMancareRow(1, mancareParam, "param");
        printMancareRow(2, mancareCopy, "copie");
        System.out.println();

        System.out.println("=== TEST CONSTRUCTORI RESTAURANT ===");
        Restaurant restDefault = new Restaurant(); // fara parametri
        Restaurant restParam = new Restaurant(
                "La Bunica",
                "Str. Exemplu 10",
                4.6,
                "Traditionala",
                80,
                true,
                true
        ); // cu parametri
        Restaurant restCopy = new Restaurant(restParam); // de copiere

        printHeaderRestaurante();
        printRestaurantRow(0, restDefault, "default");
        printRestaurantRow(1, restParam, "param");
        printRestaurantRow(2, restCopy, "copie");
        System.out.println();

        // ============================================
        // 2. Vectori cu cel putin 10 instante din fiecare clasa
        // ============================================

        // --- Vector Produse ---
        Produs[] vectorProduse = new Produs[10];
        vectorProduse[0] = new Produs("Cafea mica", 7.0, 5, "Bautura");
        vectorProduse[1] = new Produs("Cafea mare", 10.0, 8, "Bautura");
        vectorProduse[2] = new Produs("Ceai verde", 9.5, 0, "Bautura");
        vectorProduse[3] = new Produs("Suc natural", 13.0, 150, "Bautura");
        vectorProduse[4] = new Produs("Croissant", 8.0, 320, "Desert");
        vectorProduse[5] = new Produs("Cheesecake", 18.0, 500, "Desert");
        vectorProduse[6] = new Produs("Salata Caesar", 24.0, 380, "Mancare");
        vectorProduse[7] = new Produs("Pizza Margherita", 28.0, 900, "Mancare");
        vectorProduse[8] = new Produs("Apa plata", 6.0, 0, "Bautura");
        vectorProduse[9] = new Produs("Limonada", 12.0, 120, "Bautura");

        System.out.println("=== VECTOR PRODUSE (10 elemente) ===");
        printHeaderProduse();
        for (int i = 0; i < vectorProduse.length; i++) {
            printProdusRow(i, vectorProduse[i], "vector");
        }
        System.out.println();

        // --- Vector Mancare ---
        Mancare[] vectorMancaruri = new Mancare[10];

        ArrayList<String> ing2 = new ArrayList<>(Arrays.asList("Salata", "Pui", "Crutoane", "Parmezan"));
        ArrayList<String> alg2 = new ArrayList<>(Arrays.asList("Lactoza"));
        ArrayList<String> ing3 = new ArrayList<>(Arrays.asList("Faina", "Apa", "Mozzarella", "Rosii"));
        ArrayList<String> alg3 = new ArrayList<>(Arrays.asList("Gluten"));
        ArrayList<String> ing4 = new ArrayList<>(Arrays.asList("Paste", "Smantana", "Bacon", "Parmezan"));
        ArrayList<String> alg4 = new ArrayList<>(Arrays.asList("Lactoza", "Gluten"));
        ArrayList<String> ing5 = new ArrayList<>(Arrays.asList("Salata", "Rosii", "Castraveti", "Masline"));
        ArrayList<String> algEmpty = new ArrayList<>();

        vectorMancaruri[0] = new Mancare("Salata Caesar", 24.0, 380, "Mancare", ing2, true, alg2);
        vectorMancaruri[1] = new Mancare("Pizza Margherita", 28.0, 900, "Mancare", ing3, true, alg3);
        vectorMancaruri[2] = new Mancare("Paste Carbonara", 26.0, 850, "Mancare", ing4, true, alg4);
        vectorMancaruri[3] = new Mancare("Salata Greceasca", 20.0, 250, "Mancare", ing5, false, algEmpty);
        vectorMancaruri[4] = new Mancare("Supa crema de legume", 18.0, 200, "Mancare",
                new ArrayList<>(Arrays.asList("Morcov", "Telina", "Cartof")), true, algEmpty);
        vectorMancaruri[5] = new Mancare("Burger Vita", 32.0, 950, "Mancare",
                new ArrayList<>(Arrays.asList("Chifla", "Carne vita", "Cascaval")), true,
                new ArrayList<>(Arrays.asList("Gluten", "Lactoza")));
        vectorMancaruri[6] = new Mancare("Cartofi wedges", 14.0, 400, "Mancare",
                new ArrayList<>(Arrays.asList("Cartofi", "Ulei", "Condimente")), true, algEmpty);
        vectorMancaruri[7] = new Mancare("Wrap pui", 22.0, 600, "Mancare",
                new ArrayList<>(Arrays.asList("Lipie", "Pui", "Legume")), true,
                new ArrayList<>(Arrays.asList("Gluten")));
        vectorMancaruri[8] = new Mancare("Bruschete", 16.0, 320, "Mancare",
                new ArrayList<>(Arrays.asList("Paine", "Rosii", "Usturoi")), false,
                new ArrayList<>(Arrays.asList("Gluten")));
        vectorMancaruri[9] = new Mancare("Tiramisu", 19.0, 500, "Desert",
                new ArrayList<>(Arrays.asList("Pişcoturi", "Mascarpone", "Cafea")), false,
                new ArrayList<>(Arrays.asList("Lactoza", "Gluten")));

        System.out.println("=== VECTOR MANCARE (10 elemente) ===");
        printHeaderMancare();
        for (int i = 0; i < vectorMancaruri.length; i++) {
            printMancareRow(i, vectorMancaruri[i], "vector");
        }
        System.out.println();

        // --- Vector Restaurante ---
        Restaurant[] vectorRestaurante = new Restaurant[10];
        vectorRestaurante[0] = new Restaurant("La Bunica", "Str. Principala 1", 4.6, "Traditionala", 80, true, true);
        vectorRestaurante[1] = new Restaurant("Pizza Max", "Bd. Unirii 25", 4.2, "Italiana", 60, true, true);
        vectorRestaurante[2] = new Restaurant("Burger House", "Str. Libertatii 10", 4.8, "FastFood", 40, true, true);
        vectorRestaurante[3] = new Restaurant("Vegan Spot", "Str. Verde 5", 4.4, "Vegana", 30, false, true);
        vectorRestaurante[4] = new Restaurant("Coffee Corner", "Str. Mihai 7", 4.1, "Cafea & Desert", 25, false, false);
        vectorRestaurante[5] = new Restaurant("Steak House", "Bd. Independentei 15", 4.9, "Steak", 100, true, false);
        vectorRestaurante[6] = new Restaurant("Sushi Bar", "Str. Japoniei 3", 4.7, "Japoneza", 35, true, true);
        vectorRestaurante[7] = new Restaurant("Casa Mare", "Str. Larga 20", 3.9, "Romanesca", 120, true, false);
        vectorRestaurante[8] = new Restaurant("Express Lunch", "Str. Rapida 8", 4.0, "FastFood", 20, false, true);
        vectorRestaurante[9] = new Restaurant("Fine Dine", "Str. Eleganta 2", 4.95, "Gourmet", 50, true, true);

        System.out.println("=== VECTOR RESTAURANTE (10 elemente) ===");
        printHeaderRestaurante();
        for (int i = 0; i < vectorRestaurante.length; i++) {
            printRestaurantRow(i, vectorRestaurante[i], "vector");
        }
        System.out.println();

        // ============================================
        // 3. Afisare filtrata – doua conditii combinate
        // ============================================

        // 3.1 Produse: pret > 10 si kcal > 0
        System.out.println("=== PRODUSE cu pret > 10 si Kcal > 0 ===");
        printHeaderProduse();
        for (int i = 0; i < vectorProduse.length; i++) {
            Produs p = vectorProduse[i];
            if (p.getPret() > 10.0 && p.getKcal() > 0) {
                printProdusRow(i, p, "filtrat");
            }
        }
        System.out.println();

        // 3.2 Mancare: este calda SI are cel putin 1 alergen
        System.out.println("=== MANCARE calda si cu cel putin 1 alergen ===");
        printHeaderMancare();
        for (int i = 0; i < vectorMancaruri.length; i++) {
            Mancare m = vectorMancaruri[i];

            int nrAlerg = (m.getListaAlergeni() != null)
                    ? m.getListaAlergeni().size()
                    : 0;

            if (m.getisCalda() && nrAlerg > 0) {
                printMancareRow(i, m, "filtrat");
            }
        }
        System.out.println();

        // 3.3 Restaurante: rating >= 4.5 SI livrare la domiciliu
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

    public static void printHeaderProduse() {
        System.out.printf("%-3s | %-8s | %-20s | %-12s | %8s | %8s%n",
                "Nr", "Tip", "Nume", "Categorie", "Pret", "Kcal");
        System.out.println("----+----------+----------------------+--------------+----------+----------");
    }

    public static void printProdusRow(int idx, Produs p, String tip) {
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

    public static void printHeaderMancare() {
        System.out.printf("%-3s | %-8s | %-20s | %-6s | %-12s | %-12s | %-12s | %8s | %8s%n",
                "Nr", "Tip", "Nume", "Calda", "NrIngred.", "NrAlerg.", "Categorie", "Pret", "Kcal");
        System.out.println("----+----------+----------------------+--------+--------------+--------------+--------------+----------+----------");
    }

    public static void printMancareRow(int idx, Mancare m, String tip) {
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

    public static void printHeaderRestaurante() {
        System.out.printf("%-3s | %-8s | %-20s | %-22s | %8s | %-15s | %8s | %-10s | %-10s%n",
                "Nr", "Tip", "Nume", "Locatie", "Rating", "Tip bucatarie", "Locuri", "Rezervari", "Livrare");
        System.out.println("----+----------+----------------------+------------------------+----------+-----------------+----------+------------+------------");
    }

    public static void printRestaurantRow(int idx, Restaurant r, String tip) {
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
