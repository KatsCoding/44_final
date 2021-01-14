package Field;
import Game.Player;
import gui_fields.GUI_Field;

import java.util.ArrayList;

public class FieldStreet extends Fields{
    String displayPrice;
    String propertyName;
    boolean owned;
    Player owner;
    char type;
    int[] rentPrices = new int[6];
    int rentPriceMultiplier = 1;
    int streetPrice;
    boolean Checked = false;
    int maxOwned;
    int housePrice;
    int houses;
    int hotels;
    int housecounter;
    int currentRent;
    ArrayList<FieldStreet> relatedFields;


    public FieldStreet(String propertyName, String displayPrice, char type, boolean owned, int streetPrice, int[] rentLevels, int HousePrice, Player owner, int maxOwned){
        // The field base lines for what street fields consist of.
        this.displayPrice = displayPrice;
        this.propertyName = propertyName;
        this.owned = owned;
        this.owner = owner;
        this.type = type;
        this.rentPrices = rentLevels;
        this.streetPrice = streetPrice;
        this.Checked = Checked;
        this.maxOwned = maxOwned;
        this.housePrice = HousePrice;
        this.houses=0;
        this.hotels=0;
        this.housecounter=0;
        this.relatedFields = new ArrayList<FieldStreet>();
    }
    public void addRelatedField(FieldStreet relatedField){
        if (!this.relatedFields.contains(relatedField)) {
            this.relatedFields.add(relatedField);
        }
    }
    public ArrayList<FieldStreet> getRelatedFields(){
        return this.relatedFields;
    }
    public static void linkFields(FieldStreet[] fields){
        for (int i = 0 ; i <= fields.length - 1; i++) {
            for (int j = 0 ; j <= fields.length - 1; j++) {
                if (i != j) {
                    fields[i].addRelatedField(fields[j]);
                }
            }
        }
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

    public boolean buildHouse() {
        if (this.canBuildHouse()) {
            this.owner.addCash(-this.housePrice);
            this.houses++;
            this.housecounter++;
            return true;
        }
        return false;
    }

    public boolean buildHotel(){
        if (canBuildHotel() == true){
            this.owner.addCash(-this.housePrice);
            this.houses++;
            this.hotels++;
            this.housecounter = 0;
        }
        return false;
    }

    public boolean removeHouse() {
        if (this.canSellHouse() == true) {
            this.owner.addCash(this.housePrice);
            this.houses--;
            this.housecounter--;
            this.housecounter = 4;
            return true;
        }
        return false;
    }

    public boolean removeHotel(){
        if (canSellHotel() == true){
            this.owner.addCash(this.housePrice);
            this.houses--;
            this.hotels--;
        }
        return false;
    }

    public boolean canBuildHouse() {
        if (!this.getOwned()) {
            return false;
        }
        return this.houses < this.rentPrices.length - 2;
    }

    public boolean canBuildHotel(){
        if (getHouses() == 4){
                 return true;
        }
        return false;
    }

    public boolean canSellHouse() {
        if (getHouses() > 0 && getHouses() < 5) {
            return true;
        }
        return false;
    }

    public boolean canSellHotel(){
        if (getHouses() == 5){
            return true;
        }
        return false;
    }

    public String getPropertyName() {
        return propertyName;
    }

//    @Override
  //  public String FieldStart() {
   //     return null;
    //}

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
        return this.rentPrices[this.houses];
    }

    public int getStreetPrice() {
        return streetPrice;
    }

    @Override
    public int getPrice() {
        return 0;
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

    public int getHotels() {
        return hotels;
    }

    public int getHousecounter() {
        return housecounter;
    }
}
