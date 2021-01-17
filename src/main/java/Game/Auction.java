package Game;


import Field.Fields;
import gui_fields.GUI_Field;
import gui_main.GUI;



public class Auction {
    Fields field;
    int fieldNumber;
    Player[] players;
    Integer[] bids;
    Integer minimumBet = 0;
    GUI gui;
    GUI_Field gui_field;
    Game game;
    public Auction(Fields field, Player[] players, GUI gui, GUI_Field gui_field, Game game, int fieldNumber){
    //public Auction(Fields field, Player[] players, Game game, int fieldNumber) {
        this.field = field;
        this.players = players;
        this.bids = new Integer[players.length];
        //this.gui = gui;
        this.gui_field = gui_field;
        this.game = game;
        this.fieldNumber = fieldNumber;
    }

    public void startAuction() {
        // En spiller ad gangen får mulighed for at give et bud.
        // Man kan ikke byde lavere end laveste bud.
        // Hver spiller kan vælge at byde eller lade vær.
        for (Integer i = 0; i<players.length; i++) {
            requestPlayerInput(i);
        }
        Integer winner = getWinner();
        if (winner >= 0) {
            // Køb grund
            this.field.setOwned(true);
            this.field.setOwner(this.players[winner]);
            this.gui_field.setSubText(this.players[winner].getName()); //game.getGui() property owner name updated here
            this.players[winner].addCash(-this.bids[winner]); //pays for the property
            this.game.fieldAction.checkColorGroupOwned(this.fieldNumber);


        }
    }

    private void requestPlayerInput(int playerNumber) {
        // spørgs om man ønsker at give bud
        // hvis ja så spørg om beløb større end minimumBed
        String auctionChoise = game.getGui().getUserSelection("Vil du byde på den grund:", "Ja", "Nej");
        if (auctionChoise.equals("Ja")){
            bids[playerNumber] = game.getGui().getUserInteger("Hvor meget har du lyst til at byde," + minimumBet + "er minimums budet.", minimumBet,this.players[playerNumber].getCash());
        } else {
            bids[playerNumber] = 0;
        }
    }

    private Integer getWinner() {
        // Find winner
        for (Integer i = players.length-1; i>=0; i--) {
            if (bids[i] > 0) {
                return (i);
            }
        }
        return (-1);
    }
}
