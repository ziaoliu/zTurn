package cc150;

/*
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 * EXAMPLE
 * Input:  the node c from the linked list a->b->c->d-> e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */

public class Chapter02Q07 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(6);
		list.add(7);
		list.add(8);

		// print linked list
		list.print();

		LinkedList.Node node = list.head;

		// removeMidNode();
		while (node != null) {

			if (node.v == 1)
				removeMidNode(node);
			node = node.n;
		}

		// print linked list
		list.print();
	}

	public static void removeMidNode(LinkedList.Node n) {
		if (n == null || n.n == null)
			return;
		n.v = n.n.v;
		n.n = n.n.n;

	}
}
