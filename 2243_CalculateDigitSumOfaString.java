class Solution {
	public String digitSum(String s, int k) {
		while (s.length() > k) {
			s = replaceWithSum(s, k);
		}
		return s;
	}

	private String replaceWithSum(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int currentSum = 0;

		for (int i = 0; i < s.length(); i++) {
			currentSum += s.charAt(i) - '0';
			if ((i + 1) % k == 0 || i == s.length() - 1) {
				sb.append(currentSum);
				currentSum = 0;
			}
		}
		return sb.toString();
	}
}