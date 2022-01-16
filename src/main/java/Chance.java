import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Chance extends Square {



    boolean owned = true;
    int ownedBy;
    static String x;

    public Chance() {


    }



    public void handlePlayer(Game game) {
        Player aCurrentPlayer = game.aPlayers[game.currentPlayer];
        int currentPosition = aCurrentPlayer.currentPosition;
        int anyPosition;

        ChanceCard.getChanceCard(game);

        }

    }