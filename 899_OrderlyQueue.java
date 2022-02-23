class Solution {
	public String orderlyQueue(String s, int k) {
		if (k > 1) {
			char ary[] = s.toCharArray();
			Arrays.sort(ary);
			return new String(ary);
		} else {
			String str = s + s;
			for (int i = 1; i < s.length(); i++) {
				String t = str.substring(i, i + s.length());
				if (s.compareTo(t) > 0)
					s = t;
			}
		}
		return s;
	}
}