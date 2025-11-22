/*
Se va face un fisier de test care sa cuprinda cel putin cate 3 instante din cele
3 clase, folosind toti constructorii. Pentru fiecare instanta vor fi afisate datele membre.

Sa se creeze un vector cu cel putin 10 instante din fiecare clasa si sa se afiseze instantele
pentru fiecare clasa.
 */

import java.util.ArrayList;

public class TestAI {
    public static void main(String[] args) {

        String[] ingrBautura = {"Apă", "Zahăr", "Cofeină"};
        Bautura b1 = new Bautura();
        Bautura b2 = new Bautura("Cola", 5.5, 140, "Răcoritoare", true, false, ingrBautura); // constructor cu parametri
        Bautura b3 = new Bautura(b2);

        System.out.println("=== Bauturi ===");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        //  Desert
        String[] ingrDesert = {"Făină", "Zahăr", "Ouă", "Unt"};
        Desert d1 = new Desert();
        Desert d2 = new Desert("Tort Ciocolată", 25.0, 450, "Dessert", "Tort", ingrDesert, 8);
        Desert d3 = new Desert(d2);

        System.out.println("\n=== Deserturi ===");
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        //  FastFood
        String[] sandviciuri = {"Cheeseburger", "Hotdog", "Sandwich"};
        FastFood f1 = new FastFood();
        FastFood f2 = new FastFood("Burger King", "București", 4.5, "Americană", 3, sandviciuri);
        FastFood f3 = new FastFood(f2);

        System.out.println("\n=== FastFood ===");
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        // Vectori

        String[] numeBaturui={"Cola","Pepsi","Fanta Portocale", "Sprite","Limonadă", "Apă minerală", "Cafea Latte","Ceai Verde", "Smoothie Banane", "Bere Blondă"};
        String[][] ingredienteBauturi = { {"Apă carbogazoasă", "Zahăr", "Cofeină"},            {"Apă carbogazoasă", "Zahăr", "Cofeină"},          {"Apă carbogazoasă", "Zahăr", "Arome naturale"},     {"Apă carbogazoasă", "Arome naturale", "Zahăr"},    {"Apă", "Zahăr", "Lămâie"},                          {"Apă minerală"},                                     {"Cafea", "Lapte", "Zahăr"},                          {"Ceai verde", "Lămâie", "Miere"},                   {"Banane", "Lapte", "Miere"},                         {"Hamei", "Malț", "Apă"}                              } ;
        ArrayList<Bautura> bauturi = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bauturi.add(new Bautura(numeBaturui[i], 3.5 + i, 100 + i * 10, (i==6 || i==7 ? "Calda" : "Racoritoare"), (i==9 || (i>=0 && i<=3)), i ==9, ingredienteBauturi[i]));
        }


        String[] numeDeserturi = {
                "Tort Ciocolată",
                "Prajitură cu Mere",
                "Cheesecake",
                "Tartă cu Cireșe",
                "Tiramisu",
                "Brownie cu Ciocolată",
                "Muffin cu Afine",
                "Clătite cu Nutella",
                "Înghețată de Vanilie",
                "Panna Cotta"
        };
        String[] mapaTipuri={"Dulce","Rece","Acrisoar"};
        String[] categoriiDesert = {
                "Tort",
                "Prajitură",
                "Cheesecake",
                "Tartă",
                "Desert Italian",
                "Brownie",
                "Muffin",
                "Clătite",
                "Înghețată",
                "Desert Italian"
        };
        String[][] ingredienteDesert = {
                {"Făină", "Zahăr", "Ouă", "Unt", "Ciocolată"},
                {"Făină", "Mere", "Zahăr", "Scorțișoară"},
                {"Brânză mascarpone", "Zahăr", "Ouă", "Biscuiți"},
                {"Făină", "Cireșe", "Zahăr", "Unt"},
                {"Ouă", "Zahăr", "Mascarpone", "Cafea", "Cacao"},
                {"Făină", "Ciocolată", "Zahăr", "Unt"},
                {"Făină", "Zahăr", "Ouă", "Afine"},
                {"Făină", "Ouă", "Laptele", "Nutella"},
                {"Lapte", "Zahăr", "Frișcă", "Vanilie"},
                {"Frișcă", "Zahăr", "Gelatină", "Vanilie"}
        };

        ArrayList<Desert> deserturi = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            deserturi.add(new Desert(numeDeserturi[i], 10 + i, 300 + i * 20, categoriiDesert[i], mapaTipuri[i%3], ingredienteDesert[i], i + 1));
        }

        String[] mapaSpecialitati={"Asiatic","International","American","Spaniol"};
        String[] denumireFastFood = {
                "McDonald's",
                "Burger King",
                "KFC",
                "Subway",
                "Pizza Hut",
                "Domino's",
                "Starbucks",
                "Five Guys",
                "Dunkin' Donuts",
                "Panini Express"
        };
        String[] locatieFastFood = {
                "București", "Cluj-Napoca", "Timișoara", "Iași", "Brașov",
                "Constanța", "Oradea", "Sibiu", "Ploiești", "Craiova"
        };
        String[][] listaSandwich = {
                {"Big Mac", "McChicken", "Filet-O-Fish"},
                {"Whopper", "Bacon King", "Chicken Fries"},
                {"Zinger", "Original Recipe", "Popcorn Chicken"},
                {"Sub cu Ton", "Sub cu Pui", "Sub Veggie"},
                {"Pizza Sandwich", "Cheesy Bread", "Stuffed Crust"},
                {"Pepperoni Sandwich", "Chicken Sandwich", "Veggie Pizza"},
                {"Sandwich cu Pui", "Panini", "Bagel cu Cremă"},
                {"Bacon Burger", "Cheeseburger", "Hot Dog"},
                {"Bagel cu Unt", "Sandwich cu Nutella", "Croissant"},
                {"Panini Caprese", "Panini Prosciutto", "Panini Veggie"}
        };
        ArrayList<FastFood> fastFoods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fastFoods.add(new FastFood( denumireFastFood[i], locatieFastFood[i], 3.0 + i * 0.2, mapaSpecialitati[i%4], listaSandwich[i].length, listaSandwich[i]));
        }

        System.out.println("\n=== Lista Bauturi (10 instanțe) ===");
        for (Bautura b : bauturi) {
            System.out.println(b);
        }

        System.out.println("\n=== Lista Deserturi (10 instanțe) ===");
        for (Desert d : deserturi) {
            System.out.println(d);
        }

        System.out.println("\n=== Lista FastFood (10 instanțe) ===");
        for (FastFood f : fastFoods) {
            System.out.println(f);
        }

        System.out.println("\n=== BAUTURI FILTRATE ===");
        for (Bautura b : bauturi) {
            if (b.isCarbogazoasa() && b.getPret() < 10) {
                System.out.println(b);
            }
        }

        System.out.println("\n=== DESERTURI FILTRATE ===");
        for (Desert d : deserturi) {
            if (d.getNumarIngrediente() > 3 && d.getPortii() >= 2) {
                System.out.println(d);
            }
        }

        System.out.println("\n=== FASTFOOD FILTRATE ===");
        for (FastFood f : fastFoods) {
            if (f.getRating() > 4.0 && f.getListaSandwichuri().length >= 2) {
                System.out.println(f);
            }
        }



    }
}
