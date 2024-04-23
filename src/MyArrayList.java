import interfaces.MyList;
import java.util.*;

 public class MyArrayList<T> implements MyList<T>{
    private T[] arr;
    private int size;

    public MyArrayList(){
        arr = (T[]) new Object[5];
        size = 0;
    }

    @Override
    public void add(T element){
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }
    @Override
    public void set(int index, T element){
        checkIndex(index);
        arr[index] = element;
    }
    @Override
    public void add(int index, T element){
        checkIndex(index);
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[index]=element;
    }
    @Override
    public void addFirst(T element){
        add(0,element);
    }
    @Override
    public void addLast(T element){
        add(element);
    }
    @Override
    public T get(int index){
        checkIndex(index);
        return arr[index];
    }
    @Override
    public T getFirst(){
        if(size==0){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return arr[0];
    }
    @Override
    public T getLast(){
        if(size==0){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return arr[size-1];
    }
    @Override
    public void remove(int index){
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        arr[size - 1] = null;
        size--;
    }
    @Override
    public void removeFirst(){
        if(size==0){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        remove(0);
    }
    @Override
    public void removeLast(){
        if(size==0){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        remove(size-1);
    }
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
    @Override
    public int indexOf(Object element){
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object element){
        for (int i = size - 1; i >= 0 ; i--) {
            if(arr[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean exists(Object element){
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Object[] toArray(){
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = arr[i];
        }
        return array;
    }
    @Override
    public void clear(){
        arr = (T[]) new Object[5];
        size = 0;
    }
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
