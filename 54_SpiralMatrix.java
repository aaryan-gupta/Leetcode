class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		int minRow = 0, minCol = 0, maxRow = matrix.length - 1, maxCol = matrix[0].length - 1;
		int t = (maxRow + 1) * (maxCol + 1), c = 0;
		List<Integer> a = new ArrayList<>();
		while (c < t) {
			for (int i = minCol; i <= maxCol && c < t; i++) {
				a.add(matrix[minRow][i]);
				c++;
			}
			minRow++;
			for (int i = minRow; i <= maxRow && c < t; i++) {
				a.add(matrix[i][maxCol]);
				c++;
			}
			maxCol--;
			for (int i = maxCol; i >= minCol && c < t; i--) {
				a.add(matrix[maxRow][i]);
				c++;
			}
			maxRow--;
			for (int i = maxRow; i >= minRow && c < t; i--) {
				a.add(matrix[i][minCol]);
				c++;
			}
			minCol++;
		}
		return a;
	}
}