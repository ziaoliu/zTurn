package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class Q119_PascalsTriangleII {
	public static void main(String[] args) {
		Q119_PascalsTriangleII test = new Q119_PascalsTriangleII();
		SolutionAgain s = test.new SolutionAgain();
		for (int i = 0; i < 10; i++) {
			System.out.println(s.getRow(i));
		}
	}

	public class SolutionAgain {
		public List<Integer> getRow(int numRows) {
			List<Integer> list = new ArrayList<>();
			if (numRows < 0)
				return list;
			list.add(1);
			for (int i = 1; i <= numRows; i++) {
				for (int j = list.size() - 1; j > 0; j--) {
					list.set(j, list.get(j) + list.get(j - 1));
				}
				list.add(1);
			}

			return list;
		}
	}

	public class Solution {
		public List<Integer> getRow(int numRows) {
			List<Integer> list = new ArrayList<>();
			if (numRows < 0)
				return list;
			list.add(1);
			for (int i = 1; i <= numRows; i++) {
				for (int j = i - 1; j > 0; j--) {
					list.set(j, list.get(j) + list.get(j - 1));
				}
				list.add(1);
			}
			return list;
		}
	}
}
