class Solution {
	public int[] countBits(int n) {
		int a[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			int t = i;
			while (t > 0) {
				a[i] += t & 1;
				t >>= 1;
			}
		}
		return a;
	}
}

// =======================================

class Solution {
	public int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++)
			f[i] = f[i >> 1] + (i & 1);
		return f;
	}
}