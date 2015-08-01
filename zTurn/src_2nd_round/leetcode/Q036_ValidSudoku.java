package leetcode;

import java.util.Arrays;

/*
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

 http://www.cnblogs.com/springfor/p/3884217.html
 http://blog.csdn.net/linhuanmars/article/details/20748171
 */
public class Q036_ValidSudoku {
	public class Solution {
		public boolean isValidSudoku(char[][] board) {
			if (board == null)
				return false;
			if (board.length != 9 || board[0].length != 9)
				return false;

			// each row
			for (int j = 0; j < 9; j++) {
				boolean[] check = new boolean[9];
				for (int i = 0; i < 9; i++) {
					if (board[j][i] == '.')
						continue;
					int index = board[j][i] - '1';
					if (!check[index])
						check[index] = true;
					else
						return false;
				}
			}
			// each column
			for (int j = 0; j < 9; j++) {
				boolean[] check = new boolean[9];
				for (int i = 0; i < 9; i++) {
					if (board[i][j] == '.')
						continue;
					int index = board[i][j] - '1';
					if (!check[index])
						check[index] = true;
					else
						return false;
				}
			}
			// each square
			for (int k = 0; k < 9; k++) {
				boolean[] check = new boolean[9];
				for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
					for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
						if (board[i][j] == '.')
							continue;
						int index = board[i][j] - '1';
						if (!check[index])
							check[index] = true;
						else
							return false;
					}
				}
			}

			return true;
		}// end of method
	}
}
