// 56 ms

class Solution {
	public String getSmallestString(int n, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			int x = Math.min(26, k - i);
			sb.append((char) (x - 1 + 'a'));
			k -= x;
		}
		return sb.reverse().toString();
	}
}

// ===============================

// 24 ms

class Solution {
	public String getSmallestString(int n, int k) {
		char[] sol = new char[n];
		final char[] chr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int avail = k - n;
		for (int i = 0; i < n; i++) {
			int c = Math.min(25, avail);
			sol[n - i - 1] = chr[c];
			avail -= c;
		}
		return new String(sol);
	}
}

// ===================================

// 9 ms

class Solution {
	public String getSmallestString(int n, int k) {
		char ans[] = new char[n];
		int i = 0;
		while (i < n) {
			ans[i] = 'a';
			i++;
		}
		k = k - n;
		int j = n - 1;
		while (k > 0) {
			if (k < 25) {
				ans[j] = (char) ('a' + k);
				k = 0;
			} else {
				ans[j] = 'z';
				k -= 25;
			}
			j--;
		}
		return new String(ans);
	}
}