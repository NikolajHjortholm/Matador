import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

import java.util.Arrays;

public class Player {
    int balance, currentPosition, playerNumber, any;
    String name;
    Boolean imprisoned, ownsGroup;

    Boolean[] owns = new Boolean[40];

    public Player (String name, int balance) {
        this.balance = balance;
        currentPosition = 0;
        this.name = name;
        imprisoned = false;
        ownsGroup = false;

        for (int i=0; i<40; i++){
            owns[i]=false;
        }

    }

    public static void currentPlayer() {

    }

    // Updates player position on gui
    public static void updatePlayerGuiPosition(Game game){

        game.players[game.currentPlayer].getCar().setPosition(game.gui.getFields()[game.aPlayers[game.currentPlayer].currentPosition]);

    }

}
