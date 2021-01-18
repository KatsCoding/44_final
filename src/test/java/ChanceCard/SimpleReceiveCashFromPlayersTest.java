package ChanceCard;

import Game.Game;
import gui_main.GUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleReceiveCashFromPlayersTest {

    @Test
    void getAmountFromPlayer() {


    }

}
// funktion:
  /*  protected int getAmountFromPlayer(Game game, GUI gui, Player player) {
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
    }*/