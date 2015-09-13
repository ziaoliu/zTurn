package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 Given a string s and a dictionary of words dict, 
 determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 http://www.shuatiblog.com/blog/2014/06/02/Word-Break/
 http://blog.csdn.net/linhuanmars/article/details/22358863
 */
public class Q139_WordBreak {
	public static void main(String[] args) {
		Q139_WordBreak test = new Q139_WordBreak();
		Solution s = test.new Solution();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("le");
		wordDict.add("et");
		wordDict.add("code");
		System.out.println(s.wordBreak("leetcode", wordDict));
	}

	public class Solution {
		public boolean wordBreak(String s, Set<String> wordDict) {
			if (s == null || s.length() == 0 || wordDict == null
					|| wordDict.size() == 0)
				return false;
			boolean[] dp = new boolean[s.length() + 1];
			dp[0] = true;

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j <= i; j++) {
					String sub = s.substring(j, i + 1);
					// word[0, j] has to be true
					// word[j, i] has to exist
					if (dp[j] && wordDict.contains(sub)) {
						dp[i + 1] = true;
						break;
					}
				}
			}

			return dp[s.length()];
		}
	}

	public class SolutionDFS {
		public boolean wordBreak(String s, Set<String> wordDict) {
			if (s == null || s.length() == 0 || wordDict == null
					|| wordDict.size() == 0)
				return false;
			return dfs(s, wordDict, 0);
		}

		private boolean dfs(String s, Set<String> wordDict, int i) {
			if (i == s.length())
				return true;
			if (i > s.length())
				return false;
			for (int index = i + 1; index <= s.length(); index++) {
				String tmp = s.substring(i, index);
				if (wordDict.contains(tmp) && dfs(s, wordDict, index))
					return true;
			}
			return false;
		}
	}
}
