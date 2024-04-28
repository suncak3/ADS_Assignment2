package Data_Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> implements Iterable<T> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    /**
     * Checks if the MinHeap is empty.
     * @return true if it's empty, or false otherwise.
     */
    public boolean empty(){
        return heap.size() == 0;
    }

    /**
     * Returns number of elements.
     * @return size of the heap.
     */
    public int size(){
        return heap.size();
    }

    /**
     * Returns the minimum of heap(in MinHeap it is the root element).
     * @return minimum element.
     */
    public T getMin(){
        if (empty()){
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    /**
     * Retrieves and deletes the root element of the heap.
     * @return the minimum(root) element.
     */
    public T extractMin(){
        if (empty()){
            throw new NoSuchElementException("Heap is empty");
        }
        T min = getMin();
        T lastItem = heap.get(heap.size() - 1);
        heap.set(0, lastItem);
        heap.remove(heap.size() - 1);
        heapify(0);
        return min;
    }

    /**
     * Adds the element to the heap.
     * @param element element to be added.
     */
    public void insert(T element){
        heap.add(element);
        traverseUp(heap.size() - 1);
    }

    /**
     * Method to print the heap.
     */
    public void printHeap(){
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * Can perform heapify actions starting from index
     * @param index index to be started.
     */
    private void heapify(int index){
        int smallest = index;
        int leftIndex = leftChildOf(index);
        int rightIndex = rightChildOf(index);

        if (leftIndex < heap.size() && heap.get(leftIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = leftIndex;
        }

        if (rightIndex < heap.size() && heap.get(rightIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = rightIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    /**
     * can perform traverseUp actions starting from index
     * @param index index to be started.
     */
    private void traverseUp(int index){
        while(index != 0 && heap.get(parentOf(index)).compareTo(heap.get(index)) > 0){
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    /**
     * Returns the index of the left child.
     * @param index index to find left child.
     * @return the index of left child.
     */
    private int leftChildOf(int index){
        return 2 * index + 1;
    }

    /**
     * Returns the index of the right child.
     * @param index index to find right child.
     * @return the index of right child.
     */
    private int rightChildOf(int index){
        return 2 * index + 2;
    }

    /**
     * Returns the index of the parent item
     * @param index index of which parent to find.
     * @return index of parent element.
     */
    private int parentOf(int index){
        return (index - 1) / 2;
    }

    /**
     * Exchanges two elements by their positions.
     * @param index1 index to be swapped.
     * @param index2 index to be swapped.
     */
    private void swap(int index1, int index2){
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    @Override
    public Iterator<T> iterator() {
        return heap.iterator();
    }
}
