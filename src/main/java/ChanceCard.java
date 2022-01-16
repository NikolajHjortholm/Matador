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

        text = array[cText];
        type = Integer.parseInt((array[cType]));
        number = Integer.parseInt((array[cNumber]));
        pay = Integer.parseInt((array[cPay]));


    }

    public static void initilizeChanceCards() throws Exception {
        List<String> chanceConfig = Files.readAllLines(Paths.get(path));
        int no = 0;
        for (String s : chanceConfig) {
            if (no == 0) {
                no++;
                continue;
            }

            ChanceCard chanceCard = null;
            String[] array = s.split(";");
            String cardFinder = array[0];

            chanceCard = new ChanceCard(array);
            chanceCards[no - 1] = chanceCard;

            no++;
        }
    }

    public static void getChanceCard(Game game){

        int rand=(int)(Math.random()*numberOfCards);
        game.gui.showMessage(chanceCards[rand].text);
        game.aPlayers[game.currentPlayer].balance-=chanceCards[rand].pay;

    }

}
