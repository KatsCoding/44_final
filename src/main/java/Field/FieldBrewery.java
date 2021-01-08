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

    @Override
    public Player getOwner() {
        return null;
    }
}