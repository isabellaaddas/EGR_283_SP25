package edu.mtc.egr283.queue;

import java.util.*;

// Tail of the queue as end of the ArrayList (length - 1)
// Head of the queue as front of the ArrayList (0)
public class QueueAL<E> implements Queue<E> {

    // Class constants for the toString method
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String COMMA_SPACE = ", ";

    // Instance variable
    private ArrayList<E> queue;

    public QueueAL() {
        this.queue = new ArrayList<E>();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public boolean contains(Object obj) {
        return this.queue.contains(obj);
    }

    @Override
    public Iterator<E> iterator() {
        return this.queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.queue.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.queue.toArray(a);
    }

    @Override
    public boolean add(E e) throws NullPointerException, ClassCastException {
        return this.offer(e);
    }

    @Override
    public boolean remove(Object obj) {
        boolean rv = false;
        // Not empty and head is the same as parameter obj
        if (!this.isEmpty() && (this.queue.get(0)).equals(obj)) {
            rv = true;
            this.queue.remove(0);
        }
        return rv;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.queue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return this.queue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.queue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.queue.retainAll(c);
    }

    @Override
    public void clear() {
        this.queue.clear();
    }

    @Override
    public boolean offer(E e) throws NullPointerException, ClassCastException {
        boolean rv = false;

        if (e == null) {
            throw new NullPointerException();
        }

        // If e is an instance of class type, add to queue
        if (e instanceof E) {
            rv = this.queue.add(e);
        }
        else {
            throw new ClassCastException();
        }

        return rv;
    }

    @Override
    public E remove() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        return this.queue.remove(0);
    }

    @Override
    public E poll() {
        E rv = null;
        if (!this.isEmpty()) {
            rv = this.queue.remove(0);
        }
        return rv;
    }

    @Override
    public E element() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.queue.get(0);
    }

    @Override
    public E peek() {
        E rv = null;
        if (!this.isEmpty()) {
            rv = this.queue.get(0);
        }
        return rv;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(QueueAL.LEFT_SQUARE_BRACKET);
        if (!this.isEmpty()) {
            sb.append(this.queue.get(0));
        }
        for (int i = 1; i < this.size(); ++i) {
            sb.append(QueueAL.COMMA_SPACE);
            sb.append(this.queue.get(i));
        }
        sb.append(QueueAL.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }
}
