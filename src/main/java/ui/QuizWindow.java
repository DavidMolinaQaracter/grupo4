package ui;

import javax.swing.*;
import java.awt.*;
import core.*;

public class QuizWindow extends JFrame {
    private Quiz quiz;
    private JLabel preguntaLabel;
    private JButton[] botones;

    public QuizWindow(Quiz quiz) {
        this.quiz = quiz;

        setTitle("Juego - Trivia Quiz");
        setSize(500, 300);
        setLayout(new GridLayout(5, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        preguntaLabel = new JLabel("", SwingConstants.CENTER);
        add(preguntaLabel);

        botones = new JButton[4];
        for (int i = 0; i < 4; i++) {
            botones[i] = new JButton();
            add(botones[i]);
            int index = i;
            botones[i].addActionListener(e -> responder(index));
        }

        mostrarPregunta();
        setVisible(true);
    }

    private void mostrarPregunta() {
        Question q = quiz.getPreguntaActual();

        if (q == null) return;

        preguntaLabel.setText("<html><center>" + q.getEnunciado() + "</center></html>");
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

