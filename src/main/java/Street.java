

import java.io.IOException;

public class Street extends Square {

    int ownedBy, price, mortgageValue, housePrice, rent0, rent1, rent2, rent3, rent4, rent5;
    boolean mortgaged, owned;



    public Street(String[] values) throws IOException {
        ownedBy = 0;
        mortgaged = false;
        owned = false;
        price = Integer.parseInt((values[rPrice]));
        housePrice = Integer.parseInt((values[rHousePrice]));
        rent0 = Integer.parseInt((values[rRent0]));
        rent1 = Integer.parseInt((values[rRent1]));
        rent2 = Integer.parseInt((values[rRent2]));
        rent3 = Integer.parseInt((values[rRent3]));
        rent4 = Integer.parseInt((values[rRent4]));
        rent5 = Integer.parseInt((values[rRent5]));
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent0;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public void handlePlayer(Game game) {
        Player aCurrentPlayer = game.aPlayers[game.currentPlayer];
        int currentPosition = aCurrentPlayer.currentPosition;
        int anyPosition;

        //goes to property
        if (!owned) {

            if (game.gui.getUserButtonPressed(aCurrentPlayer.name + " do you want to buy "+name, " Yes ", " No ").equals(" Yes ")){
                if (aCurrentPlayer.balance < getPrice()) {
                    game.gui.showMessage(" Not Enough Money: ");
                }
                else {
                    aCurrentPlayer.balance=aCurrentPlayer.balance-getPrice();
                    owned = true;
                    mortgaged = true;
                    ownedBy = game.currentPlayer;
                    game.gui.showMessage(" You bought " + name);
                }
            }
        }
        else if (ownedBy == game.currentPlayer) {
            game.gui.showMessage(" You landed on your own square "+name);
        }
        else if (mortgaged) {
            int loss = getRent();
            if (aCurrentPlayer.balance < getRent()) {
                game.gui.showMessage( " Get the money by monday: ");
            }
            else {
                aCurrentPlayer.balance = aCurrentPlayer.balance - loss;
                game.aPlayers[ownedBy].balance += loss;
                game.gui.showMessage( " You landed on: "+name+" owned by "+game.aPlayers[this.ownedBy].name+" and payed "+getRent());
            }
        }

    }

}
