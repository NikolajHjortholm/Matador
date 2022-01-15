public class Tax extends Square {

    public void handlePlayer(Game game) {
        Player player = game.aPlayers[game.currentPlayer];
        player.balance *= 0.9;
        Square.parking.balance += player.balance * 0.1;
        game.gui.showMessage(" you landed on "+name+ " and payed 10% in taxes");
    }

}
