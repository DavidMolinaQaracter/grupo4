import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class App {

    // Method to read a single question and its data from the file
    public static String[] readQuestionData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        
        // Read question, correct answer index, and options
        String question = reader.readLine();
        int correctAnswerIndex = Integer.parseInt(reader.readLine()) - 1; // 1-based to 0-based index
        String[] options = new String[4];
        
        // Read the options
        for (int i = 0; i < 4; i++) {
            options[i] = reader.readLine();
        }
        
        reader.close();
        
        // Return the question, options, and correct answer index
        return new String[]{question, Integer.toString(correctAnswerIndex), options[0], options[1], options[2], options[3]};
    }

    // Method to create the UI for the question and options
    public static void createAndShowUI(String[] questionData) {
        String question = questionData[0];
        int correctAnswerIndex = Integer.parseInt(questionData[1]);
        String[] options = {questionData[2], questionData[3], questionData[4], questionData[5]};

        // Create the frame
        JFrame frame = new JFrame("Simple Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel for the question and options
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add the question to the panel
        JLabel questionLabel = new JLabel(question);
        panel.add(questionLabel);

        // Create radio buttons for the options
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton[] radioButtons = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            radioButtons[i] = new JRadioButton(options[i]);
            buttonGroup.add(radioButtons[i]);
            panel.add(radioButtons[i]);
        }

        // Add a submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check the answer and display the result
                boolean isCorrect = false;
                for (int i = 0; i < 4; i++) {
                    if (radioButtons[i].isSelected()) {
                        if (i == correctAnswerIndex) {
                            isCorrect = true;
                        }
                        break;
                    }
                }

                // Show the result in a dialog
                String message = isCorrect ? "Correct!" : "Incorrect. Try again!";
                JOptionPane.showMessageDialog(frame, message);
            }
        });

        // Add the submit button to the panel
        panel.add(submitButton);

        // Add the panel to the frame and make it visible
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            // Define the file path
            String filePath = "main/java/data/data.txt";

            // Read the question data from the file
            String[] questionData = readQuestionData(filePath);

            // Create and show the UI with the question data
            createAndShowUI(questionData);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading the question data file.");
        }
    }
}
