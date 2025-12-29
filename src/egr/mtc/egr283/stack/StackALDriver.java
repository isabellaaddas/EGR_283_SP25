package egr.mtc.egr283.stack;

public class StackALDriver {

    private static StackAL<Boolean> s;

    public static void main(String[] args) {

        s = new StackAL<Boolean>();
        printStack();

        s.push(true);
        s.push(false);
        s.push(false);
        s.push(true);
        s.push(false);
        s.push(true);
        printStack();

        System.out.println("Peek is: " + s.peek());

        System.out.println("Pop: " + s.pop());
        printStack();

        System.out.println("Search [true]: " + s.search(true));
        System.out.println("Search [false]: " + s.search(false));

        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());
        printStack();

        System.out.println("Search [false]: " + s.search(false));
    }

    private static void printStack() {
        System.out.print("Is empty: " + s.empty());
        System.out.println(", size: " + s.size());
        System.out.println("Stack is: " + s.toString());
    }
}
