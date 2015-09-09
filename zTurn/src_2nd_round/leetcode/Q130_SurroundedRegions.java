package leetcode;

import java.util.LinkedList;

/*
 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 http://blog.csdn.net/linhuanmars/article/details/22904855
 */
public class Q130_SurroundedRegions {
	// X, O, .
	public class Solution {
		public void solve(char[][] board) {
			if (board == null || board.length == 0 || board[0].length == 0)
				return;
			for (int i = 0; i < board[0].length; i++)
				bfs(board, 0, i);
			for (int i = 0; i < board[0].length; i++)
				bfs(board, board.length - 1, i);
			for (int i = 0; i < board.length; i++)
				bfs(board, i, 0);
			for (int i = 0; i < board.length; i++)
				bfs(board, i, board[0].length - 1);

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 'O')
						board[i][j] = 'X';
					if (board[i][j] == '.')
						board[i][j] = 'O';
				}
			}

		}

		private void bfs(char[][] board, int row, int col) {
			if (row < 0 || col < 0 || row > board.length - 1
					|| col > board[0].length - 1)
				return;
			if (board[row][col] == 'O') {
				board[row][col] = '.';
				LinkedList<Integer> queue = new LinkedList<Integer>();
				queue.add(row * board[0].length + col);
				while (queue.size() > 0) {
					int code = queue.remove(0);
					int i = code / board[0].length;
					int j = code % board[0].length;
					// up
					if (i >= 1 && board[i - 1][j] == 'O') {
						board[i - 1][j] = '.';
						queue.add((i - 1) * board[0].length + j);
					}
					// down
					if (i < board.length - 1 && board[i + 1][j] == 'O') {
						board[i + 1][j] = '.';
						queue.add((i + 1) * board[0].length + j);
					}
					// left
					if (j >= 1 && board[i][j - 1] == 'O') {
						board[i][j - 1] = '.';
						queue.add(i * board[0].length + j - 1);
					}
					// right
					if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
						board[i][j + 1] = '.';
						queue.add(i * board[0].length + j + 1);
					}
				}
			}
		}// end of bfs
	}

	public class SolutionStackOverFlow {
		public void solve(char[][] board) {
			if (board == null || board.length == 0 || board[0].length == 0)
				return;
			boolean[][] visited = new boolean[board.length][board[0].length];
			for (int i = 0; i < board[0].length; i++)
				dfs(board, visited, 0, i);
			for (int i = 0; i < board[0].length; i++)
				dfs(board, visited, board.length - 1, i);
			for (int i = 0; i < board.length; i++)
				dfs(board, visited, i, 0);
			for (int i = 0; i < board.length; i++)
				dfs(board, visited, i, board.length - 1);

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 'O')
						board[i][j] = 'X';
					if (board[i][j] == '.')
						board[i][j] = 'O';
				}
			}

		}

		private void dfs(char[][] board, boolean[][] visited, int row, int col) {
			if (row < 0 || col < 0 || row > visited.length - 1
					|| col > visited[0].length - 1 || visited[row][col])
				return;
			visited[row][col] = true;
			if (board[row][col] == 'X' || board[row][col] == '.')
				return;
			if (board[row][col] == 'O') {
				board[row][col] = '.';
				dfs(board, visited, row + 1, col);
				dfs(board, visited, row - 1, col);
				dfs(board, visited, row, col + 1);
				dfs(board, visited, row, col - 1);
			}
		}
	}
}
