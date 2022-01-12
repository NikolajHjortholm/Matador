package squares;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Square {



    public void landOnSquare (int currentPosition) throws IOException {

        String path = "src/main/java/files/fields.csv";

        //Reads what type of square the player has landed on
        String reader = Files.readAllLines(Paths.get(path)).get(currentPosition+1);
        String[] value = reader.split(",");

        //If player lands on street
        if (value[2].equals(" street")){
            System.out.println("Price:" + value[3] + " House price:" + value[4] + " Rent 0:" + value[5] + " Rent 1:" + value[6] + " Rent 2:" + value[7] +" Rent 3:" + value[8] +" Rent 4:" + value[9] +" Rent 5:" + value[10]);

        }
        //If player lands on chance
        if (value[2].equals(" chance")){
            System.out.println("You landed on chance");
        }
        //if player lands on tax
        if (value[2].equals(" tax")){
            System.out.println("You landed on tax");
        }
        if (value[2].equals(" ferry")){
            System.out.println("You landed on ferry");
        }
        if (value[2].equals(" jail")){
            System.out.println("You landed on jail");
        }
        if (value[2].equals(" brewery")){
            System.out.println("You landed on brewery");
        }
        if (value[2].equals(" refugee")){
            System.out.println("You landed on refugee");
        }


    }


    public static void Square() {
        /** GUI_Field[] fields = {
                new GUI_Start(),
                new GUI_Street(),
                new GUI_Chance(),
                new GUI_Street(),
                new GUI_Tax(),
                new GUI_Shipping(),
                new GUI_Street(),
                new GUI_Chance(),
                new GUI_Street(),
                new GUI_Street(),
                new GUI_Jail(),
                new GUI_Street(),
                new GUI_Brewery(),
                new GUI_Street(),
                new GUI_Street(),
                new GUI_Shipping(),
                new GUI_Street(),
                new GUI_Chance(),
                new GUI_Street(),
                new GUI_Street(),
                new GUI_Refuge(),
                new GUI_Street(),
                new GUI_Chance(),
                new GUI_Street(),
                new GUI_Street(),
                new GUI_Shipping(),
                new GUI_Street(),
                new GUI_Street(),
                new GUI_Brewery(),
                new GUI_Street(),
                new GUI_Jail(),
                new GUI_Street(),
                new GUI_Street(),
                new GUI_Chance(),
                new GUI_Street(),
                new GUI_Shipping(),
                new GUI_Chance(),
                new GUI_Street(),
                new GUI_Tax(),
                new GUI_Street(),


        };
**/

    }
}
