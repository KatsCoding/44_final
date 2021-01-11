package Game;

import java.util.*;
import ChanceCard.*;

public class Pile {
    protected Queue<ChanceCard> cards = new LinkedList<ChanceCard>();
    protected Queue<ChanceCard> currentPile = new LinkedList<ChanceCard>();

    public ChanceCard draw(){
        ChanceCard card = currentPile.poll();
        // tilbagelægning
        if(card != null) currentPile.add(card);
        return card;
    }

    public void addCard(ChanceCard[] newCards) {
        int i;
        for(i=0; i<newCards.length; i++){
            cards.add(newCards[i]);
        }
    }
    public void addCard(ChanceCard card) {
        cards.add(card);
    }

    public void shuffle(){
        ArrayList<ChanceCard> tmp = new ArrayList<ChanceCard>(cards);
        Collections.shuffle(tmp);
        currentPile = new LinkedList<ChanceCard>(tmp);
    }

    public void loadPile() {
        addCard( new SimpleMove("Ryk tre felter frem", 3, true));
        addCard( new SimpleMove("Ryk tre felter tilbage", -3, false));
        addCard( new SimpleMove("Ryk tre felter tilbage", -3, false));
        addCard( new SimpleMoveToSpecificField("Ryk frem til START", "START", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til START", "START", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Frederiksberg Allé", "Frederiksberg Allé", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Grønningen", "Grønningen", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Vimmelskaftet", "Vimmelskaftet", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Strandvejen", "Strandvejen", true));
        addCard( new SimpleMoveToSpecificField("Tag til rådhuspladsen", "Frederiksberg Allé", true));
        addCard( new SimpleMoveToSpecificField("Tag med Mols-linien, flyt brikken frem", "Mols-linien", true));
        addCard( new SimpleReceiveCash("Du har vundet i klasselotteriet. Du modtager 500 kr", 500));
        addCard( new SimpleReceiveCash("Du har vundet i klasselotteriet. Du modtager 500 kr", 500));
        addCard( new SimpleReceiveCash("Du modtager dit aktieudbytte. Du modtager 1000 kr", 1000));
        addCard( new SimpleReceiveCash("Du modtager dit aktieudbytte. Du modtager 1000 kr", 1000));
        addCard( new SimpleReceiveCash("Du modtager dit aktieudbytte. Du modtager 1000 kr", 1000));
        addCard( new SimpleReceiveCash("Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr", 3000));
        addCard( new SimpleReceiveCash("Du har en række med elleve rigtige i tipning, du modtager 1000 kr", 1000));
        addCard( new SimpleReceiveCash("Grundet dyrtiden har du fået gageforhøjelse, du modtager 1000 kr", 1000));
        addCard( new SimpleReceiveCash("Deres præmieobligation er udtrykket. Du modtager 1000 kr", 1000));
        addCard( new SimpleReceiveCash("Deres præmieobligation er udtrykket. Du modtager 1000 kr", 1000));
        addCard( new SimpleReceiveCash("Du har solgt nogle gamle møbler på auktion. Du modtager 1000", 1000));
        addCard( new SimpleReceiveCash("Værdien af egen avl fra nyttehaven udgør 200 som du får af banken", 200));
        addCard( new SimplePayCash("Du har kørt frem for 'fuldt stop', betal 1000 kr i bøde", -1000 ));
        addCard( new SimplePayCash("Betal 300 kr for vognvask og smøring", -300 ));
        addCard( new SimplePayCash("Betal 3000 kr for reperation af din vogn", -3000 ));
        addCard( new SimplePayCash("Betal 3000 kr for reperation af din vogn", -3000 ));
        addCard( new SimplePayCash("Du har købt 4 nye dæk til din vogn. Du skal betale 1000 kr", -1000 ));
        addCard( new SimplePayCash("Du har fået en parkeringsbøde, betal 200 kr i bøde", -200 ));
        addCard( new SimplePayCash("Betal 1000 kr for din bilforsikring", -1000 ));
        addCard( new SimplePayCash("Du har været udenlands og købt for mange smøger. Betal 200 kr i told", -200 ));
        addCard( new SimplePayCash("Du skal betale 2000 kr for din tandlægeregning", -2000 ));


    }


}

// KORT DER MANGLES: 1,2,20,28,32
