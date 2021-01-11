package Game;

import java.io.FileReader;
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
        addCard(new SimpleMoveChanceCard("Ryk fem felter frem", 5));
        addCard(new SimpleMoveChanceCard("Ryk syv felter frem", 7));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Frederiksberg Alle", "Frederiksberg Alle", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Strandvejen", "Strandvejen", true));
    }


}
