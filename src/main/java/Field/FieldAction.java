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
    //boolean[] usedChanceCards = new boolean[18];
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
       // TODO insert FieldChance here
       // } else if (gameboard[currentPlacement] instanceof FieldChance) {
       //     landOnChance();
        }
    }
   public void landOnStreet() {
       if (!gameboard[currentPlacement].getOwned()) { //checks if NOT owned
           if (currentPlayer.getCash() < gameboard[currentPlacement].getStreetPrice()){

           }
           else{ //buys property and assigns player's name to the gui.
               gameboard[currentPlacement].setOwned(true);
               gameboard[currentPlacement].setOwner(currentPlayer);
               gui.getFields()[currentPlacement].setSubText(currentPlayer.getName()); //gui property owner name updated here
               currentPlayer.addCash(-(gameboard[currentPlacement].getStreetPrice())); //pays for the property
               checkColorGroupOwned(currentPlacement);
           }


       } else { //if the property is already owned
           if (gameboard[currentPlacement].getOwner() != currentPlayer) { //Only does something if the player doesn't own the property himself
               if (currentPlayer.getCash() < gameboard[currentPlacement].getCurrentRent()){//checks if you're poor
                   gui.showMessage("Desværre du Har ikke råd til at købe feltet");
                   gui.getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "");}
               else {
                   currentPlayer.addCash(-(gameboard[currentPlacement].getCurrentRent()));
                   gameboard[currentPlacement].getOwner().addCash(gameboard[currentPlacement].getCurrentRent());
                   //System.out.println(gameboard[currentPlacement].getRentPrice() + l.coinsBeenPaid[o]);
               }
           }
       }
   }

    //has to make it so its only as long as there non houses build on the group.
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

    public void landOnJail() {

        currentField.setCar(currentGUIPlayer, false); //sets gui player's position on currentField

        currentPlayer.setPlayerPosition(6); //sets player position to jail cell
        currentPlacement = currentPlayer.getPlayerPosition(); //updates currentPlacement
        currentPlayer.setJailed(true);
        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPlacement]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField}
    }
/*
    public int rollChanceCard() {
        return (int) (Math.random() * usedChanceCards.length);
    }

    public void landOnChance() {
        boolean cardsLeft = false;
        for (int i = 0; i < usedChanceCards.length; i++) { //Checks to see if at least 1 card is left.
            if (!usedChanceCards[i]) {
                cardsLeft = true;
                break;
            }
        }
        if (!cardsLeft) { //Resets the deck
            Arrays.fill(usedChanceCards, false);
        }


        if (cardsLeft) { //Finds an unused card and calls chance() with it's ID.
            int cardID = rollChanceCard();
            while (usedChanceCards[cardID]) {
                cardID = rollChanceCard();
            }

           //TODO noget med chance og cardID?
           //chance(cardID);
        }
    }*/

}