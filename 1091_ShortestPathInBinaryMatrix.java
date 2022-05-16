class Solution {
	public int shortestPathBinaryMatrix(int[][] g) {
		if (g[0][0] == 1)
			return -1;
		int m = g.length, n = g[0].length;
		Queue<int[]> nm = new LinkedList<>();
		nm.offer(new int[] { 0, 0, 1 });
		int a[][] = { { 1, 1 }, { 1, 0 }, { 0, 1 }, { -1, -1 }, { -1, 0 }, { 0, -1 }, { 1, -1 }, { -1, 1 } };
		while (!(nm.isEmpty())) {
			int s = nm.size();
			while (s-- > 0) {
				int b[] = nm.poll();
				if (b[0] == m - 1 && b[1] == n - 1)
					return b[2];
				for (int d[] : a) {
					int p = b[0] + d[0];
					int q = b[1] + d[1];
					if (p >= 0 && q >= 0 && p < m && q < n && g[p][q] == 0) {
						nm.offer(new int[] { p, q, b[2] + 1 });
						g[p][q] = 1;
					}
				}
			}
		}
		return -1;
	}
}