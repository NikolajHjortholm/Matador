package squares;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Square {

    Property[] properties = new Property[40];
    Boolean[] landedOn = new Boolean[40];
    String path = "src/main/java/files/fields.csv";

    int rName=0, rPosition=1, rType=2, rPrice=3, rHousePrice=4, rRent0=5, rRent1=6, rRent2=7, rRent3=8, rRent4=9, rRent5=10;

    public Square() {

        for (int i = 0; i < 40; i++) {
            landedOn[i] = false;
        }
    }

    public <Player> void landOnSquare (int currentPosition, Player currentPlayer) throws IOException {



        //If player lands on street
        if (reader(currentPosition, rType).equals(" street")){


            int tempPosition = Integer.parseInt((reader(currentPosition, 1)));

            //initiates square landed on
            if (!landedOn[tempPosition]) {

                landedOn[tempPosition] = true;

                properties[tempPosition] = new Property();
                properties[tempPosition].position=tempPosition;
                System.out.println("Nice");
            }

            //goes to property
            properties[tempPosition].landOnProperty(currentPosition, currentPlayer);




        }
        //If player lands on chance
        if ((reader(currentPosition, rType).equals(" chance"))){
            System.out.println("You landed on chance");
        }
        //if player lands on tax
        if ((reader(currentPosition, rType).equals(" tax"))){
            System.out.println("You landed on tax");
        }
        if ((reader(currentPosition, rType).equals(" ferry"))){
            System.out.println("You landed on ferry");
        }
        if ((reader(currentPosition, rType).equals(" jail"))){
            System.out.println("You landed on jail");
        }
        if ((reader(currentPosition, rType).equals(" brewery"))){
            System.out.println("You landed on brewery");
        }
        if ((reader(currentPosition, rType).equals(" refugee"))){
            System.out.println("You landed on refugee");
        }


    }

    public String reader(int currentPosition, int line) throws IOException {

        String reader = Files.readAllLines(Paths.get(path)).get(currentPosition+1);
        String[] value = reader.split(",");

        return value[line];
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
