class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		helper(result, candidates, target, 0, new ArrayList<>());
		return result;
	}

	void helper(List<List<Integer>> result, int arr[], int target, int index, ArrayList<Integer> ds) {
		if (target == 0) {
			result.add(new ArrayList<>(ds));
			return;
		}
		for (int i = index; i < arr.length; i++) {
			if (i > index && arr[i] == arr[i - 1])
				continue;
			if (arr[i] > target)
				break;
			ds.add(arr[i]);
			helper(result, arr, target - arr[i], i + 1, ds);
			ds.remove(ds.size() - 1);
		}
	}
}