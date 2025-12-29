package edu.mtc.egr283.sll;

public class SLLNodeDriver {

    public static void main(String[] args) {

        SLLNode<String> tailNode = new SLLNode<String>();
        tailNode.setNodeData("Tail");
        //System.out.println(tailNode.getNodeData());

        SLLNode<String> middleNode = new SLLNode<String>("Middle");
        middleNode.setNextNode(tailNode);
        //System.out.println(middleNode.getNodeData());
        //System.out.println(middleNode.getNextNode().getNodeData());

        SLLNode<String> headNode = new SLLNode<String>("Head", middleNode);
        //System.out.println(headNode.getNodeData());
        //System.out.println(headNode.getNextNode().getNodeData());
        //System.out.println(headNode.getNextNode().getNextNode().getNodeData());

        // Iterate through the SLLNodes (traverse)
        SLLNode<String> cursor = new SLLNode<String>(null, headNode);
        while (cursor.getNextNode() != null) {
            cursor = cursor.getNextNode();
            System.out.println(cursor.getNodeData());
        }
        System.out.println("End of list");
    }
}
