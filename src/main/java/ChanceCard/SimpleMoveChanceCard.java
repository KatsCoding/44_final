package ChanceCard;

import Game.Game;
import gui_main.GUI;

public class SimpleMoveChanceCard extends ChanceCard {
    protected int move;

    public SimpleMoveChanceCard(String text, int move) {
        this.text = text;
        this.move = move;
    }

    public void  execute(Game game, GUI gui) {
        gui.displayChanceCard(this.text);
        game.moveCurrentPlayer(this.move, true);
    }
}