class Solution {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int c1[] = new int[26];
		int c2[] = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			c1[s1.charAt(i) - 'a']++;
			c2[s2.charAt(i) - 'a']++;
		}
		if (Arrays.equals(c1, c2))
			return true;
		int front = 0, back = s1.length();
		while (back < s2.length()) {
			c2[s2.charAt(front) - 'a']--;
			c2[s2.charAt(back) - 'a']++;
			if (Arrays.equals(c1, c2))
				return true;
			front++;
			back++;
		}
		return false;
	}
}