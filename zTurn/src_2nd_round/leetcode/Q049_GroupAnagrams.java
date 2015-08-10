package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:
 For the return value, each inner list's elements must follow the lexicographic order.
 All inputs will be in lower-case.
 */
public class Q049_GroupAnagrams {
	public class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			List<List<String>> result = new ArrayList<List<String>>();
			if (strs == null || strs.length == 0)
				return result;
			HashMap<String, List<String>> map = new HashMap<>();
			for (String str : strs) {
				char[] temp = str.toCharArray();
				Arrays.sort(temp);
				String key = new String(temp);
				if (map.containsKey(key)) {
					List<String> list = map.get(key);
					list.add(str);
					map.put(key, list);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(str);
					map.put(key, list);
				}
			}
			Iterator<List<String>> i = map.values().iterator();
			while (i.hasNext()) {
				List<String> list = i.next();
				Collections.sort(list);
				result.add(list);
			}
			return result;
		}// end of method
	}
}
