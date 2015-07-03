package leetcode;

import java.util.LinkedList;

/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * http://blog.csdn.net/linhuanmars/article/details/22904855
 * http://www.cnblogs.com/springfor/p/3869853.html
 */
public class SurroundedRegionsOJ {
	public class Solution {
		public void solve(char[][] board) {
			if (board == null || board.length < 1 || board[0].length < 1)
				return;

			// first and last row
			for (int i = 0; i < board[0].length; i++) {
				fill(board, 0, i);
				fill(board, board.length - 1, i);
			}

			// first and last col
			for (int i = 0; i < board.length; i++) {
				fill(board, i, 0);
				fill(board, i, board[0].length - 1);
			}

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 'X')
						continue;
					if (board[i][j] == 'O')
						board[i][j] = 'X';
					if (board[i][j] == '#')
						board[i][j] = 'O';
				}
			}

		}// end of solve

		public void fill(char[][] board, int i, int j) {
			if (board[i][j] != 'O')
				return;
			board[i][j] = '#';
			LinkedList<Integer> level = new LinkedList<Integer>();
			level.add(i * board[0].length + j);

			while (level.size() > 0) {
				int code = level.poll();
				int row = code / board[0].length;
				int col = code % board[0].length;

				// up
				if (row >= 1 && board[row - 1][col] == 'O') {
					level.add((row - 1) * board[0].length + col);
					board[row - 1][col] = '#';
				}
				// down
				if (row < board.length - 1 && board[row + 1][col] == 'O') {
					level.add((row + 1) * board[0].length + col);
					board[row + 1][col] = '#';
				}
				// left
				if (col >= 1 && board[row][col - 1] == 'O') {
					level.add(row * board[0].length + col - 1);
					board[row][col - 1] = '#';
				}
				// right
				if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
					level.add(row * board[0].length + col + 1);
					board[row][col + 1] = '#';
				}
			}
		}// end of fill
	}
}
