package edu.mtc.egr283.dll;

public class DLLNodeDriver {

    public static void main(String[] args) {

        DLLNode<String> node1 = new DLLNode<String>();
        node1.setNodeData("First");
        //System.out.println(node1.getNodeData());

        DLLNode<String> node3 = new DLLNode<String>("Third");
        //System.out.println(node3.getNodeData());

        DLLNode<String> node2 = new DLLNode<String>(node1, "Second", node3);
        node1.setNext(node2);
        node3.setPrev(node2);

//        System.out.println(node2.getPrev().getNodeData());
//        System.out.println(node2.getNodeData());
//        System.out.println(node2.getNext().getNodeData());

        // Traverse forward through the DLL
        DLLNode<String> cursor = new DLLNode<String>(null, "Cursor", node1);
        System.out.println("Start of list");
        while(cursor.getNext() != null) {
            cursor = cursor.getNext();
            System.out.println(cursor.getNodeData());
        }
        System.out.println("End of list");

        System.out.println();

        // Traverse backwards through the list
        DLLNode<String> prevCursor = new DLLNode<String>(node3, "Prev", null);
        System.out.println("Start of PREV list");
        while (prevCursor.getPrev() != null) {
            prevCursor = prevCursor.getPrev();
            System.out.println(prevCursor.getNodeData());
        }
        System.out.println("End of PREV list");
    }
}
