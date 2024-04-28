import java.util.Scanner;

import Data_Structures.*;
import Testers.*;
import interfaces.MyList;

public class Main {
    public static <T> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("--- Choose Data Structure to Test ---");
            System.out.println("1. Test MyLinkedList");
            System.out.println("2. Test MyArrayList");
            System.out.println("3. Test MyQueue");
            System.out.println("4. Test MyStack");
            System.out.println("5. Test MyMinHeap");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    MyLinkedListTester<Integer> linkedListTester = new MyLinkedListTester<>();
                    linkedListTester.test(scanner);
                    break;
                case 2:
                    MyArrayListTester<Integer> arrayListTester = new MyArrayListTester<>();
                    arrayListTester.test(scanner);
                    break;
                case 3:
                    MyQueueTester<String> queueTester = new MyQueueTester<>();
                    queueTester.test(scanner);
                    break;
                case 4:
                    MyStackTester<String> stackTester = new MyStackTester<>();
                    stackTester.test(scanner);
                    break;
                case 5:
                    MyMinHeapTester<String> minHeapTester = new MyMinHeapTester<>();
                    minHeapTester.test(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
