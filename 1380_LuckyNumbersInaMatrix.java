class Solution {
	public List<Integer> luckyNumbers(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			int min = Integer.MAX_VALUE, index = -1;
			for (int j = 0; j < matrix[i].length; j++) {
				if (min > matrix[i][j]) {
					index = j;
					min = matrix[i][j];
				}
			}
			if (checkColumnMin(matrix, index) == min)
				list.add(min);
		}
		return list;
	}

	private int checkColumnMin(int[][] matrix, int index) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			max = Math.max(matrix[i][index], max);
		}
		return max;
	}
}