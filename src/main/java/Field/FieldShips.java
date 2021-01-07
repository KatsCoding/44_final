package Field;

import Game.Player;

public class FieldShips extends Fields {
    int price;
    String propertynavn;
    Boolean owned;
    Player owner;
    char type;

    public FieldShips( String propertyName,int price, Boolean owned, Player owner, char type) {
        this.price = price;
        this.propertynavn = propertyName;
        this.owned = owned;
        this.owner = owner;
        this.type = type;
    }
    public Player getOwner() {
        return owner;
    }
}