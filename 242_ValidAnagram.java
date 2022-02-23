// 8 ms
class Solution {
	public boolean isAnagram(String s, String t) {
		char sch[] = s.toCharArray(), tch[] = t.toCharArray();
		Arrays.sort(sch);
		Arrays.sort(tch);
		return (new String(sch).equals(new String(tch)));
	}
}

// 3 ms
class Solution {
	public boolean isAnagram(String s, String t) {
		char x[] = s.toCharArray(), y[] = t.toCharArray();
		if (s.length() != t.length())
			return false;
		Arrays.sort(x);
		Arrays.sort(y);
		for (int i = 0; i < s.length(); i++) {
			if (x[i] != y[i])
				return false;
		}
		return true;
	}
}