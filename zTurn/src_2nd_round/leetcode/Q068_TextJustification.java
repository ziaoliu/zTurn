package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.
 */
public class Q068_TextJustification {
	public static void main(String[] args) {
		Q068_TextJustification test = new Q068_TextJustification();
		SolutionAgain t = test.new SolutionAgain();
		String[] words = { "What","must","be","shall","be." };
		System.out.println(t.fullJustify(words, 12));
	}

	// public class Solution {
	// public ArrayList<String> fullJustify(String[] words, int maxWidth) {
	//
	// }
	// }

	public class SolutionAgain {
		public List<String> fullJustify(String[] words, int maxWidth) {
			List<String> result = new ArrayList<>();
			if (words == null || words.length == 0 || maxWidth < 0)
				return result;
			int preLength = 0;
			List<String> tmp = new ArrayList<>();
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (word.length() > maxWidth)
					return new ArrayList<>();
				int length = preLength + word.length();
				if (tmp.size() > 0)
					length = length + 1;
				if (length > maxWidth) {
					// every row
					// System.out.println("if: " + tmp);
					int slots = tmp.size() - 1;
					int spaces = slots == 0 ? maxWidth - preLength
							: (maxWidth - preLength) / slots + 1;
					slots = slots == 0 ? 0 : (maxWidth - preLength) % slots;
					StringBuilder sb = new StringBuilder();
					StringBuilder pad = pad(spaces);
					for (int j = 0; j < tmp.size(); j++) {
						sb.append(tmp.get(j));
						if (tmp.size() == 1 || j + 1 < tmp.size())
							sb.append(pad);
						if (slots > 0) {
							sb.append(" ");
							slots--;
						}
					}
					result.add(sb.toString());
					// reset the new row
					tmp = new ArrayList<>();
					preLength = 0;
					i--;
				} else {
					preLength = length;
					tmp.add(words[i]);
					// last row
					if (i + 1 == words.length) {
						// System.out.println("else: " + tmp);
						int spaces = maxWidth - preLength - 1;
						StringBuilder sb = new StringBuilder();
						for (String str : tmp) {
							sb.append(str);// .append(" ");
							if (str.length() < maxWidth)
								sb.append(" ");
						}
						sb.append(pad(spaces));
						result.add(sb.toString());
					}
				}
			}
			return result;
		}

		private StringBuilder pad(int spaces) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < spaces; i++)
				sb.append(" ");
			return sb;
		}
	}

	public class SolutionStupid {
		public ArrayList<String> fullJustify(String[] words, int maxWidth) {
			ArrayList<String> result = new ArrayList<>();
			if (words == null || words.length == 0 || maxWidth < 0)
				return result;
			ArrayList<String> tmp = new ArrayList<>();
			int length = 0;
			int preLen = 0;
			for (int i = 0; i < words.length; i++) {
				int slots = tmp.size() - 1;
				preLen = length;
				length = length + words[i].length() + slots;
				if (length > maxWidth) {
					if (slots == 0) {
						result.add(tmp.get(0));
					} else {
						int spaces = maxWidth - preLen;
						int per = spaces / slots;
						StringBuilder s = new StringBuilder();
						for (int j = 0; j < per; j++)
							s.append(" ");
						int extra = spaces % slots;
						StringBuilder sb = new StringBuilder();
						for (int k = 0; k < tmp.size(); k++) {
							String str = tmp.get(k);
							sb.append(str);
							if (k + 1 < tmp.size())
								sb.append(s);
							if (extra > 0) {
								extra--;
								sb.append(" ");
							}
						}
						result.add(sb.toString());
					}
					// reset for a new line
					tmp = new ArrayList<>();
					length = 0;
					i--;
				} else {
					tmp.add(words[i]);
				}
			}// end for
				// last row
			if (tmp.size() > 0) {
				int spaces = maxWidth - preLen;
				String pad = tmp.size() - 1 == 0 ? "" : " ";
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < tmp.size(); k++) {
					String str = tmp.get(k);
					sb.append(str);
					if (k + 1 <= tmp.size())
						sb.append(pad);
				}
				result.add(sb.toString());
			}
			return result;
		}
	}
}
