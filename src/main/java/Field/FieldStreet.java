package Field;
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
    int housePrice;
    int houses;
    int currentRent;


    public FieldStreet(String propertyName, String displayPrice, char type, boolean owned, int streetPrice, int[] rent_levels, int HousePrice, Player owner, int maxOwned){
        // The field base lines for what street fields consist of.
        this.displayPrice = displayPrice;
        this.propertyName = propertyName;
        this.owned = owned;
        this.owner = owner;
        this.type = type;
        this.rentPrice = rent_levels;
        this.streetPrice = streetPrice;
        this.Checked = Checked;
        this.maxOwned = maxOwned;
        this.housePrice = HousePrice;
        this.houses=0;
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

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public String FieldStart() {
        return null;
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

    public int getCurrentRent(){
        return this.rentPrice[this.houses];
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
        return housePrice;
    }

    public int getRentPriceMultiplier() {
        return rentPriceMultiplier;
    }

    public void setRentPriceMultiplier(int rentPriceMultiplier) {
        this.rentPriceMultiplier = rentPriceMultiplier;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(String displayPrice){this.displayPrice = displayPrice;}
}
