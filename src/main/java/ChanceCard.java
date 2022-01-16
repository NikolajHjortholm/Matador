import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ChanceCard {

    int number, pay, type;
    String text;

    public static int numberOfCards = 7;

    public static ChanceCard[] chanceCards = new ChanceCard[numberOfCards];

    static String path = "src/main/java/files/ChanceCardPay.csv";
    int cText=0, cType=1, cNumber=2, cPay=3;

    public ChanceCard(String[] array) {

        //Puts in information from ChanceCardPay.csv
        text = array[cText];
        type = Integer.parseInt((array[cType]));
        number = Integer.parseInt((array[cNumber]));
        pay = Integer.parseInt((array[cPay]));


    }

    public static void initilizeChanceCards() throws Exception {
        // Puts ChanceCardPay.csv in String list
        List<String> chanceConfig = Files.readAllLines(Paths.get(path));

        // Goes through the lines of the file
        int no = 0;
        for (String s : chanceConfig) {
            if (no == 0) {
                no++;
                continue;
            }
            ChanceCard chanceCard = null;

            // Splits line by ; and puts it in String array
            String[] array = s.split(";");
            String cardFinder = array[0];

            // Creates chanceCard from String information
            chanceCard = new ChanceCard(array);
            chanceCards[no - 1] = chanceCard;

            // Repeates for next line
            no++;
        }
    }

    public static void getChanceCard(Game game){

        // Pulls random chanceCard
        int rand=(int)(Math.random()*numberOfCards);
        game.gui.showMessage(chanceCards[rand].text);
        game.aPlayers[game.currentPlayer].balance-=chanceCards[rand].pay;

    }

}
