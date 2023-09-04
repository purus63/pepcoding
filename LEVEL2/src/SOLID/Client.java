package SOLID;

public class Client {
    public static void main(String[] args) {
        ShoppingMall shoppingMall = new ShoppingMall(new HighDiscount());
        shoppingMall.Customer="Hari";
        shoppingMall.bill=100;
        System.out.println(shoppingMall.getfinalbill());
    }
}
