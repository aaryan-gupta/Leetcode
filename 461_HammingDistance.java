class Solution {
	public int hammingDistance(int x, int y) {
		int xor = x ^ y, setBits = 0;
		while (xor > 0) {
			setBits += xor & 1;
			xor >>= 1;
		}
		return setBits;
	}
}