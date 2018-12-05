package rockPaperScissors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implementation of the controller for the rock, paper,
 * scissors game which listens for button clicks from
 * the view, and performs model updates.
 *
 * @author Alex Kelly
 */
public class GameController /*implements ActionListener*/ {

    private GameModel model;
    private GameView view;

    /**
     * CONSTRUCTOR
     *
     * @param model model object
     * @param view view object
     */
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

//        addListeners();
        this.view.addListeners(new ButtonListeners());
    }

    /**
     * Inner class which handles events.
     */
    class ButtonListeners implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("rock")) {
                compareChoices("rock");
            }

            else if (e.getActionCommand().equalsIgnoreCase("paper")) {
                compareChoices("paper");
            }

            else if (e.getActionCommand().equalsIgnoreCase("scissors")) {
                compareChoices("scissors");
            }

            else if (e.getActionCommand().equalsIgnoreCase("reset scores")) {
                resetGame();
            }

            else if (e.getActionCommand().equalsIgnoreCase("quit game")) {
                quitGame();
            }
        }
    }

//    /**
//     * Adds listeners to buttons in the view, and the event
//     * triggered by each of them being the source.
//     */
//    private void addListeners() {
//        view.getRockButton().addActionListener(e -> compareChoices("rock"));
//        view.getPaperButton().addActionListener(e -> compareChoices("paper"));
//        view.getScissorsButton().addActionListener(e -> compareChoices("scissors"));
//        view.getResetButton().addActionListener(e -> resetGame());
//        view.getQuitButton().addActionListener(e -> quitGame());
//    }

    /**
     * Method for randomly selecting the computers choice from
     * a list containing the three options.
     *
     * @return String value of the computers choice, either:
     *          rock, paper, or scissors
     */
    private String compChoice() {
        List<String> choices = new ArrayList<>();
        choices.add("rock");
        choices.add("paper");
        choices.add("scissors");

        return choices.get(new Random().nextInt(choices.size()));
    }

    /**
     * Compares the users choice with the random selection by
     * the computer, determines the correct outcome, and
     * updates the scores accordingly.
     *
     * @param user users choice
//     * @param comp computers choice
     */
    private void compareChoices(String user) {

        String comp = compChoice();

        //tie:
        if (user.equalsIgnoreCase(comp)) {
            model.updateScoresDraw();

            view.setWhoWon("it was a tie!");
            view.setCompChoice("computer chose " + comp);

            view.setDrawnText(String.valueOf(model.getDrawn()));
            view.setGamesPlayedText(String.valueOf(model.getGamesPlayed()));
        }

        //user win:
        else if (user.equalsIgnoreCase("rock") && comp.equalsIgnoreCase("scissors")
                || user.equalsIgnoreCase("scissors") && comp.equalsIgnoreCase("paper")
                || user.equalsIgnoreCase("paper") && comp.equalsIgnoreCase("rock")) {

            model.updateScoresUserWin();

            view.setWhoWon("you won!");
            view.setCompChoice("computer chose " + comp);

            view.setUserScoreText(String.valueOf(model.getUserWon()));
            view.setGamesPlayedText(String.valueOf(model.getGamesPlayed()));
        }

        //computer win:
        else if (comp.equalsIgnoreCase("rock") && user.equalsIgnoreCase("scissors")
                || comp.equalsIgnoreCase("scissors") && user.equalsIgnoreCase("paper")
                || comp.equalsIgnoreCase("paper") && user.equalsIgnoreCase("rock")) {

            model.updateScoresUserLost();

            view.setWhoWon("you lost!");
            view.setCompChoice("computer chose " + comp);

            view.setCompScoreText(String.valueOf(model.getCompWon()));
            view.setGamesPlayedText(String.valueOf(model.getGamesPlayed()));
        }
    }

    /**
     * Reset the scores and games played to zero.
     */
    public void resetGame() {
        model.setGamesPlayed(0);
        model.setUserWon(0);
        model.setUserLost(0);
        model.setDrawn(0);
        model.setCompWon(0);
        model.setCompLost(0);

        view.setUserScoreText(String.valueOf(model.getUserWon()));
        view.setCompScoreText(String.valueOf(model.getCompWon()));
        view.setDrawnText(String.valueOf(model.getDrawn()));
        view.setGamesPlayedText(String.valueOf(model.getGamesPlayed()));
    }

    /**
     * Exit the game.
     */
    private void quitGame() {
        System.exit(0);
    }

}
