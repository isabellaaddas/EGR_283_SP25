package edu.mtc.egr283.sll;

public class SLLNodePlayingCardDriver {

    public static void main(String[] args) {

        SLLNode<PlayingCard> node1 = new SLLNode<PlayingCard>();
        node1.setNodeData(new PlayingCard(Suit.CLUBS, Rank.JACK));
//        System.out.print(node1.getNodeData().toStringSymbol());
//        System.out.println(", " + node1.getNodeData().toString());

        SLLNode<PlayingCard> node2 = new SLLNode<PlayingCard>(
                new PlayingCard(Suit.DIAMONDS, Rank.QUEEN));
        node2.setNextNode(node1);
//        System.out.print(node2.getNodeData().toStringSymbol());
//        System.out.println(", " + node2.getNodeData().toString());
//        System.out.print(node2.getNextNode().getNodeData().toStringSymbol());
//        System.out.println(", " + node2.getNextNode().getNodeData().toString());

        SLLNode<PlayingCard> node3 = new SLLNode<PlayingCard>(
                new PlayingCard(Suit.HEARTS, Rank.KING), node2);

        SLLNode<PlayingCard> node4 = new SLLNode<PlayingCard>(
                new PlayingCard(Suit.SPADES, Rank.ACE), node3);

        // Iterate through SLLNodes (traverse)
        SLLNode<PlayingCard> cursor = new SLLNode<PlayingCard>(null, node4);
        while(cursor.getNextNode() != null) {
            cursor = cursor.getNextNode();
            System.out.print(cursor.getNodeData().toStringSymbol());
            System.out.println(", " + cursor.getNodeData().toString());
        }

        // Print out all the Playing Cards
        PlayingCard pc = null;
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                pc = new PlayingCard(s, r);
                System.out.print(pc.toStringSymbol());
                System.out.println(", " + pc.toString());
            }
        }
    }
}
