// Cerinta:
// 1) 3 instante (default, param, copy) pentru Angajat, Client, Cafenea – afisate in tabel
// 2) Vector cu 10 instante din fiecare clasa – afisate in tabel
// 3) Afisarea instantelor din vectori care respecta doua conditii combinate (&&) pe datele membre

import java.time.LocalDate;
import java.time.LocalTime;

public class TestAAA {

    public static void main(String[] args) {

        // ============================
        // 1. 3 instante per clasa
        // ============================

        // --- ANGAJAT ---
        Angajat angDefault = new Angajat();
        Angajat angParam = new Angajat(
                "Popescu Ion",
                "ion.popescu@firma.com",
                "0712345678",
                "Barista",
                3500.0,
                LocalDate.of(2024, 3, 1)
        );
        Angajat angCopy = new Angajat(angParam);

        System.out.println("=== ANGAJATI (3 instante: default, param, copy) ===");
        printHeaderAngajati();
        printAngajatRow(0, angDefault, "default");
        printAngajatRow(1, angParam,   "param");
        printAngajatRow(2, angCopy,    "copy");
        System.out.println();

        // --- CLIENT ---
        Client clientDefault = new Client();
        Client clientParam = new Client(
                "Ionescu Ana",
                "ana.ionescu@mail.com",
                "0700000000",
                120,
                true
        );
        Client clientCopy = new Client(clientParam);

        System.out.println("=== CLIENTI (3 instante: default, param, copy) ===");
        printHeaderClienti();
        printClientRow(0, clientDefault, "default");
        printClientRow(1, clientParam,   "param");
        printClientRow(2, clientCopy,    "copy");
        System.out.println();

        // --- CAFENEA ---
        Cafenea cafDefault = new Cafenea();
        Cafenea cafParam = new Cafenea(
                "Coffee Corner",
                "Centru",
                4.5,
                40,
                true,
                LocalTime.of(8, 0),
                LocalTime.of(22, 0)
        );
        Cafenea cafCopy = new Cafenea(cafParam);

        System.out.println("=== CAFENELE (3 instante: default, param, copy) ===");
        printHeaderCafenele();
        printCafeneaRow(0, cafDefault, "default");
        printCafeneaRow(1, cafParam,   "param");
        printCafeneaRow(2, cafCopy,    "copy");
        System.out.println();

        // ====================================
        // 2. Vectori cu 10 instante per clasa
        // ====================================

        // vector Angajat
        Angajat[] angajati = new Angajat[10];
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
        Client[] clienti = new Client[10];
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
        Cafenea[] cafenele = new Cafenea[10];
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

        // ==================
        // 3. Afisare vectori ca tabel
        // ==================

        System.out.println("=== VECTOR ANGAJATI (10 instante) ===");
        printHeaderAngajati();
        for (int i = 0; i < angajati.length; i++) {
            printAngajatRow(i, angajati[i], "vector");
        }
        System.out.println();

        System.out.println("=== VECTOR CLIENTI (10 instante) ===");
        printHeaderClienti();
        for (int i = 0; i < clienti.length; i++) {
            printClientRow(i, clienti[i], "vector");
        }
        System.out.println();

        System.out.println("=== VECTOR CAFENELE (10 instante) ===");
        printHeaderCafenele();
        for (int i = 0; i < cafenele.length; i++) {
            printCafeneaRow(i, cafenele[i], "vector");
        }
        System.out.println();

        // ==============================
        // 4. Afisare filtrata dupa conditii
        // ==============================

        // Angajati cu salariu >= 3400 si data angajarii dupa 2024-03-01
        System.out.println("=== ANGAJATI filtrati (salariu >= 3400 si data angajarii dupa 2024-03-01) ===");
        printHeaderAngajati();
        for (int i = 0; i < angajati.length; i++) {
            Angajat a = angajati[i];
            if (a.getSalariu() >= 3400 &&
                    a.getDataAngajarii().isAfter(LocalDate.of(2024, 3, 1))) { // doua conditii combinate cu &&
                printAngajatRow(i, a, "filtrat");
            }
        }
        System.out.println();

        // Clienti cu puncteFidelitate >= 30 si abonati la newsletter
        System.out.println("=== CLIENTI filtrati (puncte >= 30 si abonat newsletter) ===");
        printHeaderClienti();
        for (int i = 0; i < clienti.length; i++) {
            Client c = clienti[i];
            if (c.getPuncteFidelitate() >= 30 && c.isAbonatNewsletter()) {   // doua conditii combinate cu &&
                printClientRow(i, c, "filtrat");
            }
        }
        System.out.println();

        // Cafenele cu rating >= 4.0 si care au terasa
        System.out.println("=== CAFENELE filtrate (rating >= 4.0 si terasa) ===");
        printHeaderCafenele();
        for (int i = 0; i < cafenele.length; i++) {
            Cafenea cf = cafenele[i];
            if (cf.getRating() >= 4.0 && cf.isAreTerasa()) {                 // doua conditii combinate cu &&
                printCafeneaRow(i, cf, "filtrat");
            }
        }
        System.out.println();


    }

    // ==========================
    // Functii tabel ANGAJATI
    // ==========================

    private static void printHeaderAngajati() {
        System.out.printf("%-3s | %-8s | %-15s | %-22s | %-12s | %-12s | %8s | %-10s%n",
                "Idx", "Tip", "Nume", "Email", "Telefon", "Functie", "Salariu", "DataAng");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    private static void printAngajatRow(int idx, Angajat a, String tip) {
        System.out.printf("%-3d | %-8s | %-15s | %-22s | %-12s | %-12s | %8.2f | %-10s%n",
                idx,
                tip,
                a.getNume(),
                a.getEmail(),
                a.getTelefon(),
                a.getFunctie(),
                a.getSalariu(),
                a.getDataAngajarii()
        );
    }

    // ==========================
    // Functii tabel CLIENTI
    // ==========================

    private static void printHeaderClienti() {
        System.out.printf("%-3s | %-8s | %-15s | %-22s | %-12s | %8s | %-10s%n",
                "Idx", "Tip", "Nume", "Email", "Telefon", "Puncte", "Newsletter");
        System.out.println("----------------------------------------------------------------------------");
    }

    private static void printClientRow(int idx, Client c, String tip) {
        System.out.printf("%-3d | %-8s | %-15s | %-22s | %-12s | %8d | %-10s%n",
                idx,
                tip,
                c.getNume(),
                c.getEmail(),
                c.getTelefon(),
                c.getPuncteFidelitate(),
                c.isAbonatNewsletter() ? "DA" : "NU"
        );
    }

    // ==========================
    // Functii tabel CAFENELE
    // ==========================

    private static void printHeaderCafenele() {
        System.out.printf("%-3s | %-8s | %-15s | %-10s | %6s | %10s | %-7s | %-13s%n",
                "Idx", "Tip", "Denumire", "Locatie", "Rating", "Capacitate", "Terasa", "Program");
        System.out.println("--------------------------------------------------------------------------------");
    }

    private static void printCafeneaRow(int idx, Cafenea cf, String tip) {
        String program;
        if (cf.getOraDeschidere() != null && cf.getOraInchidere() != null) {
            program = cf.getOraDeschidere() + "-" + cf.getOraInchidere();
        } else {
            program = "-";
        }

        System.out.printf("%-3d | %-8s | %-15s | %-10s | %6.1f | %10d | %-7s | %-13s%n",
                idx,
                tip,
                cf.getDenumire(),   // din LocalCulinar
                cf.getLocatie(),
                cf.getRating(),
                cf.getCapacitate(),
                cf.isAreTerasa() ? "DA" : "NU",
                program
        );
    }
}
