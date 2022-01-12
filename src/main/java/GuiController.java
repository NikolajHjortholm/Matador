import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class GuiController {

    public static void readFile () throws IOException {

        String path = "src/main/java/files/fields.csv";

        int playerPosition = (int)Math.floor(Math.random()*(39-0+1)+0);

        //Reads what type of square the player has landed on
        String reader = Files.readAllLines(Paths.get(path)).get(playerPosition);
        String[] value = reader.split(",");;
        System.out.println(value[2]);

        //If player lands on street
        if (value[2].equals(" street")){
            System.out.println("Price:" + value[3] + " House price:" + value[4] + " Rent 0:" + value[5] + " Rent 1:" + value[6] + " Rent 2:" + value[7] +" Rent 3:" + value[8] +" Rent 4:" + value[9] +" Rent 5:" + value[10]);

            int Money = 30000;
            int change=Money-Integer.valueOf(value[3]);
            System.out.println(Integer.valueOf(value[3]));
            System.out.println();
            System.out.println(change);
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



    public void initializeGui (){

        GUI gui = new GUI();

        GUI_Player player = new GUI_Player("Mads", 2000);
        gui.addPlayer(player);
        player.setBalance(10000);

        GUI_Field field = gui.getFields()[0];

        player.getCar().setPosition(field);

        //Sets up every field on board
        field = gui.getFields()[0];
        //field.setTitle("My title");
        field.setSubText("");
        field.setDescription("Receive $2,000 when passing start");

        field = gui.getFields()[1];
        field.setTitle("Rødovrevej");
        field.setSubText("$1,200");
        field.setDescription
                ("Rent:     $50     \\n  " +
                        "1 house:  $250    \\n  " +
                        "2 houses: $750    \\n  " +
                        "3 houses: $2,250  \\n  " +
                        "4 houses: $4,000  \\n  " +
                        "Hotel:    $6,000  \\n  " +
                        "\\n" +
                        "Upgrade cost: $1,000" +
                        "Mortgage value: $600");

        field = gui.getFields()[2];
        //field.setTitle("My title");
        field.setSubText("Chance");
        field.setDescription("Receive a chance card");

        field = gui.getFields()[3];
        field.setTitle("Hvidovrevej");
        field.setSubText("$1,200");
        field.setDescription("Rent:     $50     \\n  " +
                "1 house:  $250    \\n  " +
                "2 houses: $750    \\n  " +
                "3 houses: $2,250  \\n  " +
                "4 houses: $4,000  \\n  " +
                "Hotel:    $6,000  \\n  " +
                "\\n" +
                "Upgrade cost: $1,000" +
                "Mortgage value: $600");

        field = gui.getFields()[4];
        field.setTitle("Pay income tax");
        field.setSubText("Pay 10%");
        field.setDescription("Pay 10% of your total money or $4,000 to the bank");

        field = gui.getFields()[5];
        field.setTitle("Øresund");
        field.setSubText("$4,000");
        field.setDescription("My description");

        field = gui.getFields()[6];
        field.setTitle("Roskildevej");
        field.setSubText("$2,000");
        field.setDescription("Rent:     $100     \\n  " +
                "1 house:  $600    \\n  " +
                "2 houses: $1,800    \\n  " +
                "3 houses: $5,400  \\n  " +
                "4 houses: $8,000  \\n  " +
                "Hotel:    $11,000  \\n  " +
                "\\n" +
                "Upgrade cost: $1,000" +
                "Mortgage value: $1,0$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$00");

        field = gui.getFields()[7];
        //field.setTitle("My title");
        field.setSubText("Chance");
        field.setDescription("Receive a chance card");

        field = gui.getFields()[8];
        field.setTitle("Valby Langgade");
        field.setSubText("$2,000");
        field.setDescription("My description");

        field = gui.getFields()[9];
        field.setTitle("Allégade");
        field.setSubText("$2,400");
        //field.setDescription("My description");

        field = gui.getFields()[10];
        //field.setTitle("My title");
        field.setSubText("Prison");
        field.setDescription("Visiting jail");

        field = gui.getFields()[11];
        field.setTitle("Frederiksberg Allé");
        field.setSubText("$2,800");
        field.setDescription("My description");

        field = gui.getFields()[12];
        field.setTitle("Tuborg");
        field.setSubText("$3,000");
        field.setDescription("My description");

        field = gui.getFields()[13];
        field.setTitle("Bülowsvej");
        field.setSubText("$2,800");
        field.setDescription("My description");

        field = gui.getFields()[14];
        field.setTitle("Gammel Kongevej");
        field.setSubText("$3,200");
        field.setDescription("My description");

        field = gui.getFields()[15];
        field.setTitle("D.F.D.S.");
        field.setSubText("$4,000");
        field.setDescription("My description");

        field = gui.getFields()[16];
        field.setTitle("Bernstorffsvej");
        field.setSubText("$3,600");
        field.setDescription("My description");

        field = gui.getFields()[17];
        //field.setTitle("My title");
        field.setSubText("Chance");
        field.setDescription("Receive a chance card");

        field = gui.getFields()[18];
        field.setTitle("Hellerupvej");
        field.setSubText("$3,600");
        field.setDescription("My description");

        field = gui.getFields()[19];
        field.setTitle("Strandvejen");
        field.setSubText("$4,000");
        field.setDescription("My description");

        field = gui.getFields()[20];
        //field.setTitle("My title");
        field.setSubText("Parking");
        field.setDescription("Receive the money paid to the bank from the tax fields");

        field = gui.getFields()[21];
        field.setTitle("Trianglen");
        field.setSubText("$4,000");
        field.setDescription("My description");

        field = gui.getFields()[22];
        //field.setTitle("My title");
        field.setSubText("Chance");
        field.setDescription("Receive a chance card");

        field = gui.getFields()[23];
        field.setTitle("Østerbrogade");
        field.setSubText("$4,000");
        field.setDescription("My description");

        field = gui.getFields()[24];
        field.setTitle("Grønningen");
        field.setSubText("$4,800");
        field.setDescription("My description");

        field = gui.getFields()[25];
        field.setTitle("Ø.S.");
        field.setSubText("$4,000");
        field.setDescription("My description");

        field = gui.getFields()[26];
        field.setTitle("Bredgade");
        field.setSubText("$5,200");
        field.setDescription("My description");

        field = gui.getFields()[27];
        field.setTitle("Kgs. Nytorv");
        field.setSubText("$5,200");
        field.setDescription("My description");

        field = gui.getFields()[28];
        field.setTitle("Carlsberg");
        field.setSubText("$3,000");
        field.setDescription("My description");

        field = gui.getFields()[29];
        field.setTitle("Østergade");
        field.setSubText("$5,600");
        field.setDescription("My description");

        field = gui.getFields()[30];
        //field.setTitle("My title");
        field.setSubText("Go to prison");
        field.setDescription("Go to prison.");

        field = gui.getFields()[31];
        field.setTitle("Amager");
        field.setSubText("$6,000");
        field.setDescription("My description");

        field = gui.getFields()[32];
        field.setTitle("Vimmelskaftet");
        field.setSubText("$6,000");
        field.setDescription("My description");

        field = gui.getFields()[33];
        //field.setTitle("My title");
        field.setSubText("Chance");
        field.setDescription("Receive a chance card");

        field = gui.getFields()[34];
        field.setTitle("Nygade");
        field.setSubText("$6,400");
        field.setDescription("My description");

        field = gui.getFields()[35];
        field.setTitle("Bornholm");
        field.setSubText("$4,000");
        field.setDescription("My description");

        field = gui.getFields()[36];
        //field.setTitle("My title");
        field.setSubText("Chance");
        field.setDescription("Receive a chance card");

        field = gui.getFields()[37];
        field.setTitle("Frederiksberggade");
        field.setSubText("$7,000");
        field.setDescription("My description");

        field = gui.getFields()[38];
        field.setTitle("Extraordinary state tax");
        field.setSubText("Pay $2,000");
        field.setDescription("My description");

        field = gui.getFields()[39];
        field.setTitle("Rådhuspladsen");
        field.setSubText("$8,000");
        field.setDescription("My description");

    }



}
