package edu.mtc.egr283.dll;

public class DLL<T> {

    private static final String COLON_SPACE = ": ";
    private static final String NEW_LINE = "\n";

    private DLLNode<T> head;
    private DLLNode<T> tail;
    private int length;

    public DLL() {

        this.length = 0;
        this.head = new DLLNode<T>();
        this.tail = new DLLNode<T>();

        // Connect the nodes
        this.head.setNext(tail);
        this.tail.setPrev(head);
    }

    public int size() {
        return this.length;
    }

    protected DLLNode<T> getHead() {
        return this.head;
    }

    protected DLLNode<T> getTail() {
        return this.tail;
    }

    public T get(int position) {
        return this.getDataAtPosition(position);
    }

    public void set(int position, T newNodeData) {
        (this.find(position)).setNodeData(newNodeData);
    }

    public void addAtHead(T newNodeData) {
        this.addAfter(this.getHead(), new DLLNode<T>(newNodeData));
    }

    public void addAtTail(T newNodeData) {
        this.addAfter(this.getTail().getPrev(), new DLLNode<T>(newNodeData));
    }

    public void addAtPosition(int position, T newNodeData) {
        DLLNode<T> cursor = this.getHead();
        DLLNode<T> newNode = new DLLNode<T>(newNodeData);

        if (position > 0) {
            cursor = this.find(position - 1);
            this.addAfter(cursor, newNode);
        }
    }

    public T remove(int position) {
        DLLNode<T> cursor = this.getHead();
        if (position > 0) {
            cursor = this.find(position - 1);
        }

        // Remove the node from the list
        DLLNode<T> targetNode = cursor.getNext();
        (targetNode.getPrev()).setNext(targetNode.getNext());
        (targetNode.getNext()).setPrev(targetNode.getPrev());
        --this.length;

        // Get data to be returned
        T rv = targetNode.getNodeData();

        // Reclaim the memory, prevent memory leaks
        targetNode.setNext(null);
        targetNode.setNodeData(null);
        targetNode.setPrev(null);

        return rv;
    }

    public T remove(T target) {
        return this.remove(this.findIndex(target));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        DLLNode<T> cursor = this.getHead().getNext();
        int index = 0;

        while (cursor != this.getTail()) {

            sb.append(index);
            sb.append(DLL.COLON_SPACE);
            sb.append(cursor.getNodeData().toString());
            sb.append(DLL.NEW_LINE);

            cursor = cursor.getNext();
            ++index;
        }

        return sb.toString();
    }

    // *** Private helper methods ***

    private void addAfter(DLLNode<T> currentNode, DLLNode<T> newNode) {

        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);

        newNode.setPrev(currentNode);
        (newNode.getNext()).setPrev(newNode);

        ++this.length;
    }

    private int findIndex (T targetData) {

        DLLNode<T> cursor = this.getHead().getNext();
        int index = 0;

        // Continue to loop until we either reach the end of the list
        // or we find the target data

        while ((cursor != this.getTail()) && (!cursor.getNodeData().equals(targetData))) {

            cursor = cursor.getNext();
            ++index;
        }

        // If we did not find the target data, set the index to -1
        if (!cursor.getNodeData().equals(targetData)) {
            index = -1;
        }

        return index;
    }

    private DLLNode<T> find(int position) {
        DLLNode<T> cursor = null;

        if (position < (this.size() / 2)) {
            cursor = this.getHead().getNext();
            for (int i = 0; i != position; ++i) {
                cursor = cursor.getNext();
            }
        }
        else {
            cursor = this.getTail().getPrev();
            for (int i = this.size() - 1; i != position; --i) {
                cursor = cursor.getPrev();
            }
        }

        return cursor;
    }

    private T getDataAtPosition(int position) {
        return (this.find(position)).getNodeData();
    }
}
