class Solution {
	public int shortestPath(int[][] grid, int k) {
		int directions[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int lives[][] = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++)
			Arrays.fill(lives[i], -1);
		Queue<int[]> q = new ArrayDeque();
		q.offer(new int[] { 0, 0, k, 0 }); // row, column, lives, distance
		while (!q.isEmpty()) {
			int current[] = q.poll();
			int currentI = current[0], currentJ = current[1], currentLives = current[2], currentDistance = current[3];
			if (currentI == grid.length - 1 && currentJ == grid[0].length - 1)
				return currentDistance;
			if (grid[currentI][currentJ] == 1)
				currentLives--;
			for (int[] direction : directions) {
				int nexti = currentI + direction[0], nextj = currentJ + direction[1];
				if (nexti < 0 || nextj < 0 || nexti >= grid.length || nextj >= grid[0].length
						|| lives[nexti][nextj] >= currentLives)
					continue;
				q.offer(new int[] { nexti, nextj, currentLives, currentDistance + 1 });
				lives[nexti][nextj] = currentLives;
			}
		}
		return -1;
	}
}