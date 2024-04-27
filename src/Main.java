import java.util.Scanner;
import interfaces.MyList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which list do you want to test?");
        System.out.println("1: MyLinkedList");
        System.out.println("2: MyArrayList");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        MyList<Integer> myList;
        if (choice == 1) {
            myList = new MyLinkedList<>();
            System.out.println("Testing MyLinkedList");
        } else if (choice == 2) {
            myList = new MyArrayList<>();
            System.out.println("Testing MyArrayList");
        } else {
            System.out.println("Invalid choice");
            scanner.close();
            return;
        }

        // Add elements
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);
        System.out.print("After adding elements: ");
        printList(myList);

        // Add elements at specific positions
        myList.add(0, 5);
        myList.add(2, 15);
        System.out.print("After inserting elements at specific index: ");
        printList(myList);
        myList.addFirst(66);
        myList.addLast(77);
        System.out.print("After adding elements at first and last indexes: ");
        printList(myList);

        // Access elements
        System.out.println("Element at index 1: " + myList.get(1));
        System.out.println("First element: " + myList.getFirst());
        System.out.println("Last element: " + myList.getLast());

        // Modify elements
        myList.set(1, 52);
        System.out.print("After updating element: ");
        printList(myList);

        // Remove elements
        myList.remove(2);
        System.out.print("After removing element at index 2: ");
        printList(myList);

        myList.removeFirst();
        myList.removeLast();
        System.out.print("After removing first and last elements: ");
        printList(myList);

        // Sorting the list
        myList.add(25);
        myList.add(5);
        myList.sort();
        System.out.print("Sorted list: ");
        printList(myList);

        // Check existence
        System.out.println("Does 25 exist in the list? " + myList.exists(25));

        // Index of elements
        System.out.println("Index of 25: " + myList.indexOf(25));
        System.out.println("Last index of 5: " + myList.lastIndexOf(5));


        // Size of the list
        System.out.println("Size of the list: " + myList.size());

        // Clear the list
        myList.clear();
        System.out.print("After clearing list: ");
        printList(myList);
    }

    /**
     * Prints all elements in the MyList in a readable format.
     * @param list The MyList to print.
     */
    private static void printList(MyList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
