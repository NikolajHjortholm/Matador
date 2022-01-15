public class Chance extends Square {

    public void handlePlayer(Game game) {
        game.gui.showMessage(" You landed on "+name);
    }

}
