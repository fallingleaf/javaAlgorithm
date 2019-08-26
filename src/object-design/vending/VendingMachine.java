package vending;
import java.util.List;

// https://javarevisited.blogspot.com/2016/06/design-vending-machine-in-java.html
// Main class Vending Machine, Item in machince, Coin uses
// Vending Machine keeps track of its quantity of Item and Coin
// Provide methods to get price for item, insert coin, collect items 
public interface VendingMachine {
    public int selectItemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public List<Coin> refund();
    public Bucket<Item, List<Coin>> collectItemAndChange();
    public void reset();
}
