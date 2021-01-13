package Field;

import Game.Player;

public class FieldBrewery extends Fields {
    String name;
    int price;
    Player owner;
    boolean owned;

    FieldBrewery(String name,int price, boolean owned, Player owner,char type) {
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.owned = owned;
    }
public int getPrice(){
        return price;
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
    public void setDisplayPrice(String displayPrice) {

    }
}