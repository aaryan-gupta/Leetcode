class Solution {
	public boolean isHappy(int n) {
		if (n == 1 || n == 7)
			return true;
		int a = n, sum = n;
		while (sum > 9) {
			sum = 0;
			while (a > 0) {
				sum += Math.pow(a % 10, 2);
				a /= 10;
			}
			a = sum;
			if (sum == 1)
				return true;
		}
		if (sum == 7)
			return true;
		return false;
	}
}

class Solution {
	public boolean isHappy(int n) {
		int slow, fast;
		slow = fast = n;
		do {
			slow = numSquareSum(slow);
			fast = numSquareSum(numSquareSum(fast));
		} while (slow != fast);
		return (slow == 1);
	}

	static int numSquareSum(int n) {
		int squareSum = 0;
		while (n != 0) {
			squareSum += (n % 10) * (n % 10);
			n /= 10;
		}
		return squareSum;
	}
}