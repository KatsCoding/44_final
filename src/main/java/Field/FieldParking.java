package Field;

import Game.Player;

public class FieldParking extends Fields{
    FieldParking(String name){

    }

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
        return null;
    }

    @Override
    public String FieldStart() {
        return null;
    }

    @Override
    public String getDisplayPrice() {
        return null;
    }

    @Override
    public void setDisplayPrice(String displayPrice) {

    }
}
