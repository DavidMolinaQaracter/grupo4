package ui;

import javax.swing.*;
import java.awt.*;
import core.Quiz;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Trivia Quiz");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("TRIVIA QUIZ", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.CENTER);

        JButton jugarBtn = new JButton("Jugar");
        jugarBtn.addActionListener(e -> {
            new QuizWindow(new Quiz());
            dispose();
        });

        add(jugarBtn, BorderLayout.SOUTH);
        setVisible(true);
    }
}
