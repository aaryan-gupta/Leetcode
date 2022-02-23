class Solution {
	public boolean judgeSquareSum(int c) {
		int i = 0, j = (int) Math.sqrt(c);
		while (i <= j) {
			if ((i * i + j * j) == c)
				return true;
			else if ((i * i + j * j) > c)
				j--;
			else
				i++;
		}
		return false;
	}
}