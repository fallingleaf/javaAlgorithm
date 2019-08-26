package blackjack;
import java.util.*;


public abstract class Player {
    private List<cards> hand = new ArrayList<>();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    abstract boolean canPlay();
    abstract boolean wantToPlay();
    abstract int getTotalPoints();

    public void addCard(Card card) {
        hand.add(card);
    }
}
