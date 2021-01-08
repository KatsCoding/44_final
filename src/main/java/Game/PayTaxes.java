package Game;

public class PayTaxes {
    private double tax;
    private int moneyLeft;
    private int stateTaxPaid;
    private final int stateTax = 2000;
    private final int price = 4000;

    public double Taxes(int i){
        tax = i*0.1;

        return tax;
    }

    public int MoneyLeft(int i){
        moneyLeft = i-price;

        return moneyLeft;
    }

    public int StateTaxPaid(int i){
        stateTaxPaid = i-stateTax;

        return stateTaxPaid;
    }
}
