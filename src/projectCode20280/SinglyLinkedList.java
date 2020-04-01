package projectCode20280;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

	private static class Node<E> {
		private E element;//reference (like a pointer) to the element stored at this node
		private Node<E> next;//reference (like a pointer) to the subsequent node in the list

		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}


	}
	public String toString() {
		String tempString = "";

		for(Iterator<E> it = iterator(); it.hasNext();){
			tempString += "[" + it.next() + "]";
		}
		return tempString;
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}



	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private Node<E> getNode(int position){
		Node<E> current = head;
		for(int i = 0; i < position; i++){
			current = current.next;
		}
		return current;
	}

	@Override
	public E get(int i) {
		return getNode(i).getElement();
	}

	@Override
	public void add(int i, E e) {
		if(i == 0)//adding at the beginning of the list
			addFirst(e);
		else if(i == size){//adding at the end of the list
			addLast(e);
		}
		else {
			addNodeAfter(getNode(i-1), e);
		}
	}

	private void addNodeAfter(Node<E> e, E data)
	{
		Node<E> newNode = new Node<E>(data, e.getNext());
		e.setNext(newNode);
		size++;
	}

	@Override
	public E remove(int i) {
		Node<E> previous = getNode(i-1);
		Node<E> current = previous.getNext();
		E element = current.getElement();
		previous.setNext(current.getNext());
		return element;
	}

	@Override
	public Iterator<E> iterator() {

	    return new ListIterator(); // create a new instance of the inner class
	}

	private class ListIterator implements Iterator<E> {

		private Node<E> iterator;

		ListIterator() {
			this.iterator = head;
		}

		public boolean hasNext() {
			return iterator.getNext() != null;
		}

		public E next() {
			E data = iterator.getElement();
			iterator = iterator.getNext();
			return data;
		}

//		public void remove() {
//			// NOT IMPLEMENTED
//		}

	}

	@Override
	public int size() {
		return this.size;
	}


	@Override
	public E removeFirst() {
		if(isEmpty()){
			return null;
		}
		E answer = head.getElement();//the element to be removed is the head since we're removing the first element
		head = head.getNext();//setting the head to be the next element since the current head is going to be removed
		size--;//decrementing the size of the list since one node is removed
		if(size == 0)
			tail = null; //special case: the list is now empty ie there was one element in the list before it was removed

		return answer;
	}

	@Override
	public E removeLast() {
		if(isEmpty()){
			return null;
		}
		if(head == tail){
			return removeFirst();
		}
		return remove(size);
	}

	@Override
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e, head);
		head = newNode;
		size++;
	}

//    public void addAfterGivenNode(Node<E> node, E element){
//        Node<E> newNode = new Node<E>(node,  )
//    }

	@Override
	public void addLast(E e) {
		if(isEmpty()){
			addFirst(e);
		}
		//start with a temporary pointer pointing to head
		else {
			Node<E> tmp = head;
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			Node<E> newTail = new Node<E>(e, null);
			tail= newTail;
			tmp.setNext(tail);
		}
	}

	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
	}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());

		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());

		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}


}