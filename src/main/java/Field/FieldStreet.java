package Field;

public class FieldStreet extends Fields{
    String displayPrice;
    String propertyName;
    boolean owned;
    Player owner;
    char type;
    int[] rentPrice = new int[6];
    //int rentPriceMultiplier = 1;
    int streetPrice;
    boolean Checked = false;
    int maxOwned;
    int HousePrice;


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

      public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean isOwned() {
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

    public void setType(char type) {
        this.type = type;
    }

    public int[] getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int[] rentPrice) {
        this.rentPrice = rentPrice;
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
}
