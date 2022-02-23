public class Solution {
	public int maxProfit(int prices[]) {
		int min = Integer.MAX_VALUE, max = 0;
		for (int p : prices) {
			min = Math.min(min, p);
			max = Math.max(p - min, max);
		}
		return max;
	}
}