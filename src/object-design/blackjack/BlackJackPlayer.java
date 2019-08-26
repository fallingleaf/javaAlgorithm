package blackjack;
import java.util.*;


public class BlackJackPlayer extends Player {
    @Override
    public boolean canPlay() {
        return getTotalPoints() < 21;
    }

    @Override
    public boolean wantToPlay() {
        return getTotalPoints() < 17;
    }

    @Override
    public int getTotalPoints() {
        int minPoint;
        int maxPoint;

        for(Card card: hand) {
            minPoint += card.getValue();
            maxPoint += card.rank == Rank.ACE ? 11 : card.getValue();
        }

        return maxPoint > 21 ? minPoint : maxPoint;
    }
}
