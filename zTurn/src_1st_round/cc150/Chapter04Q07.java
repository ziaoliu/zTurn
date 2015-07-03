package cc150;

/* 
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 * 
 * REF: http://blog.icodejava.com/199/how-to-find-the-lowest-common-ancestor-lca-of-two-nodes-in-a-binary-tree/
 * REF: http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
 */

public class Chapter04Q07 {

	class Node {
		public Node left;
		public Node right;
		public int data;

		public Node findInBST(Node n, int a, int b) {
			if (n == null)
				return null;

			if (n.data > a && n.data > b)
				return findInBST(n.left, a, b);
			else if (n.data < a && n.data < b)
				return findInBST(n.right, a, b);
			else
				return n;
		}

		public Node genericFind(Node n, Node a, Node b) {

			if (n == null)
				return null;

			if (n == a || n == b)
				return n;

			Node left = genericFind(n.left, a, b);
			Node right = genericFind(n.right, a, b);

			if (left != null && right != null)
				return n;

			return (left != null) ? left : right;
		}

		// test
		public Node search(Node n, Node a, Node b) {
			if (n == null)
				return null;

			if (n == a || n == b)
				return n;

			Node left = search(n.left, a, b);
			Node right = search(n.right, a, b);

			if (left != null && right != null)
				return n;

			return (left != null) ? left : right;
		}
	}
}
