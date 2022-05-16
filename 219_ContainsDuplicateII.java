class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer n = hm.put(nums[i], i);
			System.out.println(n);
			if (n != null && (i - n) <= k)
				return true;
		}
		return false;
	}
}