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

    public abstract void setCurrentRent(int Houses);

    public abstract void setRentPriceMultiplier(int b);

    public abstract void setRentPrice(int currentRent);

    public abstract String getPropertyName();// property mane from fieldstreet class

    public abstract String FieldStart();// name from Fieldstart class

    public abstract String getDisplayPrice();//display price from fieldstreet class

    public abstract void setDisplayPrice(String displayPrice);

}


