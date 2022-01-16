

import java.awt.*;
import java.io.IOException;
import java.awt.Color;

public class Street extends Square {

    int ownedBy, level, group, price, mortgageValue, housePrice, rent0, rent1, rent2, rent3, rent4, rent5;
    boolean mortgaged, owned, groupOwned;



    public Street(String[] values) throws IOException {
        ownedBy = 0;
        mortgaged = false;
        owned = false;
        groupOwned = false;
        level = 0;

        position = Integer.parseInt((values[rPosition]));
        price = Integer.parseInt((values[rPrice]));
        housePrice = Integer.parseInt((values[rHousePrice]));
        rent0 = Integer.parseInt((values[rRent0]));
        rent1 = Integer.parseInt((values[rRent1]));
        rent2 = Integer.parseInt((values[rRent2]));
        rent3 = Integer.parseInt((values[rRent3]));
        rent4 = Integer.parseInt((values[rRent4]));
        rent5 = Integer.parseInt((values[rRent5]));
        mortgageValue = Integer.parseInt((values[rMortgageValue]));
        group = Integer.parseInt((values[rGroup]))-1;

        for (int i=0; i<3; i++) {
            if ((streetGroups[group][i] == 0)) {
                //true on null, empty string, or white space only. Do something here
                streetGroups[group][i] = position;
                break;
            } else {

            }
        }
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {

        switch(level) {
            case 0:
                if (groupOwned){
                    return rent0*2;
                } else {
                    return rent0;
                }

            case 1:
                return rent1;

            case 2:
                return rent2;

            case 3:
                return rent3;

            case 4:
                return rent4;

            case 5:
                return rent5;

        }
    return rent0;
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
                if (aCurrentPlayer.balance - getPrice() < 0) {
                    game.gui.showMessage(" Not Enough Money: ");
                }
                //Player buys street
                else {
                    aCurrentPlayer.balance=aCurrentPlayer.balance-getPrice();
                    owned = true;
                    mortgaged = true;
                    ownedBy = game.currentPlayer;
                    aCurrentPlayer.owns[currentPosition] = true;
                    game.gui.showMessage(" You bought " + name);
                    updateSquareGui(game);
                    groupIsOwned(game);

                }
            }
        }
        else if (ownedBy == game.currentPlayer) {
            game.gui.showMessage(" You landed on your own square "+name);
        }
        else if (mortgaged) {
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

    public void updateSquareGui(Game game){

        Game.gui.getFields()[game.aPlayers[game.currentPlayer].currentPosition].setBackGroundColor(game.players[game.currentPlayer].getCar().getPrimaryColor());
        Game.gui.getFields()[game.aPlayers[game.currentPlayer].currentPosition].setSubText("Rent: $" + getRent());
    }


    //Checks if group is owned
    public void groupIsOwned(Game game) {

        if (group==0 || group==7){

            if (game.aPlayers[game.currentPlayer].owns[streetGroups[group][0]] && game.aPlayers[game.currentPlayer].owns[streetGroups[group][1]]){
                groupOwned=true;
                game.aPlayers[game.currentPlayer].ownsGroup=true;

                Game.gui.getFields()[streetGroups[group][0]].setSubText("Rent: $" + getRent());
                Game.gui.getFields()[streetGroups[group][1]].setSubText("Rent: $" + getRent());

                game.gui.showMessage( " You own all of street group " + group+1 + "! The rent of the streets is now double");
            }

        }else {
            if (game.aPlayers[game.currentPlayer].owns[streetGroups[group][0]] && game.aPlayers[game.currentPlayer].owns[streetGroups[group][1]] && game.aPlayers[game.currentPlayer].owns[streetGroups[group][2]]){
                groupOwned=true;
                game.aPlayers[game.currentPlayer].ownsGroup=true;

                Game.gui.getFields()[streetGroups[group][0]].setSubText("Rent: $" + getRent());
                Game.gui.getFields()[streetGroups[group][1]].setSubText("Rent: $" + getRent());
                Game.gui.getFields()[streetGroups[group][2]].setSubText("Rent: $" + getRent());

                game.gui.showMessage( " You own all of street group " + group+1 + "! The rent of the streets is now double");

            }
        }


    }

}

