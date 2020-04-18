package projectCode20280;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {

    private static final int CAPACITY = 1000;//default array capacity
    private E[] data;
    private int frontIndex = 0;
    private int numberOfElements = 0;

    private ArrayQueue() {
        this(CAPACITY);
    }

    private ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(-4);
        System.out.println(arrayQueue);

        System.out.println("First: " + arrayQueue.first());

        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        System.out.println("First: " + arrayQueue.first());

    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public void enqueue(E e) throws IllegalStateException {//inserts an element at the end of the queue
        if(numberOfElements == data.length) throw new IllegalStateException("The queue is full");
        int avail = (frontIndex + numberOfElements) % data.length;
        data[avail] = e;
        numberOfElements++;
    }

    @Override
    public E first() {
        if(isEmpty())
            return null;
        return data[frontIndex];
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            return null;
        E answer = data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex + 1) % data.length;
        numberOfElements--;
        return answer;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "data=" + Arrays.toString(data) +
                ", frontIndex=" + frontIndex +
                ", numberOfElements=" + numberOfElements +
                '}';
    }
}
