package ChanceCard;

import Game.Game;
import gui_main.GUI;

public class SimplePayTaxes extends ChanceCard {
    int taxPerHouse;
    int taxPerHotel;

    protected int calculateTaxes(Game game) {
        int hotels = game.getCurrentPlayer().getHotel();
        int houses = game.getCurrentPlayer().getHouses();

        return hotels * this.taxPerHotel + houses * this.taxPerHouse;
    }
    public SimplePayTaxes(String text,int taxPerHouse, int taxPerHotel){
        this.text = text;
        this.taxPerHouse = taxPerHouse;
        this.taxPerHotel = taxPerHotel;
    }

    public void execute(Game game, GUI gui){
        gui.displayChanceCard(this.text);
        int taxDue = calculateTaxes(game);
        switch (game.withdrawCashFromCurrentPlayer(taxDue)) {
            case OK:
                break;
            case INSUFFICIENT_CASH: {
                int missing = taxDue - game.getCurrentUserFunds();
                gui.showMessage(String.format("Du har ikke penge nok. Der mangler %d \n Sælg ejendomme for at få penge nok", missing));
                // allow the user to sell properties (not implemented fully - could be for further work)
                game.promptCurrentUserPropertySale();
                // Then check whether the user now has enough cash otherwise end game for user
                switch (game.withdrawCashFromCurrentPlayer(taxDue)) {
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
