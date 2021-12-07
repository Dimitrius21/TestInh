package by.epam.lab;

import java.util.Scanner;

public class DiscountPurchase extends AbstractPurchase {
    private int discount;
    private static final RoundMethod TYPE_OF_ROUND = RoundMethod.FLOOR;

    public DiscountPurchase() {
    }

    public DiscountPurchase(Product product, int quantity, int discount) {
        super(product, quantity);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public Byn getExactCost(){
        return calculate1(-discount,0,1);
    }

    @Override
    public String toString() {
        return getQuantity() + ";" + discount + ";" + getCost();
    }

    //@Override
//    public String fieldsToString() {
//        return super.fieldsToString()+ ";" + discount;
//    }



}
