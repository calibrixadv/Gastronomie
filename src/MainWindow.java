import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

        public static void main(String[] args) {
            new MainWindow();
        }

        public MainWindow() {
            setTitle("Meniu Principal");
            setSize(300, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new GridLayout(3, 1, 10, 10));

            JButton btnB1 = new JButton("AAA");
            JButton btnB2 = new JButton("AB");
            JButton btnAI = new JButton("AI");

            add(btnB1);
            add(btnB2);
            add(btnAI);

            // ---------------- ASCULTATOR pentru AI -------------------
            btnAI.addActionListener(e -> {
                dispose();           // închide MainWindow
                new AI_GUI_App();        // deschide fereastra AI
            });

            setVisible(true);

        }

    }

