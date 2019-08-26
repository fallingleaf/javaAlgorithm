import java.util.List;
import java.util.ArrayList;

// Stock market example
// Order class: buy and sell command, implement execute()
// Broker class: take and place orders

// Command classes
public interface Order {
    void execute();
}

public class BuyStock implements Order {
    private Stock stock;
    private int quantity;

    public BuyStock(Stock stock, int quantity) {
        this.stock = stock;
        this.quatity = quantity;
    }

    public void execute() {
        stock.buy(quantity);
    }
}

public class SellStock implements Order {
    private Stock stock;
    private int quantity;

    public SellStock(Stock stock, int quantity) {
        this.stock = stock;
        this.quatity = quantity;
    }

    public void execute() {
        stock.sell(quantity);
    }
}

// Stock class
public class Stock {
    public String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void sell(int num) {
        if(quantity >= num) {
            quantity -= num;
            System.out.println("Sold " + num + " stocks");
            return;
        }
        throw new Exception("Not enough stock to sell");
    }

    public void buy(int num) {
        quantity += num;
        System.out.println("Bought " + num + " stocks");
    }
}


// Broker class
public class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order ord) {
        orderList.add(ord);
    }

    public void placeOrders() {
        for(Order ord: orderList) {
            ord.execute();
        }

        orderList.clear();
    }
}
