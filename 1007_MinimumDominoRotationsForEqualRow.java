class Solution {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		int len = tops.length;
		int[][] dp = new int[6][3];
		for (int i = 0; i < len; i++) {
			if (tops[i] == bottoms[i]) {
				dp[tops[i] - 1][0]++;
				dp[tops[i] - 1][1]++;
				dp[tops[i] - 1][2]++;
			} else {
				dp[tops[i] - 1][0]++;
				dp[tops[i] - 1][1]++;
				dp[bottoms[i] - 1][0]++;
				dp[bottoms[i] - 1][2]++;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			if (dp[i][0] == len) {
				min = Math.min(min, Math.min(len - dp[i][1], len - dp[i][2]));
			}
		}
		if (min < len)
			return min;
		return -1;
	}
}

// ==============================================

class Solution {
	public int minDominoRotations(int[] top, int[] bottom) {
		int n = top.length;
		int a = top[0], b = bottom[0];
		for (int i = 1; i < n; i++) {
			if (a != top[i] && a != bottom[i])
				a = -1;
			if (b != top[i] && b != bottom[i])
				b = -1;
			if (a == -1 && b == -1)
				return -1;
		}
		a = a != -1 ? a : b;
		int tswap = 0, bswap = 0;
		for (int i = 0; i < n; i++) {
			if (a != top[i])
				tswap++;
			if (a != bottom[i])
				bswap++;
		}
		return Math.min(tswap, bswap);
	}
}

// =================================================

class Solution {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		int[] t = new int[6];
		int[] b = new int[6];
		for (int i = 0; i < tops.length; i++) {
			t[tops[i] - 1]++;
			b[bottoms[i] - 1]++;
		}
		int m1 = 0, c1 = 0;
		for (int i = 0; i < 6; i++) {
			if (t[i] > m1) {
				m1 = t[i];
				c1 = i + 1;
			}
		}
		int c2 = 0;
		m1 = 0;
		for (int i = 0; i < 6; i++) {
			if (b[i] > m1) {
				m1 = b[i];
				c2 = i + 1;
			}
		}
		while (true) {
			boolean f = true;
			int c = 0;
			if (t[c1 - 1] >= b[c2 - 1]) {
				for (int i = 0; i < tops.length; i++) {
					if (tops[i] == c1)
						continue;
					else if (bottoms[i] == c1)
						c++;
					else {
						f = false;
						break;
					}
				}
				if (f)
					return c;
			} else {
				boolean f2 = true;
				c = 0;
				for (int i = 0; i < bottoms.length; i++) {
					if (bottoms[i] == c2)
						continue;
					else if (tops[i] == c2)
						c++;
					else {
						f2 = false;
						break;
					}
				}
				if (f2)
					return c;
				return -1;
			}
			return -1;
		}
	}
}

// =================================================

class Solution {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= 6; i++) {
			int max = 0;
			for (int j = 0; j < tops.length; j++) {
				if (tops[j] == i)
					continue;
				else if (bottoms[j] == i)
					max++;
				else {
					max = -1;
					break;
				}
			}
			if (max != -1)
				ans = Math.min(ans, max);
		}
		for (int i = 1; i <= 6; i++) {
			int max = 0;
			for (int j = 0; j < tops.length; j++) {
				if (bottoms[j] == i)
					continue;
				else if (tops[j] == i)
					max++;
				else {
					max = -1;
					break;
				}
			}
			if (max != -1)
				ans = Math.min(ans, max);
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}