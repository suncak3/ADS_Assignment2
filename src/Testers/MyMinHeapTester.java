package Testers;

import Data_Structures.MyMinHeap;

import java.util.Scanner;

public class MyMinHeapTester<T extends Comparable<T>> {
    private MyMinHeap<T> heap = new MyMinHeap<>();

    public void test(Scanner scanner) {
        int choice;

        while (true) {
            System.out.println("--- MyMinHeap Tester ---");
            System.out.println("1. Insert");
            System.out.println("2. Get Minimum");
            System.out.println("3. Extract Minimum");
            System.out.println("4. Check if Heap is Empty");
            System.out.println("5. Print Heap");
            System.out.println("6. Size of Heap");
            System.out.println("7. Exit");
            System.out.print("Choose a method: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    T element = (T) scanner.nextLine();
                    heap.insert(element);
                    System.out.println("Inserted: " + element);
                    break;
                case 2:
                    if (!heap.empty()) {
                        System.out.println("Minimum element is: " + heap.getMin());
                    } else {
                        System.out.println("Heap is empty.");
                    }
                    break;
                case 3:
                    if (!heap.empty()) {
                        System.out.println("Extracted minimum element: " + heap.extractMin());
                    } else {
                        System.out.println("Heap is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Heap is " + (heap.empty() ? "empty" : "not empty"));
                    break;
                case 5:
                    heap.printHeap();
                    break;
                case 6:
                    System.out.println("Size of the heap: " + heap.size());
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
