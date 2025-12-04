package ui;

import javax.swing.*;
import java.awt.*;
import core.*;

public class ResultsWindow extends JFrame {

    public ResultsWindow(Quiz quiz) {
        setTitle("Resultados");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel puntaje = new JLabel(
                "Tu Puntaje: " + quiz.getPuntaje() + "/" + quiz.getTotalPreguntas(),
                SwingConstants.CENTER
        );
        puntaje.setFont(new Font("Arial", Font.BOLD, 20));
        add(puntaje, BorderLayout.NORTH);

        JTextArea detalles = new JTextArea();
        detalles.setEditable(false);

        for (GameResult r : quiz.getResultados()) {
            detalles.append(r.getPregunta() + "\n");
            detalles.append("Correcta: " + r.getRespuestaCorrecta() + "\n");
            detalles.append("Acertada: " + (r.isFueCorrecta() ? "SI" : "NO") + "\n\n");
        }

        add(new JScrollPane(detalles), BorderLayout.CENTER);

        JButton volver = new JButton("Volver al menu");
        volver.addActionListener(e -> {
            new MainMenu();
            dispose();
        });

        add(volver, BorderLayout.SOUTH);

        setVisible(true);
    }
}
