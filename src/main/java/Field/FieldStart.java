package Field;

import Game.Player;

//TODO Katrine synes denne klasse burde omdefineres da man kan lave dens funktion via 2 linjer i game, som vi også brugte i del_3.

public class FieldStart extends Fields{
    String propertyName;

    public FieldStart(String name) { propertyName = name; }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public void setOwner(Player owner) {

    }

    @Override
    public boolean getOwned() {
        return false;
    }

    @Override
    public void setOwned(boolean b) {

    }

    @Override
    public int getStreetPrice() {
        return 0;
    }

    @Override
    public char getType() {
        return 0;
    }

    @Override
    public int getCurrentRent() {
        return 0;
    }

    @Override
    public void setCurrentRent(int Houses) {

    }

    @Override
    public void setRentPriceMultiplier(int b) {

    }

    @Override
    public void setRentPrice(int currentRent) {

    }

    @Override
    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public String FieldStart() {
        return propertyName;
    }

    @Override
    public String getDisplayPrice() {
        return null;
    }

    @Override
    public void setDisplayPrice(String displayPrice) {

    }

}
