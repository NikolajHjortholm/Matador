import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Chance extends Square {

    int text, numberOfCard, pay;

    static String path = "src/main/java/files/ChanceCardPay.csv";
    boolean owned = true;
    int ownedBy;
    static String x;

    public Chance(String[] values) {
        text = 0;
        numberOfCard = 0;
        pay = Integer.parseInt(values[0]);

    }

    public static void initilizeChance() throws Exception {
        List<String> chanceConfig = Files.readAllLines(Paths.get(path));
        int no = 0;
        for (String s : chanceConfig) {
            if (no == 0) {
                no++;
                continue;
            }
            Chance chance = null;
            String[] array = s.split("; ");
            String cardFinder = array[0];

            no++;
        }
    }

    public void handlePlayer(Game game) {
        Player aCurrentPlayer = game.aPlayers[game.currentPlayer];
        int currentPosition = aCurrentPlayer.currentPosition;
        int anyPosition;

        if (!owned) {
            game.gui.setChanceCard(String.valueOf(text));
            game.gui.displayChanceCard(String.valueOf(text));

        }

    }

}