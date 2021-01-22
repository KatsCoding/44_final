package Game;


public class DiceCup {
    //                                                                                                       v  spillet slutter her
    int[] d1 = {4, 2, 6, 2, 6, 3, 5, 6, 3, 3, 1, 5, 5, 3, 2, 4, 6, 2, 6, 3, 1, 1, 1, 3, 2, 2, 3, 3, 5, 5, 6, 1, 4};
    int[] d2 = {2, 3, 1, 1, 4, 2, 6, 1, 5, 1, 1, 5, 5, 1, 4, 3, 6, 3, 4, 2, 1, 1, 2, 1, 1, 1, 2, 1, 1, 3, 6, 2, 6};
    int index = -1;


    private Dice[] dice;
    private int totalValue = 0;
    private int diceAmount;

    public DiceCup(int diceAmount){

    }

    public void roll(){
        index++;

    }

    /**
     * Undersøger om ALLE dices i bægeret har den samme vaerdi.
     * Hvis der kun er én Dice, vil dette altid være sandt.
     *
     * @return Om alle dice er ens
     */
    public boolean isDoubles() {
        return d1[index] == d2[index];
    }

    /** @return Den nuværende sum af dices vaerdier
     */
    public int getTotalValue() {
        return d1[index] + d2[index];
    }

    public Dice[] getDice() {
        Dice[] diceArray = {new Dice(d1[index]), new Dice(d2[index])};

        //lav et array af terninger med de rigtige værdier
        return diceArray;

    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
}
