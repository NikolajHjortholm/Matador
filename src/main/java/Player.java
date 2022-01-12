import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

import java.util.Arrays;

public class Player {


    public static int playerCount = 0;
    public static GUI_Player[] players;

    public static void Player() {

        playerCount = Game.gui.getUserInteger("Enter player amount",2,6);
        players = new GUI_Player[playerCount];

        int balance = 30000;

        String input = null;
        GUI_Player player = null;

        for (int i =0; i<playerCount; i++) {

            input = Game.gui.getUserString("Enter names: ");
            player = new GUI_Player(input, balance);
            players[i] = player;
            Game.gui.addPlayer(player);
            GUI_Field field = Game.gui.getFields()[0];
            player.getCar().setPosition(field);
            System.out.println(players[i]);
        }
    }

    public static void currentPlayer() {



    }
}
