package SOLID;

public class HighDiscount implements DiscountStrategy{

    @Override
    public int getfinalbill(int billamount) {
        return billamount-(int)(0.5*billamount);
    }
}
