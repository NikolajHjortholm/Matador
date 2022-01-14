import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Square{

    Property[] properties = new Property[40];
    Boolean[] landedOn = new Boolean[40];
    String path = "src/main/java/files/fields.csv";

    int rName=0, rPosition=1, rType=2, rPrice=3, rHousePrice=4, rRent0=5, rRent1=6, rRent2=7, rRent3=8, rRent4=9, rRent5=10;


    public Square() {

        for (int i = 0; i < 40; i++) {
            landedOn[i] = false;
        }
    }


    public String reader(int currentPosition, int line) throws IOException {

        String reader = Files.readAllLines(Paths.get(path)).get(currentPosition+1);
        String[] value = reader.split(",");

        return value[line];

    }

    public int intreader(int currentPosition, int line) throws IOException {

        String reader = Files.readAllLines(Paths.get(path)).get(currentPosition+1);
        String[] value = reader.split(",");

        int rValue = Integer.parseInt(value[line]);
        return rValue;

    }


    public void landOnSquare (int currentPosition, Player currentPlayer) throws IOException {

    String type = reader(currentPosition, rType);

        //If player lands on street
        if ((type).equals(" street")){


            //initiates square landed on
            if (!landedOn[currentPosition]) {

                landedOn[currentPosition] = true;

                properties[currentPosition] = new Property(currentPosition);

            }

            //goes to property
            if (!properties[currentPosition].owned){

                currentPlayer.balance=currentPlayer.balance-properties[currentPosition].getPrice();

            }else if(!properties[currentPosition].mortgaged){

                currentPlayer.balance=currentPlayer.balance-properties[currentPosition].getRent();

            }



        }
        //If player lands on chance
        if ((type).equals(" chance")){
            System.out.println("You landed on chance");
        }
        //if player lands on tax
        if ((type).equals(" tax")){
            System.out.println("You landed on tax");
        }
        if ((type).equals(" ferry")){
            System.out.println("You landed on ferry");
        }
        if ((type).equals(" jail")){
            System.out.println("You landed on jail");
        }
        if ((type).equals(" brewery")){
            System.out.println("You landed on brewery");
        }
        if ((type).equals(" refugee")){
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
