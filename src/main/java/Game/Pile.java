package Game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import org.json.simple.parser.JSONParser;

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

    public static void loadFromFile(String confFile)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(confFile))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray cardList = (JSONArray) obj;

            //Iterate over employee array
            cardList.forEach( emp -> addCardObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void addCardObject(JSONObject newCard)
    {
        //Get employee object within list
        String text = (String) newCard.get("text");
        int cash = (int) newCard.get("cash");,
        int moveUser = (int) newCard.get("moveUser");
        boolean gotoJail = (boolean) newCard.get("gotoJail");
        int gotoSpecificField = (int) newCard.get("gotoSpecificField");

        cards.add(new ChanceCard(text, cash, moveUser, gotoJail, gotoSpecificField));

    }
}
