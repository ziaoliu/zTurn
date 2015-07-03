package leetcode;

/* Substring with Concatenation of All Words
 * 
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * https://linchicoding.wordpress.com/2014/08/25/leetcode-substring-with-concatenation-of-all-words/
 * http://blog.csdn.net/linhuanmars/article/details/20342851
 * http://www.cnblogs.com/TenosDoIt/p/3807055.html
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWordsOJ {
	public class Solution {
		public List<Integer> findSubstring(String S, String[] L) {
			List<Integer> result = new ArrayList<Integer>();
			if (null == S)
				return result;
			if (null == L || L.length <= 0)
				return result;

			int len = L[0].length();

			HashMap<String, Integer> map = new HashMap<String, Integer>();
			// construct map for each search word and occurance
			for (String temp : L) {
				if (null != temp) {
					int strCount = 1;
					if (!map.containsKey(temp)) {
						map.put(temp, strCount);
					} else {
						strCount = map.get(temp);
						map.put(temp, strCount + 1);
					}
				}
			}

			// go thru the String S
			for (int i = 0; i <= S.length() - len * L.length; i++) {
				HashMap<String, Integer> tempMap = new HashMap<String, Integer>(
						map);
				for (int j = i; j <= i + len * L.length; j += len) {
					if (j + len > S.length())
						break;
					String tempStr = S.substring(j, j + len);
					if (!tempMap.containsKey(tempStr))
						break;
					int tempCount = tempMap.get(tempStr);
					if (tempCount > 1) {
						tempCount--;
						tempMap.put(tempStr, tempCount);
					} else {
						tempMap.remove(tempStr);
					}
				}
				if (tempMap.size() == 0) {
					result.add(i);
				}
			}

			return result;
		}// end of method
	}// end of solution
}
