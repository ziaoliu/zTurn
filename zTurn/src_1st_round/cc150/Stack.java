package cc150;

import java.util.ArrayList;

/*
 * Chapter 3 Stack Data Structure implementation
 */

public class Stack {
	int size;
	int capacity = 0;
	int min = Integer.MAX_VALUE;
	ArrayList<Object> stack;
	ArrayList<Integer> minValues = new ArrayList<Integer>();

	public Stack() {
		this.size = 0;
		this.stack = new ArrayList<Object>();
		this.capacity = this.stack.size();
	}
	
	public Stack(int capacity) {
		this.size = 0;
		this.stack = new ArrayList<Object>(capacity);
		this.capacity = capacity;
	}

	public Object peek() {
		return stack.get(size - 1);
	}

	public Object pop() {
		if (size > 0) {
			Object o = stack.get(size - 1);
			stack.remove(size - 1);
			size--;

			if ((int) o == min) {
				minValues.remove(minValues.size() - 1);
				if (minValues.size() > 0)
					min = minValues.get(minValues.size() - 1);
				else
					min = Integer.MAX_VALUE;
			}

			return o;
		} else
			return null;
	}

	public boolean push(Object o) {
		size++;
		stack.add(o);

		if ((int) o < min) {
			min = (int) o;
			minValues.add(min);
		}

		return true;
	}
	
	public Object remove(int index){
		return stack.remove(index);
	}
	
	public void print(){
		System.out.println(stack.toString());
	}

	public int size() {
		return size;
	}

	public Object min() {
		return min;
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(7);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		System.out.println("Peeking: " + s.peek());

		System.out.println("|===Bottom=======Top=====>");
		s.print();
		System.out.println("|===Bottom=======Top=====>");
		
		System.out.println("size: " + s.size());

		System.out.println("popping: " + s.pop());
		System.out.println("popping: " + s.pop());
		System.out.println("popping: " + s.pop());

		System.out.println("size: " + s.size());
		System.out.println("min: " + s.min());

		System.out.println("popping: " + s.pop());
		System.out.println("popping: " + s.pop());
		
		System.out.println("min: " + s.min());
		System.out.println("popping: " + s.pop());
		System.out.println("min: " + s.min());
		System.out.println("popping: " + s.pop());

		System.out.println("size: " + s.size());
	}
}
