class Solution {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (nums.length < k || sum % k != 0)
			return false;
		boolean visited[] = new boolean[nums.length];
		return helper(nums, visited, 0, k, 0, sum / k);
	}

	boolean helper(int nums[], boolean visited[], int start, int k, int currentSum, int subsetSum) {
		if (k == 0)
			return true;
		if (currentSum > subsetSum)
			return false;
		if (currentSum == subsetSum)
			return helper(nums, visited, 0, k - 1, 0, subsetSum);
		for (int i = start; i < nums.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			if (helper(nums, visited, i + 1, k, currentSum + nums[i], subsetSum))
				return true;
			visited[i] = false;
		}
		return false;
	}
}