import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        GuiController gui = new GuiController();
        gui.initializeGui();

        Board b = new Board();
        b.initializeGame();


    }

}
