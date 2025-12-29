package edu.mtc.egr283.sll;

/**
 * This is the Single Linked List class.
 * @author Ezra A.
 * @version 1.00 2025-02-10
 *
 * @param <E> Generic data type
 */
public class SLL<E> {

    private static final String COLON_SPACE = ": ";
    private static final String NEW_LINE = "\n";

    private int length;
    private SLLNode<E> head;
    private SLLNode<E> tail;

    /**
     * Constructor.
     * Initializes the size or length to zero and
     * creates the dummy head and dummy tail nodes.
     */
    public SLL() {
        this.length = 0;
        this.tail = new SLLNode<E>();
        this.head = new SLLNode<E>(null, tail);
    }

    /**
     * Accessor method for the length/size of the list
     *
     * @return the length of the list
     */
    public int size() {
        return this.length;
    }

    /**
     * Mutator method to modify the data at the
     * given position
     * @param position given position to store the data
     * @param newNodeData new data to be stored
     */
    public void setData(int position, E newNodeData) {
        (this.find(position)).setNodeData(newNodeData);
    }

    /**
     * Method to add a new node containing the given data
     * to the list at the given position
     * @param position index of where to store the node
     * @param newNodeData data to be stored in the node
     */
    public void add(int position, E newNodeData) {
        SLLNode<E> cursor = this.head;

        // Find the node in front of the position
        if (position > 0) {
            cursor = this.find(position - 1);
        }

        this.addAfter(cursor, new SLLNode<E>(newNodeData, null));
    }

    /**
     * Method to add a node at the beginning of the list
     * containing the given data
     * @param newNodeData data to be stored
     */
    public void addAtHead(E newNodeData) {
        this.add(0, newNodeData);
    }

    /**
     * Method to remove data node from the list
     * at the given position
     * @param position index of the node to remove
     * @return the data from the removed node
     */
    public E remove(int position) {
        SLLNode<E> cursor = this.head;
        if (position > 0) {
            cursor = this.find(position - 1);
        }

        SLLNode<E> targetNode = cursor.getNextNode();
        cursor.setNextNode(targetNode.getNextNode());

        --length;

        E rv = targetNode.getNodeData();

        // Reclaim the memory by removing references from targetNode
        targetNode.setNextNode(null);
        targetNode.setNodeData(null);
        return rv;
    }

    /**
     * Method to remove the node containing the
     * given data from the list
     * @param targetData data to be removed
     * @return the data that was removed from the list
     */
    public E remove(E targetData) {
        return this.remove(this.findIndex(targetData));
    }

    /**
     * Accessor method to retrieve the data stored
     * at the given position or index
     * @param position index of data to retrieve
     * @return the data from the requested position
     */
    public E get (int position) {
        return this.getDataAtPosition(position);
    }

    @Override
    /**
     * Returns the list via an index:data pairing
     * with a new line separating each pairing
     * @return the string representation of the list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        SLLNode<E> cursor = this.head.getNextNode();
        int index = 0;

        while (cursor != this.tail) {
            sb.append(index);
            sb.append(SLL.COLON_SPACE);
            sb.append(cursor.getNodeData().toString());
            sb.append(SLL.NEW_LINE);

            cursor = cursor.getNextNode();
            ++index;
        }
        return sb.toString();
    }

    // *** Private helper methods below ***
    private void addAfter(SLLNode<E> currentNode, SLLNode<E> newNode) {

        // Set newNode's next to currentNode's next
        newNode.setNextNode(currentNode.getNextNode());

        // Set currentNode's next to newNode
        currentNode.setNextNode(newNode);

        ++this.length;
    }

    private int findIndex(E targetData) {
        int rv = 0;
        SLLNode<E> cursor = this.head.getNextNode();

        // Run while loop until cursor reaches tail or cursor data equals target data
        while ((cursor != this.tail) && (!cursor.getNodeData().equals(targetData))) {
            cursor = cursor.getNextNode();
            ++rv;
        }

        // Did not find target data?
        if (rv == this.size()) {
            rv = -1;
        }

        return rv;
    }

    private SLLNode<E> find(int position) {
        SLLNode<E> cursor = this.head.getNextNode();
        int index = 0;

        // Run while loop until index is position is reached or tail is reached
        while ((index != position) && (cursor != this.tail)) {
            ++index;
            cursor = cursor.getNextNode();
        }

        return cursor;
    }

    // Return the data at position
    private E getDataAtPosition(int position) {
        return (this.find(position)).getNodeData();
    }
}
