package vending;
import vending.exceptions.*;
import java.util.List;


public class VendingMachineImpl implements VendingMachine {
    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Item> itemInventory = new Inventory<Item>();

    private long totalSales;
    private Item currentItem;
    private int currentBalance;

    public VendingMachineImpl() {
        initialize();
    }

    private void initialize() {
        for(Coin c: Coin.values()) {
            cashInventory.put(c, 5);
        }

        for(Item item: Item.values()) {
            itemInventory.put(item, 5);
        }
    }

    @Override
    public int selectItemAndGetPrice(Item item) {
        if(itemInventory.hasItem(item)) {
            currentItem = item;
            return item.getPrice();
        }
        throw new SoldOutException("Item sold out, please select another.");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance += coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        currentSales += item.getPrice();
        List<Coin> change = collectChange();
        return new Bucket<Item, List<Coin>>(item, change);
    }

    private Item collectItem() throws NotSufficientChangeException,
        NotFullPaidException {
        // Check if item paid in full amount
        if(isFullPaid()) {
            // Check if has sufficient change
            if(hasSufficientChange()) {
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not enough change.");
        }
        int remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining: " + remainingBalance);
    }

    private List<Coin> collectChange() {
        int changeAmount = currentItem.getPrice() - currentBalance;
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refunds = getChange(currentBalance);
        updateCashInventory(refunds);
        currentBalance = 0;
        currentItem = null;
        return refunds;
    }

    private boolean isFullPaid() {
        return currentBalance >= currentItem.getPrice();
    }

    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentItem.getPrice() - currentBalance);
    }

    private boolean hasSufficientChangeForAmount(int amount) {
        try {
            getChange(amount);
            return true;
        } catch(NotSufficientChangeException err) {
            return false;
        }

    }

    private void updateCashInventory(List<Coin> change) {
        for(Coin c: change) {
            cashInventory.deduct(c);
        }
    }

    private List<Coin> getChange(int amount) throws NotSufficientChangeException {
        List<Coin> change = new ArrayList<Coin>();
        Coin[] coins = {Coin.QUARTER, Coin.NICKLE, Coin.DIME, Coin.PENNY};

        for(Coin c: coins) {
            if(amount >= c.getDenomination()) {
                int numCoins = amount / c.getDenomination();
                for(int i = 0; i < numCoins; i++) {
                    change.add(c);
                }
                amount = amount % c.getDenomination();
                break;
            }
        }

        if(amount > 0) {
            throw new NotSufficientChangeException("Not enough change.");
        }

        return change;
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        currentBalance = 0;
        currentItem = null;
        totalSales = 0;
    }


}
