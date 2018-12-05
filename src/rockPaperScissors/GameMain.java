package rockPaperScissors;

/**
 * Contains the main method to run the game.
 *
 * @author Alex Kelly
 */
public class GameMain {

    /**
     * MAIN METHOD
     */
    public static void main(String[] args) {
        GameView view = new GameView();
        GameModel model = new GameModel();
        GameController controller = new GameController(model, view);

    }
}
