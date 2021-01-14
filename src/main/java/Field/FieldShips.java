package Field;

import Game.Player;

public class FieldShips extends Fields {
    int price;
    String propertyName;
    String displayPrice;
    boolean owned;
    Player owner;
    char type;

    public FieldShips( String propertyName,String displayPrice,int price, boolean owned, Player owner, char type) {
        this.price = price;
        this.propertyName = propertyName;
        this.displayPrice = displayPrice;
        this.owned = owned;
        this.owner = owner;
        this.type = type;
    }

    public int getPrice(){
        return price;
    }

    public Player getOwner() {
        return owner;
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

    public char getType() {
        return type;
    }

    @Override
    public int getCurrentRent() {
        return 0;
    }


    @Override
    public void setRentPriceMultiplier(int b) {

    }


    @Override
    public String getPropertyName() {
        return propertyName;
    }

   // @Override
   // public String FieldStart() {
   //     return propertyName;
   // }

    @Override
    public String getDisplayPrice() {
        return displayPrice;
    }

    @Override
    public void setDisplayPrice(String displayPrice) {

    }
}