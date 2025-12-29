package edu.mtc.egr283.queue;

import java.util.Iterator;

public class QueueALDriver {

    public static QueueAL<String> q;

    public static void main(String[] args) {

        q =new QueueAL<String>();
        printQueue();

        System.out.println("Adding: One");
        q.add("One");
        printQueue();

        System.out.println("Adding: Two");
        q.offer("Two");
        printQueue();

        System.out.println("Peek returns: " + q.peek());
        System.out.println("Element returns: " + q.element());

        System.out.println("Adding: Three, Four, and Five");
        q.add("Three");
        q.add("Four");
        q.add("Five");
        printQueue();

        System.out.println("Remove returns: " + q.remove());
        printQueue();
        System.out.println("Poll returns: " + q.poll());
        printQueue();

        System.out.println("Attempting remove(One): " + q.remove("One"));
        System.out.println("Attempting remove(Three): " + q.remove("Three"));
        printQueue();

        System.out.println("Contains(One: " + q.contains("One"));
        System.out.println("Contains(Four): " + q.contains("Four"));

        Iterator<String> itr = q.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("*********");
        System.out.println("Adding Six and Seven");
        q.add("Six");
        q.add("Seven");
        printQueue();

        for (Object obj : q.toArray()) {
            System.out.println(obj.toString());
        }

        System.out.println("*********");
        String[] sa = new String[1];
        sa = q.toArray(sa);
        for (String s : sa) {
            System.out.println(s.toString());
        }

        q.clear();
        printQueue();
    }

    private static void printQueue() {
        System.out.print("Is empty: " + q.isEmpty());
        System.out.println(", size: " + q.size());
        System.out.println("Queue is " + q.toString());
    }
}
