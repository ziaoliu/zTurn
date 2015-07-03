package cc150;

/*
 * Implement a function to check if a binary tree is a binary search tree.
 * 
 * Note: all left children smaller then the current node
 * 		 all right children larger then the current node
 */

public class Chapter04Q05 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Tree tree = new Tree(array[array.length / 2]);
		tree.binarySort(array);
		tree.DFS();
		System.out.println("Is this tree BST? " + (tree.isBST()? "Yes": "No"));
		
		System.out.println("Second approach: Is this tree BST? " + (tree.isBST2()? "Yes": "No"));
	}

}
