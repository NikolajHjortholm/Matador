import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

import java.util.Arrays;

public class Player {



    public static void Player() {
        Dice dices = new Dice();
        int numberInput;
        numberInput = Game.gui.getUserInteger("Enter player amount",2,6);
        int balance =30000 / numberInput;


        String input = null;
        boolean[] array = new boolean[6];
        GUI_Player player = null;

        for (int i =0; i<numberInput; i++) {

            input = Game.gui.getUserString("Enter names: ");
            player = new GUI_Player(input, balance);
            array[i] = Game.gui.addPlayer(player);
        }
        for (boolean i = array[0]; i <=array[6]; i++) {


        }

        for (int i =0; i<=39; i++) {
            GUI_Field field = Game.gui.getFields()[0];
            player.getCar().setPosition(field);


        }

    }

    public static void currentPlayer() {



    }
}
