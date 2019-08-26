package blackjack;
import java.util.*;


public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        initDeck();
        shuffle();
    }

    private void initDeck() {
        for(Suit suit: Suit.values()) {
            for(Rank rank: Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card removeCard() {
        if(cards.size() == 0) {
            throw RuntimeException("Deck is empty!");
        }

        Card card = cards.remove(cards.size() - 1);
        return card;
    }
}
