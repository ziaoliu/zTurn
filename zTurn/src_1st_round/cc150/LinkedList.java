package cc150;

class LinkedList {

	Node head = null;

	LinkedList(int val) {
		if (head == null)
			head = new Node(val);
		else {
			add(val);
		}
	}

	public void add(int v) {
		Node head = this.head;
		while (head.n != null) {
			head = head.n;
		}
		head.n = new Node(v);
	}

	public void print() {
		LinkedList.Node n = this.head;
		while (n.n != null) {
			System.out.print(n.v + " -> ");
			n = n.n;
		}
		System.out.print(n.v + "");
		System.out.println();
	}

	class Node {
		Node n;
		int v;

		Node(int val) {
			this.n = null;
			this.v = val;
		}
	}
}

