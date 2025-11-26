import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class AAA_GUI_App extends JFrame {

    private JTextField txtCond1;
    private JTextField txtCond2;
    private JComboBox<String> cmbClasa;
    private JTextArea output;

    // "Vectorii" cu care lucrăm
    private Angajat[] angajati;
    private Client[] clienti;
    private Cafenea[] cafenele;

    public AAA_GUI_App() {
        setTitle("Filtrare Angajati / Clienti / Cafenele");
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------------- TOP: back + filtre ----------------
        JPanel topWrapper = new JPanel(new BorderLayout());

        JButton btnBack = new JButton("< Back");
        topWrapper.add(btnBack, BorderLayout.WEST);

        JPanel panelTop = new JPanel(new GridLayout(3, 2, 10, 10));

        panelTop.add(new JLabel("Alege clasa:"));
        cmbClasa = new JComboBox<>(new String[]{"Angajat", "Client", "Cafenea"});
        panelTop.add(cmbClasa);

        panelTop.add(new JLabel("Condiție 1:"));
        txtCond1 = new JTextField();
        panelTop.add(txtCond1);

        panelTop.add(new JLabel("Condiție 2:"));
        txtCond2 = new JTextField();
        panelTop.add(txtCond2);

        topWrapper.add(panelTop, BorderLayout.CENTER);
        add(topWrapper, BorderLayout.NORTH);

        // ---------------- ZONA AFIȘARE ----------------
        output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        // ---------------- BUTON FILTRARE ----------------
        JButton btnFilter = new JButton("Filtrează");
        add(btnFilter, BorderLayout.SOUTH);

        // ---------------- LISTENERS ----------------
        btnFilter.addActionListener(e -> aplicaFiltre());

        btnBack.addActionListener(e -> {
            dispose();
            new MainWindow();   // revine la meniul principal
        });

        // ---------------- INITIALIZARE DATE + FIȘIERE ----------------
        initializareDate();          // umple vectorii cu 10 elemente ca în TestAAA
        salveazaVectoriInFisiere();  // cerința 6

        setVisible(true);
    }

    // ==================== Cerința 2: vectorii cu 10 instanțe ====================
    private void initializareDate() {
        // vector Angajat
        angajati = new Angajat[10];
        for (int i = 0; i < angajati.length; i++) {
            angajati[i] = new Angajat(
                    "Angajat" + i,
                    "angajat" + i + "@firma.com",
                    "07" + i + i + i + i + i + i + i,
                    "Functie" + i,
                    3000.0 + i * 100,
                    LocalDate.of(2024, 1, 1).plusMonths(i)
            );
        }

        // vector Client
        clienti = new Client[10];
        for (int i = 0; i < clienti.length; i++) {
            clienti[i] = new Client(
                    "Client" + i,
                    "client" + i + "@mail.com",
                    "07" + i + (i + 1) + (i + 2) + (i + 3) + (i + 4) + (i + 5),
                    i * 10,
                    i % 2 == 0
            );
        }

        // vector Cafenea
        cafenele = new Cafenea[10];
        for (int i = 0; i < cafenele.length; i++) {
            cafenele[i] = new Cafenea(
                    "Cafenea " + i,
                    "Zona " + i,
                    3.5 + (i % 3) * 0.3,
                    20 + i * 5,
                    i % 2 == 0,
                    LocalTime.of(7 + (i % 3), 0),
                    LocalTime.of(21, 0)
            );
        }
    }

    // ==================== Cerința 6: 2 fișiere cu 2 vectori ====================
    private void salveazaVectoriInFisiere() {
        salveazaAngajatiInFisier("angajati.txt");
        salveazaCafeneleInFisier("cafenele.txt");
        // (dacă vrei, poți face și pentru clienți, dar cerința zice „doi vectori”)
    }

    private void salveazaAngajatiInFisier(String numeFisier) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(numeFisier))) {
            for (Angajat a : angajati) {
                pw.println(a.toString());
            }
        } catch (IOException e) {
            System.out.println("Eroare la scrierea " + numeFisier + ": " + e.getMessage());
        }
    }

    private void salveazaCafeneleInFisier(String numeFisier) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(numeFisier))) {
            for (Cafenea c : cafenele) {
                pw.println(c.toString());
            }
        } catch (IOException e) {
            System.out.println("Eroare la scrierea " + numeFisier + ": " + e.getMessage());
        }
    }

    // ==================== Cerința 4 + 5: metode de filtrare + GUI ====================

    private void aplicaFiltre() {
        output.setText("");

        String clasa = (String) cmbClasa.getSelectedItem();

        try {
            switch (clasa) {
                case "Angajat": {
                    // Condiție 1: salariu minim (double)
                    // Condiție 2: anul minim al angajării (int)
                    double salariuMin = Double.parseDouble(txtCond1.getText());
                    int anMin = Integer.parseInt(txtCond2.getText());
                    filtreazaAngajati(salariuMin, anMin);
                    break;
                }
                case "Client": {
                    // Condiție 1: puncte min fidelitate (int)
                    // Condiție 2: abonat newsletter? (1 = da, 0 = nu)
                    int puncteMin = Integer.parseInt(txtCond1.getText());
                    int abonatInt = Integer.parseInt(txtCond2.getText());
                    boolean abonat = (abonatInt == 1);
                    filtreazaClienti(puncteMin, abonat);
                    break;
                }
                case "Cafenea": {
                    // Condiție 1: rating minim (double)
                    // Condiție 2: capacitate minimă (int)
                    double ratingMin = Double.parseDouble(txtCond1.getText());
                    int capacitateMin = Integer.parseInt(txtCond2.getText());
                    filtreazaCafenele(ratingMin, capacitateMin);
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            output.setText("⚠ Introdu valori numerice valide în cele două câmpuri!");
        }
    }

    // >>> Astea sunt practic cele "două metode" din cerință (noi facem 3, câte una pe clasă) <<<

    private void filtreazaAngajati(double salariuMin, int anMin) {
        output.append("=== Angajati cu salariu >= " + salariuMin +
                " si an angajare >= " + anMin + " ===\n");
        for (Angajat a : angajati) {
            if (a.getSalariu() >= salariuMin &&
                    a.getDataAngajarii().getYear() >= anMin) {
                output.append(a.toString() + "\n");
            }
        }
    }

    private void filtreazaClienti(int puncteMin, boolean abonatNecesar) {
        output.append("=== Clienti cu puncte >= " + puncteMin +
                " si abonatNewsletter = " + abonatNecesar + " ===\n");
        for (Client c : clienti) {
            if (c.getPuncteFidelitate() >= puncteMin &&
                    c.isAbonatNewsletter() == abonatNecesar) {
                output.append(c.toString() + "\n");
            }
        }
    }

    private void filtreazaCafenele(double ratingMin, int capacitateMin) {
        output.append("=== Cafenele cu rating >= " + ratingMin +
                " si capacitate >= " + capacitateMin + " ===\n");
        for (Cafenea cf : cafenele) {
            if (cf.getRating() >= ratingMin &&
                    cf.getCapacitate() >= capacitateMin) {
                output.append(cf.toString() + "\n");
            }
        }
    }
}
