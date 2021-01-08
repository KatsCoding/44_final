package Field;
import Game.Player;

import Game.Player;

public class FieldStreet extends Fields{
    String displayPrice;
    String propertyName;
    boolean owned;
    Player owner;
    char type;
    int[] rentPrice = new int[6];
    int rentPriceMultiplier = 1;
    int streetPrice;
    boolean Checked = false;
    int maxOwned;
    int HousePrice;
    int houses;
    int currentRent;


    public FieldStreet(String propertyName, String displayPrice, char type, boolean owned, int streetPrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rent5, int HousePrice, Player owner, int maxOwned){
        // The field base lines for what street fields consist of.
        this.displayPrice = displayPrice;
        this.propertyName = propertyName;
        this.owned = owned;
        this.owner = owner;
        this.type = type;
        this.rentPrice[0] = rent0;
        this.rentPrice[1] = rent1;
        this.rentPrice[2] = rent2;
        this.rentPrice[3] = rent3;
        this.rentPrice[4] = rent4;
        this.rentPrice[5] = rent5;
        this.streetPrice = streetPrice;
        this.Checked = Checked;
        this.maxOwned = maxOwned;
        this.HousePrice = HousePrice;
    }

    /**
     *
     * @return The amount of houses.
     */
    public int getHouses() {
        return houses;
    }

    /**
     * set Houses
     * @param field - The field number for which we want to buy houses for.
     * @param houses - Sets the amount of houses for the field.
     */
    public void setHouses(int field, int houses) {
        this.houses = houses;

        setHouses(field, houses);
    }

    /**
     * set Hotel
     * @param field - The field number for which we want to buy hotel for
     */
    public void setHotel(int field,boolean b) {
        this.houses = 5;

        setHotel(field,true);
    }

      public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean getOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public char getType() {
        return type;
    }

    //made two methods that will allow us to change the rentprice between each position by changing the number of houses
    public int [] getRentPrice (){
            return rentPrice;
        }
    public int[] setRentPrice(){
        this.rentPrice()
    }

    public void setCurrentRent(int Houses) {
        this.currentRent = this.rentPrice[Houses] * rentPriceMultiplier;
    }

    public int getCurrentRent(){
        return currentRent;
    }

    public int getStreetPrice() {
        return streetPrice;
    }

    public void setStreetPrice(int streetPrice) {
        this.streetPrice = streetPrice;
    }

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
    }

    public int getMaxOwned() {
        return maxOwned;
    }

    public void setMaxOwned(int maxOwned) {
        this.maxOwned = maxOwned;
    }

    public int getHousePrice() {
        return HousePrice;
    }

    public void setHousePrice(int housePrice) {
        HousePrice = housePrice;
    }

    public int getRentPriceMultiplier() {
        return rentPriceMultiplier;
    }

    public void setRentPriceMultiplier(int rentPriceMultiplier) {
        this.rentPriceMultiplier = rentPriceMultiplier;
    }
}
