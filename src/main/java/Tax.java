public class Tax extends Square {

    // Player lands on tax and pays 10% of balance
    public void handlePlayer(Game game) {
        Player player = game.aPlayers[game.currentPlayer];
        player.balance *= 0.9;
        Square.parking.balance += calculateTax(player.balance);
        game.gui.showMessage(" you landed on "+name+ " and payed 10% in taxes");
    }

    public int calculateTax(int balance) {
        return (int) (balance * 0.1);
    }

}
