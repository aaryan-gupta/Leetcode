class Solution {
	public int arrangeCoins(int n) {
		int completed_rows = 0, current_rows = 1;
		while (current_rows <= n) {
			n = n - current_rows;
			current_rows++;
			completed_rows++;
		}
		return completed_rows;
	}
}