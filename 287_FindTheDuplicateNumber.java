class Solution {
	public int findDuplicate(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i : nums) {
			if (hs.contains(i))
				return i;
			hs.add(i);
		}
		return 0;
	}
}

// ======================

class Solution {
	public int findDuplicate(int[] arr) {
		int n = arr.length;
		int freq[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (freq[arr[i]] == 0)
				freq[arr[i]] += 1;
			else
				return arr[i];
		}
		return 0;
	}
}

// ==============================

class Solution {
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			int n = nums[i];
			int x = n ^ nums[i + 1];
			if (x == 0)
				return n;
		}
		return 0;
	}
}