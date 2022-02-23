// 236 ms

class NumMatrix {
	int[][] sums;

	public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return;
		sums = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 1; i < sums.length; i++)
			for (int j = 1; j < sums[0].length; j++)
				sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row1][col2 + 1] - sums[row2 + 1][col1];
	}
}

// 106 ms

class NumMatrix {
	int m[][];

	public NumMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++)
				matrix[i][j] += matrix[i][j - 1];
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] += matrix[i - 1][j];
		}
		m = matrix;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return m[row2][col2] - ((col1 != 0 ? m[row2][col1 - 1] : 0) + (row1 != 0 ? m[row1 - 1][col2] : 0)
				- ((row1 != 0 && col1 != 0) ? m[row1 - 1][col1 - 1] : 0));
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */