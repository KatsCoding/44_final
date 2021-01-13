package ChanceCard;

import Game.Game;
import gui_main.GUI;

public class SimpleMoveToSpecificField extends ChanceCard {
    String fieldName;
    boolean grantCrossStartBonus;

    public SimpleMoveToSpecificField(String text, String fieldName, boolean grantCrossStartBonus) {
        this.text = text;
        this.fieldName = fieldName;
        this.grantCrossStartBonus = grantCrossStartBonus;
    }

    public void execute(Game game, GUI gui) {
        gui.displayChanceCard(this.text);
        game.moveCurrentPlayerToNameField(this.fieldName, this.grantCrossStartBonus);
    }
}
