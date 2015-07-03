package cc150;

import java.util.ArrayList;

/*
 * Chapter 3 Queue Data Structure implementation
 */

public class Queue {

	int size;
	ArrayList<Object> q;

	public Queue() {
		size = 0;
		q = new ArrayList<Object>();
	}

	public boolean enqueue(Object o) {
		size++;
		q.add(o);
		return true;
	}

	public Object dequeue() {
		if (size > 0) {
			Object o = q.get(0);
			q.remove(0);
			size--;
			return o;
		} else
			return null;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);

		System.out.println("size: " + q.size());
		
		System.out.println("deQ: " + q.dequeue());
		System.out.println("deQ: " + q.dequeue());
		System.out.println("deQ: " + q.dequeue());
		
		System.out.println("size: " + q.size());
		
		System.out.println("deQ: " + q.dequeue());
		System.out.println("deQ: " + q.dequeue());
		System.out.println("deQ: " + q.dequeue());
		System.out.println("deQ: " + q.dequeue());
		
		System.out.println("size: " + q.size());
	}
}
