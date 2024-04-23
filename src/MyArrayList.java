import interfaces.MyList;
import java.util.*;

 public class MyArrayList<T> implements MyList<T>{
    private T[] arr;
    private int size;

     /**
      * Constructs an empty list with an initial capacity of 5.
      */
    public MyArrayList(){
        arr = (T[]) new Object[5];
        size = 0;
    }

     /**
      * Adds an element to the end of this list.
      * Extends the array if the current capacity is reached.
      * @param element the element to be added to the end of the list.
      */
    @Override
    public void add(T element){
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

     /**
      * Replaces the element at the specific index with new one.
      * @param index index of the element to be replaced
      * @param element new element to be set
      */
    @Override
    public void set(int index, T element){
        checkIndex(index);
        arr[index] = element;
    }

     /**
      * Inserts an element at a specific index, and shifting other elements to the right.
      * Automatically extends the list if needed.
      * @param index
      * @param element
      */
    @Override
    public void add(int index, T element){
        checkIndex(index);
        if(size>=arr.length){
            increaseBuffer();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index]=element;
        size++;
    }

     /**
      * Inserts the element at the beginning of the list.
      * @param element element to be added at the beginning.
      */
    @Override
    public void addFirst(T element){
        add(0,element);
    }

     /**
      * Inserts the element at the end of the list.
      * @param element element to be added at the end of the list.
      */
    @Override
    public void addLast(T element){
        add(element);
    }

     /**
      * Returns the element at the specific element.
      * @param index index of the element to return.
      * @return the element at the specified index.
      */
    @Override
    public T get(int index){
        checkIndex(index);
        return arr[index];
    }

     /**
      * Returns the first element of the list.
      * @return the first element in this list.
      * @throws IndexOutOfBoundsException if the list is empty.
      */
    @Override
    public T getFirst(){
        if(size==0){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return arr[0];
    }

     /**
      * Returns the last element of the list.
      * @return the last element in this lest.
      * @throws IndexOutOfBoundsException if the list is empty.
      */
    @Override
    public T getLast(){
        if(size==0){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return arr[size-1];
    }

     /**
      * Removes the element at the specific index.
      * Shifts elements to the left
      * @param index index of the element to be removed.
      */
    @Override
    public void remove(int index){
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        arr[size - 1] = null;
        size--;
    }

     /**
      * Removes the first element of the list.
      */
    @Override
    public void removeFirst(){
        if(size==0){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        remove(0);
    }

     /**
      * Removes the last element of the list.
      */
    @Override
    public void removeLast(){
        if(size==0){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        remove(size-1);
    }

     /**
      * Sorts the elements of the list in ascending order.
      */
    @Override
    public void sort(){
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if(((Comparable)arr[j]).compareTo(arr[j + 1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

     /**
      * Returns the index of the given element
      * or -1 if the element is not found.
      * @param element element to search index for.
      * @return the index of the element.
      */
    @Override
    public int indexOf(Object element){
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

     /**
      * Returns the index of the last occurrence of the given element
      * or -1 if the element is not found.
      * @param element element to search index for.
      * @return the index of the element.
      */
    @Override
    public int lastIndexOf(Object element){
        for (int i = size - 1; i >= 0 ; i--) {
            if(arr[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

     /**
      * Checks if the specific element exists in the list.
      * @param element element to be tested.
      * @return true if exists or false otherwise.
      */
    @Override
    public boolean exists(Object element){
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(element)){
                return true;
            }
        }
        return false;
    }

     /**
      * Returns the array with all element of the list.
      * @return an array containing all of the elements.
      */
    @Override
    public Object[] toArray(){
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = arr[i];
        }
        return array;
    }

     /**
      * Removes all elements in the list.
      */
    @Override
    public void clear(){
        arr = (T[]) new Object[5];
        size = 0;
    }

     /**
      * Returns the number of elements in the list.
      * @return the number of the elements in the list.
      */
    @Override
    public int size(){
        return size;
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[(arr.length * 2)];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private void checkIndex(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("index is not correct");
        }
    }
    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }
            @Override
            public T next() {
                return null;
            }
        };
    }
}
