package Field;


import Game.Player;

public class FieldVisitJail extends Fields {
    String propertyName;

    public FieldVisitJail(String name) { propertyName = name; }

    @Override
    public Player getOwner() {
        return null;
    }
}