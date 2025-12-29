package edu.mtc.egr283.sll;

/**
 * This class is the Single Linked List basic node.
 * It has two fields, one to hold the data and one
 * to reference the next node in the list.
 * @author Ezra A.
 * @version 1.00 2025-02-05
 * @param <T> Generic class parameter
 */
public class SLLNode<T> {

    // Instance fields
    private T nodeData;
    private SLLNode<T> nextNode;

    /**
     * Constructor of the Single Linked List Node
     * This creates a SLLNode using the node data
     * and the SLLNode reference to the next node
     * @param newNodeData node data to be stored
     * @param newNextNode reference to next node
     */
    public SLLNode(T newNodeData, SLLNode<T> newNextNode) {
        this.setNodeData(newNodeData);
        this.setNextNode(newNextNode);
    }

    /**
     * Constructor of the Single Linked List Node
     * This creates a SLLNode using the node data
     * and null for the next node reference
     * @param newNodeData node data to be stored
     */
    public SLLNode(T newNodeData) {
        this(newNodeData, null);
    }

    /**
     * Default "no-args" constructor
     * This creates an empty SLLNode
     * with null values for both fields
     */
    public SLLNode() {
        this(null, null);
    }

    /**
     * Accessor method for the node data
     * @return the node data
     */
    public T getNodeData() {
        return this.nodeData;
    }

    /**
     * Mutator method for the node data
     * @param newNodeData the node data to be stored
     */
    public void setNodeData(T newNodeData) {
        this.nodeData = newNodeData;
    }

    /**
     * Accessor method for the next node
     * @return the next node reference
     */
    public SLLNode<T> getNextNode() {
        return this.nextNode;
    }

    /**
     * Mutator method for the next node
     * @param newNextNode reference to the next node
     */
    public void setNextNode(SLLNode<T> newNextNode) {
        this.nextNode = newNextNode;
    }
}
