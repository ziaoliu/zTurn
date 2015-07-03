package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*  Word Ladder
 *  Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 
 *  Only one letter can be changed at a time
 *  Each intermediate word must exist in the dictionary
 *  For example,
 * 
 *  Given:
 *  start = "hit"
 *  end = "cog"
 *  dict = ["hot","dot","dog","lot","log"]
 *  As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *  return its length 5.
 * 
 *  Note:
 *  Return 0 if there is no such transformation sequence.
 *  All words have the same length.
 *  All words contain only lowercase alphabetic characters.
 * 
 *  http://blog.csdn.net/linhuanmars/article/details/23029973
 */
public class WordLadderOJ {
	public class Solution {
		public int ladderLength(String beginWord, String endWord,
				Set<String> wordDict) {
			LinkedList<String> queue = new LinkedList<>();
			HashSet<String> visited = new HashSet<>();
			int level = 1;
			int lastLevel = 1;
			int currLevel = 0;
			queue.add(beginWord);
			visited.add(beginWord);

			while (queue.size() > 0) {
				String curr = queue.remove(0);
				lastLevel--;
				for (int i = 0; i < curr.length(); i++) {
					char[] currArray = curr.toCharArray();
					for (char c = 'a'; c < 'z'; c++) {
						currArray[i] = c;
						String temp = new String(currArray);
						if (!visited.contains(temp) && wordDict.contains(temp)) {
							if (temp.equals(endWord)) {
								return level + 1;
							}
							currLevel++;
							visited.add(temp);
							queue.add(temp);
						}
					}// end for
				}// end for
				if (lastLevel == 0) {
					lastLevel = currLevel;
					currLevel = 0;
					level++;
				}
			}// end while
			return 0;
		}
	}
}
