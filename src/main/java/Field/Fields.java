package Field;

import Game.Player;

abstract public class Fields {
    public abstract Player getOwner();

    public abstract void setOwner(Player owner);

    public abstract boolean getOwned();

    public abstract void setOwned(boolean b);

    public abstract int getStreetPrice();

    public abstract char getType();

    public abstract int getCurrentRent();

    public abstract void setCurrentRent();

    public abstract void setRentPriceMultiplier(int b);

    public abstract void setRentPrice(int currentRent);

    public abstract String getDisplayPrice();

    public abstract void setDisplayPrice(String displayPrice);

}


