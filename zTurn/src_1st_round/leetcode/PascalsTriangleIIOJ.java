package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given an index k, return the kth row of the Pascal's triangle.
 For example, given k = 3,
 Return [1,3,3,1].

 http://blog.csdn.net/linhuanmars/article/details/23311629
 */
public class PascalsTriangleIIOJ {
	public static void main(String[] args) {
		PascalsTriangleIIOJ test = new PascalsTriangleIIOJ();
		Solution cast = test.new Solution();
		for (int i = 0; i < 6; i++) {
			List<Integer> result = cast.getRow(i);
			System.out.println(result);
		}
	}

	public class Solution {
		public List<Integer> getRow(int numRows) {
			List<Integer> list = new ArrayList<>();
			if (numRows < 0)
				return list;
			list.add(1);
			for (int i = 1; i < numRows + 1; i++) {
				for (int j = list.size() - 2; j >= 0; j--) {
					list.set(j + 1, list.get(j) + list.get(j + 1));
				}
				list.add(1);
			}

			return list;
		}

		public List<Integer> getRowStupid(int numRows) {
			List<Integer> list = new ArrayList<>();

			if (numRows < 0)
				return list;
			list.add(1);
			if (numRows == 0) {
				return list;
			}

			list = new ArrayList<>();
			list.add(1);

			for (int i = 2; i < numRows + 1; i++) {
				list.add(1);
				List<Integer> temp = list;
				list = new ArrayList<>();
				list.add(1);
				for (int j = 1; j < temp.size(); j++) {
					list.add(temp.get(j) + temp.get(j - 1));
				}

			}

			list.add(1);

			return list;
		}// end of method
	}
}
