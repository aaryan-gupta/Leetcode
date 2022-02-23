class Solution {
	public int maximalNetworkRank(int n, int[][] roads) {
		int count[] = new int[n];
		boolean direct[][] = new boolean[n][n];
		for (int road[] : roads) {
			count[road[0]]++;
			count[road[1]]++;
			direct[road[0]][road[1]] = true;
			direct[road[1]][road[0]] = true;
		}
		int rank = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (direct[i][j] == true)
					rank = Math.max(rank, count[i] + count[j] - 1);
				else
					rank = Math.max(rank, count[i] + count[j]);
			}
		}
		return rank;
	}
}