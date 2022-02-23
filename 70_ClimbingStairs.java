class Solution {
	public int climbStairs(int n) {
		if (n <= 0)
			return 0;
		if (n <= 2)
			return n;

		int last = 2;
		int secondLast = 1;
		for (int i = 3; i <= n; i++) {
			int sum = last + secondLast;
			secondLast = last;
			last = sum;
		}
		return last;
	}
}

// Dynamic Programming - Memoization
class Solution {
	public int climbStairs(int n) {
		return countPaths(n, new int[n + 1]);
	}

	int countPaths(int n, int dpMemoi[]) {
		if (n == 0)
			return 1;
		else if (n < 1)
			return 0;
		if (dpMemoi[n] > 0)
			return dpMemoi[n];
		int cp = countPaths(n - 1, dpMemoi) + countPaths(n - 2, dpMemoi);
		dpMemoi[n] = cp;
		return cp;
	}
}

// Dynamic Programming - Tabulation
class Solution {
	public int climbStairs(int n) {
		int dpTab[] = new int[n + 1];
		dpTab[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i == 1)
				dpTab[i] = dpTab[i] + dpTab[i - 1];
			else
				dpTab[i] = dpTab[i] + dpTab[i - 1] + dpTab[i - 2];
		}
		return dpTab[n];
	}
}