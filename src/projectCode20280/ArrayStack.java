package projectCode20280;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private static final int CAPACITY = 1000;//default array capacity
    private E[] data;//generic array for storage
    private int t = -1;//stack is empty and index = size -1;
    private ArrayStack(){
        this(CAPACITY);
    }
    ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
    }

    public static void main(String[] args) {
        ArrayStack<Integer> as = new ArrayStack<>();
        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);
        System.out.println(as);

        System.out.println("Top: " + as.top());

        as.pop();
        System.out.println(as);
        as.pop();
        System.out.println(as);
        System.out.println("Top: " + as.top());

    }

    @Override
    public int size() {//return the number of elements in the stack
        return t + 1;
    }

    @Override
    public boolean isEmpty() {//returns a boolean indicating whether the stack is empty
        return t == -1;
    }

    @Override
    public void push(E e) throws IllegalStateException{//adds element e to the top of the stack
        if(size() == data.length)
            throw new IllegalStateException("The stack is full");
        data[++t] = e;//increment t before adding new element

    }

    @Override
    public E top() {//returns the top element of the stack without removing it
        if(isEmpty())
            return null;
        return data[t];
    }

    @Override
    public E pop() {//removes and returns the top element from the stack (or null if stack is empty)
        if (isEmpty())
            return null;
        E answer = data[t];
        data[t] = null;//dereference to help garbage collection
        t--;
        return answer;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "data=" + Arrays.toString(data) +
                ", t=" + t +
                '}';
    }
}