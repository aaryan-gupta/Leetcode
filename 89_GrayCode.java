class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> l = new ArrayList<>();
		l.add(0);
		if (n == 0)
			return l;
		l.add(1);
		int c = 1;
		for (int i = 2; i <= n; i++) {
			c *= 2;
			for (int j = l.size() - 1; j >= 0; j--)
				l.add(c + l.get(j));
		}
		return l;
	}
}