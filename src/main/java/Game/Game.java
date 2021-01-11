package Game;

//import stuff
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import Field.*;
import GUI.*;

public class Game {

    Dice die = new Dice();
    GUI gui;
    private int numberOfPlayers;
    private int currentPosition;
    boolean gameOver = false;
    PlayerList Players;
    GUI_Player[] guiPlayers;
    Player currentPlayer;
    GUI_Player currentGUIPlayer;
    Fields[] gameboard;
    GUI_Field currentField;


    public void endGame(Player currentPlayer){
        gameOver = true;
    }
}
