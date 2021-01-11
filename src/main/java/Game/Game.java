package Game;

import ChanceCard.ChanceCard;
import gui_main.GUI;

public class Game {
    GUI gui;
    Pile pile;
    public void moveCurrentPlayer(int move, boolean grantCrossStartBonus) {}
    public void moveCurrentPlayerToNameField(String fieldName, boolean grantCrossStartBonus) {}

    public void getPositionOfNameField(String field) {}



    public void makePile() {
        this.pile = new Pile();
        this.pile.loadPile();
        this.pile.shuffle();
    }

    public void landOnChance() {
        ChanceCard card = this.pile.draw();
        if (card == null) {
            this.pile.shuffle();
            card = this.pile.draw();
        }
        card.execute(this, this.gui);
    }


}
