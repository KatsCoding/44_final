package Game;

public class Dice {
    private final int MAX = 6;

    private int value = 1;

    Dice(int startValue) {
        value = startValue;
    }

    Dice() { value = 1; }

    public int getValue() {
        return value; }

    public void setValue(int value){
        this.value = value;
    }

    public int roll(){
        value = (int)(Math.random() * MAX) + 1;
        return value;
    }

}