class Solution {
	public List<Integer> partitionLabels(String s) {
		int lastIndex[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			lastIndex[s.charAt(i) - 'a'] = i;
		List<Integer> l = new ArrayList<>();
		int upperBound = 0;
		for (int i = 0; i < s.length();) {
			int prev = upperBound, c = s.charAt(i) - 'a';
			upperBound = lastIndex[c];
			while (i <= upperBound) {
				c = s.charAt(i++) - 'a';
				upperBound = Math.max(upperBound, lastIndex[c]);
			}
			if (l.size() == 0)
				l.add(upperBound + 1);
			else
				l.add(upperBound - prev);
		}
		return l;
	}
}