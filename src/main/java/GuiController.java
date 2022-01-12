import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class GuiController {

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