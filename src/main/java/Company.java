public class Company extends Square {

    int ownedBy, price, rent0, rent1, rent2, rent3, rent4;
    boolean owned = false;


    public void handlePlayer(Game game) {
        Player aCurrentPlayer = game.aPlayers[game.currentPlayer];
        int currentPosition = aCurrentPlayer.currentPosition;
        int anyPosition;

        if (!owned){

            if (game.gui.getUserButtonPressed(aCurrentPlayer.name + " do you want to buy "+name, " Yes ", " No ").equals(" Yes ")){
                if (aCurrentPlayer.balance < price) {
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
        else if (ownedBy==game.currentPlayer){
            game.gui.showMessage(" You landed on your own square "+name);
        }
        else {
            int loss = getRent();
            if (aCurrentPlayer.balance < getRent()) {
                game.gui.showMessage( " You dont have enough money, and lost: ");
            }
            else {
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
