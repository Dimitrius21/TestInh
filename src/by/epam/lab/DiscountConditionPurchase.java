package by.epam.lab;

import java.util.Scanner;

import static by.epam.lab.RoundMethod.CEIL;
import static by.epam.lab.RoundMethod.ROUND;

public class DiscountConditionPurchase extends AbstractPurchase {
    private static final int QUANTITY_FOR_DISCOUNT = 5;
    private static final RoundMethod TYPE_OF_ROUND = RoundMethod.FLOOR;
    private double discount;

    public DiscountConditionPurchase() {
    }

    public DiscountConditionPurchase(Product product, int quantity, double discount) {
        super(product, quantity);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getExactCost(){
        return calculate1(0,0, (100-discount)/100.0);
    }


    @Override
    public String toString() {
        return getQuantity() + ";" + discount + ";" + getCost();
    }

}