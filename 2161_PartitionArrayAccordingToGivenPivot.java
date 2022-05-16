class Solution {
	public int[] pivotArray(int[] nums, int pivot) {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		int c = 0;
		for (int x : nums) {
			if (x < pivot)
				l1.add(x);
			else if (x > pivot)
				l2.add(x);
			else
				c++;
		}
		int i = 0;
		for (Integer x : l1)
			nums[i++] = x;
		while (c-- > 0)
			nums[i++] = pivot;
		for (Integer x : l2)
			nums[i++] = x;
		return nums;
	}
}

// ===========================================

class Solution {
	public int[] pivotArray(int[] nums, int pivot) {
		int[] ans = new int[nums.length];
		int start = 0;
		int i = 0, c = 0;
		while (start < nums.length) {
			if (nums[start] < pivot)
				ans[i++] = nums[start];
			else if (nums[start] == pivot)
				c++;
			start++;
		}
		start = 0;
		for (int j = 0; j < c; j++)
			ans[i++] = pivot;
		while (start < nums.length) {
			if (nums[start] > pivot)
				ans[i++] = nums[start];
			start++;
		}
		return ans;
	}
}