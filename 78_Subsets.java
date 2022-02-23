class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		ans.add(new ArrayList<>());
		helper(ans, nums, 0, new ArrayList<>());
		return ans;
	}

	void helper(List<List<Integer>> ans, int nums[], int index, List<Integer> l) {
		if (index >= nums.length)
			return;
		for (int i = index; i < nums.length; i++) {
			l.add(nums[i]);
			ans.add(new ArrayList<>(l));
			helper(ans, nums, i + 1, l);
			l.remove(l.size() - 1);
		}
	}
}