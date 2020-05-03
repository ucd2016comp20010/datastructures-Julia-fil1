package projectCode20280;

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(4);
        System.out.println(linkedQueue);

        System.out.println("First: " + linkedQueue.first());

        linkedQueue.dequeue();
        System.out.println(linkedQueue);
        linkedQueue.dequeue();
        System.out.println(linkedQueue);
        System.out.println("First: " + linkedQueue.first());
    }



    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return list.get(0);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder lq = new StringBuilder();
        lq.append('[');
        for (E i: list){
            lq.append(i + ", ");
        }
        lq.deleteCharAt(lq.length() - 1);
        lq.deleteCharAt(lq.length() - 1);
        lq.append("]");
        return lq.toString();
    }

}

