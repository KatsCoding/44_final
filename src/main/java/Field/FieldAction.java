package Field;

import Game.Game;
import Game.PayTaxes;

public class FieldAction {

    Game game;
    PayTaxes payTaxes;

    public void landOnField(int diceValue) {
        if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldStreet) {
            landOnStreet();
        } else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldJail) {
            landOnJail();
        } else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldChanceCard) {
            landOnChance();
        } else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldShips) {
            landOnShips();
        } else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof FieldBrewery) {
            landOnBrewery(diceValue);
        }
        else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof IncomeTax) {
            landOnTaxField();
        }
        else if (game.getGameboard().getArray()[game.getCurrentPosition()] instanceof ExtraOrdinaryTax) {
            landOnExtraOrdinaryTaxField();
        }
    }


    public void landOnStreet() {
        if (!game.getGameboard().getArray()[game.getCurrentPosition()].getOwned()) { //checks if NOT owned
           String choice =  game.getGui().getUserSelection("Dette felt er frit, vil du købe det?", "Ja tak, jeg køber det", "Nej tak, jeg vil spare på mine penge");
            if ( choice == "Ja tak, jeg køber det") {
                if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getStreetPrice()) {
                    game.getGui().showMessage("Desværre du Har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge nogle huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej gider ikke have det alligevel");
                    //TODO indsæt salg af huse her for at få råd

                } else { //buys property and assigns player's name to the game.getGui().
                    game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                    game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                    game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getStreetPrice())); //pays for the property
                    checkColorGroupOwned(game.getCurrentPosition());
                }
            }

        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()) {//checks if you're poor
                    game.getGui().showMessage("Du har ikke råd til at betale lejen. Game over :(");
                    boolean poor = true;
                    while (poor) {
                        mortgage();
                    }


                } else {
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent()));
                    game.getGameboard().getArray()[game.getCurrentPosition()].getOwner().addCash(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent());
                }
            }
        }
    }

    public void mortgage() {

    }

    public void landOnShips() {

        if (!game.getGameboard().getArray()[game.getCurrentPosition()].getOwned()) { //checks if NOT owned
            String choice = game.getGui().getUserSelection("Hey skibet her er frit, vil du købe det?", "Ja, køb skibet", "Nej tak, jeg vil spare på mine penge");
            if ( choice == "Ja, køb skibet") {
                if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getPrice()) {
                    game.getGui().showMessage("Desværre du har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej, jeg vil ikke købe det alligevel");

                } else { //buys property and assigns player's name to the game.getGui().
                    game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                    game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                    game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getPrice())); //pays for the property
                    checkColorGroupOwned(game.getCurrentPosition());
                }
            }

        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < (game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().ShipOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner()))) {//checks if you're poor
                    game.getGui().showMessage("Desværre du har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej, jeg vil ikke købe det alligevel");
                } else {
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().ShipOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner())));
                    game.getGameboard().getArray()[game.getCurrentPosition()].getOwner().addCash(game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().ShipOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner()));
                    //System.out.println(game.getGameboard().getArray()[game.getCurrentPosition()].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
    }

    public void landOnBrewery(int diceValue) {
        if (!game.getGameboard().getArray()[game.getCurrentPosition()].getOwned()) { //checks if NOT owned
           String choice = game.getGui().getUserSelection("Dette felt er frit, vil du købe det?", "Ja tak, jeg køber det", "Nej tak, jeg vil spare på mine penge");
            if ( choice == "Ja tak, jeg køber det") {
                if (game.getCurrentPlayer().getCash() < game.getGameboard().getArray()[game.getCurrentPosition()].getPrice()) {
                    game.getGui().showMessage("Desværre du har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej, jeg vil ikke købe det alligevel");


                } else { //buys property and assigns player's name to the game.getGui().
                    game.getGameboard().getArray()[game.getCurrentPosition()].setOwned(true);
                    game.getGameboard().getArray()[game.getCurrentPosition()].setOwner(game.getCurrentPlayer());
                    game.getGui().getFields()[game.getCurrentPosition()].setSubText(game.getCurrentPlayer().getName()); //game.getGui() property owner name updated here
                    game.getCurrentPlayer().addCash(-(game.getGameboard().getArray()[game.getCurrentPosition()].getPrice())); //pays for the property
                    checkColorGroupOwned(game.getCurrentPosition());
                }
            }

        } else { //if the property is already owned
            if (game.getGameboard().getArray()[game.getCurrentPosition()].getOwner() != game.getCurrentPlayer()) { //Only does something if the player doesn't own the property himself
                if (game.getCurrentPlayer().getCash() < (diceValue * game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().breweryOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner()))) {//checks if you're poor
                    game.getGui().showMessage("Desværre du har ikke råd til at købe feltet");
                    game.getGui().getUserSelection("Vil du sælge huse eller egendom for at få råd?", "Ja lad os sælge nogle huse", "ja lad os sælge nogle egendomme", "Nej, jeg vil ikke købe det alligevel");
                } else {
                    game.getCurrentPlayer().addCash(-(diceValue * game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().breweryOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner())));
                    game.getGameboard().getArray()[game.getCurrentPosition()].getOwner().addCash(diceValue * game.getGameboard().getArray()[game.getCurrentPosition()].getCurrentRent() * game.getGameboard().breweryOwnerCounter(game.getGameboard().getArray()[game.getCurrentPosition()].getOwner()));
                    //System.out.println(game.getGameboard().getArray()[game.getCurrentPosition()].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
    }

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
                    ((FieldStreet) f).setCanBuild(true);
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
            if (currentField instanceof FieldStreet) {
                for (Fields f : group) {
                    ((FieldStreet) f).setCanBuild(false);
                }
            }
        }
    }

    //TODO have to make sure all things in this method are correct and working the way its set up with the rules for then jailed
    public void landOnJail() {
        game.getGui().showMessage("Du er røget i fængsel!");
        game.getCurrentField().setCar(game.getCurrentGUIPlayer(), false); //sets game.getGui() player's position on game.GetCurrentField()

        game.getCurrentPlayer().setPlayerPosition(10); //sets player position to jail cell
        game.setCurrentPosition(game.getCurrentPlayer().getPlayerPosition());  //updates game.getCurrentPosition()
        game.getCurrentPlayer().setJailed(true);
        game.getCurrentField().setCar(game.getCurrentGUIPlayer(), true); //sets game.getGui() player's position on game.GetCurrentField()}
    }

    //TODO just like with jail make sure the method and rules match with the setup for this

    public void landOnChance() {
        game.landOnChance(); // landOnChance implemented in game class (which makes the player draw a card)
    }

    public void landOnTaxField(){
        String choice = game.getGui().getUserSelection("Du er landet på et skattefelt. Hvordan vil du betale?", "Betal med 10% af mit samlede antal værdier", "Betal 4000");
        payTaxes.incomeTax(choice, game.getCurrentPlayer());
    }

    public void landOnExtraOrdinaryTaxField(){
    game.getGui().showMessage("Statsskat. Betal 2000");
        payTaxes.extraOrdinaryTax(game.getCurrentPlayer());
    }

    public void setGame(Game game) {
        this.game = game;
        payTaxes  = new PayTaxes(game.getGameboard());
    }

}
