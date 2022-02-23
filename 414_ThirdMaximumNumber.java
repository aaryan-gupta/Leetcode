// 6 ms
class Solution {
	public int thirdMax(int[] nums) {
		Arrays.sort(nums);
		int i = 1;
		for (int n : nums) {
			if (n != nums[i - 1]) {
				nums[i] = n;
				i++;
			}
		}
		int newAry[] = new int[i];
		for (int j = 0; j < i; j++) {
			newAry[j] = nums[j];
		}
		if (newAry.length == 1)
			return nums[0];
		if (newAry.length == 2)
			return nums[1];
		return newAry[newAry.length - 3];
	}
}

// 1 ms
class Solution {
	public int thirdMax(int[] nums) {
		int l1 = Integer.MIN_VALUE;
		for (int num : nums)
			l1 = Math.max(num, l1);
		int l2 = Integer.MIN_VALUE;
		for (int num : nums)
			if (num != l1)
				l2 = Math.max(num, l2);
		if (l2 == Integer.MIN_VALUE)
			return l1;
		int l3 = Integer.MIN_VALUE;
		for (int num : nums)
			if (num != l1 && num != l2)
				l3 = Math.max(num, l3);
		boolean present = false;
		for (int num : nums)
			if (num == l3)
				present = true;
		if (present)
			return l3;
		else
			return l1;
	}
}