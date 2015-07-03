package cc150;

import java.util.Stack;

/*
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy
 * the elements into any other data structure (such as an array). The stack supports
 * the following operations: push, pop, peek, and isEmpty.
 */

public class Chapter03Q06 {
	public static void main(String[] args) {
		java.util.Stack<Integer> source = new Stack<Integer>();

		source.push(7);
		source.push(5);
		source.push(2);
		source.push(9);
		source.push(1);
		source.push(6);
		source.push(3);

		sortStack(source);
	}

	public static void sortStack(Stack<Integer> source) {
		System.out.println("before sorting: " + source.toString());

		java.util.Stack<Integer> temp = new Stack<Integer>();

		while (!source.isEmpty()) {
			int pop = source.pop();
			if (temp.isEmpty())
				temp.push(pop);
			else {
				int peekTmpt = temp.peek();
				if (peekTmpt > pop) {
					temp.push(pop);
				} else {
					int count = 0;
					while (!temp.isEmpty() && temp.peek() < pop) {
						source.push(temp.pop());
						count++;
					}
					temp.push(pop);
					for (int i = 0; i < count; i++) {
						temp.push(source.pop());
					}
				}
			}
		}

		while (!temp.isEmpty()) {
			source.push(temp.pop());
		}

		System.out.println("after  sorting: " + source.toString());
	}

}
