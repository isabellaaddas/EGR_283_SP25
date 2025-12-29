package edu.mtc.egr283.dll;

import edu.mtc.egr283.sll.PlayingCard;
import edu.mtc.egr283.sll.Rank;
import edu.mtc.egr283.sll.Suit;

public class DLLNodeDriverPlayingCard {

    public static void main(String[] args) {

        DLLNode<PlayingCard> head = new DLLNode<PlayingCard>();
        DLLNode<PlayingCard> tail = new DLLNode<PlayingCard>();
        head.setNext(tail);
        tail.setPrev(head);

        DLLNode<PlayingCard> cursor;
        DLLNode<PlayingCard> tempNext = tail;
        DLLNode<PlayingCard> tempPrev = head;

        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {

                cursor = new DLLNode<PlayingCard>(tempPrev, new PlayingCard(s,r), tempNext);

                // Output card as it is made
                System.out.print(cursor.getNodeData().toStringSymbol());
                System.out.println(", " + cursor.getNodeData().toString());

                // Set up for next card
                tempPrev.setNext(cursor);
                tempPrev = cursor;
                tail.setPrev(cursor);
            }
        }

        System.out.println("************************");

        // Tail to Head traversal
        cursor = tail.getPrev();
        do {

            System.out.print(cursor.getNodeData().toStringSymbol());
            System.out.println(", " + cursor.getNodeData().toString());
            cursor = cursor.getPrev();
        } while (cursor.getPrev() != null);

        System.out.println("************************");

        // Head to Tail traversal
        cursor = head.getNext();
        do {

            System.out.print(cursor.getNodeData().toStringSymbol());
            System.out.println(", " + cursor.getNodeData().toString());
            cursor = cursor.getNext();
        } while (cursor.getNext() != null);
    }
}
