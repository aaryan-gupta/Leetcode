class Solution {
	public boolean checkPerfectNumber(int num) {
		int sum = 0, temp = num;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0)
				sum += i;
		}
		if (sum == temp)
			return true;
		return false;
	}
}