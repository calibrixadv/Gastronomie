
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // --- ANGAJAȚI ---
        Angajat angDefault = new Angajat();
        Angajat angFull = new Angajat(
                "Ana Pop", "ana@example.com", "0711222333",
                "Barista", 3500.0, LocalDate.of(2024, 9, 1)
        );
        Angajat angCopy = new Angajat(angFull);
        printSection("ANGAJATI", angDefault, angFull, angCopy);

        // --- CLIENȚI ---
        Client cliDefault = new Client();
        Client cliFull = new Client(
                "Mihai Ionescu", "mihai@example.com", "0722333444",
                120, true
        );
        Client cliCopy = new Client(cliFull);
        printSection("CLIENTI", cliDefault, cliFull, cliCopy);

        // --- CAFENELE ---
        Cafenea cafDefault = new Cafenea(); // denumire/locatie/rating din super() -> "Necunoscut"
        Cafenea cafFull = new Cafenea(
                "Café Noir", "Str. Exemplu 10", 4.6,
                45, true, LocalTime.of(8, 0), LocalTime.of(22, 0)
        );
        Cafenea cafCopy = new Cafenea(cafFull);
        printSection("CAFENELE", cafDefault, cafFull, cafCopy);
    }

    private static void printSection(String title, Object... objs) {
        System.out.println("==== " + title + " ====");
        for (Object o : objs) {
            System.out.println(o);
        }
        System.out.println();
    }
}
