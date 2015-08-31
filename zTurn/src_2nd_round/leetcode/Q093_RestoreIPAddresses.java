package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Q093_RestoreIPAddresses {
	public static void main(String[] args) {
		Q093_RestoreIPAddresses test = new Q093_RestoreIPAddresses();
		Solution s = test.new Solution();
		// System.out.println(s.restoreIpAddresses("25525511135"));
		System.out.println(s.process("00"));
	}

	public class Solution {
		public List<String> restoreIpAddresses(String s) {
			List<String> result = new ArrayList<String>();
			List<String> list = new ArrayList<String>();
			if (s == null || s.length() == 0)
				return result;
			dfs(result, list, s, 0);
			return result;
		}

		private void dfs(List<String> result, List<String> list, String s, int i) {
			if (list.size() > 4)
				return;
			if (list.size() == 4 && i == s.length()) {
				StringBuilder sb = new StringBuilder();
				for (String str : list) {
					String tmp = process(str);
					sb.append(tmp).append(".");
				}
				sb.deleteCharAt(sb.length() - 1);
				if (!result.contains(sb.toString())
						&& sb.length() == s.length() + 3)
					result.add(sb.toString());
				return;
			}
			for (int index = i; index < i + 3 && index < s.length(); index++) {
				String str = s.substring(i, index + 1);
				if (str.length() > 0 && Integer.parseInt(str) < 256) {
					list.add(str);
					dfs(result, list, s, index + 1);
					list.remove(list.size() - 1);
				}
			}
		}// end of dfs

		private String process(String str) {
			StringBuilder sb = new StringBuilder();
			int index = str.length() - 1;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c != '0') {
					index = i;
					break;
				}

			}
			if (index == str.length())
				sb.append("0");
			else {
				for (int i = index; i < str.length(); i++) {
					sb.append(str.charAt(i));
				}
			}
			return sb.toString();
		}
	}
}
