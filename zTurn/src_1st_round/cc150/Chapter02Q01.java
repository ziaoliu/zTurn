package cc150;

/*
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is notallowed?
 */

public class Chapter02Q01 {
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

		// withBuffer(list);
		withoutBuffer(list);

		// print linked list
		list.print();
	}

	public static void withBuffer(LinkedList list) {
		LinkedList.Node head = list.head;
		LinkedList.Node prev = null;
		boolean[] buffer = new boolean[256];
		while (head != null) {

			// find the duplicates
			if (buffer[head.v]) {
				System.out.println("Duplicates found " + head.v
						+ ". Removing! ");
				prev.n = head.n;
			} else {
				buffer[head.v] = true;
				prev = head;
			}
			head = head.n;
		}

	}

	public static void withoutBuffer(LinkedList list) {
		LinkedList.Node head = list.head;
		while (head != null) {
			LinkedList.Node temp = head.n;
			LinkedList.Node prev = head;
			while (temp != null) {

				if (head.v == temp.v) {
					System.out.println("Duplicates found " + temp.v
							+ ". Removing! ");
					prev.n = temp.n;
				} else {
					prev = temp;
				}

				temp = temp.n;
			}
			head = head.n;
		}

	}

}
