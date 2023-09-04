package SOLID;

public class ShoppingMall {

    String Customer;
    int bill;

    DiscountStrategy ds;
    ShoppingMall(DiscountStrategy discountstrategy)
    {
        this.ds = discountstrategy;
    }

    public int getfinalbill()
    {
        return ds.getfinalbill(this.bill);
    }

}
