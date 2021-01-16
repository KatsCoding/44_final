package Field;

import Game.Player;

public class FieldChanceCard extends Fields{
    String propertyName;

    public FieldChanceCard(String name) { propertyName = name; }

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
    public int getPrice() {
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
        return null;
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
        return false;
    }

    @Override
    public int getMortgage() {
        return 0;
    }
}
