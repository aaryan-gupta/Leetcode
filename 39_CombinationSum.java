class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> l = new ArrayList<>();
		helper(0, candidates, target, l, new ArrayList<>());
		return l;
	}

	void helper(int index, int arr[], int target, List<List<Integer>> l, ArrayList<Integer> ds) {
		if (index == arr.length) {
			if (target == 0)
				l.add(new ArrayList<>(ds));
			return;
		}
		if (arr[index] <= target) {
			ds.add(arr[index]);
			helper(index, arr, target - arr[index], l, ds);
			ds.remove(ds.size() - 1);
		}
		helper(index + 1, arr, target, l, ds);
	}
}