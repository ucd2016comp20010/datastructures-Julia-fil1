package projectCode20280;

import java.util.*;

//public class SinglyLinkedList<E> implements List<E> {
//	// Instance variables
//	Node root;
//	int size;
//	Node tail;
//
//
//	public static void main(String[] args) {
//				String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
//
//		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
//		for (String s : alphabet) {
//			sll.addFirst(s);
//			sll.addLast(s);
//	}
//		System.out.println(sll.toString());
//
//		sll.removeFirst();
//		System.out.println(sll.toString());
//
//		sll.removeLast();
//		System.out.println(sll.toString());
//
//		sll.remove(2);
//		System.out.println(sll.toString());
//
//		for (String s : sll) {
//			System.out.print(s + ", ");
//		}
//	}
//
//
////	public void reverse() {
////		// Reverse the order of the list using only a stack. Do not create a new list!
////		Stack<E> stack = new Stack<>();
////		Node ptr = this.root;
////		// Push the elements of the list to the stack
////		while(ptr != null) {
////			stack.push(ptr.data);
////			ptr = ptr.next;
////		}
////
////		for(E e : stack) {
////			System.out.println(e);
////		}
////		// Pop from stack and replace
////		// current nodes value
////		while(!stack.isEmpty()) {
////			if(ptr == null) {
////				root = new Node(stack.peek());
////				ptr = root;
////			} else {
////				ptr.next = new Node(stack.peek());
////				ptr = ptr.next;
////			}
////			stack.pop();
////		}
////		Objects.requireNonNull(ptr).next = null;
////	}
//
//		public SinglyLinkedList() {
//		root = null;
//		tail = null;
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
//			Node temp = root; // Temp Node for traversing list
//
//			for(int j = 0; j < i; j++) {// Move forward i times
//				temp = temp.next; // Move forward
//			}
//			return temp.data; // Return data
//		}
//	}
//
//	public E first(){
//		if (isEmpty()){
//			return null;
//		}
//		return root.getData();
//	}
//
//	public E last(){
//		if (isEmpty()){
//			return null;
//		}
//
//		return tail.getData();
//	}
//
//	@Override
//	public void add(int i, E e) {
//		if(i >= size) {
//			throw new IllegalArgumentException("Invalid index of list, must be less than size.");
//		} else {// Otherwise valid index
//			Node temp = root; // Temp Node for traversing list
//			for(int j = 0; j < i -1; j++) {
//				temp = temp.next; // Move forward
//			}
//			Node newNode = new Node(e); // Create new Node
//			newNode.next = temp.next; // Set next pointer
//			temp.next = newNode; // Set temp pointer
//			size++;
//		}
//	}
//
//
//	@Override
//	public E remove(int i) {
//		if(i >= size) {
//			throw new IllegalArgumentException("Invalid index of list, must be less than size.");
//		} else {// Otherwise valid index
//			Node temp = root; // Temp Node for traversing list
//
//			for(int j = 0; j < i - 1; j++) {// Move forward i times
//				temp = temp.next; // Move forward
//			}
//
//			Node deletedNode = temp.next;
//			temp.next = temp.next.next;
//
//			size--;
//			return deletedNode.data;
//		}
//	}
//
//	@Override
//	public Iterator<E> iterator() {
//		return new SinglyLinkedListIterator();
//	}
//
//	@Override
//	public int size() {
//		return size;
//	}
//
//	@Override
//	public E removeFirst() {
//		if(root != null) {// If there is anything to remove
//			root = root.next; // Remove the first node
//			size--; // Decrement size
//		}
//		return null;
//	}
//
//
//		@Override
//	public E removeLast() {
//		if(isEmpty()){
//			return null;
//		}
//		if(root == tail){
//			return removeFirst();
//		}
//		return remove(size-1);
//	}
//
//
//	@Override
//	public void addFirst(E e) {
//		//linkFirst(e);
//		Node first = root;
//		Node newHead = new Node(e);
//
//		if(first != null) {
//			newHead.next = first;
//		}
//		root = newHead;
//
//		size++; // Increment size counter
//	}
//
//	@Override
//	public void addLast(E e) {
//		//linkLast(e);
//		if(root == null) {// If empty
//			root = new Node(e); // Root becomes a new Node holding value o
//		} else {
//			// Go to end
//			// Add this node
//			Node temp = root;
//
//			while(temp.next != null) { // While not at the last valid node
//				temp = temp.next; // Move along the list
//			}
//			temp.next = new Node(e); // Add new node
//		}
//
//		size++; // Increment size counter
//	}
//
//
//	@Override
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
//	private class Node {
//		// Instance variables
//		public E data;
//		public Node next;
//
//		public Node(E data) {
//			this.data = data;
//		}
//
//		// Getters and Setters
//		public E getData() {
//			return data;
//		}
//
//		public void setData(E data) {
//			this.data = data;
//		}
//
//		public Node getNext() {
//			return next;
//		}
//
//		public void setNext(Node next) {
//			this.next = next;
//		}
//
//		@Override
//		public String toString() {
//			return data.toString();
//		}
//	}
//
//	private class SinglyLinkedListIterator implements Iterator<E> {
//		Node curr = root;
//
//		@Override
//		public boolean hasNext() {
//			return curr != null;
//		}
//
//		@Override
//		public E next() {
//			E data = curr.data;
//			curr = curr.next;
//			return data;
//		}
//	}
//
//
//}
////package projectCode20280;
////
////import java.util.Iterator;
////
////public class SinglyLinkedList<E> implements List<E> {
////
////	private static class Node<E> {
////		private E element;//reference (like a pointer) to the element stored at this node
////		private Node<E> next;//reference (like a pointer) to the subsequent node in the list
////
////		public Node(E element, Node<E> next) {
////			this.element = element;
////			this.next = next;
////		}
////
////		public E getElement() {
////			return element;
////		}
////
////		public void setElement(E element) {
////			this.element = element;
////		}
////
////		public Node<E> getNext() {
////			return next;
////		}
////
////		public void setNext(Node<E> next) {
////			this.next = next;
////		}
////
////
////	}
////
////
////	private Node<E> head;
////	private Node<E> tail;
////	private int size;
////
////	public SinglyLinkedList() {
////		head = null;
////		tail = null;
////	}
////
////
////	public E first(){
////		if (isEmpty()){
////			return null;
////		}
////		return head.getElement();
////	}
////
////	public E last(){
////		if (isEmpty()){
////			return null;
////		}
////		if (tail != null) {
////			return tail.getElement();
////		}
////		return null;
////	}
////
////	@Override
////	public boolean isEmpty() {
////		return size == 0;
////	}
////
////	private Node<E> getNode(int position){
////		Node<E> current = head;
////		for(int i = 0; i < position; i++){
////			current = current.next;
////		}
////		return current;
////	}
////
////	@Override
////	public E get(int i) {
////		return getNode(i).getElement();
////	}
////
////	@Override
////	public void add(int i, E e) {
////		if(i == 0)//adding at the beginning of the list
////			addFirst(e);
////		else if(i == size){//adding at the end of the list
////			addLast(e);
////		}
////		else {
////			addNodeAfter(getNode(i-1), e);
////		}
////	}
////
////	private void addNodeAfter(Node<E> e, E data)
////	{
////		Node<E> newNode = new Node<E>(data, e.getNext());
////		e.setNext(newNode);
////		size++;
////	}
////
////	@Override
////	public E remove(int i) {
////		Node<E> previous = getNode(i-1);
////		Node<E> current = previous.getNext();
////		E element = current.getElement();
////		previous.setNext(current.getNext());
////		return element;
////	}
////
////	@Override
////	public Iterator<E> iterator() {
////
////		return new ListIterator(); // create a new instance of the inner class
////	}
////
////	private class ListIterator implements Iterator<E> {
////
////		private Node<E> iterator;
////
////		ListIterator() {
////			this.iterator = head;
////		}
////
////		public boolean hasNext() {
////			return iterator.getNext() != null;
////		}
////
////		public E next() {
////			E data = iterator.getElement();
////			iterator = iterator.getNext();
////			return data;
////		}
////
//////		public void remove() {
//////			// NOT IMPLEMENTED
//////		}
////
////	}
////
////	@Override
////	public int size() {
////		return this.size;
////	}
////
////
////	@Override
////	public E removeFirst() {
////		if(isEmpty()){
////			return null;
////		}
////		E answer = head.getElement();//the element to be removed is the head since we're removing the first element
////		head = head.getNext();//setting the head to be the next element since the current head is going to be removed
////		size--;//decrementing the size of the list since one node is removed
////		if(size == 0)
////			tail = null; //special case: the list is now empty ie there was one element in the list before it was removed
////
////		return answer;
////	}
////
////	@Override
////	public E removeLast() {
////		if(isEmpty()){
////			return null;
////		}
////		if(head == tail){
////			return removeFirst();
////		}
////		return remove(size);
////	}
////
////	@Override
////	public void addFirst(E e) {
////		Node<E> newNode = new Node<>(e, head);
////		head = newNode;
////		size++;
////	}
////
//////    public void addAfterGivenNode(Node<E> node, E element){
//////        Node<E> newNode = new Node<E>(node,  )
//////    }
////
////		@Override
////	public String toString() {
////		StringBuilder tempString = new StringBuilder();
////		tempString.append("[");
////		for(Iterator<E> it = iterator(); it.hasNext();){
////			tempString.append(it.next()).append(", ");
////		}
////		tempString.deleteCharAt(tempString.length() - 1);
////		tempString.deleteCharAt(tempString.length() - 1);
////		tempString.append("]");
////		return tempString.toString();
////	}
////
////	@Override
////	public void addLast(E e) {
////		if(isEmpty()){
////			addFirst(e);
////		}
////		//start with a temporary pointer pointing to head
////		else {
////			Node<E> tmp = head;
////			while (tmp.getNext() != null) {
////				tmp = tmp.getNext();
////			}
////			Node<E> newTail = new Node<E>(e, null);
////			tail= newTail;
////			tmp.setNext(tail);
////		}
////	}
////
////	public static void main(String[] args) {
////		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
////
////		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
////		for (String s : alphabet) {
////			sll.addFirst(s);
////			sll.addLast(s);
////		}
////		System.out.println(sll.toString());
////
////		sll.removeFirst();
////		System.out.println(sll.toString());
////
////		sll.removeLast();
////		System.out.println(sll.toString());
////
////		sll.remove(2);
////		System.out.println(sll.toString());
////
////		for (String s : sll) {
////			System.out.print(s + ", ");
////		}
////	}
////
////
////}
import java.util.Iterator;
import java.util.Stack;

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
		@Override
	public String toString() {
		StringBuilder tempString = new StringBuilder();
		tempString.append("[");
		for(Iterator<E> it = iterator(); it.hasNext();){
			tempString.append(it.next()).append(", ");
		}
		tempString.deleteCharAt(tempString.length() - 1);
		tempString.deleteCharAt(tempString.length() - 1);
		tempString.append("]");
		return tempString.toString();
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
		//return getNode(i).getElement();
		if (i == 0){
			return head.getElement();
		} else {
			Node<E> temp = head;
			for (int j = 0; j < i; j++){
				temp = temp.getNext();
			}
			return temp.getElement();
		}
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
//		if (isEmpty()){
//			return null;
//		}
//		if(i == 0){
//			return removeFirst();
//		}
//		if (i == size()){
//			return removeLast();
//		}
//
////		return remove(size);
//		Node<E> previous = getNode(i-1);
//		Node<E> current = previous.getNext();
//		E element = current.getElement();
//		previous.setNext(current.getNext());
//		return element;

		Node<E> curr = head;
		Node<E> prev = new Node<>(null, null);
		if (head == null){
			throw new RuntimeException("");
		}
		else if(size == 1){
			head = null;
		}
		else
			for (int j = 0; j<= i -1; j++){
				prev = curr;

				curr = curr.getNext();
			}

			prev.setNext(curr.getNext());
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
			current = head;
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
				return SinglyLinkedList.this.get(index++);
			}
		}
	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public E removeFirst() {
//		if(isEmpty()){
//			return null;
//		}
//		E answer = head.getElement();//the element to be removed is the head since we're removing the first element
//		head = head.getNext();//setting the head to be the next element since the current head is going to be removed
//		size--;//decrementing the size of the list since one node is removed
//		if(size == 0)
//			tail = null; //special case: the list is now empty ie there was one element in the list before it was removed
//
//		return answer;
		if (isEmpty())
			return null;              // nothing to remove

		E answer = head.getElement();
		head = head.getNext();                   // will become null if list had only one node
		size--;

		if (size == 0)
			tail = null;                           // special case as list is now empty

		return answer;
	}

	@Override
	public E removeLast() {
		if(isEmpty()){
			return null;
		}
//		if(head == tail){
//			return removeFirst();
//		}
//		return remove(size);

		else {
			Node<E> current = head;
			for (int i = 0; i < size() -1; i++){
				current = current.getNext();
			}

			tail = current;
			tail.setNext(null);
			return tail.getElement();

		}
	}

	@Override
	public void addFirst(E e) {
//		Node<E> newNode = new Node<>(e, head);
//		head = newNode;
//		size++;
		head = new Node<>(e, head);              // create and link a new node
		if (size == 0)
			tail = head;                           // special case: new node becomes tail also
		size++;
	}

//    public void addAfterGivenNode(Node<E> node, E element){
//        Node<E> newNode = new Node<E>(node,  )
//    }

	@Override
	public void addLast(E e) {
//		if(isEmpty()){
//			addFirst(e);
//		}
//		//start with a temporary pointer pointing to head
//		else {
//			Node<E> tmp = head;
//			while (tmp.getNext() != null) {
//				tmp = tmp.getNext();
//			}
//			Node<E> newTail = new Node<E>(e, null);
//			tail= newTail;
//			tmp.setNext(tail);
//		}
		Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
		if (isEmpty())
			head = newest;                         // special case: previously empty list
		else
			tail.setNext(newest);                  // new node after existing tail
		tail = newest;                           // new node becomes the tail
		size++;
	}

		public E first(){
		if (isEmpty()){
			return null;
		}
		return head.getElement();
	}

	public E last(){
		if (isEmpty()){
			return null;
		}

		return tail.getElement();
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