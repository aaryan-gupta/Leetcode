class Solution {
	public int finalValueAfterOperations(String[] operations) {
		int x = 0;
		for (int i = 0; i < operations.length; i++) {
			switch (operations[i]) {
				case "++X":
					++x;
					break;
				case "X++":
					x++;
					break;
				case "--X":
					--x;
					break;
				case "X--":
					x--;
					break;
			}
		}
		return x;
	}
}

// =================================

class Solution {
	public int finalValueAfterOperations(String[] operations) {
		int x = 0;
		for (String t : operations) {
			if (t.charAt(0) == '+' || t.charAt(2) == '+')
				x++;
			if (t.charAt(0) == '-' || t.charAt(2) == '-')
				x--;
		}
		return x;
	}
}