class Solution {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double a[][] = new double[101][101];
		a[0][0] = poured;
		for (int i = 0; i < query_row; i++) {
			for (int j = 0; j <= query_glass; j++) {
				double remaining = Math.max(a[i][j] - 1.0, 0);
				a[i + 1][j] += remaining / 2.0;
				a[i + 1][j + 1] += remaining / 2.0;
			}
		}
		return Math.min(a[query_row][query_glass], 1.0);
	}
}

// ========================================

class Solution {
	public double champagneTower(int poured, int query_row, int query_glass) {
		if (poured == 0)
			return 0;
		List<Double> l = new ArrayList<>();
		l.add(new Double(poured));
		while (query_row-- > 0) {
			List<Double> curr = new ArrayList<>();
			// to prevent -ve when glass cant be filled
			curr.add(Math.max(0, (l.get(0) - 1) / 2));
			for (int i = 1; i < l.size(); i++) {
				curr.add(Math.max((l.get(i - 1) - 1) / 2, 0) + Math.max((l.get(i) - 1) / 2, 0));
			}
			curr.add(curr.get(0));
			l = new ArrayList<>(curr);
		}
		// min as 1 will be max value in it
		return Math.min(1, l.get(query_glass));
	}
}