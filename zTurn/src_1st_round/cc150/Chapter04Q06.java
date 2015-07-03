package cc150;

/*
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node
 * in a binary search tree. You may assume that each node has a link to its parent.
 */

public class Chapter04Q06 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Tree tree = new Tree(array[array.length / 2]);
		tree.binarySort(array);
		tree.DFS();

	}

}

class Node {
	public Node parent;
	public Node left;
	public Node right;
	public int data;

	public Node findSuccessor(Node n) {

		if (n.right != null)
			return leftMost(n.right);
		else {
			Node p = n.parent;
			while (p != null && p.right == n) {
				p = p.parent;
				n = n.parent;
			}
			return p;
		}
	}

	private Node leftMost(Node n) {
		if (n == null)
			return null;
		if (n.left == null)
			return n;
		else {
			return leftMost(n.left);
		}
	}
}