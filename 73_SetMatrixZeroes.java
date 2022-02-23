// 6ms
class Solution {
	public void setZeroes(int[][] matrix) {
		Stack<Pair<Integer, Integer>> s = new Stack();
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				if (matrix[i][j] == 0)
					s.push(new Pair<Integer, Integer>(i, j));
		while (!s.empty()) {
			int i = s.peek().getKey();
			int j = s.peek().getValue();
			for (int i1 = 0; i1 < matrix.length; i1++)
				matrix[i1][j] = 0;
			for (int j1 = 0; j1 < matrix[i].length; j1++)
				matrix[i][j1] = 0;
			s.pop();
		}
	}
}

// 2ms
class Solution {
	public void setZeroes(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = -1;
					col[j] = -1;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == -1 || col[j] == -1)
					matrix[i][j] = 0;
			}
		}
	}
}