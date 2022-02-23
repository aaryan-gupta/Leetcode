class Solution {
	public boolean divisorGame(int n) {
		return n % 2 == 0;
	}
}

// =============================================

class Solution {
	public boolean divisorGame(int n) {
		if (n == 1)
			return false;
		boolean ans = true;
		int x = n - 1;
		while (x > 1) {
			ans = ans == true ? false : true;
			x--;
		}
		return ans;
	}
}