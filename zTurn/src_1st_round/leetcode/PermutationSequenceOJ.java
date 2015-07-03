package leetcode;

import java.util.ArrayList;

/* Permutation Sequence
 * 
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-permutation-sequence.html
 * http://www.lifeincode.net/programming/leetcode-permutation-sequence-java/
 */
public class PermutationSequenceOJ {
	public static void main(String[] args) {
		Solution s = new PermutationSequenceOJ().new Solution();
		String result = s.getPermutation(5, 1);
		System.out.println(result);
	}

	public class Solution {
		public String getPermutation(int n, int k) {
			if (n <= 0)
				return null;

			if (n == 1 && k == 1)
				return "1";

			int limit = 1;
			for (int i = 1; i <= n; i++) {
				limit = limit * i;
			}

			if (k > limit)
				return null;

			int[] factorial = new int[n];
			factorial[0] = 1;
			for (int i = 1; i < n; i++) {
				factorial[i] = factorial[i - 1] * i;
			}

			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(i + 1);
			}

			k--;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				int index = k / factorial[n - i - 1];
				k = k % factorial[n - i - 1];
				sb.append(list.get(index));
				list.remove(index);
			}

			return sb.toString();
		}

		private void dfs(int[] array, ArrayList<String> list, int i,
				String str, int k) {
			if (str.length() == array.length) {
				if (!list.contains(str)) {
					list.add(str);
					return;
				}
			} else if (str.length() > array.length)
				return;
			else
				for (int j = i; j < array.length; j++) {
					if (list.size() >= k)
						return;
					dfs(array, list, i + 1, str + array[j], k);
				}
		}

		public String getPermutationTimeOut(int n, int k) {
			if (n <= 0)
				return null;

			if (n == 1 && k == 1)
				return "1";

			int limit = 1;
			for (int i = 1; i <= n; i++) {
				limit = limit * i;
			}

			if (k > limit)
				return null;

			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = i + 1;
			}

			ArrayList<String> list = new ArrayList<String>();
			dfs(array, list, 0, "", k);
			System.out.println(list);
			return list.get(k - 1);
		}

	}
}
