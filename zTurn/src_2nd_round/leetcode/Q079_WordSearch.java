package leetcode;

/*
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class Q079_WordSearch {
	public static void main(String[] args) {
		Q079_WordSearch test = new Q079_WordSearch();
		Solution t = test.new Solution();
		String str = "ab";
		char[][] array = { str.toCharArray() };
		System.out.println(t.exist(array, "ba"));
	}

	public class Solution {
		public boolean exist(char[][] board, String word) {
			if (board == null || board.length == 0 || board[0].length == 0)
				return false;
			if (word == null || word.length() == 0)
				return false;
			int m = board.length;
			int n = board[0].length;

			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (word.charAt(0) == board[i][j])
						// pass right index!!!
						if (dfs(i, j, 0, word, board, visited))
							return true;
				}
			}

			return false;
		}

		private boolean dfs(int i, int j, int curr, String word,
				char[][] board, boolean[][] visited) {
			int m = board.length;
			int n = board[0].length;
			if (curr == word.length())
				return true;
			if (curr > word.length())
				return false;
			if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || visited[i][j]
					|| word.charAt(curr) != board[i][j])
				return false;

			visited[i][j] = true;

			curr++;
			if (dfs(i - 1, j, curr, word, board, visited))
				return true;
			if (dfs(i + 1, j, curr, word, board, visited))
				return true;
			if (dfs(i, j - 1, curr, word, board, visited))
				return true;
			if (dfs(i, j + 1, curr, word, board, visited))
				return true;

			visited[i][j] = false;
			return false;
		}
	}
}
