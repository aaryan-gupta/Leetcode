class Solution {
	public int cherryPickup(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		Integer dp[][][] = new Integer[n][m][m];
		return dfs(grid, n, m, 0, 0, m - 1, dp);
	}

	int dfs(int grid[][], int n, int m, int r, int c1, int c2, Integer dp[][][]) {
		if (r < 0 || r >= n || c1 < 0 || c1 >= m || c2 < 0 || c2 >= m)
			return 0;
		if (dp[r][c1][c2] != null)
			return dp[r][c1][c2];
		int maxCherries = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int newCol1 = c1 + i, newCol2 = c2 + j;
				maxCherries = Math.max(maxCherries, dfs(grid, n, m, r + 1, newCol1, newCol2, dp));
			}
		}
		int currentCherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
		dp[r][c1][c2] = maxCherries + currentCherries;
		return dp[r][c1][c2];
	}
}