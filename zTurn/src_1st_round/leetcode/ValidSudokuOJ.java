package leetcode;

/* Valid Sudoku 
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * 
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-valid-sudoku-sudoku-solver.html
 * http://rleetcode.blogspot.com/2014/02/valid-sudoku-java.html
 */

public class ValidSudokuOJ {
	public class Solution {
		public boolean isValidSudoku(char[][] board) {
			if (null == board)
				return false;
			if (board[0].length != 9 || board.length != 9)
				return false;

			// loop each row
			for (int i = 0; i < 9; i++) {
				boolean[] check = new boolean[9];
				for (int j = 0; j < 9; j++) {
					if (board[i][j] != '.') {
						int temp = board[i][j] - '0';
						if (!check[temp])
							check[temp] = true;
						else
							return false;
					}
				}
			}

			// loop each row
			for (int i = 0; i < 9; i++) {
				boolean[] check = new boolean[9];
				for (int j = 0; j < 9; j++) {
					if (board[j][i] != '.') {
						int temp = board[j][i] - '0';
						if (!check[temp])
							check[temp] = true;
						else
							return false;
					}
				}
			}

			// loop each box
			for (int i = 0; i < 9; i = i + 3) {
				int j = 0;
				boolean[] check = new boolean[9];
				for (int m = 0; m < 9; m++) {
					for (int n = i; n < i + 3; n++) {
						if (board[n][m] != '.') {
							int temp = board[n][m] - '0';
							if (!check[temp])
								check[temp] = true;
							else
								return false;
						}
					}
					j++;
					if (j % 3 == 0)
						check = new boolean[9];
				}
			}
			return true;
		}// end of method
	}
}
