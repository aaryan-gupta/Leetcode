class Solution {
	public int prefixCount(String[] words, String pref) {
		int c = 0;
		for (String s : words) {
			if (pref.length() > s.length())
				continue;
			if (s.substring(0, pref.length()).equals(pref))
				c++;
		}
		return c;
	}
}