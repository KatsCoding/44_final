package Game;

public class ChanceCard {
    protected String text;
    protected int movePlayer;
    protected int updatePlayerCash;
    protected boolean goToJail;
    protected int goToSpecificField;

    public ChanceCard(
            String text,
            int movePlayer,
            int updatePlayerCash,
            boolean goToJail,
            int goToSpecificField
    ){
        this.text = text;
        this.movePlayer = movePlayer;
        this.updatePlayerCash = updatePlayerCash;
        this.goToJail = goToJail;
        this.goToSpecificField = goToSpecificField;
    }

    public String getText(){ return this.text; } //
    public int getMovePlayer(){ return  this.movePlayer; }
    public int updatePlayerCash(){return this.updatePlayerCash;}
    public boolean goToJail(){return this.goToJail;}
    public int goToSpecificField(){return this.goToSpecificField;}

}
