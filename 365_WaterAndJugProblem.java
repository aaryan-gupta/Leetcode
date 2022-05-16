
class Solution {
	public boolean canMeasureWater(int j1, int j2, int t) {
		if (t > j1 + j2)
			return false;
		return t % gcd(j1, j2) == 0;
	}

	private int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}