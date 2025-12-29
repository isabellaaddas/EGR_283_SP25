package egr.mtc.egr283.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackAL<T> {

    // Constants for the toString
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String COMMA_SPACE = ", ";

    private ArrayList<T> stack;

    /**
     * Creates an empty Stack.
     */
    public StackAL() {
        this.stack = new ArrayList<T>();
    }

    /**
     * Tests if the stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    public boolean empty() {
        return this.stack.isEmpty();
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return the object at the top of this stack (the last item of the ArrayList object).
     * @throws EmptyStackException - if this stack is empty
     */
    public T peek() throws EmptyStackException {
        T rv = null;
        if (this.empty()) {
            throw new EmptyStackException();
        }
        else {
            rv = this.stack.get(0);
        }
        return rv;
    }

    /**
     * Removes the object at the top of this stack and
     * returns that object as the value of this function.
     * @return The object at the top of this stack (the last item of the ArrayList object).
     * @throws EmptyStackException - if this stack is empty
     */
    public T pop() throws EmptyStackException {
        T rv = null;
        if (this.empty()) {
            throw new EmptyStackException();
        }
        else {
            rv = this.stack.get(0);
            this.stack.remove(0);
        }
        return rv;
    }

    /**
     * Pushes an item onto the top of this stack.
     * @param newItem - the item to be pushed onto this stack.
     * @return the item argument
     */
    public T push(T newItem) {
        this.stack.add(0, newItem);
        return newItem;
    }

    /**
     * Returns the 1-based position where an object is on this stack.
     * If the object o occurs as an item in this stack, this method returns
     * the distance from the top of the stack of occurrence nearest the
     * top of the stack; the topmost item of the stack is considered to be
     * at distance 1. The equals method is used to compare o to the items
     * in this stack.
     * @param target - the desired object
     * @return the 1-based position from the top of the stack where the object.
     * is located; the return value -1 indicates that the object is not on the stack.
     */
    public int search(Object target) {
        int rv = this.stack.indexOf(target) + 1;
        if (rv == 0) {
            rv = -1;
        }
        return rv;
    }

    /**
     * Returns the number of components in this stack.
     * @return the number of components in this stack.
     */
    public int size() {
        return this.stack.size();
    }

    @Override
    /**
     * Returns a string representation of this Stack,
     * containing the String representations of each element
     * within the Stack.
     * Empty Stack: []
     * Stack with items: [item1, item2, ... , itemN]
     * @return a String representation of the stack
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StackAL.LEFT_SQUARE_BRACKET);
        for (int i = 0; i < this.size() - 1; ++i) {
            sb.append(this.stack.get(i).toString());
            sb.append(StackAL.COMMA_SPACE);
        }
        if(!this.empty()) {
            sb.append(this.stack.get(this.size() - 1).toString());
        }
        sb.append(StackAL.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }
}
