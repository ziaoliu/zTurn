package leetcode;

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

public class Permutations {
	public class Solution {
		public ArrayList<ArrayList<Integer>> permute(int[] num) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

			if (num == null || num.length < 1)
				return result;

			permute(num, 0, result);

			return result;
		}

		public void permute(int[] num, int index,
				ArrayList<ArrayList<Integer>> result) {
			if (index >= num.length) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int i = 0; i < num.length; i++) {
					temp.add(num[i]);
				}
				result.add(temp);
			}

			for (int i = index; i < num.length; i++) {
				swap(num, index, i);
				permute(num, index + 1, result);
				swap(num, index, i);
			}
		}

		public void swap(int[] num, int i, int j) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
	}
}
