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

 http://blog.csdn.net/linhuanmars/article/details/23311527
 */
public class PascalsTriangleOJ {
	public static void main(String[] args) {
		PascalsTriangleOJ test = new PascalsTriangleOJ();
		SolutionIterative cast = test.new SolutionIterative();
		for (int i = 0; i < 6; i++) {
			List<List<Integer>> result = cast.generate(i);
			System.out.println(result);
		}
	}

	public class SolutionIterative {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (numRows == 0)
				return result;
			List<Integer> list = new ArrayList<>();
			list.add(1);
			if (numRows == 1) {
				result.add(list);
				return result;
			}
			result.add(list);
			
			list = new ArrayList<>();
			list.add(1);
			
			for (int i = 2; i < numRows; i++) {
				list.add(1);
				List<Integer> temp = result.get(result.size() - 1);
				result.add(list);
				list = new ArrayList<>();
				list.add(1);
				for (int j = 1; j < temp.size(); j++) {
					list.add(temp.get(j) + temp.get(j - 1));
				}
				
			}

			list.add(1);
			result.add(list);

			return result;
		}

	}

	public class SolutionRecursive {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (numRows == 0)
				return result;

			gen(result, numRows);

			return result;
		}

		public void gen(List<List<Integer>> result, int numRows) {
			ArrayList<Integer> list = new ArrayList<>();
			if (numRows == 1) {
				list.add(1);
				result.add(0, list);
				return;
			}
			if (numRows == 2) {
				list.add(1);
				list.add(1);
				result.add(0, list);
				gen(result, 1);
				return;
			}
			gen(result, numRows - 1);
			List<Integer> last = result.get(result.size() - 1);
			list.add(1);
			for (int i = 0; i < numRows - 2; i++) {
				list.add(last.get(i) + last.get(i + 1));
			}
			list.add(1);
			result.add(list);
		}// end of gen()
	}
}
