package cc150;

/*
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class Chapter02Q02 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(4);

		// print linked list
		list.print();

		find(list, 6);

		// print linked list
		list.print();
	}

	public static void find(LinkedList list, int index) {

		int backup = index;

		if (index <= 0) {
			System.out.println("input needs to be greater than 0");
			return;
		}

		LinkedList.Node head = list.head;
		while (index > 1 && head != null) {
			head = head.n;
			index--;
		}

		if (index > 1)
			System.out.println("Cannot find!");
		else {
			LinkedList.Node kth = head.n;
			head = list.head;
			while (kth != null) {
				head = head.n;
				kth = kth.n;
			}
			System.out.println("Found " + backup + "th element to the last: "
					+ head.v);
		}

	}
}
