package Field;

import Game.Player;
import Game.PlayerList;

import Game.Game;
import gui_fields.GUI_Field;
import gui_main.GUI;
import Game.Auction;

import java.util.Arrays;

public class FieldAction {

    boolean[] usedChanceCards = new boolean[18];
    Game game;

    public void landOnField(int i, int dicevalue) {
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
            landOnBrewery(dicevalue);
        }
    }

    public void landOnStreet() {
        if (!game.getGameboard().getArray()[game.getCurrentPosition()].getOwned()) { //checks if NOT owned
            String userChoice = game.getGui().getUserSelection("Hey feltet her er frit vil du købe det?", "KØB flet her min ven", "Nej tak spare på mine penge");
            if (userChoice.equals("Nej tak spare på mine penge")) {
                Player[] otherPlayers = new Player[game.getPlayers().length-1];
                // Liste af spillere som ikke er den nuværende spiller

                Auction auction = new Auction(game.getGameboard().getArray()[game.getCurrentPosition()], otherPlayers, this.game.getGui(), this.game.getCurrentField(), this.game,game.getCurrentPosition());

                auction.startAuction();

            } else if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getStreetPrice()) {
                game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej gider ikke have det alligevel");


            } else { //buys property and assigns player's name to the game.getGui().
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getStreetPrice())); //pays for the property
                checkColorGroupOwned(game.getCurrentPosition());
            }


        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()) {//checks if you're poor
                    game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "ja", "nej");
                } else {
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
            if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getPrice()) {
                game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej gider ikke have det alligevel");


            } else { //buys property and assigns player's name to the game.getGui().
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getPrice())); //pays for the property
                checkColorGroupOwned(game.getCurrentPosition());
            }


        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < (game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().ShipOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner()))) {//checks if you're poor
                    game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "");
                } else {
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().ShipOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner())));
                    game.getGameboard().getArray()[game.getCurrentPosition()].getOwner().addCash(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().ShipOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner()));
                    //System.out.println(game.getGameboard().getArray()[game.getCurrentPosition()].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
    }

    public void landOnBrewery(int dicevalue) {
        if (!game.getGameboard().getArray()[game.getCurrentPosition()].getOwned()) { //checks if NOT owned
            game.getGui().getUserSelection("Hey feltet her er frit vil du købe det?", "KØB flet her min ven", "Nej tak spare på mine penge");
            if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getPrice()) {
                game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej gider ikke have det alligevel");


            } else { //buys property and assigns player's name to the game.getGui().
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getPrice())); //pays for the property
                checkColorGroupOwned(game.getCurrentPosition());
            }


        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < (dicevalue * game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().breweryOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner()))) {//checks if you're poor
                    game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "");
                } else {
                    game.getCurrentPlayer().addCash(-(dicevalue * game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().breweryOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner())));
                    game.getGameboard().getArray()[game.getCurrentPosition()].getOwner().addCash(dicevalue * game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().breweryOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner()));
                    //System.out.println(game.getGameboard().getArray()[game.getCurrentPosition()].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
    }

    //TODO has to make it so its only as long as there non houses build on the group.
    public void checkColorGroupOwned(int propertyID) {
        int count = 0;
        int misses = 0;
        Fields[] fields = game.getGameboard().getArray();
        Fields currentField = fields[propertyID];

        for (Fields f : fields) {
            if (f.getType() == currentField.getType()) {
                if (currentField.getOwner() == f.getOwner()) {
                    //if(f.hasMortgage){ misses++;} else { count++;}
                    count++;
                } else {
                    misses++;
                }
            }
        }

        Fields[] group = new Fields[count];
        int i = 0;
        for (Fields f : fields) {
            if (f.getType() == currentField.getType()) {
                if (currentField.getOwner() == f.getOwner()) {
                    group[i++] = f;
                }
            }
        }

        //ejer alle felter af farve
        if (misses == 0) {
            boolean hasBuilding = false;
            if (currentField instanceof FieldStreet) {
                for (Fields f : group) {
                    ((FieldStreet) f).canBuild = true;
                    if (((FieldStreet) f).getHouses() > 0) {
                        hasBuilding = true;
                        break;
                    }
                    if (((FieldStreet) f).getHotels() > 0) {
                        hasBuilding = true;
                        break;
                    }
                }
            }

            if (!hasBuilding) {
                currentField.setRentPriceMultiplier(2); //todo ret til den rigtige int
            }
        } else {
            for (Fields f : group) {
                ((FieldStreet) f).canBuild = false;
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