class Solution {
	public int divide(int dividend, int divisor) {
		// int absDivisor = Math.abs(divisor);
		// int absDividend = Math.abs(dividend);
		// int x = absDivisor;
		// int c = 0;
		// if(absDivisor > absDividend) return 0;
		// else if(absDivisor == absDividend) return 1;
		// // for(int i = absDivisor; i < dividend; i += absDivisor)
		// while (absDivisor < dividend) {
		// absDivisor += x;
		// c++;
		// }
		// if(divisor < 0 && dividend < 0) return c;
		// if(divisor < 0) return c * (-1);
		// if(dividend < 0) return c * (-1);
		// return c;
		if (dividend == -2147483648 && divisor == -1)
			return 2147483647;
		return dividend / divisor;
	}
}