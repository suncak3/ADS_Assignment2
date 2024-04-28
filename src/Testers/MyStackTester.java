package Testers;

import Data_Structures.MyStack;

import java.util.Scanner;
import java.util.Stack;

public class MyStackTester<T> {
    private MyStack<T> stack = new MyStack<>();

    public void test(Scanner scanner) {
        int choice;

        while (true) {
            System.out.println("--- MyStack Tester ---");
            System.out.println("1. Push Element");
            System.out.println("2. Pop Element");
            System.out.println("3. Peek Top Element");
            System.out.println("4. Check if Stack is Empty");
            System.out.println("5. Check Size of Stack");
            System.out.println("6. Print Stack");
            System.out.println("7. Exit");
            System.out.print("Choose an operation: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to push: ");
                    T element = (T) scanner.nextLine();
                    stack.push(element);
                    System.out.println("Element pushed: " + element);
                    break;
                case 2:
                    if (!stack.empty()) {
                        System.out.println("Popped element: " + stack.pop());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 3:
                    if (!stack.empty()) {
                        System.out.println("Top element: " + stack.peek());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Stack is " + (stack.empty() ? "empty" : "not empty"));
                    break;
                case 5:
                    System.out.println("Size of the stack: " + stack.size());
                    break;
                case 6:
                    printStack();
                    break;
                case 7:
                    System.out.println("Exiting MyStack Tester.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void printStack() {
        if (stack.empty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Stack<T> tempStack = new Stack<>();
        while (!stack.empty()) {
            T element = stack.pop();
            tempStack.push(element);
        }

        System.out.println("Current Stack: ");
        while (!tempStack.empty()) {
            T element = tempStack.pop();
            System.out.print(element + " ");
            stack.push(element);
        }
        System.out.println();
    }
}
