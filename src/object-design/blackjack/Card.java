package blackjack;

public class Card {
    public enum Suit {
        HEART, DIAMOND, CLUB, SPADE;
    }

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KING, QUEEN, JACK;
    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        if(rank.getOrdinal() < 10) {
            return rank.getOrdinal() + 1;
        }
        return 10;
    }

    public Rank getRank() {
        return rank;
    }

}
