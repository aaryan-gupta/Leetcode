class Solution {
	public int minimumLength(String s) {
		if (s.length() == 1)
			return 1;
		int i = 0, j = s.length() - 1, n = s.length();
		char c = ' ';
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				c = s.charAt(i);
				while (i <= j && c == s.charAt(i)) {
					i++;
					n--;
				}
				while (i < j && c == s.charAt(j)) {
					j--;
					n--;
				}
			} else
				break;
		}
		return n;
	}
}