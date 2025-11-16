import java.util.ArrayList;

public class TestAB {
    public static void main(String[] args) {

        // ============================================
        // 1. PRODUSE – folosim toti constructorii
        // ============================================

        // Constructor fara parametri
        Produs produsDefault = new Produs();

        // Constructor cu parametri
        Produs produsParam = new Produs("Apa plata 0.5L", 5.0, 0, "Bautura");

        // Constructor de copiere
        Produs produsCopy = new Produs(produsParam);

        // Afisare ca tabel pentru cele 3 instante
        System.out.println("=== PRODUSE (3 instante: default, param, copy) ===");
        printHeaderProduse();
        printProdusRow(0, produsDefault, "default");
        printProdusRow(1, produsParam,   "param");
        printProdusRow(2, produsCopy,    "copy");
        System.out.println();


        // ============================================
        // 2. MANCARE – folosim toti constructorii
        // ============================================

        // Constructor fara parametri
        Mancare mancareDefault = new Mancare();

        // Pregatim liste pentru constructorul cu parametri
        ArrayList<String> ingBurger = new ArrayList<>();
        ingBurger.add("Chifla");
        ingBurger.add("Carne vita");
        ingBurger.add("Cascaval");

        ArrayList<String> alergeniBurger = new ArrayList<>();
        alergeniBurger.add("Gluten");
        alergeniBurger.add("Lactate");

        // Constructor cu parametri
        Mancare mancareParam = new Mancare(
                "Burger clasic",
                32.0,
                850,
                "Fel principal",
                ingBurger,
                true,
                alergeniBurger
        );

        // Constructor de copiere
        Mancare mancareCopy = new Mancare(mancareParam);

        System.out.println("=== MANCARE (3 instante: default, param, copy) ===");
        printHeaderMancare();
        printMancareRow(0, mancareDefault, "default");
        printMancareRow(1, mancareParam,   "param");
        printMancareRow(2, mancareCopy,    "copy");
        System.out.println();


        // ============================================
        // 3. RESTAURANT – folosim toti constructorii
        // ============================================

        // Constructor fara parametri
        Restaurant restaurantDefault = new Restaurant();

        // Constructor cu parametri
        Restaurant restaurantParam = new Restaurant(
                "Trattoria Roma",
                "Galati, Str. Domneasca 50",
                4.6,
                "Italiana",
                60,
                true,
                true
        );

        // Constructor de copiere
        Restaurant restaurantCopy = new Restaurant(restaurantParam);

        System.out.println("=== RESTAURANTE (3 instante: default, param, copy) ===");
        printHeaderRestaurante();
        printRestaurantRow(0, restaurantDefault, "default");
        printRestaurantRow(1, restaurantParam,   "param");
        printRestaurantRow(2, restaurantCopy,    "copy");
        System.out.println();


        // ==================================================
        // 4. VECTORI cu cel putin 10 instante / clasa
        //    (amestecam default, param, copy + obiecte noi)
        // ==================================================

        // -----------------------
        // 4.1. Vector PRODUSE
        // -----------------------
        Produs[] vectorProduse = new Produs[10];
        vectorProduse[0] = produsDefault;
        vectorProduse[1] = produsParam;
        vectorProduse[2] = produsCopy;
        vectorProduse[3] = new Produs("Cheesecake", 18.5,450 ,  "Desert");
        vectorProduse[4] = new Produs("Espresso", 7.0, 2, "Bautura");
        vectorProduse[5] = new Produs("Latte", 10.0, 120, "Bautura");
        vectorProduse[6] = new Produs("Brownie", 15.0, 380, "Desert");
        vectorProduse[7] = new Produs("Apa minerala 0.5L", 6.0, 0, "Bautura");
        vectorProduse[8] = new Produs("Ciocolata calda", 12.0, 200, "Bautura");
        // Ultimul il facem copie dupa unul din celelalte
        vectorProduse[9] = new Produs(vectorProduse[3]); // copy Cheesecake

        System.out.println("=== VECTOR PRODUSE (10 elemente) ===");
        printHeaderProduse();
        for (int i = 0; i < vectorProduse.length; i++) {
            printProdusRow(i, vectorProduse[i], "");
        }
        System.out.println();


        // -----------------------
        // 4.2. Vector MANCARE
        // -----------------------
        Mancare[] vectorMancaruri = new Mancare[10];
        vectorMancaruri[0] = mancareDefault;
        vectorMancaruri[1] = mancareParam;
        vectorMancaruri[2] = mancareCopy;

        vectorMancaruri[3] = new Mancare(
                "Salata fresh",
                24.0,
                250,
                "Aperitiv",
                new ArrayList<String>() {{
                    add("Salata verde");
                    add("Rosii");
                    add("Castraveti");
                }},
                false,
                new ArrayList<String>()
        );
        vectorMancaruri[4] = new Mancare(
                "Paste Carbonara",
                28.0,
                700,
                "Fel principal",
                new ArrayList<String>() {{
                    add("Paste");
                    add("Ou");
                    add("Pancetta");
                }},
                true,
                new ArrayList<String>() {{
                    add("Gluten");
                    add("Lactate");
                    add("Ou");
                }}
        );
        vectorMancaruri[5] = new Mancare(
                "Ciorba de vacuta",
                22.0,
                300,
                "Fel principal",
                new ArrayList<String>() {{
                    add("Carne vita");
                    add("Legume");
                }},
                true,
                new ArrayList<String>()
        );
        vectorMancaruri[6] = new Mancare(
                "Paine cu usturoi",
                10.0,
                200,
                "Aperitiv",
                new ArrayList<String>() {{
                    add("Paine");
                    add("Usturoi");
                    add("Ulei masline");
                }},
                true,
                new ArrayList<String>() {{
                    add("Gluten");
                }}
        );
        vectorMancaruri[7] = new Mancare(
                "Cartofi wedges",
                14.0,
                350,
                "Garnitura",
                new ArrayList<String>() {{
                    add("Cartofi");
                    add("Condimente");
                }},
                true,
                new ArrayList<String>()
        );
        vectorMancaruri[8] = new Mancare(
                "Salata Caesar",
                26.0,
                380,
                "Aperitiv",
                new ArrayList<String>() {{
                    add("Salata romana");
                    add("Crutoane");
                    add("Piept de pui");
                }},
                false,
                new ArrayList<String>() {{
                    add("Gluten");
                }}
        );
        // al 10-lea il facem copie dupa unul existent
        vectorMancaruri[9] = new Mancare(vectorMancaruri[4]); // copy Carbonara

        System.out.println("=== VECTOR MANCARE (10 elemente) ===");
        printHeaderMancare();
        for (int i = 0; i < vectorMancaruri.length; i++) {
            printMancareRow(i, vectorMancaruri[i], "");
        }
        System.out.println();


        // -----------------------
        // 4.3. Vector RESTAURANTE
        // -----------------------
        Restaurant[] vectorRestaurante = new Restaurant[10];
        vectorRestaurante[0] = restaurantDefault;
        vectorRestaurante[1] = restaurantParam;
        vectorRestaurante[2] = restaurantCopy;

        vectorRestaurante[3] = new Restaurant(
                "Casa Bunicii",
                "Galati, Micro 38",
                4.2,
                "Traditionala",
                80,
                true,
                false
        );
        vectorRestaurante[4] = new Restaurant(
                "Bistro Urban",
                "Galati, Centru",
                4.0,
                "Internationala",
                40,
                true,
                true
        );
        vectorRestaurante[5] = new Restaurant(
                "Sushi House",
                "Galati, Mazepa",
                4.8,
                "Japoneza",
                30,
                true,
                false
        );
        vectorRestaurante[6] = new Restaurant(
                "Burger House",
                "Galati, Tiglina",
                4.1,
                "Fast-food",
                50,
                false,
                true
        );
        vectorRestaurante[7] = new Restaurant(
                "La Dunare",
                "Galati, Faleza",
                4.7,
                "Peste & Fructe de mare",
                70,
                true,
                false
        );
        vectorRestaurante[8] = new Restaurant(
                "Vegan Spot",
                "Galati, Centru",
                4.3,
                "Vegan",
                35,
                true,
                true
        );
        // al 10-lea este copie dupa unul din celelalte
        vectorRestaurante[9] = new Restaurant(vectorRestaurante[7]); // copy La Dunare

        System.out.println("=== VECTOR RESTAURANTE (10 elemente) ===");
        printHeaderRestaurante();
        for (int i = 0; i < vectorRestaurante.length; i++) {
            printRestaurantRow(i, vectorRestaurante[i], "");
        }
        System.out.println();
    }

    // ==========================
    // FUNCTII AUXILIARE – PRODUSE
    // ==========================
    private static void printHeaderProduse() {
        System.out.printf("%-3s | %-8s | %-25s | %8s | %8s | %-12s%n",
                "Idx", "Tip", "Nume", "Pret", "Kcal", "Categorie");
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void printProdusRow(int idx, Produs p, String tip) {
        // ajusteaza getKcal() -> getCalorii() daca asa e in clasa ta
        System.out.printf("%-3d | %-8s | %-25s | %8.2f | %8d | %-12s%n",
                idx,
                tip,
                p.getNume(),
                p.getPret(),
                p.getKcal(),
                p.getCategorie()
        );
    }

    // ==========================
    // FUNCTII AUXILIARE – MANCARE
    // ==========================
    private static void printHeaderMancare() {
        System.out.printf("%-3s | %-8s | %-20s | %8s | %8s | %-12s | %-7s | %-7s | %-7s%n",
                "Idx", "Tip", "Nume", "Pret", "Kcal", "Categorie",
                "Calda?", "NrIng", "NrAlrg");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    private static void printMancareRow(int idx, Mancare m, String tip) {
        int nrIng = (m.getListaIngrediente() != null) ? m.getListaIngrediente().size() : 0;
        int nrAlerg = (m.getListaAlergeni() != null) ? m.getListaAlergeni().size() : 0;

        System.out.printf("%-3d | %-8s | %-20s | %8.2f | %8d | %-12s | %-7s | %-7d | %-7d%n",
                idx,
                tip,
                m.getNume(),
                m.getPret(),
                m.getKcal(),
                m.getCategorie(),
                m.getisCalda() ? "DA" : "NU",
                nrIng,
                nrAlerg
        );
    }

    // ==========================
    // FUNCTII AUXILIARE – RESTAURANTE
    // ==========================
    private static void printHeaderRestaurante() {
        System.out.printf("%-3s | %-8s | %-20s | %-25s | %6s | %-15s | %-10s | %-10s%n",
                "Idx", "Tip", "Denumire", "Locatie", "Rating", "Tip bucatarie",
                "Rezervari", "Livrare");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    private static void printRestaurantRow(int idx, Restaurant r, String tip) {
        System.out.printf("%-3d | %-8s | %-20s | %-25s | %6.2f | %-15s | %-10s | %-10s%n",
                idx,
                tip,
                r.getDenumire(),      // sau getNume() daca asa e la tine
                r.getLocatie(),
                r.getRating(),
                r.getNumarLocuri(),
                r.getTipBucatarie(),
                r.getisAcceptaRezervari() ? "DA" : "NU",
                r.getisLivrareLaDomiciliu() ? "DA" : "NU"
        );
    }
}
