package edu.mtc.egr283.dll;

public class DLLDriver {

    public static void main(String[] args) {

        DLL<String> dll = new DLL<String>();

        dll.addAtHead("Head");
        dll.addAtTail("Tail");

        System.out.println("The size is " + dll.size());
        System.out.println(dll.toString());

        dll.addAtPosition(1, "third");
        dll.addAtPosition(1, "second");
        dll.addAtPosition(3, "fourth");
        dll.addAtPosition(4, "fifth");
        dll.addAtPosition(5, "sixth");

        System.out.println("The size is " + dll.size());
        System.out.println(dll.toString());

        System.out.println("Remove by position - 3");
        dll.remove(3);

        System.out.println("The size is " + dll.size());
        System.out.println(dll.toString());

        System.out.println("Remove by target data - fifth");
        dll.remove("fifth");

        System.out.println("The size is " + dll.size());
        System.out.println(dll.toString());

        System.out.println("Set position 1 to first");
        dll.set(1, "first");

        System.out.println("The size is " + dll.size());
        System.out.println(dll.toString());
    }
}
