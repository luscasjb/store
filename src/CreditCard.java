import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private double limit;
    private double balance;
    private List<Purchase> purchase;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.purchase = new ArrayList<>();
    }

    public boolean throwBuy(Purchase buy) {
        if (this.balance > buy.getValue()) {
            this.balance -= buy.getValue();
            this.purchase.add(buy);
            return true;
        } else
            return false;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getBuy() {
        return purchase;
    }
}
