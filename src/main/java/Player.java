import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Player {





    public static void Player() {

        int numberInput;

        numberInput = Game.gui.getUserInteger("Enter player amount",2,6);
        int balance =30000 / numberInput;

        for (int i =0; i<numberInput; i++) {
            GUI_Player player = new GUI_Player(Game.gui.getUserString("Enter names"),balance);
            Game.gui.addPlayer(player);

        }


    }
    public static void Car() {
        GUI_Car car = new GUI_Car();


    }
}
