package projectCode20280;

public class LinkedStack<E> implements Stack<E> {
private SinglyLinkedList<E> list = new SinglyLinkedList<>();
LinkedStack(){}
    public static void main(String[] args) {
        LinkedStack<Integer> ls = new LinkedStack<>();
        ls.push(1);
        ls.push(2);
        ls.push(3);
        ls.push(4);
        System.out.println(ls);

        System.out.println("Top: " + ls.top());

        ls.pop();
        System.out.println(ls);
        ls.pop();
        System.out.println(ls);
        System.out.println("Top: " + ls.top());

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
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.get(0);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    public String toString() {
        String output = new String();
        for(int i = 0; i < list.size(); i++) {
            output += list.get(i) + ", ";
        }
        return output;
    }
}
