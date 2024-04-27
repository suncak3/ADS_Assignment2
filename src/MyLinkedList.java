import interfaces.MyList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    private MyNode<T> head = null;
    private MyNode<T> tail = null;
    private int size = 0;

    private static class MyNode<E>{
        E element;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E element, MyNode<E> prev, MyNode<E> next){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(T element) {
        MyNode<T> t = tail;
        MyNode<T> newNode = new MyNode<>(element, t, null);
        tail = newNode;
        if(t == null){
            head = newNode;
        }
        else{
            t.next = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T element){
        MyNode<T> t = getNode(index);
        t.element = element;
    }

    @Override
    public void add(int index, T element){
        if(index == size){
            add(element);
        }
        MyNode<T> node = getNode(index);
        MyNode<T> newNode = new MyNode<>(element, node.prev, node);

        if(node.prev != null){
            node.prev.next = newNode;
        }
        else{
            head = newNode;
        }
        node.prev = newNode;
        size++;
    }

    @Override
    public void addFirst(T element){
        MyNode<T> h = head;
        MyNode<T> newNode = new MyNode<T>(element, null, h);
        head = newNode;
        if(h == null){
            tail = newNode;
        }
        else{
            h.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T element){
        add(element);
    }

    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    @Override
    public T getFirst() {
        return getNode(0).element;
    }

    @Override
    public T getLast() {
        return getNode(size - 1).element;
    }

    @Override
    public void remove(int index) {
        MyNode<T> node = getNode(index);
        if(node.prev == null){
            head = node.next;
        }
        else{
            node.prev.next = node.next;
        }
        if(node.next == null){
            tail = node.prev;
        }
        else{
            node.next.prev = node.prev;
        }
        node.element = null;
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort(){
        Object[] array = this.toArray();
        bubbleSort(array);
        MyNode<T> t = head;

        for(Object element : array){
            t.element = (T) element;
            t = t.next;
        }
    }

    @Override
    public int indexOf(Object element){
        int index = 0;
        MyNode<T> t = head;
        while(t != null){
            if(t.element.equals(element)){
                return index;
            }
            t = t.next;
            index += 1;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element){
        int index = size - 1;
        MyNode<T> h = tail;
        while(h != null){
            if(h.element.equals(element)){
                return index;
            }
            h = h.prev;
            index -= 1;
        }
        return -1;
    }

    @Override
    public boolean exists(Object element){
        MyNode<T> h = head;
        while(h != null){
            if(h.element.equals(element)){
                return true;
            }
            h = h.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        MyNode<T> t = head;
        while(t != null){
            array[index++] = t.element;
            t = t.next;
        }
        return array;
    }

    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }

    private void bubbleSort(Object[] array){
        boolean swapped;
        for(int i = 0; i < array.length - 1; i++){
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if(((Comparable)array[j]).compareTo(array[j + 1]) > 0){
                    Object temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    private MyNode<T> getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Incorrect index");
        }

        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
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
