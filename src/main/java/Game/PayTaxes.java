package Game;
import Field.Gameboard;

public class PayTaxes {

    private int moneyLeft;
    private final int price = 4000;
    private final int tax = 2000;
    private int mortgage;
    private int balance;
    private int value;



    Gameboard gameboard = new Gameboard();
    Player currentPlayer;


    public int incomeTax(String bottonInput){
        int cash = currentPlayer.getCash();// get the balance of the current player

        for (int j = 0; j < 40; j++) {
            if (gameboard.getArray()[j].getOwner() == currentPlayer) {// check if the current player ownes the field
                int houseValue =+ gameboard.getArray()[j].getHouses() * gameboard.getArray()[j].getHousePrice();//get house and house price on field and multiply it
                int fieldValue =+ gameboard.getArray()[j].getStreetPrice();//get field price

                if (gameboard.getArray()[j].useMortgage()) {//check if mortgage is used on a field if there is, it get the mortgage price.
                    mortgage =+ gameboard.getArray()[j].getMortgage();
                    return mortgage;
                }
                value =+ houseValue + fieldValue;// lay field price and house value together
                return value;
            }
        }

        balance = cash + mortgage + value;
        if (bottonInput.equals("10%")){
        moneyLeft = cash - (int) (balance*0.1);
    }else{
        moneyLeft = cash-price;
        }
        return moneyLeft;
    }

    public int extraOrdinaryTax(){
        int cash = currentPlayer.getCash();// get the balance of the current player

        moneyLeft = cash - tax;

        return moneyLeft;
    }

}