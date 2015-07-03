package cc150;

/*
 * Write code to partition a linked list around a value x, such that all nodes less than
 * x come before all nodes greater than or equal to x.
 *
 * Solution: split into two lists and then merge
 */

public class Chapter02Q04 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(5);
		list.add(6);
		list.add(7);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(2);

		// print linked list
		list.print();

		// x = 4
		int x = 4;
		sort(list, x);

		// print linked list
		// list.print();
	}

	public static void sort(LinkedList list, int x) {
		LinkedList.Node head = list.head;
		LinkedList.Node runner = head;
		if (head == null || head.n == null)
			return;

		int max = Integer.MAX_VALUE;

		// find the pivot point
		while (head != null) {
			if (x >= head.v && x - head.v < max) {
				runner = head;
				max = x - head.v;
				System.out.println("minimum: " + head.v);
			}

			head = head.n;
		}

		int pivotValue = runner.v;

		// start the second loop for reordering
		head = list.head;

		LinkedList fh = null;
		LinkedList sh = null;

		while (head != null) {

			if (head.v < pivotValue) {
				if (fh == null) {
					fh = new LinkedList(head.v);
				} else {
					fh.add(head.v);
				}

			} else {
				if (sh == null) {
					sh = new LinkedList(head.v);
				} else {
					sh.add(head.v);
				}
			}
			head = head.n;
		}

		LinkedList.Node temp = fh.head;

		while (temp.n != null) {
			temp = temp.n;
		}

		temp.n = sh.head;
		fh.print();
		// list.print();
	}
}
