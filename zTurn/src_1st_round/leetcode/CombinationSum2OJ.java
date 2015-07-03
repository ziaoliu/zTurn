package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//http://blog.sina.com.cn/s/blog_eb52001d0102v270.html
//http://n00tc0d3r.blogspot.com/2013/01/combination-sum.html
public class CombinationSum2OJ {
	public class Solution {
		public List<List<Integer>> combinationSum2(int[] num, int target) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();

			if (null == num || num.length <= 0)
				return result;

			Arrays.sort(num);

			boolean[] numFlag = new boolean[num.length];

			dfs(0, 0, target, num, numFlag, list, result);

			return result;
		}

		public void dfs(int position, int sum, int target, int[] num,
				boolean[] numFlag, List<Integer> list,
				List<List<Integer>> result) {

			if (sum == target) {
				List<Integer> temp = new ArrayList<Integer>(list);
				Collections.sort(temp);
				if (!result.contains(temp))
					result.add(temp);
				return;
			}

			if (sum > target) {
				return;
			} else if (sum < target) {
				// 每次只取第一个，例如
				// 123334，到了333这里，我们第一次只取第1个3，因为我们选任何一个3是对组合来说是一个解。所以只
				// 第一次取就好了。
				int pre = -1;
				for (int i = position; i < num.length; i++) {
					if (num[i] == pre)
						continue;
					if (!numFlag[i]) {
						pre = num[i];
						list.add(num[i]);
						numFlag[i] = true;

						dfs(position + 1, num[i] + sum, target, num, numFlag,
								list, result);

						list.remove(list.size() - 1);
						numFlag[i] = false;
					}
				}
			}
		}
	}// end Solution
}
