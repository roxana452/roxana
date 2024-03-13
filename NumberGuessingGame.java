package numbers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame {
    private JFrame frame;
    private JTextField guessField;
    private JLabel infoLabel;
    private JButton guessButton, newGameButton;
    private int targetNumber;
    private int attemptsLeft;
    private final int minRange = 1;
    private final int maxRange = 100;
    private final int maxAttempts = 5;

    public NumberGuessingGame() {
        frame = new JFrame("Number Guessing Game");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        newGameButton = new JButton("New Game");
        infoLabel = new JLabel("Enter a number between " + minRange + " and " + maxRange);
        attemptsLeft = maxAttempts;

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeGuess();
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        frame.add(guessField);
        frame.add(guessButton);
        frame.add(newGameButton);
        frame.add(infoLabel);

        frame.pack();
        frame.setVisible(true);

        startNewGame();
    }

    private void startNewGame() {
        targetNumber = generateRandomNumber(minRange, maxRange);
        attemptsLeft = maxAttempts;
        infoLabel.setText("Enter a number between " + minRange + " and " + maxRange);
        guessField.setText("");
    }

    private void makeGuess() {
        try {
            int guessedNumber = Integer.parseInt(guessField.getText());
            if (guessedNumber < minRange || guessedNumber > maxRange) {
                JOptionPane.showMessageDialog(frame, "Please enter a number between " + minRange + " and " + maxRange);
                return;
            }

            attemptsLeft--;
            if (guessedNumber == targetNumber) {
                JOptionPane.showMessageDialog(frame, "Congratulations! You've guessed the number.");
                startNewGame();
            } else {
                if (attemptsLeft == 0) {
                    JOptionPane.showMessageDialog(frame, "Out of attempts. The number was: " + targetNumber + "\nGood luck next time!");
                    startNewGame();
                } else {
                    if (guessedNumber < targetNumber) {
                        infoLabel.setText("Too low. Guess higher. Attempts left: " + attemptsLeft);
                    } else {
                        infoLabel.setText("Too high. Guess lower. Attempts left: " + attemptsLeft);
                    }
                    guessField.setText("");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
        }
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGame();
            }
        });
    }
}
