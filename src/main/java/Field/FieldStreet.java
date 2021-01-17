package Field;

import Game.Player;

import java.util.ArrayList;

public class FieldStreet extends Fields {
    private String displayPrice;
    private String propertyName;
    private boolean owned;
    private Player owner;
    private char type;
    private int[] rentPrices;
    private int rentPriceMultiplier = 1;
    private int streetPrice;
    private boolean OwnedAllType = false;
    private int maxOwned;
    private int housePrice;
    private int houses;
    private int hotels;
    private int houseCounter;
    private boolean canBuild;
    private ArrayList<FieldStreet> relatedFields;


    public FieldStreet(String propertyName, String displayPrice, char type, boolean owned, int streetPrice, int[] rentLevels, int HousePrice, Player owner, int maxOwned) {
        // The field base lines for what street fields consist of.
        this.displayPrice = displayPrice;
        this.propertyName = propertyName;
        this.owned = owned;
        this.owner = owner;
        this.type = type;
        this.rentPrices = rentLevels;
        this.streetPrice = streetPrice;
        this.maxOwned = maxOwned;
        this.housePrice = HousePrice;
        this.houses = 0;
        this.hotels = 0;
        this.houseCounter = 0;
        this.relatedFields = new ArrayList<>();
    }

    public void addRelatedField(FieldStreet relatedField) {
        if (!this.relatedFields.contains(relatedField)) {
            this.relatedFields.add(relatedField);
        }
    }

    public ArrayList<FieldStreet> getRelatedFields() {
        return this.relatedFields;
    }

    public static void linkFields(FieldStreet[] fields) {
        for (int i = 0; i <= fields.length - 1; i++) {
            for (int j = 0; j <= fields.length - 1; j++) {
                if (i != j) {
                    fields[i].addRelatedField(fields[j]);
                }
            }
        }
    }

    /**
     * @return The amount of houses.
     */
    public int getHouses() {
        return houses;
    }

    public boolean getCanBuild() {
        return canBuild;
    }

    public void setCanBuild(boolean canBuild) {
        this.canBuild = canBuild;
    }

    public boolean buildHouse() {
        if (this.canBuildHouse()) {
            this.owner.addCash(-this.housePrice);
            this.houses++;
            this.houseCounter++;
            return true;
        }
        return false;
    }

    public void buildHotel() {
        if (canBuildHotel()) {
            this.owner.addCash(-this.housePrice);
            this.houses++;
            this.hotels++;
            this.houseCounter = 0;
        }
    }

    public void removeHouse() {
        if (this.canSellHouse()) {
            this.owner.addCash(this.housePrice);
            this.houses--;
            this.houseCounter--;
            this.houseCounter = 4;
        }
    }

    public void removeHotel() {
        if (canSellHotel()) {
            this.owner.addCash(this.housePrice);
            this.houses--;
            this.hotels--;
        }
    }

    public boolean canBuildHouse() {
        if (getOwnedAllType()) {
            return true;
        }
        return canBuild && this.houses < this.rentPrices.length - 2;
    }

    public boolean canBuildHotel() {
        return getHouses() == 4;
    }

    public boolean canSellHouse() {
        return getHouses() > 0 && getHouses() < 5;
    }

    public boolean canSellHotel() {
        return getHouses() == 5;
    }

    public boolean useMortgage() {
        return this.getOwned();
    }

    public int getMortgage() {
        return streetPrice / 2;
    }

    public String getPropertyName() {
        return propertyName;
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

    public int getCurrentRent() {
        return this.rentPrices[this.houses];
    }

    public int getStreetPrice() {
        return streetPrice;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    public boolean getOwnedAllType() {
        return OwnedAllType;
    }

    public void setOwnedAllType(boolean OwnedAllType) {
        this.OwnedAllType = OwnedAllType;
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

    public void setRentPriceMultiplier(int rentPriceMultiplier) {
        this.rentPriceMultiplier = rentPriceMultiplier;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(String displayPrice) {
        this.displayPrice = displayPrice;
    }

    public int getHotels() {
        return hotels;
    }

    public int getHouseCounter() {
        return houseCounter;
    }
}
