package projectCode20280;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class DoublyLinkedList<E> implements List<E> {
//
//	private class Node<E> {
//		private E element;//reference to the element stored at this node
//		private Node<E> prev; //reference to the previous node in the list
//		private Node<E> next;//reference to the subsequent node in the list
//
//		public Node(E e, Node<E> p, Node<E> n){//constructor
//			element = e;
//			prev = p;
//			next = n;
//		}
//
//
//		public E getElement() {
//			return element;
//		}
//
//		public void setElement(E element) {
//			this.element = element;
//		}
//
//		public Node<E> getPrev() {
//			return prev;
//		}
//
//		public void setPrev(Node<E> prev) {
//			this.prev = prev;
//		}
//
//		public Node<E> getNext() {
//			return next;
//		}
//
//		public void setNext(Node<E> next) {
//			this.next = next;
//		}
//	}
//
//	private Node<E> header;// header sentinel at the beginning of the list
//	private Node<E> trailer;//trailer sentinel at the end of the list
//	private int size = 0;//number of elements in the list
//
//	public DoublyLinkedList(){
//
//		header = new Node<E>(null, null, null);//creating the header
//		trailer = new Node<E>(null, header,null);//creating the trailer
//		header.setNext(trailer);//header is followed by the trailer
//
//	}
//
//
//	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
//		Node<E> middleNode = new Node<E>(e, predecessor, successor);//new node that is going to be in between two existing nodes
//		predecessor.setNext(middleNode);//the node preceding the new node is now going to point to the new node
//		successor.setPrev(middleNode);//the succeeding node will now be pointing back to the newly created node
//		size++;
//		return;
//	}
//
//	@Override
//	public int size() {
//		return size;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		return size == 0;
//	}
//
////	public Node<E> getNode(int position){
////		Node<E> currentNode = header.getNext();
////		for(int i = 0; i < position; i++){//iterate until we reach the node that we want
////			currentNode = currentNode.next;
////		}
////		return currentNode;
////	}
//
//	@Override
//	public E get(int i) {
//		return getNode(i).getElement();//return the element part of the node at the given position
//	}
//
//	@Override
//	public void add(int i, E e) {
//		if(i == 0)//adding at the beginning of the list
//			addFirst(e);
//		else if(i == size){//adding at the end of the list
//			addLast(e);
//		}
//		else {
//			Node<E> n = getNode(i);
//			addBetween(e, n.getPrev(), n);
//		}
//
//	}
//
//	@Override
//	public E remove(int i) {
//		// TODO Auto-generated method stub
////		Node<E> predecessor = getNode(i - 1);
////		Node<E> successor = getNode(i + 1);
////		predecessor.setNext(successor);
////		successor.setPrev(predecessor);
////		//E element = element.getElement();
////		//E element = current.getElement();
////		size--;
////		return element;
////		return null;
//		Node current = header.next; // Set to first node
//
//		for(int j = 0; j < i; j++) { // Until you get to the ith Node
//			current = current.next; // Traverse list
//		}
//		return (E) remove(current); // Remove the current node, and return its data
//	}
//
//	@Override
//	public Iterator<E> iterator() {
//		return new ListIterator();
//	}
//
//	private class ListIterator implements Iterator<E>{
//
//
//		private int index = 0;
//
//		@Override
//		public boolean hasNext(){
//			return index < size();
//		}
//
//		@Override
//		public E next() throws NoSuchElementException{
//			if (index == size()){
//				throw new NoSuchElementException("There is no next element.");
//			}else {
//				return DoublyLinkedList.this.get(index++);
//			}
//		}
//
////		Node<E> current;
////		public ListIterator() {
////			current = header;
////		}
////
////		@Override
////		public boolean hasNext() {
////			try {
////				return current.next != null;
////			} catch (NullPointerException e) {
////				return false;
////			}
////		}
////
////		@Override
////		public E next() {
////			current = current.next;
////			return current.prev.getElement();
////		}
//	}
//
//	public E remove(Node<E> node){
//		Node<E> predecessor = node.getPrev();
//		Node<E> successor = node.getNext();
//		predecessor.setNext(successor);
//		successor.setPrev(predecessor);
//		size--;
//		return node.getElement();
//	}
//
//	@Override
//	public E removeFirst() {
//		if(isEmpty()) {
//			return null;//if empty there's no nodes to remove
//		}
//		//return this.remove(header.getNext());
//		return remove(header.getNext());//first element is just after the header
//
//	}
//
//	@Override
//	public E removeLast() {
//		if(isEmpty()){
//			return null;
//		}
//		return remove(trailer.getPrev());//the last element is before the trailer
//	}
//
//
//	@Override
//	public void addFirst(E e) {
//		addBetween(e, header, header.getNext());//placing the node after the header
//
//	}
//
//	@Override
//	public void addLast(E e) {
//
////		addBetween(e, trailer.getPrev(), trailer);
//		Node<E> last =  header;
//		if (isEmpty()){
//			header = new Node<>(e, null, null);
//		}
//		else {
//			while (last.getNext() != null){
//				last = last.getNext();
//			}
//			Node<E> newNode = new Node<>(e, last, null);
//			last.setNext(newNode);
//			newNode.setPrev(last);
//			trailer = newNode;
//		}
//	}
//
////	public String toString() {
////		String output = new String();
////		output += "size = " + size() + "\n";
////		Node<E> curr = header.getNext();
////		while (curr != trailer) {
////			output += "> " + curr.getElement() + "\n";
////			curr = curr.getNext();
////		}
////		return output;
////	}
//
//	public String toString() {
//		StringBuilder tempString = new StringBuilder();
//		tempString.append("[");
//		for(Iterator<E> it = iterator(); it.hasNext();){
//			tempString.append(it.next()).append(", ");
//		}
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.append("]");
//		return tempString.toString();
//	}
//
//
//	public static void main(String[] args) {
//		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
//           ll.addFirst(0);
//           ll.addFirst(1);
//           ll.addFirst(2);
//           ll.addLast(-1);
//           System.out.println(ll);
//
//           ll.removeFirst();
//           System.out.println(ll);
//
//           ll.removeLast();
//           System.out.println(ll);
//
//           for(Integer e: ll) {
//                   System.out.println("value: " + e);
//           }
//	}
//
//
//}

//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class DoublyLinkedList<E> {
//
//	private Node head;
//	private Node tail;
//	private int size;
//
//	public DoublyLinkedList() {
//		size = 0;
//	}
//
//	/**
//	 * this class keeps track of each element information
//	 *
//	 * @author java2novice
//	 */
//	private class Node {
//		E element;
//		Node next;
//		Node prev;
//
//		public Node(E element, Node next, Node prev) {
//			this.element = element;
//			this.next = next;
//			this.prev = prev;
//		}
//	}
//
//	/**
//	 * returns the size of the linked list
//	 *
//	 * @return
//	 */
//	public int size() {
//		return size;
//	}
//
//	/**
//	 * return whether the list is empty or not
//	 *
//	 * @return
//	 */
//	public boolean isEmpty() {
//		return size == 0;
//	}
//
//	/**
//	 * adds element at the starting of the linked list
//	 *
//	 * @param element
//	 */
//	public void addFirst(E element) {
//		Node tmp = new Node(element, head, null);
//		if (head != null) {
//			head.prev = tmp;
//		}
//		head = tmp;
//		if (tail == null) {
//			tail = tmp;
//		}
//		size++;
//		System.out.println("adding: " + element);
//	}
//
//	/**
//	 * adds element at the end of the linked list
//	 *
//	 * @param element
//	 */
//	public void addLast(E element) {
//
//		Node tmp = new Node(element, null, tail);
//		if (tail != null) {
//			tail.next = tmp;
//		}
//		tail = tmp;
//		if (head == null) {
//			head = tmp;
//		}
//		size++;
//		System.out.println("adding: " + element);
//	}
//
//	public E get(int i) {
//		if(i >= size) {
//			throw new IllegalArgumentException("Invalid index of list, must be less than size.");
//		} else {// Otherwise valid index
//			Node temp = head; // Temp Node for traversing list
//
//			for(int j = 0; j < i; j++) {// Move forward i times
//				temp = temp.next; // Move forward
//			}
//			return temp.element; // Return data
//		}
//	}
//
//
//	public Iterator<E> iterator() {
//		return new ListIterator();
//	}
//
//	private class ListIterator implements Iterator<E> {
//
//
//		private int index = 0;
//
//		@Override
//		public boolean hasNext() {
//			return index < size();
//		}
//
//		@Override
//		public E next() throws NoSuchElementException {
//			if (index == size()) {
//				throw new NoSuchElementException("There is no next element.");
//			} else {
//				return DoublyLinkedList.this.get(index++);
//			}
//		}
//
//		/**
//		 * this method removes element from the start of the linked list
//		 *
//		 * @return
//		 */
//		public E removeFirst() {
//			if (size == 0) throw new NoSuchElementException();
//			Node tmp = head;
//			head = head.next;
//			head.prev = null;
//			size--;
//			System.out.println("deleted: " + tmp.element);
//			return tmp.element;
//		}
//
//		/**
//		 * this method removes element from the end of the linked list
//		 *
//		 * @return
//		 */
//		@Override
//		public E removeLast() {
//			if (size == 0) throw new NoSuchElementException();
//			Node tmp = tail;
//			tail = tail.prev;
//			tail.next = null;
//			size--;
//			System.out.println("deleted: " + tmp.element);
//			return tmp.element;
//		}
//	}
//		public String toString() {
//		StringBuilder tempString = new StringBuilder();
//		tempString.append("[");
//		for(Iterator<E> it = iterator(); it.hasNext();){
//			tempString.append(it.next()).append(", ");
//		}
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.append("]");
//		return tempString.toString();
//	}
//}


//package projectCode20280;
//
//import java.util.Iterator;
//
//public class DoublyLinkedList<E> implements List<E> {
//	private Node head;
//	private Node tail;
//	private int size = 0;
//
//	public DoublyLinkedList() {
//		head = new Node(null, null, null);
//		tail = new Node(null, head, null);
//		head.next = tail;
//	}
//
//	public static void main(String[] args) {
//		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
//		ll.addFirst(0);
//		ll.addFirst(1);
//		ll.addFirst(2);
//		ll.addLast(-1);
//		System.out.println(ll);
//
//		ll.removeFirst();
//		System.out.println(ll);
//
//		ll.removeLast();
//		System.out.println(ll);
//
//		for(Integer e : ll) {
//			System.out.println("value: " + e);
//		}
//	}
//
//	private void addBetween(E e, Node predecessor, Node successor) {
//		Node newNode = new Node(e, predecessor, successor);
//		predecessor.next = newNode;
//		successor.prev = newNode;
//		size++;
//	}
//
//	@Override
//	public int size() {
//		return size;
//	} // Returns the size
//
//	@Override
//	public boolean isEmpty() {
//		return size == 0; // If the list is empty, it has 0 elements
//	}
//
//	@Override
//	public E get(int i) {
//		Node current = head.next; // New Node for traversing
//
//		for(int j = 0; j < i; j++) { // Until you reach the ith Node
//			current = current.next; // Traverse list
//		}
//
//		return current.data; // Return the current (ith) Nodes data
//	}
//
//	@Override
//	public void add(int i, E e) {
//		// 0 -> 1 -> 2 -> 3
//		// add(2, e) -> 0
//		// 0 -> 1 -> E -> 2 -> 3
//		// Take 2, addBetween(e, 2.prev, 2)
//
//		Node current = head.next; // New Node for traversing
//
//		for(int j = 0; j < i; j++) { // Until you reach the ith Node
//			current = current.next; // Traverse list
//		}
//
//		addBetween(e, current.prev, current); // Add to list
//	}
//
//	@Override
//	public E remove(int i) {
//		Node current = head.next; // Set to first node
//
//		for(int j = 0; j < i; j++) { // Until you get to the ith Node
//			current = current.next; // Traverse list
//		}
//		return remove(current); // Remove the current node, and return its data
//	}
//
//	public E remove(Node n) {
//		Node prev = n.prev; // Predecessor
//		Node next = n.next; // Successor
//
//		prev.next = next; // Set next.prev to point to prev node
//		next.prev = prev; // Set prev.next to point to next node
//
//		size--; // Decrease size
//		return n.data; // Return the data held in n
//	}
//
//	@Override
//	public Iterator<E> iterator() {
//		return new DoublyLinkedListIterator();
//	}
//
//	@Override
//	public E removeFirst() {
//		if(isEmpty()) { // If empty
//			return null; // Nothing to remove
//		} else {
//			return remove(head.next); // Remove first element
//		}
//	}
//
//	@Override
//	public E removeLast() {
//		if(isEmpty()) { // If empty
//			return null; // Nothing to remove
//		} else {
//			return remove(tail.prev); // Remove last element
//		}
//	}
//
//	@Override
//	public void addFirst(E e) {
//		addBetween(e, head, head.next);
//	}
//
//	@Override
//	public void addLast(E e) {
//		addBetween(e, tail.prev, tail);
//	}
//
////	@Override
////	public String toString() {
////		Node current = head.next; // Node for iterating through list
////		StringBuilder returnString = new StringBuilder("["); // String to be returned
////
////		while(current.next != null) {// Iterate through list
////			returnString.append(current.data).append(", "); // Add data + comma
////			current = current.next; // Move to next node
////		}
////
////		return returnString + "null]"; // Close the list
////	}
//
//		@Override
//		public String toString() {
//		StringBuilder tempString = new StringBuilder();
//		tempString.append("[");
//		for(Iterator<E> it = iterator(); it.hasNext();){
//			tempString.append(it.next()).append(", ");
//			if(it.next()==(null)){
//				tempString.deleteCharAt(tempString.length());
//			}
//		}
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.append("]");
//		return tempString.toString();
//	}
//
//	private class Node {
//		// Instance variables
//		public E data;
//		public Node prev;
//		public Node next;
//
//		public Node(E data) {
//			this.data = data;
//		}
//
//		public Node(E data, Node prev, Node next) {
//			this.data = data;
//			this.prev = prev;
//			this.next = next;
//		}
//
//		@Override
//		public String toString() {
//			if(this != null) {
//				return data.toString();
//			} else {
//				return "NULL";
//			}
//		}
//	}
//
//	private class DoublyLinkedListIterator implements Iterator<E> {
//		Node current = head.next;
//
//		@Override
//		public boolean hasNext() {
//			return current != null;
//		}
//
//		@Override
//		public E next() {
//			E data = current.data;
//			current = current.next;
//			return data;
//		}
//	}
//}
//public class DoublyLinkedList<E> {
//
//	private static class Node<E> {
//		private E data;
//		private Node<E> prev;
//		private Node<E> next;
//
//		public Node(E data, Node<E> p, Node<E> n) {
//			this.data = data;
//			this.next = n;
//			this.prev = p;
//		}
//
//		/**
//		 * @return the data
//		 */
//		public E getData() {
//			return data;
//		}
//
//		/**
//		 * @return the prev
//		 */
//		public Node<E> getPrev() {
//			return prev;
//		}
//
//		/**
//		 * @param prev the prev to set
//		 */
//		public void setPrev(Node<E> prev) {
//			this.prev = prev;
//		}
//
//		/**
//		 * @return the next
//		 */
//		public Node<E> getNext() {
//			return next;
//		}
//
//		/**
//		 * @param next the next to set
//		 */
//		public void setNext(Node<E> next) {
//			this.next = next;
//		}
//
//	}
//
//	private int size = 0;
//
//	private Node<E> header;
//	private Node<E> trailer;
//
//	public DoublyLinkedList() {
//		header = new Node<>(null, null, null);
//		trailer = new Node<>(null, header, null);
//		header.setNext(trailer);
//	}
//
//	/**
//	 * @return a boolean value
//	 */
//	public boolean isEmpty() {
//		return size == 0;
//	}
//
//	/**
//	 * @return the size
//	 */
//	public int getSize() {
//		return size;
//	}
//
//	/**
//	 * @return the header
//	 */
//	public E first() {
//		if (isEmpty()) {
//			return null;
//		}
//		return header.getNext().getData();
//	}
//
//	/**
//	 * @return the trailer
//	 */
//	public E last() {
//		if (isEmpty()) {
//			return null;
//		}
//		return trailer.getPrev().getData();
//	}
//
//	public void addFirst(E e) {
//		addBetween(e, header, header.getNext());
//	}
//
//	public void addLast(E e) {
//		addBetween(e, trailer.getPrev(), trailer);
//	}
//
//	public E removeFirst() {
//		if (isEmpty()) {
//			return null;
//		}
//		return remove(header.getNext());
//	}
//
//	public E removeLast() {
//		if (isEmpty()) {
//			return null;
//		}
//		return remove(trailer.getPrev());
//	}
//
//	private void addBetween(E e, Node<E> prevNode, Node<E> nextNode) {
//		Node<E> newNode = new Node<>(e, prevNode, nextNode);
//		prevNode.setNext(newNode);
//		nextNode.setPrev(newNode);
//		size++;
//	}
//
//	private E remove(Node<E> node) {
//		Node<E> prevNode = node.getPrev();
//		Node<E> nextNode = node.getNext();
//		prevNode.setNext(nextNode);
//		nextNode.setPrev(prevNode);
//		size--;
//		return node.getData();
//	}
//
////	@Override
////	public String toString() {
////		if (isEmpty()) {
////			return "null";
////		}
////		String stringified = "";
////		Node temp = header.getNext();
////		stringified += "<Header> <--> ";
////		while (temp.getNext() != null) {
////			stringified += temp.getData() + " <--> ";
////			temp = temp.getNext();
////		}
////		stringified += "<Trailer>";
////		return stringified;
////	}
//
//
//	@Override
//	public Iterator<E> iterator() {
//		return new ListIterator();
//	}
//
//	private class ListIterator implements Iterator<E>{
//
//		Node<E> current;
//		public ListIterator() {
//			current = header;
//		}
//
//		@Override
//		public boolean hasNext() {
//			try {
//				return current.next != null;
//			} catch (NullPointerException e) {
//				return false;
//			}
//		}
//
//		@Override
//		public E next() {
//			current = current.next;
//			return current.prev.getElement();
//		}
//	}
//
//		public String toString() {
//		StringBuilder tempString = new StringBuilder();
//		tempString.append("[");
//		for(Iterator<E> it = iterator(); it.hasNext();){
//			tempString.append(it.next()).append(", ");
//		}
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.append("]");
//		return tempString.toString();
//	}
//
//	private class Node<E> {
//		private E element;//reference to the element stored at this node
//		private Node<E> prev; //reference to the previous node in the list
//		private Node<E> next;//reference to the subsequent node in the list
//
//		public Node(E e, Node<E> p, Node<E> n){//constructor
//			element = e;
//			prev = p;
//			next = n;
//		}
//
//
//		public E getElement() {
//			return element;
//		}
//
//		public void setElement(E element) {
//			this.element = element;
//		}
//
//		public Node<E> getPrev() {
//			return prev;
//		}
//
//		public void setPrev(Node<E> prev) {
//			this.prev = prev;
//		}
//
//		public Node<E> getNext() {
//			return next;
//		}
//
//		public void setNext(Node<E> next) {
//			this.next = next;
//		}
//	}

//}

//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class DoublyLinkedList<E> implements List<E> {
//
//	private Node head;
//	private Node tail;
//	private int size;
//
//	public DoublyLinkedList() {
//		size = 0;
//	}
//
//	private class Node<E> {
//		E element;
//		Node<E> next;
//		Node<E> prev;
//
//		public Node(E element, Node next, Node prev) {
//			this.element = element;
//			this.next = next;
//			this.prev = prev;
//		}
//
//		public E getElement() {
//			return element;
//		}
//
//		public void setElement(E element) {
//			this.element = element;
//		}
//
//		public Node<E> getPrev() {
//			return prev;
//		}
//
//		public void setPrev(Node<E> prev) {
//			this.prev = prev;
//		}
//
//		public Node<E> getNext() {
//			return next;
//		}
//
//		public void setNext(Node<E> next) {
//			this.next = next;
//		}
//	}
//
//
//		private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
//		Node<E> middleNode = new Node<E>(e, predecessor, successor);//new node that is going to be in between two existing nodes
//		predecessor.setNext(middleNode);//the node preceding the new node is now going to point to the new node
//		successor.setPrev(middleNode);//the succeeding node will now be pointing back to the newly created node
//		size++;
//		return;
//	}
//	@Override
//	public int size() {
//		return size;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		return size == 0;
//	}
//
//	@Override
//	public E get(int i) {
//		if(i >= size) {
//			throw new IllegalArgumentException("Invalid index of list, must be less than size.");
//		} else {// Otherwise valid index
//			Node<E> temp = head; // Temp Node for traversing list
//
//			for(int j = 0; j < i; j++) {// Move forward i times
//				temp = temp.next; // Move forward
//			}
//			return temp.element; // Return data
//		}
//	}
//
//	@Override
//	public void add(int i, E e) {
////				if(i == 0)//adding at the beginning of the list
////			addFirst(e);
////		else if(i == size){//adding at the end of the list
////			addLast(e);
////		}
////		else {
////			Node<E> n = getNode(i);
////			addBetween(e, n.getPrev(), n);
////		}
//		Node current = head.next; // New Node for traversing
//
//		for(int j = 0; j < i; j++) { // Until you reach the ith Node
//			current = current.next; // Traverse list
//		}
//
//		addBetween(e, current.prev, current); // Add to list
//	}
//
//	@Override
//	public E remove(int i) {
////				Node current = head.next; // Set to first node
////
////		for(int j = 0; j < i; j++) { // Until you get to the ith Node
////			current = current.next; // Traverse list
////		}
////		return remove(current); // Remove the current node, and return its data
////				Node<E> predecessor = getNode(i - 1);
////		Node<E> successor = getNode(i + 1);
////		predecessor.setNext(successor);
////		successor.setPrev(predecessor);
////		//E element = element.getElement();
////		E element = current.getElement();
////		size--;
////		return element;
//		return null;
//	}
//
//
//	@Override
//	public Iterator<E> iterator() {
//		return new ListIterator();
//	}
//
//	private class ListIterator implements Iterator<E> {
//
//
//		private int index = 0;
//
//		@Override
//		public boolean hasNext() {
//			return index < size();
//		}
//
//		@Override
//		public E next() throws NoSuchElementException {
//			if (index == size()) {
//				throw new NoSuchElementException("There is no next element.");
//			} else {
//				return DoublyLinkedList.this.get(index++);
//			}
//		}
//
//	}
//
//	@Override
//	public E removeFirst() {
//		if (size == 0) throw new NoSuchElementException();
//		Node<E> tmp = head;
//		head = head.next;
//		head.prev = null;
//		size--;
//		System.out.println("deleted: " + tmp.element);
//		return tmp.element;
//	}
//
//	@Override
//	public E removeLast() {
//		if (size == 0) throw new NoSuchElementException();
//		Node<E> tmp = tail;
//		tail = tail.prev;
//		tail.next = null;
//		size--;
//		System.out.println("deleted: " + tmp.element);
//		return tmp.element;
//	}
//
//
//	@Override
//	public void addFirst(E e) {
//			Node tmp = new Node(e, head, null);
//			if (head != null) {
//				head.prev = tmp;
//			}
//			head = tmp;
//			if (tail == null) {
//				tail = tmp;
//			}
//			size++;
//			System.out.println("adding: " + e);
//	}
//
//	@Override
//	public void addLast(E e) {
//		Node tmp = new Node(e, null, tail);
//		if (tail != null) {
//			tail.next = tmp;
//		}
//		tail = tmp;
//		if (head == null) {
//			head = tmp;
//		}
//		size++;
//		System.out.println("adding: " + e);
//
//	}
//
//		public E first() {
//		if (isEmpty()) {
//			return null;
//		}
//		return head.getNext().getElement();
//	}
//
//	/**
//	 * @return the trailer
//	 */
//	public E last() {
//		if (isEmpty()) {
//			return null;
//		}
//		return tail.getPrev().getElement();
//	}
//			@Override
//		public String toString() {
//		StringBuilder tempString = new StringBuilder();
//		tempString.append("[");
//		for(Iterator<E> it = iterator(); it.hasNext();){
//			tempString.append(it.next()).append(", ");
//			if(it.next()==(null)){
//				tempString.deleteCharAt(tempString.length());
//			}
//		}
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.deleteCharAt(tempString.length() - 1);
//		tempString.append("]");
//		return tempString.toString();
//	}
//
//	public static void main(String[] args) {
//		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
//		ll.addFirst(0);
//		ll.addFirst(1);
//		ll.addFirst(2);
//		ll.addLast(-1);
//		System.out.println(ll);
//
//		ll.removeFirst();
//		System.out.println(ll);
//
//		ll.removeLast();
//		System.out.println(ll);
//
//		for(Integer e: ll) {
//			System.out.println("value: " + e);
//		}
//	}
//
//
//}


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