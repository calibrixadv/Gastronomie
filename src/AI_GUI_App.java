import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AI_GUI_App extends JFrame {

    private JTextField txtRatingMin;
    private JTextField txtValoareMin;
    private JComboBox<String> cmbClasaFilter;
    private JTextArea outputFilter;

    private JComboBox<String> cmbClasaEdit;
    private JComboBox<String> cmbInstanta;
    private JPanel panelFields;
    private JButton btnGet, btnSet;

    private JTextArea txtInstante;
    private JButton btnRefreshInstante;

    private ArrayList<FastFood> fastfoods;
    private ArrayList<Desert> deserturi;
    private ArrayList<Bautura> bauturi;

    public AI_GUI_App() {
        setTitle("Aplicatie Gastronomica - AI");
        setSize(900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initializareDate();

        JTabbedPane tabs = new JTabbedPane();

        // ---------- TAB 1: Filtrare ----------
        tabs.addTab("Filtrare", buildFilterPanel());

        // ---------- TAB 2: Get / Set ----------
        tabs.addTab("Get / Set obiecte", buildGetSetPanel());

        // ---------- TAB 3: Instante ----------
        JPanel panelInstante = new JPanel(new BorderLayout());

        JTextArea txtInstante = new JTextArea();
        txtInstante.setEditable(false);

        JButton btnIncarca = new JButton("Încărcați instanțe");
        JButton btnSalveaza = new JButton("Salvați instanțe");

        btnSalveaza.addActionListener(e -> {
            salveazaInstante();
            txtInstante.setText("Instanțele au fost salvate în instanteAI.txt");
        });

        btnIncarca.addActionListener(e -> {
            incarcaInstante();
            txtInstante.setText("Instanțele au fost încărcate din instanteAI.txt");
        });


        JPanel panelButtons = new JPanel();
        panelButtons.add(btnIncarca);
        panelButtons.add(btnSalveaza);

        panelInstante.add(panelButtons, BorderLayout.NORTH);
        panelInstante.add(new JScrollPane(txtInstante), BorderLayout.CENTER);

        tabs.add("Instanțe", panelInstante);

        add(tabs, BorderLayout.CENTER);


        // Add back button on top area
        JPanel top = new JPanel(new BorderLayout());
        JButton btnBack = new JButton("< Back");
        btnBack.addActionListener(e -> {
            dispose();
            new MainWindow();
        });
        top.add(btnBack, BorderLayout.WEST);

        add(top, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);

        setVisible(true);
    }

    // ------------------ BUILD PANELS ------------------

    private JPanel buildFilterPanel() {
        JPanel panel = new JPanel(new BorderLayout(10,10));

        // top controls
        JPanel controls = new JPanel(new GridLayout(3, 2, 8, 8));
        controls.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        controls.add(new JLabel("Alege clasa:"));
        cmbClasaFilter = new JComboBox<>(new String[]{"FastFood", "Desert", "Bautura"});
        controls.add(cmbClasaFilter);

        controls.add(new JLabel("Conditie 1 (rating sau kcal):"));
        txtRatingMin = new JTextField();
        controls.add(txtRatingMin);

        controls.add(new JLabel("Conditie 2 (produse/portii/ingrediente):"));
        txtValoareMin = new JTextField();
        controls.add(txtValoareMin);

        panel.add(controls, BorderLayout.NORTH);

        outputFilter = new JTextArea();
        outputFilter.setEditable(false);
        panel.add(new JScrollPane(outputFilter), BorderLayout.CENTER);

        JButton btnFilter = new JButton("Filtrează");
        btnFilter.addActionListener(e -> aplicaFiltre());
        panel.add(btnFilter, BorderLayout.SOUTH);

        // change labels dynamically (optional)
        cmbClasaFilter.addActionListener(ev -> {
            String cls = (String) cmbClasaFilter.getSelectedItem();
            if ("FastFood".equals(cls)) {
                ((JLabel)controls.getComponent(2)).setText("Conditie 1 (rating):");
                ((JLabel)controls.getComponent(4)).setText("Conditie 2 (numar produse):");
            } else if ("Desert".equals(cls)) {
                ((JLabel)controls.getComponent(2)).setText("Conditie 1 (kcal):");
                ((JLabel)controls.getComponent(4)).setText("Conditie 2 (portii):");
            } else {
                ((JLabel)controls.getComponent(2)).setText("Conditie 1 (kcal):");
                ((JLabel)controls.getComponent(4)).setText("Conditie 2 (ingrediente):");
            }
        });

        return panel;
    }

    private JPanel buildGetSetPanel() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel topControls = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        topControls.add(new JLabel("Clasa:"));
        cmbClasaEdit = new JComboBox<>(new String[]{"FastFood", "Desert", "Bautura"});
        topControls.add(cmbClasaEdit);

        topControls.add(new JLabel("Instanța:"));
        cmbInstanta = new JComboBox<>();
        topControls.add(cmbInstanta);

        JButton btnLoadList = new JButton("Încărcați instanțe");
        btnLoadList.addActionListener(e -> populateInstantaCombo());
        topControls.add(btnLoadList);

        panel.add(topControls, BorderLayout.NORTH);

        // fields panel (dynamic)
        panelFields = new JPanel();
        panelFields.setLayout(new BoxLayout(panelFields, BoxLayout.Y_AXIS));
        JScrollPane scrollFields = new JScrollPane(panelFields);
        scrollFields.setPreferredSize(new Dimension(400, 300));
        panel.add(scrollFields, BorderLayout.CENTER);

        // bottom buttons (GET / SET)
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnGet = new JButton("GET");
        btnSet = new JButton("SET");
        bottom.add(btnGet);
        bottom.add(btnSet);
        panel.add(bottom, BorderLayout.SOUTH);

        cmbClasaEdit.addActionListener(e -> buildFieldsForSelectedClass());
        cmbInstanta.addActionListener(e -> {
        });
        btnGet.addActionListener(e -> performGet());
        btnSet.addActionListener(e -> performSet());

        populateInstantaCombo();
        buildFieldsForSelectedClass();

        return panel;
    }

    private JPanel buildInstantePanel() {
        JPanel panel = new JPanel(new BorderLayout(8,8));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        txtInstante = new JTextArea();
        txtInstante.setEditable(false);
        panel.add(new JScrollPane(txtInstante), BorderLayout.CENTER);

        btnRefreshInstante = new JButton("Refresh");
        btnRefreshInstante.addActionListener(e -> refreshInstanteView());
        panel.add(btnRefreshInstante, BorderLayout.SOUTH);

        refreshInstanteView();
        return panel;
    }


    private void buildFieldsForSelectedClass() {
        panelFields.removeAll();
        String cls = (String) cmbClasaEdit.getSelectedItem();

        int count = 0;
        if ("FastFood".equals(cls)) count = fastfoods.size();
        if ("Desert".equals(cls)) count = deserturi.size();
        if ("Bautura".equals(cls)) count = bauturi.size();
        cmbInstanta.removeAllItems();
        for (int i = 0; i < count; i++) cmbInstanta.addItem(String.valueOf(i));

        if ("FastFood".equals(cls)) {
            panelFields.add(new JLabel("Denumire:"));
            panelFields.add(new JTextField(30)); // index 0

            panelFields.add(new JLabel("Locație:"));
            panelFields.add(new JTextField(30)); // 1

            panelFields.add(new JLabel("Rating (double):"));
            panelFields.add(new JTextField(10)); // 2

            panelFields.add(new JLabel("Tip bucătărie:"));
            panelFields.add(new JTextField(20)); // 3

            panelFields.add(new JLabel("Număr produse (int):"));
            panelFields.add(new JTextField(6)); // 4

            panelFields.add(new JLabel("Lista sandwich-uri (separate prin ,):"));
            panelFields.add(new JTextField(50)); // 5

        } else if ("Desert".equals(cls)) {
            panelFields.add(new JLabel("Nume:"));
            panelFields.add(new JTextField(30)); // 0

            panelFields.add(new JLabel("Preț (double):"));
            panelFields.add(new JTextField(10)); // 1

            panelFields.add(new JLabel("Kcal (int):"));
            panelFields.add(new JTextField(6)); // 2

            panelFields.add(new JLabel("Categorie:"));
            panelFields.add(new JTextField(20)); // 3

            panelFields.add(new JLabel("Tip:"));
            panelFields.add(new JTextField(20)); // 4

            panelFields.add(new JLabel("Portii (int):"));
            panelFields.add(new JTextField(6)); // 5

            panelFields.add(new JLabel("Ingrediente (separate prin ,):"));
            panelFields.add(new JTextField(50)); // 6

        } else { // Bautura
            panelFields.add(new JLabel("Nume:"));
            panelFields.add(new JTextField(30)); // 0

            panelFields.add(new JLabel("Preț (double):"));
            panelFields.add(new JTextField(10)); // 1

            panelFields.add(new JLabel("Kcal (int):"));
            panelFields.add(new JTextField(6)); // 2

            panelFields.add(new JLabel("Categorie:"));
            panelFields.add(new JTextField(20)); // 3

            panelFields.add(new JLabel("Carbogazoasă:"));
            panelFields.add(new JCheckBox()); // 4

            panelFields.add(new JLabel("Alcoolică:"));
            panelFields.add(new JCheckBox()); // 5

            panelFields.add(new JLabel("Ingrediente (separate prin ,):"));
            panelFields.add(new JTextField(50)); // 6
        }

        panelFields.revalidate();
        panelFields.repaint();
    }

    // ------------------ ACTIONS: GET / SET ------------------

    private void performGet() {
        String cls = (String) cmbClasaEdit.getSelectedItem();
        String idxStr = (String) cmbInstanta.getSelectedItem();
        if (idxStr == null) {
            JOptionPane.showMessageDialog(this, "Nu există instanțe pentru clasa selectată.");
            return;
        }
        int idx = Integer.parseInt(idxStr);

        Component[] comps = panelFields.getComponents();

        try {
            if ("FastFood".equals(cls)) {
                FastFood f = fastfoods.get(idx);
                ((JTextField)comps[1]).setText(f.getDenumire());
                ((JTextField)comps[3]).setText(f.getLocatie());
                ((JTextField)comps[5]).setText(String.valueOf(f.getRating()));
                ((JTextField)comps[7]).setText(f.getTipBucatarie());
                ((JTextField)comps[9]).setText(String.valueOf(f.getNumarProduse()));
                ((JTextField)comps[11]).setText(String.join(",", f.getListaSandwichuri()));
            } else if ("Desert".equals(cls)) {
                Desert d = deserturi.get(idx);
                ((JTextField)comps[1]).setText(d.getNume());
                ((JTextField)comps[3]).setText(String.valueOf(d.getPret()));
                ((JTextField)comps[5]).setText(String.valueOf(d.getKcal()));
                ((JTextField)comps[7]).setText(d.getCategorie());
                ((JTextField)comps[9]).setText(d.getTip());
                ((JTextField)comps[11]).setText(String.valueOf(d.getPortii()));
                ((JTextField)comps[13]).setText(String.join(",", d.getIngrediente()));
            } else { // Bautura
                Bautura b = bauturi.get(idx);
                ((JTextField)comps[1]).setText(b.getNume());
                ((JTextField)comps[3]).setText(String.valueOf(b.getPret()));
                ((JTextField)comps[5]).setText(String.valueOf(b.getKcal()));
                ((JTextField)comps[7]).setText(b.getCategorie());
                ((JCheckBox)comps[9]).setSelected(b.isCarbogazoasa());
                ((JCheckBox)comps[11]).setSelected(b.isAlcoolica());
                ((JTextField)comps[13]).setText(String.join(",", b.getIngrediente()));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Eroare la GET: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void performSet() {
        String cls = (String) cmbClasaEdit.getSelectedItem();
        String idxStr = (String) cmbInstanta.getSelectedItem();
        if (idxStr == null) {
            JOptionPane.showMessageDialog(this, "Nu există instanțe pentru clasa selectată.");
            return;
        }
        int idx = Integer.parseInt(idxStr);

        Component[] comps = panelFields.getComponents();

        try {
            if ("FastFood".equals(cls)) {
                FastFood f = fastfoods.get(idx);
                String den = ((JTextField)comps[1]).getText();
                String loc = ((JTextField)comps[3]).getText();
                double rating = Double.parseDouble(((JTextField)comps[5]).getText());
                String tip = ((JTextField)comps[7]).getText();
                int nr = Integer.parseInt(((JTextField)comps[9]).getText());
                String[] sandwiches = ((JTextField)comps[11]).getText().split("\\s*,\\s*");

                // apply setters - assumed methods present
                f.setDenumire(den);
                f.setLocatie(loc);
                f.setRating(rating);
                f.setTipBucatarie(tip);
                f.setNumarProduse(nr);
                f.setListaSandwichuri(sandwiches);

                JOptionPane.showMessageDialog(this, "FastFood actualizat.");
            } else if ("Desert".equals(cls)) {
                Desert d = deserturi.get(idx);
                String nume = ((JTextField)comps[1]).getText();
                double pret = Double.parseDouble(((JTextField)comps[3]).getText());
                int kcal = Integer.parseInt(((JTextField)comps[5]).getText());
                String categorie = ((JTextField)comps[7]).getText();
                String tip = ((JTextField)comps[9]).getText();
                int portii = Integer.parseInt(((JTextField)comps[11]).getText());
                String[] ingrediente = ((JTextField)comps[13]).getText().split("\\s*,\\s*");

                d.setNume(nume);
                d.setPret(pret);
                d.setKcal(kcal);
                d.setCategorie(categorie);
                d.setTip(tip);
                d.setPortii(portii);
                d.setIngrediente(new ArrayList<>(Arrays.asList(ingrediente)));

                JOptionPane.showMessageDialog(this, "Desert actualizat.");
            } else { // Bautura
                Bautura b = bauturi.get(idx);
                String nume = ((JTextField)comps[1]).getText();
                double pret = Double.parseDouble(((JTextField)comps[3]).getText());
                int kcal = Integer.parseInt(((JTextField)comps[5]).getText());
                String categorie = ((JTextField)comps[7]).getText();
                boolean carb = ((JCheckBox)comps[9]).isSelected();
                boolean alc = ((JCheckBox)comps[11]).isSelected();
                String[] ingrediente = ((JTextField)comps[13]).getText().split("\\s*,\\s*");

                b.setNume(nume);
                b.setPret(pret);
                b.setKcal(kcal);
                b.setCategorie(categorie);
                b.setCarbogazoasa(carb);
                b.setAlcoolica(alc);
                b.setIngrediente(new ArrayList<>(Arrays.asList(ingrediente)));

                JOptionPane.showMessageDialog(this, "Băutură actualizată.");
            }

            // refresh instances view
            refreshInstanteView();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Eroare la SET: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // ------------------ FILTER ACTION ------------------

    private void aplicaFiltre() {
        outputFilter.setText("");

        String cls = (String) cmbClasaFilter.getSelectedItem();
        String s1 = txtRatingMin.getText().trim();
        String s2 = txtValoareMin.getText().trim();

        if (s1.isEmpty() || s2.isEmpty()) {
            outputFilter.setText("Introdu valori în ambele câmpuri.");
            return;
        }

        try {
            switch (cls) {
                case "FastFood": {
                    double ratingMin = Double.parseDouble(s1);
                    int minProduse = Integer.parseInt(s2);
                    for (FastFood f : fastfoods) {
                        if (f.getRating() >= ratingMin && f.getNumarProduse() >= minProduse)
                            outputFilter.append(f.toString() + "\n");
                    }
                    break;
                }
                case "Desert": {
                    int kcalMin = Integer.parseInt(s1);
                    int minPortii = Integer.parseInt(s2);
                    for (Desert d : deserturi) {
                        if (d.getKcal() >= kcalMin && d.getPortii() >= minPortii)
                            outputFilter.append(d.toString() + "\n");
                    }
                    break;
                }
                case "Bautura": {
                    int kcalMin = Integer.parseInt(s1);
                    int minIngr = Integer.parseInt(s2);
                    for (Bautura b : bauturi) {
                        if (b.getKcal() >= kcalMin && b.getNumarIngrediente() >= minIngr)
                            outputFilter.append(b.toString() + "\n");
                    }
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            outputFilter.setText("Introdu valori numerice valide.");
        }
    }

    // ------------------ INSTANCES VIEW ------------------

    private void refreshInstanteView() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== FastFood ===\n");
        for (int i = 0; i < fastfoods.size(); i++)
            sb.append(i).append(": ").append(fastfoods.get(i).toString()).append("\n");

        sb.append("\n=== Desert ===\n");
        for (int i = 0; i < deserturi.size(); i++)
            sb.append(i).append(": ").append(deserturi.get(i).toString()).append("\n");

        sb.append("\n=== Bautura ===\n");
        for (int i = 0; i < bauturi.size(); i++)
            sb.append(i).append(": ").append(bauturi.get(i).toString()).append("\n");

        if (txtInstante != null) txtInstante.setText(sb.toString());
    }

    private void populateInstantaCombo() {
        String cls = (String) cmbClasaEdit.getSelectedItem();
        cmbInstanta.removeAllItems();
        int count = 0;
        if ("FastFood".equals(cls)) count = fastfoods.size();
        if ("Desert".equals(cls)) count = deserturi.size();
        if ("Bautura".equals(cls)) count = bauturi.size();
        for (int i = 0; i < count; i++) cmbInstanta.addItem(String.valueOf(i));
    }

    // ------------------ DATA INITIALIZATION ------------------

    private void initializareDate() {
        String[] numeBaturui={"Cola","Pepsi","Fanta Portocale", "Sprite","Limonadă", "Apă minerală", "Cafea Latte","Ceai Verde", "Smoothie Banane", "Bere Blondă"};
        String[][] ingredienteBauturi = { {"Apă carbogazoasă", "Zahăr", "Cofeină"},            {"Apă carbogazoasă", "Zahăr", "Cofeină"},          {"Apă carbogazoasă", "Zahăr", "Arome naturale"},     {"Apă carbogazoasă", "Arome naturale", "Zahăr"},    {"Apă", "Zahăr", "Lămâie"},                          {"Apă minerală"},                                     {"Cafea", "Lapte", "Zahăr"},                          {"Ceai verde", "Lămâie", "Miere"},                   {"Banane", "Lapte", "Miere"},                         {"Hamei", "Malț", "Apă"}                              } ;
        bauturi = new ArrayList<>();
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

        deserturi = new ArrayList<>();
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
        fastfoods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fastfoods.add(new FastFood( denumireFastFood[i], locatieFastFood[i], 3.0 + i * 0.2, mapaSpecialitati[i%4], listaSandwich[i].length, listaSandwich[i]));
        }

    }
    private void salveazaInstante() {
        try {
            StringBuilder json = new StringBuilder();
            json.append("{\n");

            // ------- FastFood -------
            json.append("\"fastfood\": [\n");
            for (int i = 0; i < fastfoods.size(); i++) {
                FastFood f = fastfoods.get(i);
                json.append("  {\n");
                json.append("    \"denumire\": \"" + f.getDenumire() + "\",\n");
                json.append("    \"locatie\": \"" + f.getLocatie() + "\",\n");
                json.append("    \"rating\": " + f.getRating() + ",\n");
                json.append("    \"tipBucatarie\": \"" + f.getTipBucatarie() + "\",\n");
                json.append("    \"numarProduse\": " + f.getNumarProduse() + ",\n");

                json.append("    \"listaSandwichuri\": [");
                String[] list = f.getListaSandwichuri();
                for (int j = 0; j < list.length; j++) {
                    json.append("\"" + list[j] + "\"");
                    if (j < list.length - 1) json.append(", ");
                }
                json.append("]\n");

                json.append("  }");
                if (i < fastfoods.size() - 1) json.append(",");
                json.append("\n");
            }
            json.append("],\n");

            // ------- Deserturi -------
            json.append("\"deserturi\": [\n");
            for (int i = 0; i < deserturi.size(); i++) {
                Desert d = deserturi.get(i);
                json.append("  {\n");
                json.append("    \"nume\": \"" + d.getNume() + "\",\n");
                json.append("    \"pret\": " + d.getPret() + ",\n");
                json.append("    \"kcal\": " + d.getKcal() + ",\n");
                json.append("    \"categorie\": \"" + d.getCategorie() + "\",\n");
                json.append("    \"tip\": \"" + d.getTip() + "\",\n");
                json.append("    \"portii\": " + d.getPortii() + ",\n");

                json.append("    \"ingrediente\": [");
                for (int j = 0; j < d.getIngrediente().size(); j++) {
                    json.append("\"" + d.getIngrediente().get(j) + "\"");
                    if (j < d.getIngrediente().size() - 1) json.append(", ");
                }
                json.append("]\n");

                json.append("  }");
                if (i < deserturi.size() - 1) json.append(",");
                json.append("\n");
            }
            json.append("],\n");

            // ------- Bauturi -------
            json.append("\"bauturi\": [\n");
            for (int i = 0; i < bauturi.size(); i++) {
                Bautura b = bauturi.get(i);
                json.append("  {\n");
                json.append("    \"nume\": \"" + b.getNume() + "\",\n");
                json.append("    \"pret\": " + b.getPret() + ",\n");
                json.append("    \"kcal\": " + b.getKcal() + ",\n");
                json.append("    \"categorie\": \"" + b.getCategorie() + "\",\n");
                json.append("    \"isCarbogazoasa\": " + b.isCarbogazoasa() + ",\n");
                json.append("    \"isAlcoolica\": " + b.isAlcoolica() + ",\n");

                json.append("    \"ingrediente\": [");
                for (int j = 0; j < b.getIngrediente().size(); j++) {
                    json.append("\"" + b.getIngrediente().get(j) + "\"");
                    if (j < b.getIngrediente().size() - 1) json.append(", ");
                }
                json.append("]\n");

                json.append("  }");
                if (i < bauturi.size() - 1) json.append(",");
                json.append("\n");
            }
            json.append("]\n");

            json.append("}\n");

            java.nio.file.Files.write(
                    java.nio.file.Paths.get("instanteAI.txt"),
                    json.toString().getBytes()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void incarcaInstante() {
        try {
            fastfoods.clear();
            deserturi.clear();
            bauturi.clear();

            String text = new String(java.nio.file.Files.readAllBytes(
                    java.nio.file.Paths.get("instanteAI.txt"))
            );

            // Eliminăm spații pentru parsing simplu
            text = text.replace("\n", "").replace("\r", "").trim();

            // ---------------- FASTFOOD ----------------
            String fastfoodBlock = text.split("\"fastfood\":")[1].split("],")[0];
            String[] ffEntries = fastfoodBlock.split("\\{");

            for (String entry : ffEntries) {
                if (!entry.contains("denumire")) continue;

                String denumire = extract(entry, "denumire");
                String locatie = extract(entry, "locatie");
                double rating = Double.parseDouble(extract(entry, "rating"));
                String tipBucatarie = extract(entry, "tipBucatarie");
                int numarProduse = Integer.parseInt(extract(entry, "numarProduse"));
                String[] listaSandwichuri = extractArray(entry, "listaSandwichuri");

                fastfoods.add(new FastFood(
                        denumire, locatie, rating, tipBucatarie,
                        numarProduse, listaSandwichuri
                ));
            }

            // ---------------- DESERTURI ----------------
            String desertBlock = text.split("\"deserturi\":")[1].split("],")[0];
            String[] dsEntries = desertBlock.split("\\{");

            for (String entry : dsEntries) {
                if (!entry.contains("nume")) continue;

                String nume = extract(entry, "nume");
                double pret = Double.parseDouble(extract(entry, "pret"));
                int kcal = Integer.parseInt(extract(entry, "kcal"));
                String categorie = extract(entry, "categorie");
                String tip = extract(entry, "tip");
                int portii = Integer.parseInt(extract(entry, "portii"));
                String[] ingrediente = extractArray(entry, "ingrediente");

                deserturi.add(new Desert(
                        nume, pret, kcal, categorie, tip, ingrediente, portii
                ));
            }

            // ---------------- BAUTURI ----------------
            String bauturiBlock = text.split("\"bauturi\":")[1].split("]")[0];
            String[] btEntries = bauturiBlock.split("\\{");

            for (String entry : btEntries) {
                if (!entry.contains("nume")) continue;

                String nume = extract(entry, "nume");
                double pret = Double.parseDouble(extract(entry, "pret"));
                int kcal = Integer.parseInt(extract(entry, "kcal"));
                String categorie = extract(entry, "categorie");
                boolean isCarbogazoasa = Boolean.parseBoolean(extract(entry, "isCarbogazoasa"));
                boolean isAlcoolica = Boolean.parseBoolean(extract(entry, "isAlcoolica"));
                String[] ingrediente = extractArray(entry, "ingrediente");

                bauturi.add(new Bautura(
                        nume, pret, kcal, categorie,
                        isCarbogazoasa, isAlcoolica,
                        ingrediente
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String extract(String block, String key) {
        try {
            String val = block.split("\"" + key + "\"")[1];
            val = val.substring(val.indexOf(":") + 1).trim();
            if (val.startsWith("\""))
                return val.substring(1, val.indexOf("\"", 1));
            else
                return val.split(",")[0].replace("}", "").trim();
        } catch (Exception e) {
            return "";
        }
    }

    private String[] extractArray(String block, String key) {
        try {
            String arr = block.split("\"" + key + "\"")[1];
            arr = arr.substring(arr.indexOf("[") + 1, arr.indexOf("]"));
            if (arr.trim().isEmpty()) return new String[0];
            String[] elems = arr.split(",");
            for (int i = 0; i < elems.length; i++) {
                elems[i] = elems[i].replace("\"", "").trim();
            }
            return elems;
        } catch (Exception e) {
            return new String[0];
        }
    }


}
