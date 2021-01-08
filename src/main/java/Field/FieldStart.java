package Field;

import Game.Player;

public class FieldStart extends Fields{
    String propertyName;

    public FieldStart(String name) { propertyName = name; }

    @Override
    public Player getOwner() {
        return null;
    }
}
