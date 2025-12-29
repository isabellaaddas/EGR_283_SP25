package edu.mtc.egr283.sll;

public class PlayingCard {

    private final Suit suit;
    private final Rank rank;

    public PlayingCard(Suit newSuit, Rank newRank) {
        this.suit = newSuit;
        this.rank = newRank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return this.getRank().getName() + " of " + this.getSuit().getName();
    }

    public String toStringSymbol() {
        return this.getRank().getSymbol() + "" + this.getSuit().getSymbol();
    }
}
