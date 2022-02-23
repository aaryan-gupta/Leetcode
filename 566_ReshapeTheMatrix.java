class Solution {
	public int[][] matrixReshape(int[][] mat, int r, int c) {
		int res[][] = new int[r][c];
		int a = 0, b = 0;
		if (r * c != mat.length * mat[0].length)
			return mat;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				res[a][b++] = mat[i][j];
				if (b >= res[0].length) {
					b = 0;
					a++;
				}
			}
		}
		return res;
	}
}