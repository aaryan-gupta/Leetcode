class Solution {
	public void solveSudoku(char[][] board) {
		solve(board);
	}

	boolean solve(char board[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
							if (solve(board))
								return true;
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	boolean isValid(char board[][], int row, int col, char c) {
		for (int k = 0; k < 9; k++) {
			if (board[k][col] == c)
				return false;
			if (board[row][k] == c)
				return false;
			if (board[3 * (row / 3) + (k / 3)][3 * (col / 3) + (k % 3)] == c)
				return false;
		}
		return true;
	}
}