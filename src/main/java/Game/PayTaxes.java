package Game;

public class PayTaxes {

    private double moneyLeft;
    private final int price = 4000;


    public double incomeTax(double i){
    if (i == 0 ){
        moneyLeft =i*0.1;
    }else{
        moneyLeft = i-price;
        }
    return moneyLeft;
    }

}
