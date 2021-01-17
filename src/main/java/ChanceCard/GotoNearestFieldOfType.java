package ChanceCard;

import Field.Fields;
import Field.Gameboard;
import Game.Game;
import gui_main.GUI;

public class GotoNearestFieldOfType extends ChanceCard {
    boolean grantCrossStartBonus;
    Class<? extends Fields> fieldType;

    public GotoNearestFieldOfType(String text, Class<? extends Fields> fieldType){
        this.text = text;
        this.fieldType = fieldType;
    }

    protected int getFieldPosition(Game game) {
        Gameboard gameboard = game.getGameboard();

        int[] fieldPositions = gameboard.getPositionsOfFieldTypes(this.fieldType);
        int currentPosition = game.getCurrentPosition();
        int aheadPos = gameboard.getArray().length + 1;
        int behindPos = gameboard.getArray().length + 1;
        for(int i=0;i<fieldPositions.length;i++){
            int fieldPosition = fieldPositions[i];
            if(fieldPosition >= currentPosition && fieldPosition < aheadPos){
                aheadPos = fieldPosition;
            }
            if(fieldPosition <= currentPosition && fieldPosition < behindPos){
                behindPos = fieldPosition;
            }
        }
        if (aheadPos < gameboard.getArray().length)
            return aheadPos;
        else
            return behindPos;
    }

    public void execute(Game game, GUI gui){
        gui.displayChanceCard(this.text);
        int nearestPos = this.getFieldPosition(game);
        int lastPos = game.getGameboard().getArray().length ;
        int currentPos = game.getCurrentPosition();
        int dist;

        if( nearestPos >= currentPos)
            dist = nearestPos - currentPos;
        else
            dist = (lastPos - currentPos) + nearestPos;

        game.moveCurrentPlayer(dist, grantCrossStartBonus);
    }
}

