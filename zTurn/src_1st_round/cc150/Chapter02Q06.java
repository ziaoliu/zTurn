package cc150;

/*
 * Given a circular linked list, implement an algorithm which returns the node at
 * the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points
 * to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input:  A->B->C->D->E->C [the same C as earlier]
 * Output: C
 */

public class Chapter02Q06 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(7);
		list.add(5);
		list.add(1);
		list.add(6);
		list.add(3);

		list.add(2);
		list.add(8);
		list.add(1);
		// print linked list
		list.print();

		LinkedList.Node temp = list.head;
		LinkedList.Node temp2 = null;
		while (temp != null) {
			if (temp.v == 1 && temp.n != null)
				temp2 = temp;

			if (temp.n == null && temp.v == 1) {
				temp.n = temp2;
				break;
			}
			temp = temp.n;
		}

		add(list);

	}

	public static void add(LinkedList list) {
		// two pointers
		LinkedList.Node slow = list.head;
		LinkedList.Node fast = list.head;

		while (slow != null && fast != null) {
			slow = slow.n;
			fast = fast.n.n;

			if (slow == fast) {
				System.out.println("found it! " + slow.v + "" + fast.v);
				break;
			}
		}

		slow = list.head;

		while (slow != fast) {
			slow = slow.n;
			fast = fast.n;
		}

		System.out.println("found the starting point of the cycle: " + slow.v);
	}

}
