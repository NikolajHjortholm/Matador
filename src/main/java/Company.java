public class Company extends Square {

    int ownedBy, price, rent0, rent1, rent2, rent3, rent4;
    boolean owned = false;

    // Handles player landing on company
    public void handlePlayer(Game game) {
        Player aCurrentPlayer = game.aPlayers[game.currentPlayer];
        int currentPosition = aCurrentPlayer.currentPosition;
        int anyPosition;

        // If company not owned
        if (!owned){

            // Asks if player wants to buy company
            if (game.gui.getUserButtonPressed(aCurrentPlayer.name + " do you want to buy "+name, " Yes ", " No ").equals(" Yes ")){

                // Checks if player has enough money
                if (aCurrentPlayer.balance-price < 0) {
                    game.gui.showMessage(" Not Enough Money: ");
                }
                else {
                    aCurrentPlayer.balance=aCurrentPlayer.balance - price;
                    owned = true;
                    ownedBy = game.currentPlayer;
                    game.gui.showMessage(" You bought " + name);
                }
            }
        }
        // If company owned by current player
        else if (ownedBy==game.currentPlayer){
            game.gui.showMessage(" You landed on your own square "+name);
        }
        // If company owned by another player
        else {

            int loss = getRent();
            // Player can't pay and loses game
            if (aCurrentPlayer.balance < getRent()) {
                game.gui.showMessage( " You dont have enough money, and lost: ");
            }

            else {
                //Player gives rent to player who ones the company
                aCurrentPlayer.balance = aCurrentPlayer.balance - loss;
                game.aPlayers[ownedBy].balance += loss;
                game.gui.showMessage( " You landed on: "+name+" owned by "+game.aPlayers[this.ownedBy].name+" and payed "+getRent());
            }
        }
    }

    public int getRent() {

        return rent0;
    }


}
