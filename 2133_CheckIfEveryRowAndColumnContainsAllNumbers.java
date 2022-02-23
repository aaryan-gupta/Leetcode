class Solution {
	public boolean checkValid(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			boolean vis[] = new boolean[matrix.length + 1];
			boolean vis1[] = new boolean[matrix.length + 1];
			for (int j = 0; j < matrix[0].length; j++) {
				if (!vis[matrix[i][j]])
					vis[matrix[i][j]] = true;
				if (!vis1[matrix[j][i]])
					vis1[matrix[j][i]] = true;
			}
			for (int k = 1; k < vis.length; k++) {
				if (!vis[k])
					return false;
				if (!vis1[k])
					return false;
			}
		}
		return true;
	}
}

// ===================================================

class Solution {
	public boolean checkValid(int[][] matrix) {
		int mask = 0;
		for (int i = 1; i <= matrix.length; i++)
			mask ^= i;
		for (int i = 0; i < matrix.length; i++) {
			int mask1 = mask, mask2 = mask;
			for (int j = 0; j < matrix[i].length; j++) {
				mask1 ^= matrix[i][j];
				mask2 ^= matrix[j][i];
			}
			if (mask1 != 0 || mask2 != 0)
				return false;
		}
		return true;
	}
}