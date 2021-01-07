package Field;

import Game.Player;

public class FieldJail extends Fields{
    String propertyName;

    public FieldJail(String name) { propertyName = name; }

    @Override
    public Player getOwner() {
        return null;
    }
}

