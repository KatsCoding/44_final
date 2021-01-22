package Game;

import java.util.*;
import ChanceCard.*;
import Field.FieldShips;

public class Pile {
    protected Queue<ChanceCard> cards = new LinkedList<>();
    protected Queue<ChanceCard> currentPile = new LinkedList<>();

    public ChanceCard draw(){
        ChanceCard card = currentPile.poll();
        // tilbagelægning
        if(card != null) currentPile.add(card);
        return card;
    }

    public void addCard(ChanceCard card) {
        currentPile.add(card);
    }

    public void shuffle() {
        currentPile = new LinkedList<>();
        loadPile();
    }

    public void loadPile() {
        addCard( new SimpleMoveToSpecificField("Gå i fængsel", "Ryk i fængsel", false));
        addCard( new SimpleMove("Ryk tre felter frem", 3, true));
        addCard( new GetOutOfJailCard("I anledning af kongens fødselsdag benådes de for fængsel. Dette kort kan opbevares indtil du får brug for det"));
        addCard( new SimpleMoveToSpecificField("Tag til rådhuspladsen", "Rådhuspladsen", true));
        addCard( new SimpleReceiveCash("Du har vundet i klasselotteriet. Du modtager 500 kr", 500));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Grønningen", "Grønningen", true));
        addCard( new SimpleReceiveCashFromPlayers("Det er deres fødselsdag. Modtag af hver medspiller 200 kr.",200));
        addCard( new SimpleMove("Ryk tre felter tilbage", -3, false));
        addCard( new SimpleMove("Ryk tre felter tilbage", -3, false));
        addCard( new SimpleMoveToSpecificField("Ryk frem til START", "Start", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til START", "Start", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Frederiksberg Allé", "Frederiksberg Allé", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Vimmelskaftet", "Vimmelskaftet", true));
        addCard( new SimpleMoveToSpecificField("Ryk frem til Strandvejen", "Strandvejen", true));
        addCard( new SimpleMoveToSpecificField("Tag med Mols-linien, flyt brikken frem", "Mols-Linien", true));
        addCard( new SimpleMoveToSpecificField("Gå i fængsel", "Ryk i fængsel", false));
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
        addCard( new SimplePayCash("Du har kørt frem for 'fuldt stop', betal 1000 kr i bøde", 1000 ));
        addCard( new SimplePayCash("Betal 300 kr for vognvask og smøring", 300 ));
        addCard( new SimplePayCash("Betal 3000 kr for reperation af din vogn", 3000 ));
        addCard( new SimplePayCash("Betal 3000 kr for reperation af din vogn", 3000 ));
        addCard( new SimplePayCash("Du har købt 4 nye dæk til din vogn. Du skal betale 1000 kr", 1000 ));
        addCard( new SimplePayCash("Du har fået en parkeringsbøde, betal 200 kr i bøde", 200 ));
        addCard( new SimplePayCash("Betal 1000 kr for din bilforsikring", 1000 ));
        addCard( new SimplePayCash ("Betal 200 kr for levering af to kasser øl", 200));
        addCard( new SimplePayCash("Du har været udenlands og købt for mange smøger. Betal 200 kr i told", 200 ));
        addCard( new SimplePayCash("Du skal betale 2000 kr for din tandlægeregning", 2000 ));
        addCard( new GetOutOfJailCard("I anledning af kongens fødselsdag benådes de for fængsel. Dette kort kan opbevares indtil du får brug for det"));
        addCard( new SimplePayTaxes("Oliepriserne er steget, og du skal betale 500 kr pr hus og 2000 kr pr hotel", 500,2000));
        addCard( new SimplePayTaxes("Ejemdomsskatten er steget. Ekstraudgifterne er 800 kr pr hus og 2300 kr pr hotel", 800,2300));
        addCard( new SimpleReceiveCashFromPlayers("Du har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag 500 kr fra hver medspiller",500));
        addCard( new SimpleReceiveCashFromPlayers("Du skal holde familiefest og får et tilskud fra hver medspiller på 500 kr",500));
        addCard( new GotoNearestFieldOfType("Tag med den nærmeste færge",  FieldShips.class ));
    }

} // Kort ikke lavet: 20 og 28


