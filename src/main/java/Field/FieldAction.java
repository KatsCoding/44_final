package Field;

import Game.Player;
import Game.PlayerList;

import Game.Game;

import java.util.Arrays;

public class FieldAction {

    boolean[] usedChanceCards = new boolean[18];
    Game game;

    public void landOnField(int i) {
        if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldStreet) {
            landOnStreet();
        } else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldJail) {
           landOnJail();
       // TODO insert FieldChance here
        } else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldChanceCard) {
            landOnChance();
        } else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldShips) {
            landOnShips();
        } else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldBrewery) {
            landOnBrewery();
        }
    }

    public void landOnStreet() {
        if (!game.getGameboard().getArray()[game.getCurrentPosition()].getOwned()) { //checks if NOT owned
            game.getGui().getUserSelection("Hey feltet her er frit vil du købe det?", "KØB flet her min ven", "Nej tak spare på mine penge");
            if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getStreetPrice()){
                game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej gider ikke have det alligevel");


            }
            else{ //buys property and assigns player's name to the game.getGui().
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getStreetPrice())); //pays for the property
                checkColorGroupOwned(game.getCurrentPosition());
            }


        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()){//checks if you're poor
                    game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "");}
                else {
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()));
                    game.getGameboard().getArray()[game.getCurrentPosition()].getOwner().addCash(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent());
                    //System.out.println(game.getGameboard().getArray()[game.getCurrentPosition()].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
    }

    public void landOnShips() {
        if (!game.getGameboard().getArray()[game.getCurrentPosition()].getOwned()) { //checks if NOT owned
            game.getGui().getUserSelection("Hey feltet her er Skibet her vil du købe det?", "KØB Skibet her min ven", "Nej tak spare på mine penge");
            if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getPrice()){
                game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej gider ikke have det alligevel");


            }
            else{ //buys property and assigns player's name to the game.getGui().
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getPrice())); //pays for the property
                checkColorGroupOwned(game.getCurrentPosition());
            }


        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()){//checks if you're poor
                    game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "");}
                else {
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()));
                    game.getGameboard().getArray()[game.getCurrentPosition()].getOwner().addCash(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent());
                    //System.out.println(game.getGameboard().getArray()[game.getCurrentPosition()].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
    }

    public void landOnBrewery() {
        if (!game.getGameboard().getArray()[game.getCurrentPosition()].getOwned()) { //checks if NOT owned
            game.getGui().getUserSelection("Hey feltet her er frit vil du købe det?", "KØB flet her min ven", "Nej tak spare på mine penge");
            if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getPrice()){
                game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej gider ikke have det alligevel");


            }
            else{ //buys property and assigns player's name to the game.getGui().
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getPrice())); //pays for the property
                checkColorGroupOwned(game.getCurrentPosition());
            }


        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()){//checks if you're poor
                    game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "");}
                else {
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()));
                    game.getGameboard().getArray()[game.getCurrentPosition()].getOwner().addCash(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent());
                    //System.out.println(game.getGameboard().getArray()[game.getCurrentPosition()].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
    }

    //TODO has to make it so its only as long as there non houses build on the group.
    private void checkColorGroupOwned(int propertyID) {
        char type = game.getGameboard().getArray()[propertyID].getType(); //sets type equal to purchased property's type
        for (int i = 0; i < game.getGameboard().getArray().length; i++) {
            if (game.getGameboard().getArray()[i].getType() == type && (i != propertyID)) { //checks for the matching property
                if (game.getGameboard().getArray()[i].getOwner() == game.getGameboard().getArray()[propertyID].getOwner()) { //checks if both properties are now owned by the same person or not.
                    game.getGameboard().getArray()[i].setRentPriceMultiplier(2);
                    game.getGameboard().getArray()[propertyID].setRentPriceMultiplier(2);
                    //kald methode så canBuild er true
                } else {
                    game.getGameboard().getArray()[i].setRentPriceMultiplier(1);
                    game.getGameboard().getArray()[propertyID].setRentPriceMultiplier(1);
                }
//                game.getGameboard().getArray()[i].setRentPrice(game.getGameboard().getArray()[i].getCurrentRent()); //updates rent price with the new multiplier
                //game.getGameboard().getArray()[propertyID].setRentPrice(game.getGameboard().getArray()[propertyID].getCurrentRent());
                // TODO fix game.getGameboard() setCurrentRent
                // game.getGameboard().getArray()[2].setCurrentRent();
            }


        }

    }
    //TODO have to make sure all things in this method are correct and working the way its set up with the rules for then jailed
    public void landOnJail() {

        game.getCurrentField().setCar(game.getCurrentGUIPlayer(), false); //sets game.getGui() player's position on game.GetCurrentField()

        game.getCurrentPlayer().setPlayerPosition(10); //sets player position to jail cell
        game.setCurrentPosition(game.getCurrentPlayer().getPlayerPosition());  //updates game.getCurrentPosition()
        game.getCurrentPlayer().setJailed(true);
        game.getCurrentField().setCar(game.getCurrentGUIPlayer(), true); //sets game.getGui() player's position on game.GetCurrentField()}
    }
    //TODO just like with jail make sure the method and rules match with the setup for this
    public int rollChanceCard() {
        return (int) (Math.random() * usedChanceCards.length);
    }

    public void landOnChance() {
        game.landOnChance(); // landOnChance implemented in game class (which makes the player draw a card)
    }

    public void setGame(Game game) {
        this.game = game;
    }
}