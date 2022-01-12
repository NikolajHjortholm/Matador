import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GuiController gui = new GuiController();
        gui.initializeGui();
        gui.readFile();

        Board b = new Board();
        b.initializeGame();


    }

}
