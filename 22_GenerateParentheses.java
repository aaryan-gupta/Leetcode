class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> l = new ArrayList();
		helper(l, new StringBuilder(), 0, 0, n);
		return l;
	}

	public void helper(List<String> l, StringBuilder current, int ob, int cb, int max) {
		if (current.length() == max * 2) {
			l.add(current.toString());
			return;
		}
		if (ob < max) {
			current.append("(");
			helper(l, current, ob + 1, cb, max);
			current.deleteCharAt(current.length() - 1);
		}
		if (cb < ob) {
			current.append(")");
			helper(l, current, ob, cb + 1, max);
			current.deleteCharAt(current.length() - 1);
		}
	}
}