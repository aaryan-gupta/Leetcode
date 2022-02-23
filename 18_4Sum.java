class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		HashSet<List<Integer>> hs = new HashSet<>();
		if (nums.length == 0)
			return new ArrayList<>(hs);
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int l = i + 1; l < nums.length - 2; l++) {
				int j = l + 1;
				int k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum == target)
						hs.add(Arrays.asList(nums[i], nums[j++], nums[k--], nums[l]));
					else if (sum > target)
						k--;
					else
						j++;
				}
			}
		}
		return new ArrayList<>(hs);
	}
}