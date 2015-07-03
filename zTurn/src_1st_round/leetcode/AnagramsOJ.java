package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* Anagrams 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/21664747
 */

public class AnagramsOJ {
	public static void main(String[] args) {
		AnagramsOJ solution = new AnagramsOJ();
		Solution test = solution.new Solution();
		System.out.println(test.anagrams(new String[] { "", "" }));
	}

	public class Solution {
		public List<String> anagrams(String[] strs) {
			ArrayList<String> result = new ArrayList<String>();
			if (null == strs || strs.length <= 1)
				return result;
			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

			for (int i = 0; i < strs.length; i++) {
				String temp = strs[i];
				char[] array = temp.toCharArray();
				Arrays.sort(array);
				String newStr = new String(array);
				if (!map.containsKey(newStr)) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(temp);
					map.put(newStr, list);
				} else {
					ArrayList<String> list = map.get(newStr);
					list.add(temp);
					//map.put(newStr, list);
				}
			}

			for (ArrayList<String> temp : map.values()) {
				if (temp.size() <= 1)
					continue;
				result.addAll(temp);
			}

			return result;
		}// end of method
	}
}
