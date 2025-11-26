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
    private JLabel lblCond1;
    private JLabel lblCond2;

    // Vectorii pentru cele 3 clase
    private Angajat[] angajati;
    private Client[] clienti;
    private Cafenea[] cafenele;

    public AAA_GUI_App() {
        setTitle("Aplicatie Gastronomica - AAA");
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------- TOP: buton Back + filtre --------
        JPanel panelTopWrapper = new JPanel(new BorderLayout());

        JButton btnBack = new JButton("< Back");
        panelTopWrapper.add(btnBack, BorderLayout.WEST);

        JPanel panelTop = new JPanel(new GridLayout(3, 2, 10, 10));

        panelTop.add(new JLabel("Alege clasa:"));
        cmbClasa = new JComboBox<>(new String[]{"Angajat", "Client", "Cafenea"});
        panelTop.add(cmbClasa);

        lblCond1 = new JLabel();
        txtCond1 = new JTextField();
        panelTop.add(lblCond1);
        panelTop.add(txtCond1);

        lblCond2 = new JLabel();
        txtCond2 = new JTextField();
        panelTop.add(lblCond2);
        panelTop.add(txtCond2);

        panelTopWrapper.add(panelTop, BorderLayout.CENTER);
        add(panelTopWrapper, BorderLayout.NORTH);

        // -------- ZONA AFISARE --------
        output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        // -------- BUTON FILTRARE --------
        JButton btnFilter = new JButton("Filtrează");
        add(btnFilter, BorderLayout.SOUTH);

        // -------- LISTENERS --------
        btnFilter.addActionListener(e -> aplicaFiltre());

        btnBack.addActionListener(e -> {
            dispose();          // închide fereastra curentă
            new MainWindow();   // revine la meniul principal
        });

        cmbClasa.addActionListener(e -> actualizeazaEticheteConditii());
        actualizeazaEticheteConditii();  // setare inițială

        // -------- INITIALIZARE DATE + SCRIERE IN FISIERE --------
        initializareDate();         // vectori cu 10 elemente, ca in TestAAA
        salveazaVectoriInFisiere(); // cerinta 6: toti vectorii in fisiere

        setVisible(true);
    }

    // ================== Etichete dinamice pentru condiții ==================
    private void actualizeazaEticheteConditii() {
        String clasa = (String) cmbClasa.getSelectedItem();

        if ("Angajat".equals(clasa)) {
            lblCond1.setText("Salariu minim:");
            lblCond2.setText("An minim angajare:");
            txtCond1.setToolTipText("Ex: 3400");
            txtCond2.setToolTipText("Ex: 2024");
        } else if ("Client".equals(clasa)) {
            lblCond1.setText("Puncte min fidelitate:");
            lblCond2.setText("Abonat newsletter (1 = DA, 0 = NU):");
            txtCond1.setToolTipText("Ex: 30");
            txtCond2.setToolTipText("1 = DA, 0 = NU");
        } else if ("Cafenea".equals(clasa)) {
            lblCond1.setText("Rating minim:");
            lblCond2.setText("Capacitate minimă:");
            txtCond1.setToolTipText("Ex: 4.0");
            txtCond2.setToolTipText("Ex: 40");
        }
    }

    // ================== Initializare vectori (ca in TestAAA) ==================
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

    // ================== Cerinta 6: toti vectorii in fisiere ==================
    private void salveazaVectoriInFisiere() {
        salveazaAngajatiInFisier("angajati.txt");
        salveazaClientiInFisier("clienti.txt");
        salveazaCafeneleInFisier("cafenele.txt");
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

    private void salveazaClientiInFisier(String numeFisier) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(numeFisier))) {
            for (Client c : clienti) {
                pw.println(c.toString());
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

    // ================== Cerinta 4 + 5: filtrare dupa 2 conditii ==================
    private void aplicaFiltre() {
        output.setText("");

        String clasa = (String) cmbClasa.getSelectedItem();

        try {
            if ("Angajat".equals(clasa)) {
                // Cond.1: salariu minim (double)
                // Cond.2: an minim al angajarii (int)
                double salariuMin = Double.parseDouble(txtCond1.getText());
                int anMin = Integer.parseInt(txtCond2.getText());
                filtreazaAngajati(salariuMin, anMin);
            } else if ("Client".equals(clasa)) {
                // Cond.1: puncte min
                // Cond.2: 1 = abonat, 0 = neabonat
                int puncteMin = Integer.parseInt(txtCond1.getText());
                int abonatInt = Integer.parseInt(txtCond2.getText());
                boolean abonat = (abonatInt == 1);
                filtreazaClienti(puncteMin, abonat);
            } else if ("Cafenea".equals(clasa)) {
                // Cond.1: rating minim
                // Cond.2: capacitate minima
                double ratingMin = Double.parseDouble(txtCond1.getText());
                int capacitateMin = Integer.parseInt(txtCond2.getText());
                filtreazaCafenele(ratingMin, capacitateMin);
            }
        } catch (NumberFormatException ex) {
            output.setText("⚠ Introdu valori numerice valide în cele două câmpuri!");
        }
    }

    // === metodele care parcurg vectorii si afiseaza instantele care satisfac cele 2 conditii ===

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
