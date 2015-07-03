package leetcode;

/* Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24336987
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-word-search.html
 */
public class WordSearchOJ {
	public static void main(String[] args) {
		WordSearchOJ test = new WordSearchOJ();
		Solution testCase = test.new Solution();

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };

		String word = "ABCCEDFSA";
		System.out.println(testCase.exist(board, word));
	}

	public class Solution {
		public boolean exist(char[][] board, String word) {
			if (null == board)
				return false;
			if (null == word)
				return false;
			boolean[][] visitMap = new boolean[board.length][board[0].length];

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (word.charAt(0) == board[i][j]) {
						if (dfs(board, word, 0, i, j, visitMap))
							return true;
					}
				}
			}

			return false;
		}

		public boolean dfs(char[][] board, String word, int index, int row,
				int col, boolean[][] visitMap) {

			if (index == word.length())
				return true;
			if (index > word.length())
				return false;
			if (row < 0 || col < 0 || row >= board.length
					|| col >= board[0].length
					|| board[row][col] != word.charAt(index)
					|| visitMap[row][col])
				return false;
			visitMap[row][col] = true;
			index++;
			if (dfs(board, word, index, row - 1, col, visitMap))
				return true;
			if (dfs(board, word, index, row + 1, col, visitMap))
				return true;
			if (dfs(board, word, index, row, col - 1, visitMap))
				return true;
			if (dfs(board, word, index, row, col + 1, visitMap))
				return true;
			visitMap[row][col] = false;
			return false;
		}
	}
}
