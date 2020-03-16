package projectCode20280;
import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {
	public String toString() {
		Node<E> current = tail.next;
		StringBuilder output = new StringBuilder("size " + size() + ": [");

		while(current != tail) {
			output.append(current.element).append(", ");
			current = current.next;
		}

		return output.toString() + tail.element + "]";
	}


	/*
	Having Node as a nested class provides strong encapsulation,
	shielding users of our class from the underlying details about nodes and links.
	This design also allows Java to differentiate this node type from forms of nodes we may define for use in other structures.
	 */

	//nested node class
	private static class Node<E> {
		private E element;//reference to the element stored at this node
		private Node<E> next;//reference to the subsequent node in the list

		private Node(E e, Node<E> n){
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext(){
			return next;
		}

		public void setNext(Node<E> n){
			next = n;
		}
	}

	private Node<E> tail = null;
	private int size = 0;

	private CircularlyLinkedList(){}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) {
		Node<E> current = tail.next;//creating a node to iterate through the list
		for(int j = 0; j < i; j++)
			current = current.next;
		return current.element;
	}

	@Override
	public void add(int i, E e) {
		Node<E> previous = tail;
		Node<E> current = tail.next;

		for(int j = 0; j < i; j++){
			previous = previous.next;
			current = current.next;
		}

		previous.next = new Node<>(e, current);
		size++;
	}

	@Override
	public E remove(int i) {
		if(isEmpty())
			return null;
		else{
			Node<E> previous = tail;
			Node<E> current = tail.next;

			for(int j = 0; j < i; j++){
				previous = previous.next;
				current = current.next;
			}
			previous = current.next;
			size--;
			return current.element;
		}
	}

	@Override
	public E removeFirst() {
		Node<E> current = tail.next;
		tail.next = current.next;
		//tail.next = tail.next.next;
		size--;
		return current.element;
	}

	@Override
	public E removeLast() {
		if (isEmpty())
			return null;
		else {
			Node<E> current = tail.next;
			while (current.next != tail){
				current = current.next;
			}
			E element = tail.element;
			current.next = tail.next;
			tail = current;
			size--;
			return element;
		}
	}

	@Override
	public Iterator<E> iterator() {
			return new CircularlyLinkedListIterator(); // create a new instance of the inner class
		}


	@Override
	public void addFirst(E e) {
		if(isEmpty()) {
			tail = new Node<>(e, null);
			tail.next = tail; // linking to itself
		} else {
			tail.next = new Node<>(e, tail.next);
		}
		size++;

	}

	@Override
	public void addLast(E e) {
		addFirst(e); // inserts new node at the beginning of the list
		tail = tail.next; // new node becomes the tail
	}

	private void rotate() {
		if(tail != null) { // If list is not empty
			tail = tail.next; // the old head becomes the new tail
		}
	}


	private class CircularlyLinkedListIterator extends CircularlyLinkedList<E> implements Iterator<E>{

		Node<E> prev = null;
		Node<E> current = tail.next;

		@Override
		public boolean hasNext() {
			//return iterator.getNext() != null;
			return !((prev == tail) && (current == tail.next));
		}

		@Override
		public E next() {
			E data = current.element;
			prev = current;
			current = current.next;
			return data;
		}

	}
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}

		System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();

		ll.rotate();
		System.out.println(ll);

		ll.removeFirst();
		ll.rotate();
		System.out.println(ll);

		ll.removeLast();
		ll.rotate();
		System.out.println(ll);

		ll.addFirst(1);
		System.out.println(ll);

		for (Integer e : ll) {
			System.out.println("value: " + e);
		}

	}
}