package by.epam.lab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private Product product;
    int quantity;
    private static final RoundMethod TYPE_OF_ROUND = RoundMethod.FLOOR;

    public AbstractPurchase() {
    }

    public AbstractPurchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    protected final Byn calculate(int delta, double k){
        Byn cost = new Byn(getProduct().getPrice());
        return cost.add(delta).mul(k*getQuantity(), RoundMethod.ROUND, 0);
    }

    protected final Byn calculate1(int param1, int param2, double k){
        Byn cost = new Byn(getProduct().getPrice());
        return cost.add(param1).mul(getQuantity()).add(param2).mul(k, RoundMethod.ROUND, 0);
    }

    protected Byn getExactCost(){
        return calculate1(0,0,1);
    }

    public Byn getCost() {
        return getExactCost().round(TYPE_OF_ROUND, 2);
    }

    @Override
    public int compareTo(AbstractPurchase purchase) {
        int res = 1;
        try {
            if (getCost().equals(purchase.getCost())) {
                res = 0;
            } else getCost().sub(purchase.getCost());
        } catch (IllegalArgumentException ex) {
            ex.getMessage().equals("Result is negative");
            res = -1;
        }
        return res;
        //TODO  - поменять возвращаемое значение для обратной сортировки
    }

    @Override
    public String toString() {
        return quantity+";"+getCost();
    }
}

