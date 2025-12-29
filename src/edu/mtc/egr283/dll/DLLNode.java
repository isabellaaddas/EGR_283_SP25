package edu.mtc.egr283.dll;

/**
 * This is the Double Linked List node class.
 * The class has three fields, one for referencing
 * the previous node, one for the data pay load and
 * one for referencing the next node in the list
 *
 * @param <E> Generic data pay load class
 */
public class DLLNode<E> {

    private DLLNode<E> prev;
    private E nodeData;
    private DLLNode<E> next;

    /**
     * Constructor.
     * This constructor takes in three parameters
     * one for the reference to the previous node
     * one for the node data and
     * one for the reference to the next node
     * @param newPrev reference to the previous node
     * @param newNodeData node data to be stored
     * @param newNext reference to the next node
     */
    public DLLNode(DLLNode<E> newPrev, E newNodeData, DLLNode<E> newNext) {
        this.setPrev(newPrev);
        this.setNodeData(newNodeData);
        this.setNext(newNext);
    }

    /**
     * Constructor to create a double linked list
     * node only containing the node data and the
     * references to the previous node and the next
     * node are null values
     * @param newNodeData node data to be stored
     */
    public DLLNode(E newNodeData) {
        this(null, newNodeData, null);
    }

    /**
     * Default constructor
     *
     * Creates an empty Double Linked List node
     * containing null values
     */
    public DLLNode() {
        this(null, null, null);
    }

    /**
     * Accessor method to retrieve the reference
     * to the previous node in the list
     * @return reference to the previous node
     */
    public DLLNode<E> getPrev() {
        return this.prev;
    }

    /**
     * Mutator method to store the reference to
     * the previous node in the list
     * @param newPrev reference to be stored
     */
    public void setPrev(DLLNode<E> newPrev) {
        this.prev = newPrev;
    }

    /**
     * Accessor method to retrieve the node data
     * @return the stored node data
     */
    public E getNodeData() {
        return this.nodeData;
    }

    /**
     * Mutator method to store the node data
     * @param newNodeData node data to be stored
     */
    public void setNodeData(E newNodeData) {
        this.nodeData = newNodeData;
    }

    /**
     * Accessor method to retrieve the reference
     * to the next node in the list
     * @return reference to the next node
     */
    public DLLNode<E> getNext() {
        return this.next;
    }

    /**
     * Mutator method to store the reference to
     * the next node in the list
     * @param newNext reference to be stored
     */
    public void setNext(DLLNode<E> newNext) {
        this.next = newNext;
    }
}
