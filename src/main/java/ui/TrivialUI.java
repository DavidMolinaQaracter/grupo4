import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class TrivialUI {

    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton option1, option2, option3, option4;
    private ButtonGroup group;
    private JButton sendButton, nextButton;

    public TrivialUI() {
        createUI();
    }

    private void createUI() {
        frame = new JFrame("GitHubTrivial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Pregunta
        questionLabel = new JLabel("Here is the Question", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(questionLabel, BorderLayout.NORTH);

        // Panel de respuestas
        JPanel answersPanel = new JPanel();
        answersPanel.setLayout(new GridLayout(4, 1));

        option1 = new JRadioButton("Option 1");
        option2 = new JRadioButton("Option 2");
        option3 = new JRadioButton("Option 3");
        option4 = new JRadioButton("Option 4");

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        answersPanel.add(option1);
        answersPanel.add(option2);
        answersPanel.add(option3);
        answersPanel.add(option4);

        frame.add(answersPanel, BorderLayout.CENTER);

        // Panel de botones inferiores
        JPanel buttonPanel = new JPanel();

        sendButton = new JButton("Answer");
        nextButton = new JButton("Next");

        buttonPanel.add(sendButton);
        buttonPanel.add(nextButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TrivialUI();
    }
}


