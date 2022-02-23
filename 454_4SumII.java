class Solution {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		for (int a : A) {
			for (int b : B)
				hm.put(a + b, hm.getOrDefault(a + b, 0) + 1);
		}
		for (int c : C) {
			for (int d : D)
				count += hm.getOrDefault((-1) * (c + d), 0);
		}
		return count;
	}
}