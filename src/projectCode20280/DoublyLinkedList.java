package projectCode20280;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements List<E> {

	private class Node<E> {
		private E element;//reference to the element stored at this node
		private Node<E> prev; //reference to the previous node in the list
		private Node<E> next;//reference to the subsequent node in the list

		public Node(E e, Node<E> p, Node<E> n){//constructor
			element = e;
			prev = p;
			next = n;
		}


		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	private Node<E> header;// header sentinel at the beginning of the list
	private Node<E> trailer;//trailer sentinel at the end of the list
	private int size = 0;//number of elements in the list

	public DoublyLinkedList(){

		header = new Node<E>(null, null, null);//creating the header
		trailer = new Node<E>(null, header,null);//creating the trailer
		header.setNext(trailer);//header is followed by the trailer

	}


	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> middleNode = new Node<E>(e, predecessor, successor);//new node that is going to be in between two existing nodes
		predecessor.setNext(middleNode);//the node preceding the new node is now going to point to the new node
		successor.setPrev(middleNode);//the succeeding node will now be pointing back to the newly created node
		size++;
		return;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public Node<E> getNode(int position){
		Node<E> currentNode = header.getNext();
		for(int i = 0; i < position; i++){//iterate until we reach the node that we want
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	@Override
	public E get(int i) {
		return getNode(i).getElement();//return the element part of the node at the given position
	}

	@Override
	public void add(int i, E e) {
		if(i == 0)//adding at the beginning of the list
			addFirst(e);
		else if(i == size){//adding at the end of the list
			addLast(e);
		}
		else {
			Node<E> n = getNode(i);
			addBetween(e, n.getPrev(), n);
		}

	}

	@Override
	public E remove(int i) {
//		Node<E> current = header.next; // Set to first node
//		Node<E> predecessor = current.getPrev();
//		Node<E> successor = current.getNext();
//
//		if(i >= size) {
//			throw new IllegalArgumentException("Invalid index of list, must be less than size.");
//		} else {
//			for (int j = 0; j < i; j++) { // Until you get to the ith Node
//				current = current.next; // Traverse list
//			}
//
//			predecessor.setNext(successor);
//			successor.setPrev(predecessor);
		Node<E> prev = new Node<E>(null, null, null);
		Node<E> curr = header;
		for (int j = 0; j <= i; j++) {
			prev = curr;
			curr = curr.getNext();
		}
		prev.setNext(curr.getNext());
		curr.getNext().setPrev(prev);

		size--;
		return curr.getElement();
	}


	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E>{
		int index = 0;
		Node<E> current;
		public ListIterator() {
			current = header;
		}

		@Override
		public boolean hasNext() {
//			try {
//				return current.next != null;
//			} catch (NullPointerException e) {
//				return false;
//			}
			return index < size();

		}

		@Override
		public E next() {
//			current = current.next;
//			return current.prev.getElement();
			if (index == size()){
				throw new NoSuchElementException();
			} else {
				return DoublyLinkedList.this.get(index++);
			}
		}
	}

	public E remove(Node<E> node){
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

	@Override
	public E removeFirst() {
		if(isEmpty()) {
			return null;//if empty there's no nodes to remove
		}
		//return this.remove(header.getNext());
		return remove(header.getNext());//first element is just after the header

	}

	@Override
	public E removeLast() {
		if(isEmpty()){
			return null;
		}
		return remove(trailer.getPrev());//the last element is before the trailer
	}


	@Override
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());//placing the node after the header

	}

	@Override
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
		public String toString() {
		StringBuilder tempString = new StringBuilder();
		tempString.append("[");
		for(Iterator<E> it = iterator(); it.hasNext();){
			tempString.append(it.next()).append(", ");
//			if(it.next()==(null)){
//				tempString.deleteCharAt(tempString.length());
//			}
		}
		tempString.deleteCharAt(tempString.length() - 1);
		tempString.deleteCharAt(tempString.length() - 1);
		tempString.append("]");
		return tempString.toString();
	}


	public static void main(String[] args) {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		ll.addFirst(0);
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addLast(-1);
		System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();
		System.out.println(ll);

		for(Integer e: ll) {
			System.out.println("value: " + e);
		}
	}


}