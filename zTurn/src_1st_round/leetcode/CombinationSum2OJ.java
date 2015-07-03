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
				// ÿ��ֻȡ��һ��������
				// 123334������333������ǵ�һ��ֻȡ��1��3����Ϊ����ѡ�κ�һ��3�Ƕ������˵��һ���⡣����ֻ
				// ��һ��ȡ�ͺ��ˡ�
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
