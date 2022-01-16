public class Prison extends Square {

    static int prisonPrice = 1000;

    public void handlePlayer(Game game) {

        // If player lands on visit jail
        if (position == 10) {
            game.gui.showMessage(" You went to prison on a visit ");
        }

        // If player lands on get imprisoned
        if (position == 31) {
            game.gui.showMessage(" You got imprisoned ");

            // Player is moved to other prison square and get imprisoned
            game.aPlayers[game.currentPlayer].currentPosition = 10;
            Player.updatePlayerGuiPosition(game);
            game.aPlayers[game.currentPlayer].imprisoned = true;
        }

    }

    // Turn for player if imprisoned
    public static void getOutOfPrison(Game game) {

        // Player can either roll or pay 1000 to get out of jail
        if (game.gui.getUserButtonPressed("Do you want to pay to get out of jail?", " Roll ", " Pay $" + prisonPrice + " ").equals(" Roll ")) {

            // Rolls die
            game.dice.roll();
            game.dice.rota();
            game.gui.setDice(game.dice.getDie1(),game.dice.getRot1(), game.dice.getDie2(), game.dice.getRot2());
            int die1 = game.dice.getDie1();
            int die2 = game.dice.getDie2();
            int dices = die1+die2;

            // If dies are equal player is released from prison, moves amount of squares of dies and gets a new turn
            if (die1==die2){
                game.gui.showMessage(" You got lucky and escaped prison! You get an extra turn");
                game.aPlayers[game.currentPlayer].currentPosition+=dices;
                Player.updatePlayerGuiPosition(game);
                game.aPlayers[game.currentPlayer].imprisoned = false;
                game.currentPlayer-=1;
            }

            // If dies aren't equal player is still imprisoned
        } else {
            game.aPlayers[game.currentPlayer].balance-=prisonPrice;
            game.aPlayers[game.currentPlayer].imprisoned = false;
            game.currentPlayer-=1;
        }

    }
}

