package Field;

import Game.Player;

public class FieldBrewery extends Fields {
    String name;
    int price;
    Player owner;
    boolean owned;
    char type;

    public FieldBrewery(String name,int price, boolean owned, Player owner,char type) {
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.owned = owned;
        this.type = type;
    }

    public int getPrice(){
        return price;
}

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Player owner) {

    }

    @Override
    public boolean getOwned() {
        return owned;
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


    public int getCurrentRent() {
        return 100;
    }


    @Override
    public void setRentPriceMultiplier(int b) {

    }


    @Override
    public String getPropertyName() {
        return name;
    }

  // @Override
  // public String FieldStart() {
  //     return null;
  // }

    @Override
    public String getDisplayPrice() {
        return null;
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