// 13 ms
class Solution {
	private int peremeter = 0;

	public int islandPerimeter(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					getIslandPerimeter(grid, i, j);
					return peremeter;
				}
			}
		}
		return peremeter;
	}

	public void getIslandPerimeter(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			peremeter += 1;
			return;
		}
		if (grid[i][j] == 0) {
			peremeter += 1;
			return;
		}
		if (grid[i][j] == -1)
			return;
		grid[i][j] = -1;
		getIslandPerimeter(grid, i - 1, j);
		getIslandPerimeter(grid, i, j + 1);
		getIslandPerimeter(grid, i, j - 1);
		getIslandPerimeter(grid, i + 1, j);
		return;
	}
}

// ===================================================

// 8 ms
class Solution {
	public int islandPerimeter(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					count += 4;
					if (i > 0 && grid[i - 1][j] == 1)
						count -= 2;
					if (j > 0 && grid[i][j - 1] == 1)
						count -= 2;
				}
			}
		}
		return count;
	}
}

// ===================================================

// 7 ms
class Solution {
	public int islandPerimeter(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1)
					return dfs(grid, i, j);
			}
		}
		return 4;
	}

	int dfs(int grid[][], int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0)
			return 1;
		if (grid[i][j] == -1)
			return 0;
		grid[i][j] = -1;
		int l = dfs(grid, i, j - 1);
		int r = dfs(grid, i, j + 1);
		int u = dfs(grid, i - 1, j);
		int d = dfs(grid, i + 1, j);
		return l + r + u + d;
	}
}