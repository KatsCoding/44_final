package ChanceCard;

import Game.Game;
import gui_main.GUI;

public class SimplePayCash extends ChanceCard {
    int amount;

    // skal have noget om spilleren har penge nok til at betale.
    // Tænker en boolean der tjekker om deres account indeholder mere end hvad de skal betale


    public SimplePayCash(String text,int amount){
        this.text = text;
        this.amount = amount;
    }

    public void execute(Game game, GUI gui){
        gui.displayChanceCard(this.text);
        game.withdrawCashFromCurrentPlayer(this.amount);

    }
}
