package ChanceCard;

import Game.Game;
import gui_main.GUI;

public class SimpleReceiveCash extends ChanceCard {
    int amount;

    public SimpleReceiveCash(String text, int amount){
        this.text = text;
        this.amount = amount;

    }
    public void execute(Game game, GUI gui){
        gui.displayChanceCard(this.text);
        game.addCashToCurrentPlayer(this.amount);

    }


}
