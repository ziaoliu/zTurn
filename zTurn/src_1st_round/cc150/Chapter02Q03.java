package cc150;

import java.util.Stack;

/*
 * Implement a function to check if a linked list is a palindrome. 
 */

public class Chapter02Q03 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		// print linked list
		list.print();

		isPalindrome(list);
		// print linked list
		list.print();
	}

	public static void isPalindrome(LinkedList list) {
		Stack<Integer> stack = new Stack<Integer>();

		LinkedList.Node slow = list.head;
		LinkedList.Node fast = slow;

		while (fast != null && fast.n != null) {

			stack.push(slow.v);
			System.out.println(slow.v + " : " + fast.v);
			slow = slow.n;
			fast = fast.n.n;
		}

		if (fast != null) { // fast not being null means it's odd length
			slow = slow.n;
		}

		while (slow != null) {

			if (slow.v != stack.pop()) {
				System.out.println("No palindrome");
				break;
			}

			slow = slow.n;
		}

		if (stack.size() != 0)
			System.out.println("No palindrome");
		else
			System.out.println("This is in fact palindrome");
	}
}
