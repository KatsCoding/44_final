package ChanceCard;


import Game.Game;
import gui_main.GUI;

public class ChanceCard {
    protected String text;

    public ChanceCard(){
        this.text = "";
    }

    public ChanceCard(String text){
        this.text = text;
    }

    public String getText(){ return this.text; } //

    public void execute(Game game, GUI gui) {
        gui.displayChanceCard(this.text);
    }

}


