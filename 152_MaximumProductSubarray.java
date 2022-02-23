class Solution {
	public int maxProduct(int[] nums) {
		int curMin = 1, curMax = 1, result = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++)
			result = Math.max(result, nums[i]);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				curMin = 1;
				curMax = 1;
				continue;
			}
			int temp = curMax * nums[i];
			curMax = Math.max(nums[i] * curMin, Math.max(temp, nums[i]));
			curMin = Math.min(nums[i] * curMin, Math.min(temp, nums[i]));
			result = Math.max(result, curMax);
		}
		return result;
	}
}