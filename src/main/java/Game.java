import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.io.IOException;

public class Game {
    static GUI gui;
    Dice dice = new Dice();
    int currentPlayer;

    int maxPlayerCount = 6;
    Player [] aPlayers = new Player [maxPlayerCount];
    Square squares = new Square();

    Boolean[] landedOn = new Boolean[40];


    public Game() {

        Square.Square();
        gui = new GUI();

        for (int i = 0; i < 40; i++) {
            landedOn[i] = false;
        }

    }

    //Starts game
    public void startGame() throws IOException {
        //Fixes gui
        initializeGui();
        //Player creation
        createPlayers();
        //Main loop of game
        mainLoop();
    }



    public static int playerCount = 0;
    public static GUI_Player[] players;

    public void createPlayers() {

        playerCount = Game.gui.getUserInteger("Enter player amount between 2 and 6",2,6);
        players = new GUI_Player[playerCount];



        String input = null;
        GUI_Player player = null;

        for (int i =0; i<playerCount; i++) {

            input = Game.gui.getUserString("Enter names: ");


            aPlayers[i] = new Player(input, 30000);
            aPlayers[i].playerNumber = i;

            player = new GUI_Player(input, aPlayers[i].balance);
            players[i] = player;
            Game.gui.addPlayer(player);
            GUI_Field field = Game.gui.getFields()[0];
            player.getCar().setPosition(field);
            System.out.println(players[i]);
        }
    }

    public void mainLoop() throws IOException {

        // First player starts to roll dices
        currentPlayer = 0;

        // Enter main loop for the game
        while(true){
            gui.getUserButtonPressed(aPlayers[currentPlayer].name + " Roll dice: "," Roll ");


            dice.roll();
            dice.rota();
            gui.setDice(dice.getDie1(),dice.getRot1(), dice.getDie2(), dice.getRot2());
            int dices = dice.getTotal();

            aPlayers[currentPlayer].currentPosition =aPlayers[currentPlayer].currentPosition +dice.getTotal();
            if (aPlayers[currentPlayer].currentPosition > 39) {
                aPlayers[currentPlayer].currentPosition -= 40;
            }



            GUI_Field field  = players[currentPlayer].getCar().getPosition();
            int fieldIndex = 0;
            for (int i = 0; i < gui.getFields().length; i++) {
                if (gui.getFields()[i] == field) {
                    fieldIndex = i;

                }
            }

            players[currentPlayer].getCar().setPosition(gui.getFields()[(fieldIndex + dices)%gui.getFields().length]);

            System.out.println(aPlayers[currentPlayer].currentPosition);

            landOnSquare();
            for (int i=0; i<players.length;i++) {
                players[i].setBalance(aPlayers[i].balance);
            }

            currentPlayer++;
            if (currentPlayer == players.length) {
                currentPlayer = 0;
            }

        }

    }

    public void landOnSquare() throws IOException {
        //If player lands on street
        String type;
        Player aCurrentPlayer = aPlayers[currentPlayer];
        int currentPosition = aCurrentPlayer.currentPosition;
        int anyPosition;
        type=squares.getSquare(aCurrentPlayer.currentPosition, aCurrentPlayer);

        if ((type).equals(" street")){


            //initiates square landed on
            if (!landedOn[currentPosition]) {
                landedOn[currentPosition] = true;
                squares.properties[currentPosition] = new Property(currentPosition);

            }

            //goes to property
            if (!squares.properties[currentPosition].owned){

                if (gui.getUserButtonPressed(aCurrentPlayer.name + " do you want to buy this square ", " Yes ", " No ").equals(" Yes ")){
                    aCurrentPlayer.balance=aCurrentPlayer.balance-squares.properties[currentPosition].getPrice();
                    squares.properties[currentPosition].owned=true;
                    squares.properties[currentPosition].ownedBy=currentPlayer;

                    if (aCurrentPlayer.balance < squares.properties[currentPosition].getPrice()) {
                        gui.showMessage(" Not Enough Money: ");
                    }
                    else {
                        gui.showMessage(" You bought " + squares.properties[currentPosition].name);
                    }
                    return;
                }
                else {
                    return;
                }
            }
            if (squares.properties[currentPosition].ownedBy==currentPlayer){
                System.out.println(" you landed on your own square ");

            }
            if(!squares.properties[currentPosition].mortgaged){
                int loss = squares.properties[currentPosition].getRent();
                aCurrentPlayer.balance=aCurrentPlayer.balance-loss;
                System.out.println(" you landed on " + squares.properties[currentPosition].name + ":");
                aPlayers[squares.properties[currentPosition].ownedBy].balance=aPlayers[squares.properties[currentPosition].ownedBy].balance+loss;

                if (aCurrentPlayer.balance < squares.properties[currentPosition].getRent()) {
                    gui.showMessage( " Get the money by monday: ");

                }
                /**
                else if (aCurrentPlayer.any == squares.getSquare() {


                }
                 **/
                return;
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



    public void initializeGui (){


        GUI_Field field;


        //Sets up every field on board
        field = gui.getFields()[0];
        //field.setTitle("My title");
        field.setSubText("");
        field.setDescription("Receive $2,000 when passing start");

        field = gui.getFields()[1];
        field.setTitle("Rødovrevej");
        field.setSubText("$1,200");
        field.setDescription(
                        "Rent:     $50          \\n " +
                        "1 house:  $250         \\n " +
                        "2 houses: $750         \\n " +
                        "3 houses: $2,250       \\n " +
                        "4 houses: $4,000       \\n " +
                        "Hotel:    $6,000       \\n " +
                        "Upgrade cost: $1,000   \\n " +
                        "Mortgage value: $600       ");

        field = gui.getFields()[2];
        //field.setTitle("My title");
        field.setSubText("Chance");
        field.setDescription("Receive a chance card");

        field = gui.getFields()[3];
        field.setTitle("Hvidovrevej");
        field.setSubText("$1,200");
        field.setDescription(
                        "Rent:     $50          \\n " +
                        "1 house:  $250         \\n " +
                        "2 houses: $400         \\n " +
                        "3 houses: $750         \\n " +
                        "4 houses: $2250        \\n " +
                        "Hotel:    $6,000       \\n " +
                        "Upgrade cost: $1,000   \\n " +
                        "Mortgage value: $600       ");

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
        field.setDescription("");

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

    public GUI getGui() {
        return gui;


    }
}
