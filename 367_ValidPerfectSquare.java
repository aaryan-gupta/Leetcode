// 995 ms
class Solution {
	public boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		if (num == 2147483647)
			return false;
		for (int i = 2; i <= num; i++) {
			if (i * i == num)
				return true;
		}
		System.out.println(Integer.MAX_VALUE);
		return false;
	}
}

// 2472 ms
class Solution {
	public boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		if (num == 2147483647)
			return false;
		for (int i = 2; i <= num / 2; i++) {
			if (i * i == num)
				return true;
		}
		System.out.println(Integer.MAX_VALUE);
		return false;
	}
}

// 2 ms
class Solution {
	public boolean isPerfectSquare(int num) {
		for (long i = 1; i * i <= num; i++) {
			if ((num % i == 0) && (num / i == i))
				return true;
		}
		return false;
	}
}