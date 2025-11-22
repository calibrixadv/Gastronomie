import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AI_GUI_App extends JFrame {

    private JTextField txtRatingMin;
    private JTextField txtValoareMin;
    private JComboBox<String> cmbClasa;
    private JTextArea output;

    private ArrayList<FastFood> fastfoods;
    private ArrayList<Desert> deserturi;
    private ArrayList<Bautura> bauturi;

    public AI_GUI_App() {
        setTitle("Aplicatie Gastronomica - AI");
        setSize(700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------------- TOP PANEL CU BACK + FILTRE -------------------
        JPanel panelTopWrapper = new JPanel(new BorderLayout());

        JButton btnBack = new JButton("< Back");
        panelTopWrapper.add(btnBack, BorderLayout.WEST);

        JPanel panelTop = new JPanel(new GridLayout(3, 2, 10, 10));

        panelTop.add(new JLabel("Alege clasa:"));
        cmbClasa = new JComboBox<>(new String[]{"FastFood", "Desert", "Bautura"});
        panelTop.add(cmbClasa);

        panelTop.add(new JLabel("Rating minim:"));
        txtRatingMin = new JTextField();
        panelTop.add(txtRatingMin);

        panelTop.add(new JLabel("Valoare minima (ingrediente/portii/produse):"));
        txtValoareMin = new JTextField();
        panelTop.add(txtValoareMin);

        panelTopWrapper.add(panelTop, BorderLayout.CENTER);

        add(panelTopWrapper, BorderLayout.NORTH);

        // ---------------- ZONA AFISARE -------------------
        output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        // ---------------- BUTON FILTRARE -------------------
        JButton btnFilter = new JButton("Filtrează");
        add(btnFilter, BorderLayout.SOUTH);

        // ---------------- ASCULTATOR BUTON FILTRARE -------------------
        btnFilter.addActionListener(e -> aplicaFiltre());

        // ---------------- ASCULTATOR BUTON BACK -------------------
        btnBack.addActionListener(e -> {
            dispose();          // închide GUIApp
            new MainWindow();   // redeschide MainWindow
        });

        // ---------------- INITIALIZAM DATE -------------------
        initializareDate();

        setVisible(true);
    }

    private void initializareDate() {
        fastfoods = new ArrayList<>();
        fastfoods.add(new FastFood("Burger King", "Madrid", 4.5, "Fast Food", 12,
                new String[]{"Whopper", "Long Chicken"}));
        fastfoods.add(new FastFood("Taco Bell", "Barcelona", 3.8, "Mexican", 8,
                new String[]{"Chicken Taco", "Beef Burrito"}));

        deserturi = new ArrayList<>();
        deserturi.add(new Desert("Churros", 4.5, 250, "Tradițional", "Prajitura",
                new String[]{"faina", "zahar", "ulei"}, 2));
        deserturi.add(new Desert("Flan", 6.0, 300, "Tradițional", "Crema",
                new String[]{"lapte", "oua", "caramel"}, 1));

        bauturi = new ArrayList<>();
        bauturi.add(new Bautura("Fanta", 7.5, 120, "Racoritoare", true, false,
                new String[]{"apa", "zahar", "arome"}));
        bauturi.add(new Bautura("Estrella Damm", 5.0, 180, "Alcoolica", false, true,
                new String[]{"hamei", "apa", "malt"}));
    }

    private void aplicaFiltre() {
        output.setText("");

        double ratingMin = 0;   // doar pentru FastFood
        int valoareMin;
        int kcalMin;

        String clasa = (String) cmbClasa.getSelectedItem();

        try {
            // pentru FastFood citim rating
            if (clasa.equals("FastFood"))
                ratingMin = Double.parseDouble(txtRatingMin.getText());

            // pentru Desert și Bautura folosim câmpul rating ca fiind "kcal minim"
            kcalMin = Integer.parseInt(txtRatingMin.getText());
            valoareMin = Integer.parseInt(txtValoareMin.getText());

        } catch (Exception e) {
            output.setText("⚠ Introdu valori valide!");
            return;
        }

        switch (clasa) {

            case "FastFood":
                for (FastFood f : fastfoods)
                    if (f.getRating() >= ratingMin &&
                            f.getNumarProduse() >= valoareMin)
                        output.append(f.toString() + "\n");
                break;

            case "Desert":
                for (Desert d : deserturi)
                    if (d.getKcal() >= kcalMin &&         // condiția 1
                            d.getPortii() >= valoareMin)      // condiția 2
                        output.append(d.toString() + "\n");
                break;

            case "Bautura":
                for (Bautura b : bauturi)
                    if (b.getKcal() >= kcalMin &&            // condiția 1
                            b.getNumarIngrediente() >= valoareMin) // condiția 2
                        output.append(b.toString() + "\n");
                break;
        }
    }

}

