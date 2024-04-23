//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();

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

        // Clear the list
        myList.clear();
        System.out.print("After clearing list: ");
        printList(myList);

        // Size of the list
        System.out.println("Size of the list: " + myList.size());
    }

    /**
     * Prints all elements in the MyArrayList in a readable format.
     * @param list The MyArrayList to print.
     */
    private static void printList(MyArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}