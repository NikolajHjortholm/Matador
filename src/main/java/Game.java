import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Game {
    static GUI gui;
    Dice dice = new Dice();
    int currentPlayer;

    public Game() {
        Square.Square();
        gui = new GUI();
    }


    public void MainLoop() {

        // Get player for the game
        Player.Player();

        // First player starts to roll dices
        currentPlayer = 0;

        // Enter main loop for the game
        while(true){
            gui.getUserButtonPressed("Roll dice: ","Roll");

            //rotation virker ikke.
            dice.roll();
            gui.setDice(dice.getDie1(),135, dice.getDie2(), 135);
            int dices = dice.getTotal();

            GUI_Field field  = Player.players[currentPlayer].getCar().getPosition();
            int fieldIndex = 0;
            for (int i = 0; i < gui.getFields().length; i++) {
                if (gui.getFields()[i] == field) {
                    fieldIndex = i;

                }
            }

            Player.players[currentPlayer].getCar().setPosition(gui.getFields()[(fieldIndex + dices)%gui.getFields().length]);
            //String button = gui.getUserButtonPressed("Choose player to move: ");
            currentPlayer++;
            if (currentPlayer == Player.players.length) {
                currentPlayer = 0;
            }

        }

    }

    public GUI getGui() {
        return gui;


    }
}
