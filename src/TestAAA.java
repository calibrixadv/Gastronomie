// Cerinta:
// 1) Fisier de test cu cel putin 3 instante din fiecare clasa (Angajat, Client, Cafenea),
//    folosind toti constructorii (default, cu parametri, copiere).
// 2) Vector cu cel putin 10 instante din fiecare clasa si afisarea lor.

import java.time.LocalDate;
import java.time.LocalTime;

public class TestAAA {

    public static void main(String[] args) {

        // ==============================
        // 1. 3 instante / clasa (toti constructorii)
        // ==============================

        // --- ANGAJAT ---
        Angajat angDefault = new Angajat();  // constructor default

        Angajat angParam = new Angajat(      // constructor cu toți parametrii
                "Popescu Ion",
                "ion.popescu@firma.com",
                "0712345678",
                "Barista",
                3500.0,
                LocalDate.of(2024, 3, 1)
        );

        Angajat angCopy = new Angajat(angParam); // constructor de copiere

        System.out.println("=== Angajati (3 instante) ===");
        System.out.println(angDefault);
        System.out.println(angParam);
        System.out.println(angCopy);

        // --- CLIENT ---
        Client clientDefault = new Client();  // default

        Client clientParam = new Client(      // cu toti parametrii
                "Ionescu Ana",
                "ana.ionescu@mail.com",
                "0700000000",
                120,
                true
        );

        Client clientCopy = new Client(clientParam); // copiere

        System.out.println("\n=== Clienti (3 instante) ===");
        System.out.println(clientDefault);
        System.out.println(clientParam);
        System.out.println(clientCopy);

        // --- CAFENEA ---
        Cafenea cafDefault = new Cafenea();   // default

        Cafenea cafParam = new Cafenea(       // cu toti parametrii
                "Coffee Corner",
                "Centru",
                4.5,
                40,
                true,
                LocalTime.of(8, 0),
                LocalTime.of(22, 0)
        );

        Cafenea cafCopy = new Cafenea(cafParam); // copiere

        System.out.println("\n=== Cafenele (3 instante) ===");
        System.out.println(cafDefault);
        System.out.println(cafParam);
        System.out.println(cafCopy);


        // ====================================
        // 2. Vectori cu cel putin 10 instante
        // ====================================

        // --- vector Angajat ---
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

        // --- vector Client ---
        Client[] clienti = new Client[10];

        for (int i = 0; i < clienti.length; i++) {
            clienti[i] = new Client(
                    "Client" + i,
                    "client" + i + "@mail.com",
                    "07" + i + (i + 1) + (i + 2) + (i + 3) + (i + 4) + (i + 5),
                    i * 10,
                    i % 2 == 0   // true pentru index par
            );
        }

        // --- vector Cafenea ---
        Cafenea[] cafenele = new Cafenea[10];

        for (int i = 0; i < cafenele.length; i++) {
            cafenele[i] = new Cafenea(
                    "Cafenea " + i,
                    "Zona " + i,
                    3.5 + (i % 3) * 0.3,
                    20 + i * 5,
                    i % 2 == 0,                 // terasa doar la index par
                    LocalTime.of(7 + (i % 3), 0),
                    LocalTime.of(21, 0)
            );
        }

        // ==================
        // 3. Afisare vectori
        // ==================

        System.out.println("\n=== VECTOR ANGAJATI (10) ===");
        for (Angajat a : angajati) {
            System.out.println(a);
        }

        System.out.println("\n=== VECTOR CLIENTI (10) ===");
        for (Client c : clienti) {
            System.out.println(c);
        }

        System.out.println("\n=== VECTOR CAFENELE (10) ===");
        for (Cafenea cf : cafenele) {
            System.out.println(cf);
        }
    }
}
