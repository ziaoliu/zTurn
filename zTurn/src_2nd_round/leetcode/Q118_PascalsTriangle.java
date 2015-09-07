package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Q118_PascalsTriangle {
	public class Solution {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			if (numRows <= 0)
				return result;
			list.add(1);
			result.add(list);
			for (int i = 2; i <= numRows; i++) {
				list = new ArrayList<Integer>();
				List<Integer> preList = result.get(result.size() - 1);
				int pre = 0;
				for (int j = 0; j <= preList.size(); j++) {
					int cur = 0;
					if (j < preList.size())
						cur = preList.get(j);
					list.add(pre + cur);
					pre = cur;
				}
				result.add(list);
			}
			return result;
		}
	}
}
