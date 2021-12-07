package by.epam.lab;

public class PurchaseWithTransportFee extends AbstractPurchase{
    private int transportFee;
    private static final RoundMethod TYPE_OF_ROUND = RoundMethod.FLOOR;
    public PurchaseWithTransportFee() {
    }

    public PurchaseWithTransportFee(Product product, int quantity, int transportFee) {
        super(product, quantity);
        this.transportFee = transportFee;
    }

    public int getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(int transportFee) {
        this.transportFee = transportFee;
    }

    @Override
    public Byn getExactCost(){
        return calculate1(0,transportFee,1);
    }

    @Override
    public String toString() {
        return getQuantity() + ";" + transportFee + ";" + getCost();
    }
}
