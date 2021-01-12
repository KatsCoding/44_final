package Game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import Field.*;
import GUI.*;

import java.awt.*;

public class Game {

    DiceCup diceCup = new DiceCup(2);
    private int numberOfPlayers;
    private int currentPosition;
    boolean gameOver = false;
    PlayerList players;
    GUI_Player[] guiPlayers;
    Player currentPlayer;
    GUI_Player currentGUIPlayer;
    Gameboard gameboard = new Gameboard();
    GUI_Field currentField;
    GUI_Field[] fields = GUI_game.makeGUIFields();
    GUI gui = new GUI(fields, Color.WHITE);
    FieldAction fieldAction = new FieldAction();

    public void startGame(){
        // velkomst besked
        gui.showMessage("Velkommen til matador!");

        // valg af antal spillere
        numberOfPlayers = Integer.parseInt(gui.getUserSelection("Vælg antal spillere:", "2", "3", "4", "5", "6"));
        String[] playerNames = new String[numberOfPlayers];
        // indtastning af navne på spillere
        for (int i = 0; i < numberOfPlayers; i++) {
            playerNames[i] = gui.getUserString("Indtast navn på den " + (i + 1) + ". Spiller");
        }

        //Liste over spillere og deres navne
        players = new PlayerList(numberOfPlayers, playerNames);

        // laver spillebrkker til spillere
        GUI_Car[] cars = GUI_Cars.makeCars(numberOfPlayers);

        // laver et array af start indhold for spillere
       guiPlayers = new GUI_Player[numberOfPlayers];
       for (int i = 0; i < numberOfPlayers; i++) {
           guiPlayers[i] = new GUI_Player(players.getplayer(i).getName(), Player.defaultCash(), cars[i]);
       }

        //TODO chancekortne skal blandes her

        //Sætter startfeltet
        currentField = gui.getFields()[0];
        fieldAction.setGameboard(gameboard.getArray());
        //Indsætter viuel rep. af spillere + deres biler + penge
        for (int i = 0; i < numberOfPlayers; i++) {
            gui.addPlayer(guiPlayers[i]);
            currentField.setCar(guiPlayers[i], true);
        }

        //Opdaterer visuel rep af penge på gui'en
        updateGUICash();

        //TODO add actual gå-i-gang-besked
        gui.showMessage("gå-i-gang-med-spillet-besked");

        //holder spillet i gang indtil gameOver
        while (!gameOver) {
        round();
        }
    }


    public void round(){
        //for-loop hver spiller og kalder turn()
        for (int i = 0; i < numberOfPlayers; i++) {
            turn(i);
        }
    }

    public void turn(int playerID){
        if (!gameOver) {
            gui.showMessage("Det er nu" + players.getplayer(playerID).getName() + "'s tur");
            currentPlayer = players.getplayer(playerID);
            currentGUIPlayer = guiPlayers[playerID];

            if (!currentPlayer.isJailed()) {
                move(diceCup.roll()); //move handles landing on fields etc.
            }

            //handling of jailed players
            else {
                //pay 1 money or use get out of jail free card and call turn() again.
                if (!gameOver) {
                    currentPlayer.addCash(200);
                    currentPlayer.setJailed(false);
                    turn(playerID);
                } else {
                    if (currentPlayer.getCash() > 0) {
                        currentPlayer.addCash(-1);
                        currentPlayer.setJailed(false);
                        turn(playerID);
                    } else {
                        endGame(currentPlayer);
                    }
                }
            }

            updateGUICash();

        }
        /* Opbygning:
        * besked om hvilken player's tur
        * get player for data og for gui
        * hvis spiller ikke isJailed: valgmuligheder: slå terning, køb/sælg/pantsætte osv.
        * hvad der sker i alle instances af valgmulighederne
        * hvis 2 ens terninger, så kald metode
        * hvis spiller isJailed så kald metoder
        * når spiller har kastet terninger og evt udført handling (køb field, auction osv) valgmulighed igen, er der andet de vil
        *hvis ja udfør, hvis nej næste spillers tur
        *
        * */
        //TODO lave så man slår med 2 terninger
        //TODO what happens when houses & hotels become part of it
        //TODO turn
        //TODO evt metode for sig self vedrørende isJailed osv (linje 114 - 126 cdio3 + det nye fra final)
    }
    //TODO Lave metode der afgør hvad der sker når man slår 2 ens (og 2 ens flere gange)

    //We used our move method from cdio 3, with changes as needed.
    public void move(int dist) {
        currentField = gui.getFields()[currentPlayer.getPlayerPosition()]; //makes sure the gui will remove the car of the current player's position.
        currentPlayer.movePlayer(dist); //changes player's position number
        currentPosition = currentPlayer.getPlayerPosition(); //set current placement

        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPosition]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField

        if (currentPlayer.getPassedGoThisTurn()) { //adds money if player passes go when moving.
            currentPlayer.addCash(4000);
        }
        currentPlayer.resetHasPassedGo(); //sets boolean back to false.
        fieldAction.landOnField(currentPosition);
    }

    public void endGame(Player currentPlayer){
        gameOver = true;
        gui.showMessage(currentPlayer + " har vundet spillet! Stort tillykke.");
        gui.showMessage("Tryk ok for at afslutte");
        gui.close();
    }

    private void updateGUICash(){
        for (int i = 0; i < players.getPlayers().length; i++) {
            guiPlayers[i].setBalance(players.getPlayers()[i].getCash());
        }
    }
}
