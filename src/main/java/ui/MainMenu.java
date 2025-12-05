package ui;

import core.Quiz;
import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Trivia Quiz");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // ---------- TTULO ----------
        JLabel titulo = new JLabel("TRIVIA QUIZ", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
        add(titulo, BorderLayout.NORTH);

        // ---------- BOTÓN JUGAR ----------
        JButton jugarBtn = new JButton("PLAY");
        jugarBtn.setFont(new Font("Arial", Font.BOLD, 22));
        jugarBtn.setForeground(Color.WHITE);
        jugarBtn.setBackground(new Color(66, 133, 244)); // Azul tipo Kahoot
        jugarBtn.setOpaque(true);
        jugarBtn.setBorderPainted(false);
        jugarBtn.setFocusPainted(false);
        jugarBtn.setPreferredSize(new Dimension(200, 70));

        // Panel para centrar el botón
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(Color.WHITE);
        panelCentro.add(jugarBtn);

        add(panelCentro, BorderLayout.CENTER);

        // Acción del botón
        jugarBtn.addActionListener(e -> {
            new QuizWindow(new Quiz());
            dispose();
        });

        setVisible(true);
    }
}
