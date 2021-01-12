package Game;


import Field.Gameboard;

public class PayTaxes {

    private int moneyLeft;
    private final int price = 4000;

    Gameboard gameboard = new Gameboard();
    Player currentPlayer;


    /*public int incomeTax(boolean i){
   int houseValue = currentPlayer.getHouses();// get houses from current player
   int hotelValue = currentPlayer.getHotel();// get hotels from current player
   int cash = currentPlayer.getCash();// get the balance of the current player

        int value = cash+houseValue+hotelValue+mortgage;

    if (i == true){
        moneyLeft = (int) (value*0.1);
    }else{
        moneyLeft = value-price;
        }
    return moneyLeft;
    }*/

}
