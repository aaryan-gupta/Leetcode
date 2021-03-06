class Solution {
	public boolean canJump(int[] nums) {
		int maxReach = 0;
		for (int i = 0; i < nums.length && i <= maxReach; i++)
			maxReach = Math.max(maxReach, nums[i] + i);
		return maxReach >= nums.length - 1;
	}
}