class Solution {
	private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int minimumEffortPath(int[][] heights) {
		int m = heights.length, n = heights[0].length;

		// efforts[x][y] : effort of reaching (x,y) from (0,0)
		int[][] efforts = new int[m][n];
		for (int[] effort : efforts)
			Arrays.fill(effort, Integer.MAX_VALUE);
		efforts[0][0] = 0;

		// min-heap storing triplets {x, y, effort of reaching (x,y) from (0,0) }
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		heap.offer(new int[] { 0, 0, 0 });

		while (!heap.isEmpty()) {
			int[] curr = heap.poll();
			int x = curr[0], y = curr[1], eff = curr[2];

			if (x == m - 1 && y == n - 1)
				return eff;

			for (int[] dir : DIRECTIONS) {
				int newX = x + dir[0], newY = y + dir[1];
				if (newX < 0 || newY < 0 || newX >= m || newY >= n)
					continue;

				// effort to reach {newX, newY} from {x,y},
				int newEff = Math.max(eff, Math.abs(heights[x][y] - heights[newX][newY]));
				if (efforts[newX][newY] > newEff) {
					efforts[newX][newY] = newEff;
					heap.offer(new int[] { newX, newY, newEff });
				}
			}
		}
		return 0;
	}
}

// =================================

class Solution {
	public int minimumEffortPath(int[][] heights) {
		int left = 0, right = (int) 10e6;
		while (left < right) {
			int middle = (right + left) / 2;
			if (dfs(heights, new boolean[heights.length][heights[0].length], 0, 0, heights[0][0], middle))
				right = middle;
			else
				left = middle + 1;
		}
		return right;
	}

	private boolean dfs(int[][] heights, boolean[][] visited, int row, int column, int lastHeight, int threshold) {
		if (row < 0 || row >= heights.length || column < 0 || column >= heights[0].length ||
				visited[row][column] || Math.abs(heights[row][column] - lastHeight) > threshold)
			return false;

		visited[row][column] = true;

		return ((row == heights.length - 1 && column == heights[0].length - 1)
				|| dfs(heights, visited, row + 1, column, heights[row][column], threshold)
				|| dfs(heights, visited, row - 1, column, heights[row][column], threshold)
				|| dfs(heights, visited, row, column + 1, heights[row][column], threshold)
				|| dfs(heights, visited, row, column - 1, heights[row][column], threshold));
	}
}