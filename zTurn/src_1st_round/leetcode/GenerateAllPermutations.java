package leetcode;

import java.util.ArrayList;
import java.util.Random;

/*
 * Permutations
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * reference: http://www.programcreek.com/2013/02/leetcode-permutations-java/
 * 			  http://blog.csdn.net/u010500263/article/details/18178243
 * standard dfs solution for all the combinations
 */

public class GenerateAllPermutations {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };

		System.out.println(permute(a));
	}

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}

	public static void permute(int[] num, int start,
			ArrayList<ArrayList<Integer>> result) {

		// exit condition: get to the end of one combination
		if (start >= num.length) {
			ArrayList<Integer> item = new ArrayList<Integer>();
			for (int h = 0; h < num.length; h++) {
				item.add(num[h]);
			}
			result.add(item);
		}

		// recursive dfs
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
