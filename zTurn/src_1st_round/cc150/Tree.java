package cc150;

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public Tree(int data) {
		if (root == null)
			root = new Node(data);
	}

	public Node getRoot() {
		return this.root;
	}

	public void printTree() {

	}

	// depth first search
	public void DFS() {
		search(this.root);
	}

	private void search(Node n) {

		if (n == null)
			return;

		// visit left child node
		if (n.left != null)
			search(n.left);

		// visit node
		System.out.println(n.data);

		// visit right child node
		if (n.right != null)
			search(n.right);

	}

	// chapter 4 Q2
	public void search(Node n1, Node n7) {
		if (n1 == null)
			return;

		// visit left child node
		if (n1.left != null)
			search(n1.left, n7);

		// visit current node
		if (n1.data == n7.data)
			System.out.println("found the route between two nodes");
		// System.out.println(n1.data);

		// visit right child node
		if (n1.right != null)
			search(n1.right, n7);
	}

	public Node createNode(int data) {
		return new Node(data);
	}

	// chapter 4 Q3
	public void binarySort(int[] array) {

		// left
		sort(this.getRoot(), 0, array.length / 2 - 1, array, 0);

		// right
		sort(this.getRoot(), array.length / 2 + 1, array.length - 1, array, 1);

	}

	public void sort(Tree.Node n, int low, int high, int[] array, int indi) {

		if (low > high)
			return;

		int mid = (low + high) / 2;

		Node node = new Node(array[mid]);

		if (indi == 0)
			n.left = node;
		else
			n.right = node;

		if (low != high) {
			sort(node, low, mid - 1, array, 0);
			sort(node, mid + 1, high, array, 1);
		}

	}

	// chapter 4 Q5
	int prev = Integer.MIN_VALUE;

	public boolean isBST() {
		return checkBST(this.root);
	}

	private boolean checkBST(Node n) {

		if (n == null)
			return true;

		// check left branch
		if (!checkBST(n.left))
			return false;

		// check current node
		if (prev >= n.data)
			return false;
		prev = n.data;

		// check right branch
		if (!checkBST(n.right))
			return false;

		return true;
	}

	public boolean isBST2() {
		return checkBST2(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkBST2(Node node, int minValue, int maxValue) {
		if (node == null)
			return true;

		if (node.data <= minValue || node.data > maxValue)
			return false;

		if (!checkBST2(node.left, minValue, node.data))
			return false;
		if (!checkBST2(node.right, node.data, maxValue))
			return false;

		return true;
	}

	class Node {
		private int data;
		private Node left;
		private Node right;

		public Node() {

		}

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public void addToRight(Node right) {
			if (this.right == null)
				this.right = right;
		}

		public void addToLeft(Node left) {
			if (this.left == null)
				this.left = left;
		}
	}

}
