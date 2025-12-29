package edu.mtc.egr283.sll;

public enum Suit {

    SPADES("Spades", '♠'), CLUBS("Clubs",'♣'),
    HEARTS("Hearts", '♥'), DIAMONDS("Diamonds", '♦');

    private final String name;
    private final char symbol;

    private Suit(String newName, char newSymbol) {
        this.name = newName;
        this.symbol = newSymbol;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
