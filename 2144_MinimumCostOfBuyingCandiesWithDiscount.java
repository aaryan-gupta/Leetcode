class Solution {
	public int minimumCost(int[] cost) {
		Arrays.sort(cost);
		int sum = 0;
		for (int i = cost.length - 1, j = cost.length - 2; i >= 0 || j >= 0; i -= 3, j -= 3) {
			if (i >= 0 && j >= 0)
				sum += cost[i] + cost[j];
			else if (i >= 0)
				sum += cost[i];
			else
				sum += cost[j];
		}
		return sum;
	}
}