package Game;


public class DiceCup {

    private Dice[] dices;
    private int totalValue = 0;
    private int diceAmount;

    public DiceCup(int diceAmount){
        this.diceAmount = diceAmount;
        dices = new Dice[diceAmount];
        for( int i=0; i<diceAmount; i++){
            dices[i] = new Dice();
        }
    }

    public void roll(){
        int sum = 0;
        for(int i=0; i<diceAmount; i++){
            sum += dices[i].roll();
        }
        totalValue = sum;
    }

    /**
     * Undersøger om ALLE dices i bægeret har den samme vaerdi.
     * Hvis der kun er én Dice, vil dette altid være sandt.
     *
     * @return Om alle dices er ens
     */
    public boolean isDoubles() {
        int firstElement = dices[0].getValue();
        for(int i=1; i<diceAmount; i++){
            if(firstElement != dices[i].getValue()){
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
        if( diceIndex >= dices.length ){
            diceIndex = dices.length-1;
        }else if(diceIndex<0){
            diceIndex = 1;
        }
        return dices[diceIndex];
    }

    /** @return Den nuværende sum af dices vaerdier
     */
    public int getTotalValue() {
        return totalValue;
    }

    public Dice[] getDices() {
        return dices;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
}
