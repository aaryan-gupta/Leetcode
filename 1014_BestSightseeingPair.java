class Solution {
	public int maxScoreSightseeingPair(int[] values) {
		int max_score = 0, pre_max = 0;
		for (int x : values) {
			max_score = Math.max(max_score, x + pre_max);
			pre_max = Math.max(pre_max, x) - 1;
		}
		return max_score;
	}
}