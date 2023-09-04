package SOLID;

public class LowDiscount implements DiscountStrategy{

    @Override
    public int getfinalbill(int billamount) {
        return billamount-(int)(billamount*0.1);
    }
}
