// 1116 ms

class Solution {
	public int chalkReplacer(int[] chalk, int k) {
		long sum = 0;
		for (int i = 0; i < chalk.length; i++) {
			sum += chalk[i];
		}
		while (k >= sum) {
			k -= sum;
		}
		for (int i = 0; i < chalk.length; i++) {
			if (chalk[i] > k)
				return i;
			k -= chalk[i];
		}
		return 0;
	}
}

// ==================================

// 1 ms

class Solution {
	public int chalkReplacer(int[] chalk, int k) {
		long sum = 0;
		for (int i = 0; i < chalk.length; i++) {
			sum += chalk[i];
		}
		if (k > sum) {
			long c = k % sum;
			if (c == 0)
				return 0;
			k = (int) c;
		}
		for (int i = 0; i < chalk.length; i++) {
			if (chalk[i] > k)
				return i;
			k -= chalk[i];
		}
		return 0;
	}
}