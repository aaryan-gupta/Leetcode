class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int res = 0;
		ArrayList<int[]> l = new ArrayList<>();
		l.add(intervals[0]);
		int i = 0, j = 0;
		for (int[] x : intervals) {
			if (j == 0) {
				j++;
				continue;
			}
			int y[] = l.get(i);
			if (y[1] > x[0]) {
				y[1] = Math.min(y[1], x[1]);
				res++;
			} else {
				l.add(x);
				i++;
			}
		}
		return res;
	}
}