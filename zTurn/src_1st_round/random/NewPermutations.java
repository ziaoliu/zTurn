package random;

import java.util.ArrayList;

/*
 * Permutations
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * http://www.programcreek.com/2013/02/leetcode-permutations-java/
 * http://blog.csdn.net/tuantuanls/article/details/8717262
 */

public class NewPermutations {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3,4 };
		System.out.println(permutation(a));
	}

	public static ArrayList<ArrayList<Integer>> permutation(int[] a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		dfs(a, 0, result);

		return result;
	}

	public static void dfs(int[] a, int start,
			ArrayList<ArrayList<Integer>> result) {
		if (start >= a.length) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < a.length; i++) {
				temp.add(a[i]);
			}
			result.add(temp);
		}

		for (int i = start; i < a.length; i++) {
			swap(a, start, i);
			dfs(a, start + 1, result);
			swap(a, i, start);
		}
	}

	public static void swap(int[] a, int i, int start) {
		int temp = a[i];
		a[i] = a[start];
		a[start] = temp;
	}
}
