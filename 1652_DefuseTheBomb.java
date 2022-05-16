class Solution {
	public int[] decrypt(int[] code, int k) {
		int len = code.length;
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			int start = (k > 0) ? i + 1 : i + k;
			int end = (k > 0) ? i + k : i - 1;
			for (; start <= end; start++)
				res[i] += code[(start + len) % len];
		}
		return res;
	}
}