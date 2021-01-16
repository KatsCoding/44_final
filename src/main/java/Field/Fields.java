package Field;

import Game.Player;

abstract public class Fields {
    public abstract Player getOwner();

    public abstract void setOwner(Player owner);

    public abstract boolean getOwned();

    public abstract void setOwned(boolean b);

    public abstract int getStreetPrice();

    public abstract int getPrice();

    public abstract char getType();

    public abstract int getCurrentRent();

    public abstract void setRentPriceMultiplier(int b);

    public abstract String getPropertyName();// property mane from fieldstreet class

    public String getSpecialFieldName(){return "";}


    public abstract String getDisplayPrice();//display price from fieldstreet class

    public abstract void setDisplayPrice(String displayPrice);

    public abstract int getHouses();

    public abstract int getHousePrice();

    public abstract boolean useMortgage();

    public abstract int getMortgage();

}


