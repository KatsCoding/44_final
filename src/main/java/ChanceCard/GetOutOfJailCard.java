package ChanceCard;

import Game.Game;
import gui_main.GUI;


public class GetOutOfJailCard extends ChanceCard {

    public GetOutOfJailCard(String text){
        this.text = text;
    }
    public void execute(Game game, GUI gui){
        gui.displayChanceCard(this.text);
        game.addGetOutJailCardCurrentPlayer();

    }
}
