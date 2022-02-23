class Solution {
	public List<Integer> pathInZigZagTree(int label) {
		ArrayList<Integer> l = new ArrayList<>();
		int currentTotalVal = 0, lastLevelVal = 1;
		while (currentTotalVal < label) {
			currentTotalVal += lastLevelVal;
			lastLevelVal *= 2;
		}
		lastLevelVal /= 2;
		while (label != 1) {
			l.add(label);
			int complement = 3 * lastLevelVal - label - 1;
			int parent = complement / 2;
			label = parent;
			lastLevelVal /= 2;
		}
		l.add(1);
		Collections.reverse(l);
		return l;
	}
}