package Game;


import Field.FieldStreet;
import Field.Gameboard;

public class PayTaxes {

    private int moneyLeft;
    private final int price = 4000;
    private int mortgage;
    private int houseValue;



    Gameboard gameboard = new Gameboard();
    Player currentPlayer;


    public int incomeTax(String bottonInput){
        int cash = currentPlayer.getCash();// get the balance of the current player

        for (int j = 0; j < 40; j++) {
            if (gameboard.getArray()[j].getOwner() == currentPlayer) {// check if the current player ownes the field
                houseValue =+ gameboard.getArray()[j].getHouses() * gameboard.getArray()[j].getHousePrice();//get house and house price on field and multiply it

                if (gameboard.getArray()[j].useMortgage()) {//check if mortgage is used on a field if there is, it get the mortgage price.
                    mortgage =+ gameboard.getArray()[j].getMortgage();
                    return mortgage;
                }
                return houseValue;
            }
        }
        int value = cash + houseValue + mortgage;
    if (bottonInput == "10%"){
        moneyLeft = (int) (value*0.1);
    }else{
        moneyLeft = cash-price;
        }
    return moneyLeft;
    }

}
