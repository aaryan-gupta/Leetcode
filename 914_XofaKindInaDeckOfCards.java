class Solution {
	public boolean hasGroupsSizeX(int[] deck) {
		HashMap<Integer, Integer> frequencyCount = new HashMap<Integer, Integer>();
		int min = deck.length;
		for (int i = 0; i < deck.length; i++) {
			frequencyCount.put(deck[i], frequencyCount.getOrDefault(deck[i], 0) + 1);
		}
		for (int i : frequencyCount.values())
			min = Math.min(min, i);
		List<Integer> values = new ArrayList<Integer>(frequencyCount.values());
		for (int i : values) {
			min = gcd(min, i);
			if (min == 1)
				return false;
		}
		return true;
	}

	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}