package Data_Structures;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class MyStack<T> implements Iterable<T> {
    private MyArrayList<T> stack;

    public MyStack(){
        stack = new MyArrayList<>();
    }

    /**
     * Checks is the stack empty.
     * @return true if it is empty, or false otherwise.
     */
    public boolean empty(){
        return stack.size() == 0;
    }

    /**
     * Returns number of elements in the Stack.
     * @return size of the stack.
     */
    public int size(){
        return stack.size();
    }

    /**
     * Returns a reference to the topmost element of the stack.
     * @return the top element of the stack.
     */
    public T peek(){
        if(empty()){
            throw new EmptyStackException();
        }
        return stack.get(stack.size()-1);
    }

    /**
     * Adds the element at the top of the stack
     * @param element element to be added.
     * @return the added element.
     */
    public T push(T element){
        stack.add(element);
        return element;
    }

    /**
     * Retrieves and deletes the topmost element of the stack.
     * @return top element in the stack.
     */
    public T pop(){
        if(empty()){
            throw new EmptyStackException();
        }
        T element = stack.getLast();
        stack.removeLast();
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }
}
