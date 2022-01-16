public class Parking extends Square {

    public int balance = 0;

    // Handles player landing on parking
    public void handlePlayer(Game game) {

        // Player receives money from parking square
        Player player = game.aPlayers[game.currentPlayer];
        player.balance += Square.parking.balance;
        game.gui.showMessage(" you landed on "+name+ " and received taxes payed "+Square.parking.balance);
        Square.parking.balance = 0;
    }

    
}
