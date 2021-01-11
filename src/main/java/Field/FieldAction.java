package Field;

import Game.Player;
import Game.PlayerList;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import Game.Game;

import java.util.Arrays;

public class FieldAction {

    private int currentPlacement = 0;
    boolean[] usedChanceCards = new boolean[18];
    PlayerList players;
    GUI_Player[] guiPlayers;
    Player currentPlayer;
    GUI_Player currentGUIPlayer;
    private int o = 0;
    GUI gui;
    GUI_Field currentField;
    Fields[] gameboard;
    Game game;


    public void landOnField(int i) {

        if (gameboard[currentPlacement] instanceof FieldStreet) {
            landOnStreet();
        } else if (gameboard[currentPlacement] instanceof FieldJail) {
            landOnJail();
        } else if (gameboard[currentPlacement] instanceof FieldChanceCard) {
            landOnChance();
        }
    }

    public void landOnStreet() {//TODO need to incorporate two things either that auction function or its possible to another to buy it

        if (!gameboard[currentPlacement].getOwned()) { //checks if NOT owned
            gui.getUserSelection("Hey feltet her er frit vil du købe det?", "KØB flet her min ven", "Nej tak spare på mine penge");
            if (currentPlayer.getCash() < gameboard[currentPlacement].getStreetPrice()){
                gui.showMessage("Desværre du Har ikke råd til at købe feltet");
                gui.getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej gider ikke have det alligevel");
            }
            else{ //buys property and assigns player's name to the gui.
                gameboard[currentPlacement].setOwned(true);
                gameboard[currentPlacement].setOwner(currentPlayer);
                gui.getFields()[currentPlacement].setSubText(currentPlayer.getName()); //gui property owner name updated here
                currentPlayer.addCash(-(gameboard[currentPlacement].getStreetPrice())); //pays for the property
                checkColorGroupOwned(currentPlacement);
            }

        /*TODO has to make the method so it it cheks if all of the same type is owned by the same person and
       TODO only dobbles the rent if that^ and there are no houses or hotel builds on the ground to met the requirements*/
        } else { //if the property is already owned
            if (gameboard[currentPlacement].getOwner() != currentPlayer) { //Only does something if the player doesn't own the property himself
                if (currentPlayer.getCash() < gameboard[currentPlacement].getCurrentRent()){//checks if you're poor
                    gui.showMessage("Desværre du Har ikke råd til at betal din leje");
                    gui.getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "");}

                else {
                    currentPlayer.addCash(-(gameboard[currentPlacement].getCurrentRent()));
                    gameboard[currentPlacement].getOwner().addCash(gameboard[currentPlacement].getCurrentRent());
                    //System.out.println(gameboard[currentPlacement].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
    }

    //TODO has to make it so its only as long as there non houses build on the group.
    private void checkColorGroupOwned(int propertyID) {
        char type = gameboard[propertyID].getType(); //sets type equal to purchased property's type
        for (int i = 0; i < gameboard.length; i++) {
            if (gameboard[i].getType() == type && (i != propertyID)) { //checks for the matching property
                if (gameboard[i].getOwner() == gameboard[propertyID].getOwner()) { //checks if both properties are now owned by the same person or not.
                    gameboard[i].setRentPriceMultiplier(2);
                    gameboard[propertyID].setRentPriceMultiplier(2);
                } else {
                    gameboard[i].setRentPriceMultiplier(1);
                    gameboard[propertyID].setRentPriceMultiplier(1);
                }
                gameboard[i].setRentPrice(gameboard[i].getCurrentRent()); //updates rent price with the new multiplier
                gameboard[propertyID].setRentPrice(gameboard[propertyID].getCurrentRent());
                // TODO fix gameboard setCurrentRent
                // gameboard[2].setCurrentRent();
            }


        }

    }
    //TODO have to make sure all things in this method are correct and working the way its set up with the rules for then jailed
    public void landOnJail() {

        currentField.setCar(currentGUIPlayer, false); //sets gui player's position on currentField

        currentPlayer.setPlayerPosition(10); //sets player position to jail cell
        currentPlacement = currentPlayer.getPlayerPosition(); //updates currentPlacement
        currentPlayer.setJailed(true);
        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPlacement]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField}
    }

    public void landOnChance() {
        game.landOnChance(); // landOnChance implemented in game class (which makes the player draw a card)
    }

}