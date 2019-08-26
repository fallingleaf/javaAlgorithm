package blackjack;
import java.util.*;


public class BlackJackGame {
    private Deck deck;
    private BlackJackPlayer dealer;
    private List<BlackJackPlayer> players;

    public void dealCard(Player player) {
        Card card = deck.removeCard();
        player.addCard(card);
    }
}
