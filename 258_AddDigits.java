class Solution {
	public int addDigits(int num) {
		if (num < 9)
			return num;
		int sum = num, a = num;
		while (sum > 9) {
			sum = 0;
			while (a > 0) {
				sum += a % 10;
				a /= 10;
			}
			a = sum;
		}
		if (sum <= 9)
			return sum;
		return num;
	}
}