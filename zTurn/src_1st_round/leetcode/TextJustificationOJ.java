package leetcode;

import java.util.ArrayList;

/* Text Justification

 Given an array of words and a length L, format the text such that 
 each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, 
 pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. 
 If the number of spaces on a line do not divide evenly between words, 
 the empty slots on the left will be assigned more spaces than the slots on the right.

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
public class TextJustificationOJ {
	public static void main(String[] args) {
		TextJustificationOJ solution = new TextJustificationOJ();
		Solution test = solution.new Solution();
		String[] testCase = { "Here", "is", "an", "example", "of", "text",
				"justification." };
		int maxWidth = 16;
		System.out.println(test.fullJustify(testCase, maxWidth));
	}

	public class Solution {
		public ArrayList<String> fullJustify(String[] words, int maxWidth) {
			ArrayList<String> result = new ArrayList<String>();
			if (null == words || words.length == 0)
				return result;

			ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
			ArrayList<String> row = new ArrayList<String>();

			// [1] split original words in to groups to be processed
			int length = 0;
			for (int i = 0; i < words.length; i++) {
				String temp = words[i];
				if (row.size() == 0)
					length = temp.length();
				else
					length = length + temp.length() + 1;

				if (length <= maxWidth)
					row.add(temp);
				else {
					list.add(row);
					length = temp.length();
					row = new ArrayList<String>();
					row.add(temp);
				}
			}

			if (row.size() != 0)
				list.add(row);
			//[2] go thru the pre-processed groups
			for (int i = 0; i < list.size(); i++) {
				row = list.get(i);
				int rowLength = 0;
				
				//[2.1] count group length
				for (int j = 0; j < row.size(); j++) {
					rowLength = rowLength + row.get(j).length();
				}

				//[2.2] calc padding parameters
				int count = row.size() == 1 ? 1 : row.size() - 1;
				int padding = (maxWidth - rowLength) / count;
				int leftExtraPadding = (maxWidth - rowLength) % count;
//				System.out.println(rowLength + " " + padding + " "
//						+ leftExtraPadding);

				//[2.2] Build the string row
				StringBuilder sb = new StringBuilder();
				if (i != list.size() - 1)
					for (int j = 0; j < row.size() - 1; j++) {
						sb.append(row.get(j)).append(padSpaces(padding));
						if (leftExtraPadding > 0) {
							sb.append(padSpaces(1));
							leftExtraPadding--;
						}
					}
				else {
					for (int j = 0; j < row.size() - 1; j++)
						sb.append(row.get(j)).append(" ");
				}
				sb.append(row.get(row.size() - 1));
				if (sb.length() < maxWidth) {
					sb.append(padSpaces(maxWidth - sb.length()));
				}

				result.add(sb.toString());
			}

			return result;
		}

		public String padSpaces(int num) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < num; i++) {
				sb.append(" ");
			}
			return sb.toString();
		}
	}// end of solution
}
