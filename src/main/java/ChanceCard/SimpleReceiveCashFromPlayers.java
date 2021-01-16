package ChanceCard;

import Game.Game;
import Game.Player;
import gui_main.GUI;

public class SimpleReceiveCashFromPlayers extends ChanceCard {
    int amountPerPlayer;

    public SimpleReceiveCashFromPlayers(String text, int amountPerPlayer){
        this.text = text;
        this.amountPerPlayer = amountPerPlayer;
    }

    protected int getAmountFromPlayer(Game game, GUI gui, Player player) {
        int amountReceived = 0;
        switch (game.withDrawCashFromPlayer(player, this.amountPerPlayer)) {
            case OK:
                amountReceived = this.amountPerPlayer;
                break;
            case INSUFFICIENT_CASH: {
                int missing = this.amountPerPlayer - game.getCurrentUserFunds();
                gui.showMessage(String.format("Du har ikke penge nok. Der mangler %d \n Sælg ejendomme for at få penge nok", missing));
                // allow the user to sell properties (not implemented fully - could be for further work)
                game.promptCurrentUserPropertySale();
                // Then check whether the user now has enough cash otherwise end game for user
                switch (game.withDrawCashFromPlayer(player, this.amountPerPlayer)) {
                    case OK:
                        amountReceived = this.amountPerPlayer;
                        break;
                    case INSUFFICIENT_CASH:
                        game.endGameCurrentUser();
                        break;
                }
                break;
            }
        }
        return amountReceived;
    }

    public void execute(Game game, GUI gui){
        gui.displayChanceCard(this.text);

        int amountReceived = 0;
        Player[] players = game.getPlayers();
        for(int i=0; i<players.length; i++) {
            if (players[i] != game.getCurrentPlayer()) {
                amountReceived += this.getAmountFromPlayer(game, gui, players[i]);
            }
        }
        game.addCashToCurrentPlayer(amountReceived);
    }
}
