import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

	Node<T> head;
	Node<T> tail;
	int size = 0;

	public Deque() {
		// construct an empty deque
		head = null;
		tail = null;
	}

	// is the deque empty?
	public boolean isEmpty() {
			return (size == 0);

	}

	// return the number of items on the deque
	public int size() {
		return size;
	}

	public void addFirst(T item) {
		if (item == null)
			throw new NullPointerException();

		Node<T> temp = new Node<>(item, null, null);
		
		if (isEmpty()) {
			head = temp;
			tail = temp;
		} else {
			temp.next = head;
			head.prev = temp;	
			head = temp;
		} 
		
		size++;
	}

	public void addLast(T item) {
		if (item == null)
			throw new NullPointerException();

		if (size == 0) {
			addFirst(item);
		} else {
			Node<T> temp = new Node<>(item, tail, null);
			tail.next = temp;
			tail = temp;
			size++;
		}
	}

	public T removeFirst() {
		if (size == 0)
			throw new NoSuchElementException();

		Node<T> temp = head;

		if (size == 1) {
			head = null;
			tail = null;
		} else 
			head = temp.next;
		

		return (T) temp.cargo;
		// delete and return the item at the front
	}

	public T removeLast() {
		if (size == 0)
			throw new NoSuchElementException();

		Node temp = tail;

		if (size == 1) {
			tail = null;
			head = null;
		}else
			tail = temp.prev;

		return (T) temp.cargo;
		// delete and return the item at the end
	}

	public static void main(String[] args) {
		// unit testing
		Deque<Integer> testDeque = new Deque<>();
		
//		testDeque.addFirst(4);
//		
//		for (Integer i : testDeque)
//		{
//			System.out.println(i);
//		}
		try {
			testDeque.removeFirst();
		} catch (NoSuchElementException e) {
			System.out.println("threw exception on empty list - removeFirst");
		}
		try {
			testDeque.removeLast();
		} catch (NoSuchElementException e) {
			System.out.println("threw exception on empty list - removeLast\n");
		}

		testDeque.addLast(5);
		System.out.println("head: " + testDeque.head.cargo);
		System.out.println("tail: " + testDeque.tail.cargo + "\n");
		testDeque.addFirst(4);
		System.out.println("head: " + testDeque.head.cargo);
		System.out.println("tail.prev: " + testDeque.tail.prev.cargo);
		System.out.println("head.next: " + testDeque.head.next.cargo);
		System.out.println("tail: " + testDeque.tail.cargo + "\n");
		testDeque.addLast(7);
		System.out.println("head: " + testDeque.head.cargo);
		System.out.println("head.next: " + testDeque.head.next.cargo);
		System.out.println("tail.prev: " + testDeque.tail.prev.cargo);
		System.out.println("tail: " + testDeque.tail.cargo + "\n");
		testDeque.addFirst(1);
		System.out.println("head: " + testDeque.head.cargo);
		System.out.println("head.next: " + testDeque.head.next.cargo);
		System.out.println("tail.prev: " + testDeque.tail.prev.cargo);
		System.out.println("tail: " + testDeque.tail.cargo + "\n");
		testDeque.addLast(19);
		System.out.println("head: " + testDeque.head.cargo);
		System.out.println("head.next: " + testDeque.head.next.cargo);
		System.out.println("tail.prev: " + testDeque.tail.prev.cargo);
		System.out.println("tail: " + testDeque.tail.cargo + "\n");
		testDeque.addLast(20);
		System.out.println("head: " + testDeque.head.cargo);
		System.out.println("head.next: " + testDeque.head.next.cargo);
		System.out.println("tail.prev: " + testDeque.tail.prev.cargo);
		System.out.println("tail: " + testDeque.tail.cargo + "\n");

		System.out.println("remove first: " + testDeque.removeFirst());
		System.out.println("head: " + testDeque.head.cargo);
		System.out.println("head.next: " + testDeque.head.next.cargo);
		System.out.println("tail.prev: " + testDeque.tail.prev.cargo);
		System.out.println("tail: " + testDeque.tail.cargo + "\n");

		for (Integer i : testDeque) {
			System.out.print("|" + i + "| --> ");
		}

		System.out.println();

		// second test
		Deque<String> test2 = new Deque<>();

		
		for (String a : new String[] { "lips", "Francis", "is", "name", "my", "hi", "loose" }) {
			test2.addFirst(a);	
		}

		System.out.println(test2.removeFirst() + " " + test2.removeLast());
		
		test2.addLast("Bacon");
		test2.addLast("Jr");

		for (String s : test2) {
			System.out.print(s + " ");
		}
		
	}

	// node which provides the linked list
	private class Node<T> {
		T cargo;
		Node prev;
		Node next;

		public Node(T cargo, Node prev, Node next) {
			this.cargo = cargo;
			this.prev = prev;
			this.next = next;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new nodeIterator();
	}

	private class nodeIterator implements Iterator {

		Node current;

		public nodeIterator() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public T next() {
			Node temp;
			temp = current;
			if (!hasNext())
				throw new NoSuchElementException();
			current = current.next;
			return (T) temp.cargo;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}