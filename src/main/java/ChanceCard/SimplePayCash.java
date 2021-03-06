package ChanceCard;

import Game.Game;
import gui_main.GUI;

public class SimplePayCash extends ChanceCard {
    int amount;

    public SimplePayCash(String text,int amount){
        this.text = text;
        this.amount = amount;
    }

    public void execute(Game game, GUI gui){
        gui.displayChanceCard(this.text);
        switch (game.withdrawCashFromCurrentPlayer(this.amount)) {
            case OK:
                break;
            case INSUFFICIENT_CASH: {
                int missing = this.amount - game.getCurrentUserFunds();
                gui.showMessage(String.format("Du har ikke penge nok. Der mangler %d \n Sælg ejendomme for at få penge nok", missing));
                // allow the user to sell properties (not implemented fully - could be for further work)
                game.promptCurrentUserPropertySale();
                // Then check whether the user now has enough cash otherwise end game for user
                switch (game.withdrawCashFromCurrentPlayer(this.amount)) {
                    case OK:
                        break;
                    case INSUFFICIENT_CASH:
                        game.endGameCurrentUser();
                        break;
                }
                break;
            }
        }
    }
}
