package Game;
import Game.Game;


public class DiceCup {

    Game game; //Added for exam presentation
    boolean doubles; //Also added
    private Dice[] dice;
    private int totalValue = 0;
    private int diceAmount;

    public void setGame(Game game) {
        this.game = game;
    }

    public DiceCup(int diceAmount){
        this.diceAmount = diceAmount;
        dice = new Dice[diceAmount];
        for( int i=0; i<diceAmount; i++){
            dice[i] = new Dice();
        }
    }

    public void roll(){
        /*int sum = 0;
        for(int i=0; i<diceAmount; i++){
            sum += dice[i].roll();
        }
        totalValue = sum;*/

        String stringSelection = game.getGui().getUserSelection("Hvad vil du gerne rulle?",
                "5", "6", "7", "8", "9", "10", "11", "2 DOBBELT", "4 DOBBELT", "6 DOBBELT", "8 DOBBELT", "10 DOBBELT", "12 DOBBELT", "3", "4");
        int selection = 0;
        if (stringSelection.length() <= 2) {
            selection = Integer.parseInt(stringSelection);
            doubles = false;
        }
        else {
            selection = Integer.parseInt(stringSelection.substring(0,2));
            doubles = true;
        }
        totalValue = selection;

    }

    /**
     * Undersøger om ALLE dices i bægeret har den samme vaerdi.
     * Hvis der kun er én Dice, vil dette altid være sandt.
     *
     * @return Om alle dice er ens
     */
    public boolean isDoubles() {
        /*int firstElement = dice[0].getValue();
        for(int i=1; i<diceAmount; i++){
            if(firstElement != dice[i].getValue()){
                return false;
            }
        }
        return true;*/
        return doubles;
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
