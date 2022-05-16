class Solution {
	public int mostFrequent(int[] nums, int key) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key && i != nums.length - 1) {
				hm.put(nums[i + 1], hm.getOrDefault(nums[i + 1], 0) + 1);
			}
		}
		// int max = Integer.MIN_VALUE;
		// for(int x : hm.values()) max = Math.max(max, x);
		int k = 0, v = 0;
		for (Map.Entry<Integer, Integer> x : hm.entrySet()) {
			if (x.getValue() > v) {
				v = x.getValue();
				k = x.getKey();
			}
		}
		return k;
	}
}