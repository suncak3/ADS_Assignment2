package Testers;

import Data_Structures.MyQueue;

import java.util.Scanner;

public class MyQueueTester<T> {
    private MyQueue<T> queue = new MyQueue<>();

    public void test(Scanner scanner) {
        int choice;

        while (true) {
            System.out.println("--- MyQueue Tester ---");
            System.out.println("1. Enqueue Element");
            System.out.println("2. Dequeue Element");
            System.out.println("3. Peek Front Element");
            System.out.println("4. Check if Queue is Empty");
            System.out.println("5. Check Size of Queue");
            System.out.println("6. Print Queue");
            System.out.println("7. Exit");
            System.out.print("Choose an operation: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter an element to enqueue: ");
                    T element = (T) scanner.nextLine();
                    queue.enqueue(element);
                    System.out.println("Element enqueued: " + element);
                    break;
                case 2:
                    if (!queue.empty()) {
                        System.out.println("Dequeued element: " + queue.dequeue());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 3:
                    if (!queue.empty()) {
                        System.out.println("Front element: " + queue.peek());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Queue is " + (queue.empty() ? "empty" : "not empty"));
                    break;
                case 5:
                    System.out.println("Size of the queue: " + queue.size());
                    break;
                case 6:
                    printQueue();
                    break;
                case 7:
                    System.out.println("Exiting MyQueue Tester.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void printQueue() {
        if (queue.empty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Current Queue:");
        for (T element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
