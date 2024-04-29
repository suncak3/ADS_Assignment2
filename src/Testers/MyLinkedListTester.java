package Testers;

import Data_Structures.MyArrayList;
import Data_Structures.MyLinkedList;

import java.util.Scanner;

public class MyLinkedListTester<T> {
    private MyLinkedList<Integer> list = new MyLinkedList<>();

    public void test(Scanner scanner) {
        int choice;

        while (true) {
            System.out.println("--- MyLinkedList Tester ---");
            System.out.println("1. Add Element at end");
            System.out.println("2. Add First Element");
            System.out.println("3. Add Last Element");
            System.out.println("4. Add Element at index");
            System.out.println("5. Set Element at index");
            System.out.println("6. Get Element by index");
            System.out.println("7. Get First Element");
            System.out.println("8. Get Last Element");
            System.out.println("9. Remove Element by index");
            System.out.println("10. Remove First Element");
            System.out.println("11. Remove Last Element");
            System.out.println("12. Check existence of element");
            System.out.println("13. Get Index");
            System.out.println("14. Get Last Index of element");
            System.out.println("15. Sort List");
            System.out.println("16. Size");
            System.out.println("17. Clear");
            System.out.println("18. Print list");
            System.out.println("19. Exit");
            System.out.print("Choose an operation: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    int element = scanner.nextInt();
                    list.add(element);
                    break;
                case 2:
                    int firstElement = scanner.nextInt();
                    list.addFirst(firstElement);
                    break;
                case 3:
                    int lastElement = scanner.nextInt();
                    list.addLast(lastElement);
                    break;
                case 4:
                    System.out.print("Enter an element: ");
                    int elementAtIndex = scanner.nextInt();
                    System.out.print("Enter index to add element at: ");
                    int index = scanner.nextInt();
                    list.add(index, elementAtIndex);
                    break;
                case 5:
                    System.out.print("Enter index of element: ");
                    int setIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new element: ");
                    int newElement = scanner.nextInt();
                    list.set(setIndex, newElement);
                    break;
                case 6:
                    System.out.print("Enter index: ");
                    int getIndex = scanner.nextInt();
                    System.out.println("Element at index " + getIndex + ": " + list.get(getIndex));
                    break;
                case 7:
                    System.out.println("First element: " + list.getFirst());
                    break;
                case 8:
                    System.out.println("Last element: " + list.getLast());
                    break;
                case 9:
                    System.out.print("Enter index of element: ");
                    int removeIndex = scanner.nextInt();
                    list.remove(removeIndex);
                    break;
                case 10:
                    list.removeFirst();
                    break;
                case 11:
                    list.removeLast();
                    break;
                case 12:
                    System.out.print("Enter element: ");
                    int checkElement = scanner.nextInt();
                    System.out.println("Element exists: " + list.exists(checkElement));
                    break;
                case 13:
                    System.out.print("Enter element: ");
                    int findElement = scanner.nextInt();
                    System.out.println("Index of element: " + list.indexOf(findElement));
                    break;
                case 14:
                    System.out.print("Enter element: ");
                    int lastFindElement = scanner.nextInt();
                    System.out.println("Last index of element: " + list.lastIndexOf(lastFindElement));
                    break;
                case 15:
                    list.sort();
                    break;
                case 16:
                    System.out.println("Size of the list: " + list.size());
                    break;
                case 17:
                    list.clear();
                    System.out.println("List cleared.");
                    break;
                case 18:
                    System.out.println("Current List: ");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                    break;
                case 19:
                    return;
            }
        }
    }
}
