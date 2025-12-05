package ui;

import core.*;
import java.awt.*;
import javax.swing.*;

public class QuizWindow extends JFrame {
    private Quiz quiz;
    private JLabel preguntaLabel;
    private JButton[] botones;

    public QuizWindow(Quiz quiz) {
        this.quiz = quiz;

        setTitle("Trivia Quiz");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        // ---------- SECCIÓN PREGUNTA ----------
        preguntaLabel = new JLabel("", SwingConstants.CENTER);
        preguntaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        preguntaLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(preguntaLabel, BorderLayout.NORTH);

        // ---------- PANEL DE BOTONES (2x2) ----------
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 15, 15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelBotones.setBackground(Color.WHITE);

        botones = new JButton[4];

        // colores estilo "Kahoot"
        Color[] kahootColors = {
            new Color(219, 68, 55),   // Rojo
            new Color(66, 133, 244),  // Azul
            new Color(244, 160, 0),   // Amarillo/Naranja
            new Color(15, 157, 88)    // Verde
        };

        for (int i = 0; i < 4; i++) {
            botones[i] = new JButton();
            botones[i].setFont(new Font("Arial", Font.BOLD, 18));
            botones[i].setForeground(Color.WHITE);
            botones[i].setBackground(kahootColors[i]);
            botones[i].setFocusPainted(false);
            botones[i].setOpaque(true);
            botones[i].setBorderPainted(false);

            int index = i;
            botones[i].addActionListener(e -> responder(index));
            panelBotones.add(botones[i]);
        }

        add(panelBotones, BorderLayout.CENTER);

        mostrarPregunta();
        setVisible(true);
    }

    private void mostrarPregunta() {
        Question q = quiz.getPreguntaActual();
        if (q == null) return;

        // Mostrar pregunta
        preguntaLabel.setText("<html><center>" + q.getEnunciado() + "</center></html>");

        // Mostrar opciones
        String[] opciones = q.getOpciones();
        for (int i = 0; i < 4; i++) {
            botones[i].setText(opciones[i]);
        }
    }

    private void responder(int indice) {
        quiz.responder(indice);

        if (quiz.hayMasPreguntas()) {
            mostrarPregunta();
        } else {
            new ResultsWindow(quiz);
            dispose();
        }
    }
}
