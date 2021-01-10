package Field;

import Game.Player;

public class FieldShips extends Fields {
    int price;
    String propertynavn;
    String displayPrice;
    boolean owned;
    Player owner;
    char type;

    public FieldShips( String propertyName,String displayPrice,int price, boolean owned, Player owner, char type) {
        this.price = price;
        this.propertynavn = propertyName;
        this.displayPrice = displayPrice;
        this.owned = owned;
        this.owner = owner;
        this.type = type;
    }
    public Player getOwner() {
        return owner;
    }
}