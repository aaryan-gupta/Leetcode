class Solution {
	public int findKthPositive(int[] arr, int k) {
		boolean nums[] = new boolean[arr[arr.length - 1] + 1];
		for (int i = 0; i < arr.length; i++)
			nums[arr[i]] = true;
		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == false)
				++count;
			if (count == k)
				return i;
		}
		return arr[arr.length - 1] - count + k;
	}
}