package rockPaperScissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Creates the Swing GUI for the game.
 *
 * @author Alex Kelly
 */
public class GameView extends JFrame {

    //all the below labels will be updated following each round:
    private JLabel compChoice; //contains computers choice
    private JLabel whoWon; //states who won
    private JLabel gamesPlayed; //"games played:"
    private JLabel gamesPlayedText; //directly after above label, states number of games played
    private JLabel userScore; //"users score:"
    private JLabel userScoreText; //directly after above label, states users score
    private JLabel compScore; //"comp score:"
    private JLabel compScoreText; //directly after above label, states computers score
    private JLabel drawn; //"draws:"
    private JLabel drawnText; //directly after above label, states how many games drawn

    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JButton resetButton;
    private JButton quitButton;

    /**
     * CONSTRUCTOR
     */
    public GameView() {
        JFrame frame = new JFrame("Rock, Paper, Scissors!");
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(350, 250);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1,1,1,1); //distance from edges
        gbc.weightx = 0.5; //remains constant
        gbc.fill = GridBagConstraints.HORIZONTAL; //remains constant

        /* Layout starting from top left, working across and down.. */

        whoWon = new JLabel("No games played yet..");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.PAGE_START;
        panel.add(whoWon, gbc);

        compChoice = new JLabel("-----------------");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        panel.add(compChoice, gbc);

        gamesPlayed = new JLabel("Games played:");
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(gamesPlayed, gbc);

        gamesPlayedText = new JLabel("0");
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(gamesPlayedText, gbc);

        userScore = new JLabel("Your score:");
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(userScore, gbc);

        userScoreText = new JLabel("0");
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(userScoreText, gbc);

        compScore = new JLabel("Comp score:");
        gbc.gridx = 2;
        gbc.gridy = 5;
        panel.add(compScore, gbc);

        compScoreText = new JLabel("0");
        gbc.gridx = 3;
        gbc.gridy = 5;
        panel.add(compScoreText, gbc);

        drawn = new JLabel("Drawn:");
        gbc.gridx = 2;
        gbc.gridy = 6;
        panel.add(drawn, gbc);

        drawnText = new JLabel("0");
        gbc.gridx = 3;
        gbc.gridy = 6;
        panel.add(drawnText, gbc);

        rockButton = new JButton("Rock");
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(rockButton, gbc);

        paperButton = new JButton("Paper");
        gbc.gridx = 2;
        gbc.gridy = 7;
        panel.add(paperButton, gbc);

        scissorsButton = new JButton("Scissors");
        gbc.gridx = 3;
        gbc.gridy = 7;
        panel.add(scissorsButton, gbc);

        resetButton = new JButton("Reset Scores");
        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(resetButton, gbc);

        quitButton = new JButton("Quit Game");
        gbc.gridx = 2;
        gbc.gridy = 8;
        panel.add(quitButton, gbc);

        frame.getContentPane().add(panel);
    }

    /**
     * Add the action listeners to the buttons ->
     * to be handled in the Controller class
     *
     * @param listener
     */
    public void addListeners(ActionListener listener) {
        rockButton.addActionListener(listener);
        paperButton.addActionListener(listener);
        scissorsButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        quitButton.addActionListener(listener);
    }

    /*
     * Getters for all buttons and labels so ActionListeners can
     * be added in Controller class
     */

    public JButton getRockButton() {
        return rockButton;
    }

    public JButton getPaperButton() {
        return paperButton;
    }

    public JButton getScissorsButton() {
        return scissorsButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    /*
    * Setters for labels so they can be updated by controller
    * according to their values in the model
    */

    public void setWhoWon(String text) {
        whoWon.setText(text);
    }

    public void setCompChoice(String text) {
        compChoice.setText(text);
    }

    public void setGamesPlayedText(String text) {
        gamesPlayedText.setText(text);
    }

    public void setUserScoreText(String text) {
        userScoreText.setText(text);
    }

    public void setCompScoreText(String text) {
        compScoreText.setText(text);
    }

    public void setDrawnText(String text) {
        drawnText.setText(text);
    }
}
