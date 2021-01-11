package ChanceCard;

import Game.Game;
import gui_main.GUI;

public class SimpleMove extends ChanceCard {
    protected int move;
    boolean grantCrossStartBonus;

    public SimpleMove(String text, int move, boolean grantCrossStartBonus) {
        this.text = text;
        this.move = move;
        this.grantCrossStartBonus = grantCrossStartBonus;
    }

    public void  execute(Game game, GUI gui) {
        gui.displayChanceCard(this.text);
        game.moveCurrentPlayer(this.move, true);
    }
}