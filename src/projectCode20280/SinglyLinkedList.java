package projectCode20280;

import java.util.*;
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