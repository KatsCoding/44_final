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

    public Player[] getPlayers() {
        return this.players.getPlayers();
    }

    // Method for the chancecards that gives the player cash
    public void addCashToCurrentPlayer(int amount) {
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
    public WithDrawOutCome withdrawCashFromCurrentPlayer(int amount) {
        return this.withDrawCashFromPlayer(currentPlayer, amount);
    }

    public WithDrawOutCome withDrawCashFromPlayer(Player player, int amount) {
        if (player.getCash() >= amount) {
            player.addCash(-amount);
            return WithDrawOutCome.OK;
        } else return WithDrawOutCome.INSUFFICIENT_CASH;
    }

    public int getCurrentUserFunds() {
        return currentPlayer.getCash();
    }

    public void promptCurrentUserPropertySale() {
        // TODO promtsalestuff
        // opdate userfunds after sale
        // work for further work (videreudvikling)
    }

    public void endGameCurrentUser() {
        players.removePlayer(currentPlayer);
        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        gui.showMessage(currentPlayer + ", du har tabt, og er derfor ude af spillet");
        //TODO rigtig player
    }

    public void makePile() { // creates a new pile with the cards made in pile and shuffles them
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


    public void startGame() {
        // velkomst besked
        gui.showMessage("Velkommen til matador!");

        // valg af antal spillere
        numberOfPlayers = Integer.parseInt(gui.getUserSelection("Vælg antal spillere:", "2", "3", "4", "5", "6"));
        String[] playerNames = new String[numberOfPlayers];

        //navngiver spillere lol
        nameSetUpStartGame(playerNames);

        //Liste over spillere og deres navne
        players = new PlayerList(numberOfPlayers, playerNames);

        // laver spillebrkker til spillere
        GUI_Car[] cars = GUI_Cars.makeCars(numberOfPlayers);

        // laver et array af start indhold for spillere
        guiPlayers = new GUI_Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            guiPlayers[i] = new GUI_Player(players.getPlayer(i).getName(), Player.defaultCash(), cars[i]);
        }
        fieldAction.setGame(this);

        //Sætter startfeltet
        currentField = gui.getFields()[0];

        //Indsætter viuel rep. af spillere + deres biler + penge
        for (int i = 0; i < numberOfPlayers; i++) {
            gui.addPlayer(guiPlayers[i]);
            currentField.setCar(guiPlayers[i], true);
        }

        //Opdaterer visuel rep af penge på gui'en
        updateGUICash();
        makePile();

        gui.showMessage("Nu starter spillet, held og lykke!");

        //holder spillet i gang indtil gameOver
        while (!gameOver) {
            round();
        }
    }

    public void nameSetUpStartGame(String[] allNames){

        // indtastning af navne på spillere
        for (int i = 0; i < numberOfPlayers; i++) {
            Boolean nameAlreadyExist = true;
            Boolean foundMatch = false;
            String name = null;
            while (nameAlreadyExist) {
                //tjekker om spilleren har indtastet et tomt navn
                name = gui.getUserString("Indtast navn på den " + (i + 1) + ". Spiller");
                if (name.equals("")) {
                    gui.getUserButtonPressed("Du SKAL vælge et navn", "Fortsæt");
                } else {
                    if (name.length() > 16) {
                        gui.getUserButtonPressed("Navnet er for langt (max 16 symboler)", "Fortsæt");
                    } else { //tjekker om det valgte navn matcher en af de andres navne
                        for (int k = 0; k < allNames.length; k++) {
                            if (name.equals(allNames[k])) {
                                foundMatch = true;
                            }
                        }
                        if (foundMatch) {
                            gui.getUserButtonPressed("Dette navn er allerede taget, vælg et andet", "Fortsæt");
                            foundMatch = false;
                        } else if (!foundMatch) {
                            allNames[i] = name;
                            nameAlreadyExist = false;
                        }
                    }
                }
            }

        }
    }

    public void round() {
        //for-loop hver spiller og kalder turn()
        for (int i = 0; i < players.getPlayers().length; i++) {
            turn(i);
        }
    }

    public void turn(int playerID) {turn(playerID, 1);}
    public void turn(int playerID, int turnNumber) {
        if (!gameOver) {
            currentPlayer = players.getPlayer(playerID);
            currentGUIPlayer = guiPlayers[playerID];

            if (!currentPlayer.isJailed()) {
                String choice = gui.getUserSelection("Det er nu " + players.getPlayer(playerID).getName() + "'s tur", "Rull med terningerne", "Køb et hus", "Køb et hotel", "Sælg et hus", "Sælg et hotel", "Skip");
                if (choice == "Rull med terningerne") {
                    diceCup.roll();
                    gui.setDice(diceCup.getDice()[0].getValue(), diceCup.getDice()[1].getValue());
                    moveCurrentPlayer(diceCup.getTotalValue(), true); //move handles landing on fields etc.

                    if (turnNumber < 3) {
                        if (diceCup.isDoubles()) turn(playerID, turnNumber + 1);
                    } else {
                        gui.showMessage("Du har slået 2 ens 3 gange i streg, og ryger derfor direkte i fængsel.");
                        fieldAction.landOnJail();
                    }
                } else if (choice == "Køb et hus") {
                    buyHouse(playerID);
                } else if (choice == "Køb et hotel") {
                    buyHotel(playerID);
                } else if (choice == "Sælg et hus") {
                    sellHouse(playerID);
                } else if (choice == "Sælg et hotel") {
                    sellHotel(playerID);
                }
            }

            //handling of jailed players
            else {
                currentPlayer.jailTurns += 1;
                gui.showMessage("Åh nej! " + currentPlayer.getName() + " du er i fængsel. Hvis du har et kort til at blive løsladt vil det automatisk blive brugt. ");
                if (currentPlayer.getGetOutOfJailFreeCards() > 0) {
                    currentPlayer.setGetOutOfJailFreeCards(currentPlayer.getGetOutOfJailFreeCards() - 1);
                    currentPlayer.setJailed(false);
                    turn(playerID);
                } else {
                    String choice = gui.getUserSelection("Hvordan vil du forsøge at komme ud?", "Betal bøden på 1000", "Prøve at slå 2 ens med terningerne");
                    if (choice == "Betal bøden på 1000") {
                        payBail(playerID);
                    } else if (choice == "Prøve at slå 2 ens med terningerne") {
                        rollToGetOutOfJail(playerID);
                    }
                }
            }
        }
        updateGUICash();
    }

    private void payBail(int playerID) {
        if (currentPlayer.getCash() >= 1000) {
            currentPlayer.addCash(-1000);
            currentPlayer.setJailed(false);
            turn(playerID);
        } else {
            if (currentPlayer.getJailTurns() < 3) {
                gui.showMessage("Du har ikke råd. Slå med terningerne i stedet.");
                rollToGetOutOfJail(playerID);
            } else {
                currentPlayer.setJailed(false);
                turn(playerID);
            }
        }
    }

    private void rollToGetOutOfJail(int playerID) {
        for (int i = 0; i < 3; i++) {
            diceCup.roll();
            gui.setDice(diceCup.getDice()[0].getValue(), diceCup.getDice()[1].getValue());
            if (diceCup.isDoubles()) {
                moveCurrentPlayer(diceCup.getTotalValue(), true);
                currentPlayer.setJailed(false);
                turn(playerID);
                break;
            } else {
                gui.showMessage("Desværre. Prøv igen");
            }
        }

        if (currentPlayer.isJailed()) {
            if (currentPlayer.getCash() >= 1000) {
                currentPlayer.addCash(-1000);
                currentPlayer.setJailed(false);
                gui.showMessage("Det lykkedes ikke at slå 2 ens. Hvis du har råd, betaler du nu bøden på 1000. Ellers må du prøve næste gang det bliver din tur. Du har siddet inde i " + currentPlayer.jailTurns + " runder ud af 3.");
            } else if (currentPlayer.jailTurns > 2) {
                currentPlayer.setJailed(false);
                gui.showMessage("Du har siddet inde længe nok. I din næste tur er du fri.");
            } else {
                gui.showMessage("Du lykkedes ikke i at komme ud af fængslet denne runde. Prøv igen næste gang. Du har siddet inde i " + currentPlayer.jailTurns + " runder ud af 3.");
            }
        }

    }

    /**
     * @param playerID
     * @buyHouse methode der køber huse, hvis det er muligt, ellers sender den spilleren tilbage
     * til turn.menu
     */
    private void buyHouse(int playerID) {
        int totalOwnedFields = 0;
        FieldStreet[] ownedFields = new FieldStreet[40];  // Der er ikke 40 fieldStreets på brættet, men det går nok
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (!(this.gameboard.getArray()[i] instanceof FieldStreet)) {
                continue;
            }
            // Pt tjekker vi alle felter i en gruppe alle de gange hvor feltet er der (men it works!)
            // (Så hvis en gruppe felter har 5 felter så tjekkes det hele 5 gange i stedet for kun 1 gang)
            fieldAction.checkColorGroupOwned(i);
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
        String streetChoice = gui.getUserSelection("Hvor vil du købe et hus?", streetSelection);
        int streetChoiceInteger = 0;
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (this.gameboard.getArray()[i].getPropertyName() == streetChoice) {
                streetChoiceInteger = i;
                break;
            }
        }

        ((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).buildHouse();
        ((GUI_Street) this.fields[streetChoiceInteger]).setHouses(((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).getHouses());
        updateGUICash();
        gui.showMessage(players.getPlayer(playerID).getName() + " har købt et hus på " + streetChoice + ".");
        turn(playerID);
    }

    /**
     * sælger huse hvis det er muligt
     *
     * @param playerID
     * @sellHouse
     */
    private void sellHouse(int playerID) {
        int totalOwnedFields = 0;
        FieldStreet[] ownedFields = new FieldStreet[40];
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (!(this.gameboard.getArray()[i] instanceof FieldStreet)) {
                continue;
            }
            FieldStreet field_i = (FieldStreet) this.gameboard.getArray()[i];
            if (field_i.getOwner() == this.currentPlayer && field_i.canSellHouse()) {
                ownedFields[totalOwnedFields] = field_i;
                totalOwnedFields++;
            }
        }
        if (totalOwnedFields == 0) {
            gui.showMessage("Det ser ikke ud til at du kan sælge nogen huse");
            turn(playerID);
            return;
        }
        String[] streetSelection = new String[totalOwnedFields];
        for (int i = 0; i < totalOwnedFields; i++) {
            streetSelection[i] = ownedFields[i].getPropertyName();
        }
        String streetChoice = gui.getUserSelection("Hvor vil du sælge et hus?", streetSelection);
        int streetChoiceInteger = 0;
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (this.gameboard.getArray()[i].getPropertyName() == streetChoice) {
                streetChoiceInteger = i;
                break;
            }
        }
        ((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).removeHouse();
        ((GUI_Street) this.fields[streetChoiceInteger]).setHouses(((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).getHouses());
        updateGUICash();
        gui.showMessage(players.getPlayer(playerID).getName() + " har solgt et hus på " + streetChoice + ".");
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
        String streetChoice = gui.getUserSelection("Hvor vil du købe et hotel?", streetSelection);
        int streetChoiceInteger = 0;
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (this.gameboard.getArray()[i].getPropertyName() == streetChoice) {
                streetChoiceInteger = i;
                break;
            }
        }
        ((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).buildHotel();
        ((GUI_Street) this.fields[streetChoiceInteger]).setHotel(true);
        updateGUICash();
        gui.showMessage(players.getPlayer(playerID).getName() + " har købt et hotel på " + streetChoice + ".");
        turn(playerID);
    }

    private void sellHotel(int playerID) {
        int totalOwnedFields = 0;
        FieldStreet[] ownedFields = new FieldStreet[40];
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (!(this.gameboard.getArray()[i] instanceof FieldStreet)) {
                continue;
            }
            FieldStreet field_i = (FieldStreet) this.gameboard.getArray()[i];
            if (field_i.getOwner() == this.currentPlayer && field_i.canSellHotel()) {
                ownedFields[totalOwnedFields] = field_i;
                totalOwnedFields++;
            }
        }
        if (totalOwnedFields == 0) {
            gui.showMessage("Det ser ikke ud til at du kan sælge nogen hoteller");
            turn(playerID);
            return;
        }
        String[] streetSelection = new String[totalOwnedFields];
        for (int i = 0; i < totalOwnedFields; i++) {
            streetSelection[i] = ownedFields[i].getPropertyName();
        }
        String streetChoice = gui.getUserSelection("Hvor vil du sælge et hotel?", streetSelection);
        int streetChoiceInteger = 0;
        for (int i = 0; i < this.gameboard.getArray().length; i++) {
            if (this.gameboard.getArray()[i].getPropertyName() == streetChoice) {
                streetChoiceInteger = i;
                break;
            }
        }
        ((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).removeHotel();
        ((GUI_Street) this.fields[streetChoiceInteger]).setHotel(false);
        ((GUI_Street) this.fields[streetChoiceInteger]).setHouses(((FieldStreet) this.gameboard.getArray()[streetChoiceInteger]).getHouses());
        updateGUICash();
        gui.showMessage(players.getPlayer(playerID).getName() + " har købt et hotel på " + streetChoice + ".");
        turn(playerID);
    }

    public void moveCurrentPlayer(int dist, boolean grantCrossStartBonus) { //added boolean that checks if they cross START
        currentField = gui.getFields()[currentPlayer.getPlayerPosition()]; //makes sure the gui will remove the car of the current player's position.
        currentPlayer.movePlayer(dist, gameboard.getArray().length); //changes player's position number
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
        fieldAction.landOnField(diceCup.getTotalValue());
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

    public void endGame(Player currentPlayer) {
        gameOver = true;
        gui.showMessage(currentPlayer + " du er sidste mand stående, da alle andre spillere har tabt. Stort tillykke med sejren!");
        gui.showMessage("Tryk ok for at afslutte");
        gui.close();
    }

    private void updateGUICash() {
        for (int i = 0; i < players.getPlayers().length; i++) {
            guiPlayers[i].setBalance(players.getPlayers()[i].getCash());
        }
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public GUI_Player getCurrentGUIPlayer() {
        return currentGUIPlayer;
    }

    public Gameboard getGameboard() {
        return this.gameboard;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int position) {
        currentField = gui.getFields()[position]; //makes sure the gui will remove the car of the current player's position.
        currentPosition = position; //set current placement
    }

    public GUI_Field getCurrentField() {
        return currentField;
    }

    public GUI getGui() {
        return gui;
    }

    public GUI_Field[] getFields() {
        return fields;
    }


    public void testStartGame(){

        numberOfPlayers = 3;
        String[] playerNames = {"Katrine", "Simon", "Mike"};

        //Liste over spillere og deres navne
        players = new PlayerList(numberOfPlayers, playerNames);
        currentPlayer = players.getPlayers()[0];
        fieldAction.setGame(this);

        //Sætter startfeltet
        currentField = gui.getFields()[0];

        makePile();
    }


}
