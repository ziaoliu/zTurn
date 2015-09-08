package leetcode;

import java.util.List;

/*
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 *[
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 *]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Q120_Triangle {
	public class SolutionDP {
		public int minimumTotal(List<List<Integer>> triangle) {
			if (triangle == null || triangle.size() == 0)
				return 0;
			if (triangle.size() == 1)
				return triangle.get(0).get(0);
			List<Integer> list = triangle.get(triangle.size() - 1);
			int[] array = new int[list.size()];
			for (int i = 0; i < array.length; i++)
				array[i] = list.get(i);
			for (int i = triangle.size() - 2; i >= 0; i--) {
				for (int j = 0; j <= i; j++)
					array[j] = Math.min(array[j], array[j + 1])
							+ triangle.get(i).get(j);
			}
			return array[0];
		}

		// mid level solution
		public int minimumTotalMid(List<List<Integer>> triangle) {
			if (triangle == null || triangle.size() == 0)
				return 0;
			if (triangle.size() == 1)
				return triangle.get(0).get(0);
			List<Integer> list = triangle.get(triangle.size() - 1);
			int[] array = new int[list.size()];
			for (int i = 0; i < array.length; i++)
				array[i] = list.get(i);
			for (int i = triangle.size() - 2; i >= 0; i--) {
				list = triangle.get(i);
				for (int j = 0; j < list.size(); j++)
					array[j] = Math.min(array[j], array[j + 1]) + list.get(j);
			}
			return array[0];
		}
	}

	public class Solution {
		public int minimumTotal(List<List<Integer>> triangle) {
			if (triangle == null || triangle.size() == 0)
				return 0;
			for (int i = triangle.size() - 2; i >= 0; i--) {
				List<Integer> cur = triangle.get(i);
				List<Integer> next = triangle.get(i + 1);
				for (int j = 0; j < cur.size(); j++) {
					cur.set(j,
							cur.get(j) + Math.min(next.get(j), next.get(j + 1)));
				}
			}
			return triangle.get(0).get(0);
		}
	}
}
