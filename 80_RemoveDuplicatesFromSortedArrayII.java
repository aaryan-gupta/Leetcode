class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 1)
			return 1;
		if (nums.length == 2)
			return 2;
		int c = 1, x = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			if (c < 2 && nums[i] == nums[i - 1]) {
				c++;
			} else if (nums[i] != nums[i - 1] && nums[i] != x) {
				c = 1;
			} else {
				x = nums[i];
				nums[i] = Integer.MAX_VALUE;
			}
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		c = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == Integer.MAX_VALUE)
				break;
			c++;
		}
		return c;
	}
}

// ==============================

class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int res = 2;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[res - 2]) {
				nums[res] = nums[i];
				res++;
			}
		}
		return res;
	}
}