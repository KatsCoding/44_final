package Game;


public class DiceCup {

    private Dice[] dice;
    private int totalValue = 0;
    private int diceAmount;

    public DiceCup(int diceAmount){
        this.diceAmount = diceAmount;
        dice = new Dice[diceAmount];
        for( int i=0; i<diceAmount; i++){
            dice[i] = new Dice();
        }
    }

    public void roll(){
        int sum = 0;
        for(int i=0; i<diceAmount; i++){
            sum += dice[i].roll();
        }
        totalValue = sum;
    }

    /**
     * Undersøger om ALLE dices i bægeret har den samme vaerdi.
     * Hvis der kun er én Dice, vil dette altid være sandt.
     *
     * @return Om alle dice er ens
     */
    public boolean isDoubles() {
        int firstElement = dice[0].getValue();
        for(int i=1; i<diceAmount; i++){
            if(firstElement != dice[i].getValue()){
                return false;
            }
        }
        return true;
    }

    /**
     * Henter Diceen ud fra Diceens index i Raflebægeret.
     * @param diceIndex Diceens index (0 - (diceAmount-1))
     * @return Diceen som objekt - her kan hentes Diceens specifikke vaerdi
     */
    public Dice getDice(int diceIndex){
        if( diceIndex >= dice.length ){
            diceIndex = dice.length-1;
        }else if(diceIndex<0){
            diceIndex = 1;
        }
        return dice[diceIndex];
    }

    /** @return Den nuværende sum af dices vaerdier
     */
    public int getTotalValue() {
        return totalValue;
    }

    public Dice[] getDice() {
        return dice;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
}
