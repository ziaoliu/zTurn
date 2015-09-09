package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, 
 such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.

 http://blog.csdn.net/linhuanmars/article/details/23029973
 */
public class Q127_WordLadder {
	public class Solution {
		public int ladderLength(String beginWord, String endWord,
				Set<String> wordDict) {
			LinkedList<String> queue = new LinkedList<String>();
			int count = 1;
			int curCount = 1;
			int nextCount = 0;
			queue.add(beginWord);
			while (queue.size() > 0) {
				String word = queue.remove(0);
				curCount--;
				for (int i = 0; i < word.length(); i++) {
					char[] chars = word.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c;
						String tmp = new String(chars);
						if (tmp.equals(endWord))
							return count + 1;
						if (wordDict.contains(tmp)) {
							wordDict.remove(tmp);
							queue.add(tmp);
							nextCount++;
						}
					}
				}
				if (curCount == 0) {
					curCount = nextCount;
					nextCount = 0;
					count++;
				}
			}
			return count;
		}
	}

	public static void main(String[] args) {
		Q127_WordLadder test = new Q127_WordLadder();
		SolutionNaive t = test.new SolutionNaive();

		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(t.ladderLength("hit", "cog", dict));

		String[] array = { "si", "go", "se", "cm", "so", "ph", "mt", "db",
				"mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci",
				"ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn",
				"ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au",
				"ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb",
				"if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li",
				"ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh",
				"wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne",
				"mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb",
				"ni", "mr", "pa", "he", "lr", "sq", "ye" };
		dict = new HashSet<String>(Arrays.asList(array));
		System.out.println(t.ladderLength("qa", "sq", dict));
	}

	// time limit exceeded
	public class SolutionNaive {
		int max = Integer.MAX_VALUE;

		public int ladderLength(String beginWord, String endWord,
				Set<String> wordDict) {
			dfs(beginWord, endWord, wordDict, 0);
			return max + 2;
		}

		private void dfs(String beginWord, String endWord,
				Set<String> wordDict, int count) {
			if (isTrans(beginWord, endWord)) {
				max = Math.min(max, count);
				return;
			}

			Set<String> trans = getTrans(beginWord, wordDict);
			for (String tmp : trans) {
				wordDict.remove(tmp);
				dfs(tmp, endWord, wordDict, count + 1);
				wordDict.add(tmp);
			}
		}

		private boolean isTrans(String beginWord, String endWord) {
			char[] word = beginWord.toCharArray();
			for (int i = 0; i < word.length; i++) {
				for (int j = 0; j < 26; j++) {
					word[i] = (char) ('a' + j);
					String tmp = new String(word);
					if (tmp.equals(endWord))
						return true;
				}
			}
			return false;
		}

		private Set<String> getTrans(String beginWord, Set<String> wordDict) {
			Set<String> result = new HashSet<>();
			for (int i = 0; i < beginWord.length(); i++) {
				char[] word = beginWord.toCharArray();
				for (int j = 0; j < 26; j++) {
					word[i] = (char) ('a' + j);
					String tmp = new String(word);
					if (wordDict.contains(tmp))
						result.add(tmp);
				}
			}
			return result;
		}
	}
}
