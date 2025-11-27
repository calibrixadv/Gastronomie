import javax.swing.*;
import java.awt.*;

public class AB_GUI_App extends JFrame {

    private JTextField txtCond1;
    private JTextField txtCond2;
    private JComboBox<String> cmbClasa;
    private JTextArea output;

    private Produs[] produse;
    private Mancare[] mancaruri;
    private Restaurant[] restaurante;

    public AB_GUI_App() {
        // luam vectorii direct din TestAB
        this.produse = TestAB.getVectorProduse();
        this.mancaruri = TestAB.getVectorMancaruri();
        this.restaurante = TestAB.getVectorRestaurante();

        initUI();
    }

    private void initUI() {
        setTitle("Aplicatie Gastronomica - AB");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ====== PANEL SUS: clasa + conditii ======
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        cmbClasa = new JComboBox<>(new String[]{"Produs", "Mancare", "Restaurant"});
        JLabel lblClasa = new JLabel("Clasa:");

        JLabel lblCond1 = new JLabel("Conditia 1:");
        JLabel lblCond2 = new JLabel("Conditia 2:");

        txtCond1 = new JTextField();
        txtCond2 = new JTextField();

        topPanel.add(lblClasa);
        topPanel.add(cmbClasa);
        topPanel.add(lblCond1);
        topPanel.add(txtCond1);
        topPanel.add(lblCond2);
        topPanel.add(txtCond2);

        add(topPanel, BorderLayout.NORTH);

        // ====== ZONA CENTRALA: output ======
        output = new JTextArea(18, 90);
        output.setEditable(false);
        output.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(output);
        add(scrollPane, BorderLayout.CENTER);

        // ====== BUTOANE JOS: Back + Filtreaza ======
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            new MainWindow();  // deschide meniul principal
            dispose();         // închide fereastra AB
        });
        JButton btnFiltreaza = new JButton("Filtreaza");

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(btnBack);
        bottomPanel.add(btnFiltreaza);

        add(bottomPanel, BorderLayout.SOUTH);

        // listeners
        cmbClasa.addActionListener(e -> actualizeazaEticheteConditii());
        btnFiltreaza.addActionListener(e -> aplicaFiltru());
        btnBack.addActionListener(e -> dispose()); // inchide doar fereastra asta

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        actualizeazaEticheteConditii();
    }

    private void actualizeazaEticheteConditii() {
        String clasa = (String) cmbClasa.getSelectedItem();

        String text1, text2;

        switch (clasa) {
            case "Produs":
                text1 = "Pret minim:";
                text2 = "Kcal maxim:";
                break;
            case "Mancare":
                text1 = "Kcal maxim:";
                text2 = "Numar minim de alergeni:";
                break;
            case "Restaurant":
                text1 = "Rating minim:";
                text2 = "Numar minim de locuri:";
                break;
            default:
                text1 = "Conditia 1:";
                text2 = "Conditia 2:";
        }

        JPanel topPanel = (JPanel) getContentPane().getComponent(0);
        JLabel lblCond1 = (JLabel) topPanel.getComponent(2);
        JLabel lblCond2 = (JLabel) topPanel.getComponent(4);

        lblCond1.setText(text1);
        lblCond2.setText(text2);
    }

    private void aplicaFiltru() {
        String clasa = (String) cmbClasa.getSelectedItem();
        output.setText("");

        try {
            switch (clasa) {
                case "Produs": {
                    double pretMin = Double.parseDouble(txtCond1.getText().trim());
                    int kcalMax = Integer.parseInt(txtCond2.getText().trim());

                    // info filtre in GUI
                    output.append("Filtru 1 aplicat: pret minim = " + pretMin + "\n");
                    output.append("Filtru 2 aplicat: Kcal maxim = " + kcalMax + "\n\n");

                    String titlu = "=== PRODUSE cu pret >= " + pretMin +
                            " SI kcal <= " + kcalMax + " ===\n\n";
                    output.append(titlu);

                    String header = String.format("%-3s | %-8s | %-20s | %-12s | %8s | %8s%n",
                            "Nr", "Tip", "Nume", "Categorie", "Pret", "Kcal");
                    String lineSep = "----+----------+----------------------+--------------+----------+----------";

                    output.append(header);
                    output.append(lineSep + "\n");

                    // scriem EXACT acelasi tabel in fisier
                    try (java.io.PrintWriter pw = new java.io.PrintWriter("produse_filtrate.txt")) {
                        pw.println("Filtru 1 aplicat: pret minim = " + pretMin);
                        pw.println("Filtru 2 aplicat: Kcal maxim = " + kcalMax);
                        pw.println();
                        pw.print(titlu);
                        pw.print(header);
                        pw.println(lineSep);

                        for (int i = 0; i < produse.length; i++) {
                            Produs p = produse[i];
                            if (p != null &&
                                    p.getPret() >= pretMin &&
                                    p.getKcal() <= kcalMax) {

                                String line = String.format("%-3d | %-8s | %-20s | %-12s | %8.2f | %8d%n",
                                        i,
                                        "filtrat",
                                        p.getNume(),
                                        p.getCategorie(),
                                        p.getPret(),
                                        p.getKcal());

                                output.append(line);
                                pw.print(line);   // aceeasi linie in fisier
                            }
                        }
                    }

                    output.append("\nRezultatele au fost salvate in fisierul produse_filtrate.txt\n");
                    break;
                }

                case "Mancare": {
                    int kcalMax = Integer.parseInt(txtCond1.getText().trim());
                    int minAlergeni = Integer.parseInt(txtCond2.getText().trim());

                    output.append("Filtru 1 aplicat: Kcal maxim = " + kcalMax + "\n");
                    output.append("Filtru 2 aplicat: nr. minim de alergeni = " + minAlergeni + "\n\n");

                    String titlu = "=== MANCARE cu kcal <= " + kcalMax +
                            " SI nrAlergeni >= " + minAlergeni + " ===\n\n";
                    output.append(titlu);

                    String header = String.format(
                            "%-3s | %-8s | %-20s | %-6s | %-12s | %-12s | %-12s | %8s | %8s%n",
                            "Nr", "Tip", "Nume", "Calda", "NrIngred.", "NrAlerg.",
                            "Categorie", "Pret", "Kcal");
                    String lineSep = "----+----------+----------------------+--------+--------------+--------------+--------------+----------+----------";

                    output.append(header);
                    output.append(lineSep + "\n");

                    for (int i = 0; i < mancaruri.length; i++) {
                        Mancare m = mancaruri[i];
                        if (m != null) {
                            int nrAlg = (m.getListaAlergeni() != null)
                                    ? m.getListaAlergeni().size()
                                    : 0;
                            int nrIng = (m.getListaIngrediente() != null)
                                    ? m.getListaIngrediente().size()
                                    : 0;

                            if (m.getKcal() <= kcalMax && nrAlg >= minAlergeni) {
                                String line = String.format(
                                        "%-3d | %-8s | %-20s | %-6s | %-12d | %-12d | %-12s | %8.2f | %8d%n",
                                        i,
                                        "filtrat",
                                        m.getNume(),
                                        m.getisCalda() ? "DA" : "NU",
                                        nrIng,
                                        nrAlg,
                                        m.getCategorie(),
                                        m.getPret(),
                                        m.getKcal());
                                output.append(line);
                            }
                        }
                    }
                    // pentru Mancare nu facem fisier, raman doar 2 fisiere totale
                    break;
                }

                case "Restaurant": {
                    double ratingMin = Double.parseDouble(txtCond1.getText().trim());
                    int locuriMin = Integer.parseInt(txtCond2.getText().trim());

                    output.append("Filtru 1 aplicat: rating minim = " + ratingMin + "\n");
                    output.append("Filtru 2 aplicat: numar minim de locuri = " + locuriMin + "\n\n");

                    String titlu = "=== RESTAURANTE cu rating >= " + ratingMin +
                            " SI locuri >= " + locuriMin + " ===\n\n";
                    output.append(titlu);

                    String header = String.format(
                            "%-3s | %-8s | %-20s | %-22s | %8s | %-15s | %8s | %-10s | %-10s%n",
                            "Nr", "Tip", "Nume", "Locatie", "Rating", "Tip bucatarie",
                            "Locuri", "Rezervari", "Livrare");
                    String lineSep = "----+----------+----------------------+----------------------+----------+-----------------+----------+------------+------------";

                    output.append(header);
                    output.append(lineSep + "\n");

                    try (java.io.PrintWriter pw = new java.io.PrintWriter("restaurante_filtrate.txt")) {
                        pw.println("Filtru 1 aplicat: rating minim = " + ratingMin);
                        pw.println("Filtru 2 aplicat: numar minim de locuri = " + locuriMin);
                        pw.println();
                        pw.print(titlu);
                        pw.print(header);
                        pw.println(lineSep);

                        for (int i = 0; i < restaurante.length; i++) {
                            Restaurant r = restaurante[i];
                            if (r != null &&
                                    r.getRating() >= ratingMin &&
                                    r.getNumarLocuri() >= locuriMin) {

                                String line = String.format(
                                        "%-3d | %-8s | %-20s | %-22s | %8.2f | %-15s | %8d | %-10s | %-10s%n",
                                        i,
                                        "filtrat",
                                        r.getDenumire(),
                                        r.getLocatie(),
                                        r.getRating(),
                                        r.getTipBucatarie(),
                                        r.getNumarLocuri(),
                                        r.getisAcceptaRezervari() ? "DA" : "NU",
                                        r.getisLivrareLaDomiciliu() ? "DA" : "NU");
                                output.append(line);
                                pw.print(line);
                            }
                        }
                    }

                    output.append("\nRezultatele au fost salvate in fisierul restaurante_filtrate.txt\n");
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            output.setText("⚠ Introdu NUMERE valide in ambele campuri de conditii.\n");
        } catch (Exception ex) {
            output.append("\nEroare la scrierea fisierelor: " + ex.getMessage() + "\n");
        }
    }
}
