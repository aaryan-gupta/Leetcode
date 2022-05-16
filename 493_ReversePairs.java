// COUNT INVERSIONS OF AN ARRAY

class Solution {
	public int reversePairs(int[] nums) {
		return partition(nums, 0, nums.length - 1);
	}

	int partition(int nums[], int l, int h) {
		int c = 0;
		if (l >= h)
			return 0;
		int mid = l + (h - l) / 2;
		c += partition(nums, l, mid);
		c += partition(nums, mid + 1, h);
		c += merge(nums, l, mid, h);
		return c;
	}

	int merge(int nums[], int l, int mid, int h) {
		int count = 0;
		int j = mid + 1;
		for (int i = l; i <= mid; i++) {
			while (j <= h && nums[i] > (2 * (long) nums[j]))
				j++;
			count += (j - (mid + 1));
		}
		ArrayList<Integer> t = new ArrayList<>();
		int left = l, right = mid + 1;
		while (left <= mid && right <= h) {
			if (nums[left] <= nums[right])
				t.add(nums[left++]);
			else
				t.add(nums[right++]);
		}
		while (left <= mid)
			t.add(nums[left++]);
		while (right <= h)
			t.add(nums[right++]);
		for (int i = l; i <= h; i++)
			nums[i] = t.get(i - l);
		return count;
	}
}