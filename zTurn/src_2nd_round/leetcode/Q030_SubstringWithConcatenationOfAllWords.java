package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
 You are given a string, s, and a list of words, words, that are all of the same length. 
 Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class Q030_SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		Q030_SubstringWithConcatenationOfAllWords test = new Q030_SubstringWithConcatenationOfAllWords();
		Solution s = test.new Solution();

		String[] L = { "foo", "bar" };

		System.out.println(s.findSubstring("barfoothefoobarman", L));
	}

	public class Solution {
		public List<Integer> findSubstring(String S, String[] L) {
			List<Integer> result = new ArrayList<>();
			if (S == null)
				return result;

			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < L.length; i++) {
				if (map.containsKey(L[i]))
					map.put(L[i], map.get(L[i]) + 1);
				else
					map.put(L[i], 1);
			}

			int wordLen = L[0].length();

			for (int i = 0; i < S.length(); i++) {
				HashMap<String, Integer> dup = (HashMap) map.clone();
				if (i + wordLen * L.length > S.length())
					break;
				else {
					String substring = S.substring(i, i + wordLen * L.length);
					for (int j = 0; j < substring.length(); j = j + wordLen) {
						String sub = substring.substring(j, j + wordLen);
						int count = dup.get(sub) == null ? 0 : dup.get(sub);
						if (count <= 0)
							break;
						else if (count == 1)
							dup.remove(sub);
						else if (count > 1)
							dup.put(sub, --count);
					}

					if (dup.size() == 0)
						result.add(i);
				}
			}
			return result;
		}
	}

	public class SolutionFirst {
		public List<Integer> findSubstring(String S, String[] L) {
			List<Integer> result = new ArrayList<>();
			if (S == null)
				return result;

			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < L.length; i++) {
				if (map.containsKey(L[i]))
					map.put(L[i], map.get(L[i]) + 1);
				else
					map.put(L[i], 1);
			}

			int wordLen = L[0].length();

			for (int i = 0; i < S.length(); i++) {
				HashMap<String, Integer> dup = (HashMap) map.clone();
				if (i + wordLen * L.length >= S.length())
					continue;
				else {
					String substring = S.substring(i, i + wordLen * L.length);
					for (int j = 0; j < substring.length(); j = j + wordLen) {
						String sub = substring.substring(j, j + wordLen);
						int count = dup.get(sub) == null ? 0 : dup.get(sub);
						if (count <= 0)
							continue;
						else
							dup.put(sub, --count);
					}
					Iterator<Integer> iter = dup.values().iterator();
					boolean flag = true;
					while (iter.hasNext() && flag) {
						int temp = iter.next();
						if (temp != 0)
							flag = false;
					}

					if (flag)
						result.add(i);
				}
			}
			return result;
		}
	}
}
