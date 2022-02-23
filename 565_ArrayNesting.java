// 3 ms
class Solution {
	public int arrayNesting(int[] nums) {
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0)
				continue;
			max = Math.max(max, calcLength(nums, i));
		}
		return max;
	}

	int calcLength(int nums[], int start) {
		if (start < 0 || nums[start] < 0 || nums.length == 0)
			return 0;
		int nextValue = nums[start];
		nums[start] = -1;
		return 1 + calcLength(nums, nextValue);
	}
}

// 3 ms
public class Solution {
	public int arrayNesting(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != Integer.MAX_VALUE) {
				int start = nums[i], count = 0;
				while (nums[start] != Integer.MAX_VALUE) {
					int temp = start;
					start = nums[start];
					count++;
					nums[temp] = Integer.MAX_VALUE;
				}
				res = Math.max(res, count);
			}
		}
		return res;
	}
}