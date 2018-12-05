package rockPaperScissors;

/**
 * Implementation of the model for the rock, paper
 * scissors game which contains the data.
 *
 * @author Alex Kelly
 */
public class GameModel {

    private int gamesPlayed, drawn, userWon, userLost, compWon, compLost;

    /**
     * CONSTRUCTOR
     */
    public GameModel() {
        gamesPlayed = 0;
        drawn = 0;

        userWon = 0;
        userLost = 0;

        compWon = 0;
        compLost = 0;
    }

    /* Methods to set the user and computer score depending on who
     * won the round
     */

    /**
     * update scores for a tie.
     */
    public void updateScoresDraw() {
        drawn += 1;
        gamesPlayed += 1;
    }

    /**
     * update scores for a user win (and computer loss).
     */
    public void updateScoresUserWin() {
        userWon += 1;
        compLost += 1;
        gamesPlayed += 1;
    }

    /**
     * update scores for a user loss (and computer win).
     */
    public void updateScoresUserLost() {
        userLost += 1;
        compWon += 1;
        gamesPlayed += 1;
    }

    /* Getters for updating the view via the controller */

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getDrawn() {
        return drawn;
    }


    public int getUserWon() {
        return userWon;
    }

    public int getUserLost() {
        return userLost;
    }

    public int getCompWon() {
        return compWon;
    }

    public int getCompLost() {
        return compLost;
    }

    /* Setters used by controller when resetting scores */

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setDrawn(int drawn) {
        this.drawn = drawn;
    }

    public void setUserWon(int userWon) {
        this.userWon = userWon;
    }

    public void setUserLost(int userLost) {
        this.userLost = userLost;
    }

    public void setCompWon(int compWon) {
        this.compWon = compWon;
    }

    public void setCompLost(int compLost) {
        this.compLost = compLost;
    }
}
