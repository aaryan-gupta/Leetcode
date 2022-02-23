class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int a = x, sum = 0;
		while (x != 0) {
			sum = sum * 10 + x % 10;
			x /= 10;
		}
		if (sum == a)
			return true;
		return false;
	}
}