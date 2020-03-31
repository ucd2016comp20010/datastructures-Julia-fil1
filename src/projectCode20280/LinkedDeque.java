package projectCode20280;

public class LinkedDeque<E> implements Deque<E> {
    private DoublyLinkedList<E> list = new DoublyLinkedList<>();
    public static void main(String[] args) {
        LinkedDeque<Integer> linkedDeque = new LinkedDeque<>();
        linkedDeque.addFirst(1);
        linkedDeque.addFirst(2);
        linkedDeque.addLast(3);
        linkedDeque.addLast(4);
        System.out.println(linkedDeque);

        System.out.println("First: " + linkedDeque.first());

        linkedDeque.removeFirst();
        System.out.println(linkedDeque);
        linkedDeque.removeLast();
        System.out.println(linkedDeque);
        System.out.println("First: " + linkedDeque.first());

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
    public E first() {
        return list.get(0);
    }

    @Override
    public E last() {
        return list.get(size());
    }

    @Override
    public void addFirst(E e) {
        list.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    @Override
    public E removeFirst() {
        return list.removeFirst();
    }

    @Override
    public E removeLast() {
        return list.removeLast();
    }

    @Override
    public String toString() {
        return "LinkedDeque{" +
                "list=" + list +
                '}';
    }
}
