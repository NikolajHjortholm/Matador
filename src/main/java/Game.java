import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Game {
    static GUI gui;
    Dice dice = new Dice();
    public Game() {


        Square.Square();
        gui = new GUI();
        Player.Player();


        gui.getUserButtonPressed("Roll dice: ","Roll");

        //rotation virker ikke.
        gui.setDice(dice.getDie1(),135, dice.getDie2(), 135);

        for (int i=0; i<=39; i++){


        }

        while(true){
            String button = gui.getUserButtonPressed("Choose player to move: ");

        }






    }

    public GUI getGui() {
        return gui;


    }
}
