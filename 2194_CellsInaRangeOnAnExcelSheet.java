class Solution {
	public List<String> cellsInRange(String s) {
		List<String> l = new ArrayList<>();
		for (char c1 = s.charAt(0); c1 <= s.charAt(3); c1++) {
			for (char c2 = s.charAt(1); c2 <= s.charAt(4); c2++)
				l.add(String.valueOf(c1) + String.valueOf(c2));
		}
		return l;
	}
}