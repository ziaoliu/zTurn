package cc150;

/*
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit is at the
 * head of the list. Write a function that adds the two numbers and returns the sum
 * as a linked list.
 * EXAMPLE
 * Input : (7- >1->6)+(5->9->2). That is, 617+295.
 * Output: 2->1->9. That is, 912.
 * 
 * ??????????????????????????????????
 * FOLLOWUP: NOT RESOLVED????????????
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input : (6->1->7)+(2->9->5).That is, 617+295.
 * Output: 9->1->2. That is, 912 .
 */

public class Chapter02Q05 {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(9);
		list1.add(9);
		list1.add(9);
		list1.add(9);

		// print linked list
		list1.print();

		LinkedList list2 = new LinkedList(1);
		list2.add(9);
//		list2.add(2);

		// print linked list
		list2.print();

		// x = 4
		add(list1, list2);
		System.out.println("==========================");
		// forward sequence addition
		addForward(list1, list2);

	}

	public static void add(LinkedList list1, LinkedList list2) {
		int sum = 0;
		int a = 0;
		int b = 0;
		int carryOver = 0;

		LinkedList.Node head1 = list1.head;
		LinkedList.Node head2 = list2.head;

		LinkedList result = null;

		while (head1 != null || head2 != null) {
			if (head1 != null) {
				a = head1.v;
				head1 = head1.n;
			} else
				a = 0;

			if (head2 != null) {
				b = head2.v;
				head2 = head2.n;
			} else
				b = 0;

			sum = a + b + carryOver;
			if (sum >= 10) {
				sum = sum - 10;
				carryOver = 1;
			} else
				carryOver = 0;

			if (result == null) {
				result = new LinkedList(sum);
			} else
				result.add(sum);

		}

		if (carryOver == 1)
			result.add(1);

		result.print();
	}

	public static void addForward(LinkedList list1, LinkedList list2) {
		list1.print();
		list2.print();

	}

}











