package Game;

import Field.Gameboard;

public class PayTaxes {

    private final int price = 4000;
    private final int tax = 2000;
    private int mortgage;
    private int balance;
    private int value;


    Gameboard gameboard;

    public PayTaxes(Gameboard gameboard) {
        this.gameboard = gameboard;
    }


    public void incomeTax(String buttonInput, Player currentPlayer) {
        int cash = currentPlayer.getCash();// get the balance of the current player
        int payTax = 0;

        for (int j = 0; j < 40; j++) {
            if (gameboard.getArray()[j].getOwner() == currentPlayer) {// check if the current player ownes the field
                int houseValue = +gameboard.getArray()[j].getHouses() * gameboard.getArray()[j].getHousePrice();//get house and house price on field and multiply it
                int fieldValue = +gameboard.getArray()[j].getStreetPrice();//get field price

                if (gameboard.getArray()[j].useMortgage()) {//check if mortgage is used on a field if there is, it gets the mortgage price.
                    mortgage = +gameboard.getArray()[j].getMortgage();

                }
                value = +houseValue + fieldValue;// lay field price and house value together
            }
        }

        balance = cash + mortgage + value;
        if (buttonInput.equals("Betal med 10% af mit samlede antal værdier")) {
            payTax = -(int) (balance * 0.1);
        } else {
            payTax = -price;
        }
        currentPlayer.addCash(payTax);
    }

    public void extraOrdinaryTax(Player currentPlayer) {
        int payTax = 0;

        payTax = -tax;
        currentPlayer.addCash(payTax);
    }

}