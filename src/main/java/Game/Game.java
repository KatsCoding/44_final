package Game;

import ChanceCard.ChanceCard;
import gui_fields.*;
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
    Pile pile; // Added pile to gameclass


    public enum WithDrawOutCome {
        OK,
        INSUFFICIENT_CASH
    }

    // Method for the chancecards that gives the player cash
    public void addCashToCurrentPlayer(int amount){
        currentPlayer.addCash(amount);
    }
    // method for chancecards that gives the player a "get out of jail" card
    public void addGetOutJailCardCurrentPlayer() {
        currentPlayer.setGetOutOfJailFreeCards(
                currentPlayer.getGetOutOfJailFreeCards() + 1
        );
    }
    // method for chancecards that withdraws money from the player
    // if they dont have enough the game ends for the player
    public WithDrawOutCome withdrawCashFromCurrentPlayer(int amount){
        if (currentPlayer.getCash() > amount) {
            currentPlayer.addCash(-amount);
            return WithDrawOutCome.OK;
        }
        else return WithDrawOutCome.INSUFFICIENT_CASH;
    }

    public int getCurrentUserFunds() {
        return currentPlayer.getCash();
    }

    public void promptCurrentUserPropertySale() {
        // give the user a list of owned properties and let him choose what he wants to sell
        // opdate userfunds after sale
        // work for further work (videreudvikling)
    }

    public void endGameCurrentUser() {
        // afslut spillet for current user
    }

    public void makePile() { // creates a new pile with the cards made in pile and shuffles them
        this.pile = new Pile();
        this.pile.loadPile();
        this.pile.shuffle();
    }

    public void landOnChance() {
        ChanceCard card = this.pile.draw();
        // If there is no more cards in the deck the pile gets shuffled, and a new card is draw
        // ikke aktuelt da bunken aldrig er tom da kortene bliver lagt i bunken
        if (card == null) {
            this.pile.shuffle();
            card = this.pile.draw();
        }
        card.execute(this, this.gui);
    }





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
        fieldAction.setGame(this);
        //TODO chancekortne skal blandes her

        //Sætter startfeltet
        currentField = gui.getFields()[0];

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
            currentPlayer = players.getplayer(playerID);
            currentGUIPlayer = guiPlayers[playerID];

            if (!currentPlayer.isJailed()) {
                String choice = gui.getUserSelection("Det er nu " + players.getplayer(playerID).getName() + "'s tur", "Roll", "Buy House", "Buy Hotel", "Sell House", "Skip");
                if (choice == "Roll") {
                    diceCup.roll();
                    gui.setDice(diceCup.getDices()[0].getValue(), diceCup.getDices()[1].getValue());
                    moveCurrentPlayer(diceCup.getTotalValue(),true); //move handles landing on fields etc.
                } else if (choice == "Buy House") {
                    buyHouse(playerID);
                } else if (choice == "Buy Hotel"){
                    buyHotel(playerID);
                }


            }

            //handling of jailed players
            else {
                //pay 1 money or use get out of jail free card and call turn() again.
                if (currentPlayer.getGetOutOfJailFreeCards() > 0) {
                    currentPlayer.setGetOutOfJailFreeCards(currentPlayer.getGetOutOfJailFreeCards() - 1);
                    currentPlayer.setJailed(false);
                    turn(playerID);
                } else {
                    if (currentPlayer.getCash() >= 200) {
                        currentPlayer.addCash(-200);
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
    private void buyHouse(int playerID) {
        int totalOwnedFields = 0;
        FieldStreet[] ownedFields = new FieldStreet[40];
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (!(this.gameboard.getArray()[i] instanceof FieldStreet)) {
                continue;
            }
            FieldStreet field_i = (FieldStreet) this.gameboard.getArray()[i];
            if (field_i.getOwner() == this.currentPlayer && field_i.canBuildHouse()) {
                ownedFields[totalOwnedFields] = field_i;
                totalOwnedFields++;
            }
        }
        if (totalOwnedFields == 0) {
            gui.showMessage("Det ser ikke ud til at du kan købe nogen huse");
            turn(playerID);
            return;
        }
        String[] streetSelection = new String[totalOwnedFields];
        for (int i = 0; i < totalOwnedFields; i++) {
            streetSelection[i] = ownedFields[i].getPropertyName();
        }
        String streetChoice = gui.getUserSelection("Hvor vil du købe et hus?",streetSelection);
        int streetChoiceInteger = 0;
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (this.gameboard.getArray()[i].getPropertyName() == streetChoice){
                streetChoiceInteger = i;
                break;
            }
        }
        ((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).buildHouse();
        ((GUI_Street) this.fields[streetChoiceInteger]).setHouses(((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).getHouses());
        gui.showMessage(players.getplayer(playerID).getName() +" har købt et hus på " + streetChoice + ".");
        turn(playerID);
    }
    private void buyHotel(int playerID) {
        int totalOwnedFields = 0;
        FieldStreet[] ownedFields = new FieldStreet[40];
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (!(this.gameboard.getArray()[i] instanceof FieldStreet)) {
                continue;
            }
            FieldStreet field_i = (FieldStreet) this.gameboard.getArray()[i];
            if (field_i.getOwner() == this.currentPlayer && field_i.canBuildHotel()) {
                ownedFields[totalOwnedFields] = field_i;
                totalOwnedFields++;
            }
        }
        if (totalOwnedFields == 0) {
            gui.showMessage("Det ser ikke ud til at du kan købe nogen hoteller");
            turn(playerID);
            return;
        }
        String[] streetSelection = new String[totalOwnedFields];
        for (int i = 0; i < totalOwnedFields; i++) {
            streetSelection[i] = ownedFields[i].getPropertyName();
        }
        String streetChoice = gui.getUserSelection("Hvor vil du købe et hotel?",streetSelection);
        int streetChoiceInteger = 0;
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (this.gameboard.getArray()[i].getPropertyName() == streetChoice){
                streetChoiceInteger = i;
                break;
            }
        }
        ((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).buildHotel();
        ((GUI_Street) this.fields[streetChoiceInteger]).setHotel(true);
        gui.showMessage(players.getplayer(playerID).getName() +" har købt et hotel på " + streetChoice + ".");
        turn(playerID);
    }
    //We used our move method from cdio 3, with changes as needed.

    public void moveCurrentPlayer(int dist, boolean grantCrossStartBonus) { //added boolean that checks if they cross START
        currentField = gui.getFields()[currentPlayer.getPlayerPosition()]; //makes sure the gui will remove the car of the current player's position.
        currentPlayer.movePlayer(dist,gameboard.getArray().length); //changes player's position number
        currentPosition = currentPlayer.getPlayerPosition(); //set current placement

        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPosition]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField

        if (currentPlayer.getPassedGoThisTurn()) { //adds money if player passes START when moving.
            if (grantCrossStartBonus)
                currentPlayer.addPassStartBonus(4000);
            else currentPlayer.addPassStartBonus(0); // added so it resets
        }
        currentPlayer.resetHasPassedGo(); //sets boolean back to false.
        fieldAction.landOnField(currentPosition);
    }

    // method for chancecard where player has to go to specific field
    public void moveCurrentPlayerToNameField(String fieldName, boolean grantCrossStartBonus) {
        int dist;
        int position = gameboard.getPositionNamedField(fieldName); // the position of the field the player has to move to
        int playerPosition = currentPlayer.getPlayerPosition(); // the players current position
        int numFields = gameboard.getArray().length;
        if (position > playerPosition) // if the field position is ahead of the player
            dist = position - playerPosition;
        else {
            dist = numFields - playerPosition + position; // if the field position is behind the player
        }
        moveCurrentPlayer(dist, grantCrossStartBonus);
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
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public GUI_Player getCurrentGUIPlayer() {
        return currentGUIPlayer;
    }

    public Gameboard getGameboard(){
        return this.gameboard;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(int position) {
        currentField = gui.getFields()[position]; //makes sure the gui will remove the car of the current player's position.
        currentPosition = position; //set current placement
    }
    public GUI_Field getCurrentField(){
        return currentField;
    }

    public GUI getGui() {
        return gui;
    }
    public GUI_Field[] getFields(){
        return fields;
    }
}
