package ui;

import core.*;
import java.awt.*;
import javax.swing.*;

public class ResultsWindow extends JFrame {

    public ResultsWindow(Quiz quiz) {
        setTitle("Quiz Results");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        // ---------- PANEL SUPERIOR ----------
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.WHITE);

        // Título principal
        JLabel titleLabel = new JLabel("Quiz Results", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        topPanel.add(titleLabel);

        // Línea de puntuación
        int score = quiz.getPuntaje();
        int totalQuestions = quiz.getTotalPreguntas();
        JLabel scoreLabel = new JLabel("Score: " + score + " / " + totalQuestions, SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        topPanel.add(scoreLabel);

        // Mensaje de resultado
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        if (score < 4) {
            messageLabel.setText("You failed. Try again!");
            messageLabel.setForeground(Color.RED);
        } else if (score >= 5 && score <= 9) {
            messageLabel.setText("You passed!");
            messageLabel.setForeground(new Color(0, 128, 0)); // green
        } else if (score == 10) {
            messageLabel.setText("Excellent! Perfect score!");
            messageLabel.setForeground(new Color(255, 215, 0)); // gold
        }

        topPanel.add(messageLabel);
        add(topPanel, BorderLayout.NORTH);

        // ---------- PANEL DETALLES ----------
        JTextArea detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 16));
        detailsArea.setMargin(new Insets(10, 10, 10, 10));

        for (GameResult r : quiz.getResultados()) {
            detailsArea.append("Question: " + r.getPregunta() + "\n");
            detailsArea.append("Correct Answer: " + r.getRespuestaCorrecta() + "\n");
            detailsArea.append("Your Answer: " + (r.isFueCorrecta() ? "Correct" : "Incorrect") + "\n\n");
        }

        JScrollPane scroll = new JScrollPane(detailsArea);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));
        scroll.getViewport().setBackground(Color.WHITE);
        add(scroll, BorderLayout.CENTER);

        // ---------- PANEL INFERIOR ----------
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        // Botón volver al menú
        JButton retryButton = new JButton("Retry Quiz");
        retryButton.setFont(new Font("Arial", Font.BOLD, 20));
        retryButton.setForeground(Color.WHITE);
        retryButton.setBackground(new Color(15, 157, 88));
        retryButton.setOpaque(true);
        retryButton.setBorderPainted(false);
        retryButton.setFocusPainted(false);
        retryButton.setPreferredSize(new Dimension(200, 60));
        retryButton.addActionListener(e -> {
            new MainMenu();
            dispose();
        });
        bottomPanel.add(retryButton);

        // Botón reiniciar test
        JButton closeButton = new JButton("Close Quiz");
        closeButton.setFont(new Font("Arial", Font.BOLD, 20));
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(new Color(220, 60, 60)); // rojo
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(200, 60));
        closeButton.addActionListener(e -> {
            dispose();
        });
        bottomPanel.add(Box.createHorizontalStrut(20)); // separación entre botones
        bottomPanel.add(closeButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
