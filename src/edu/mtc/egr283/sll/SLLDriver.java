package edu.mtc.egr283.sll;

import java.util.Scanner;

public class SLLDriver {

    private static Scanner kb;
    private static SLL<String> sll;

    public static void main(String[] args) {

        kb = new Scanner(System.in);

        // Test constructor and add methods
        sll = new SLL<String>();
        sll.addAtHead(getUserInput());
        sll.add(1, getUserInput());
        sll.add(1, getUserInput());
        sll.addAtHead(getUserInput());
        sll.add(3, getUserInput());

        // Output the SLL
        outputSLL();

        // Test the other methods
        System.out.println("Data at position 2 is " + sll.get(2));

        System.out.println("Removing data at position 2");
        sll.remove(2);
        outputSLL();

        System.out.println("Removing data by the data");
        sll.remove(getUserInput());
        outputSLL();

        System.out.println("Set data at position 1");
        sll.setData(1, getUserInput());
        outputSLL();

        kb.close();
    }

    private static String getUserInput() {
        System.out.print("Enter a string: ");
        return kb.nextLine();
    }

    private static void outputSLL() {
        System.out.println("The size of the SLL is " + sll.size());
        System.out.println(sll.toString());
    }
}
