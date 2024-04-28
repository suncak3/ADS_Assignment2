package Data_Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<T> implements Iterable<T> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean empty(){
        return queue.size() == 0;
    }

    /**
     * Returns number of elements in the queue.
     * @return size of the queue.
     */
    public int size(){
        return queue.size();
    }

    /**
     * Returns the front element of the queue.
     * @return the front of the queue.
     * @throws NoSuchElementException if this queue is empty.
     */
    public T peek(){
        if(empty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.getFirst();
    }

    /**
     * Adds an element to the end of the queue.
     * @param element the element to add.
     */
    public void enqueue(T element){
        queue.addLast(element);
    }

    /**
     * Returns and removes the front of the queue.
     * @return the front of the queue.
     * @throws NoSuchElementException if this queue is empty.
     */
    public T dequeue(){
        if(empty()){
            throw new NoSuchElementException("Queue is empty");
        }
        T element = queue.getFirst();
        queue.removeFirst();
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }
}
