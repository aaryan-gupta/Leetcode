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

// =============================

public class Solution {
	public boolean judgeSquareSum(int c) {
		for (long a = 0; a * a <= c; a++) {
			double b = Math.sqrt(c - a * a);
			if (b == (int) b)
				return true;
		}
		return false;
	}
}