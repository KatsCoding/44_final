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
        this.owner = owner;
    }

    @Override
    public boolean getOwned() {
        return owner != null;
    }

    @Override
    public void setOwned(boolean b) {
        owned = b;
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
        return 500;
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
    public int getHouses() {
        return 0;
    }

    @Override
    public int getHousePrice() {
        return 0;
    }

    @Override
    public boolean useMortgage() {
        if(!this.getOwned()){
            return false;
        }
        return true;
    }

    @Override
    public int getMortgage() {
        return price/2;
    }

}