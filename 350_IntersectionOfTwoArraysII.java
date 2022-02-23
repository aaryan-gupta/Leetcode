class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int first = 0, second = 0;
		int result = 0;
		while (first < nums1.length && second < nums2.length) {
			if (nums1[first] < nums2[second])
				first++;
			else if (nums1[first] > nums2[second])
				second++;
			else {
				nums1[result++] = nums1[first];
				first++;
				second++;
			}
		}
		return Arrays.copyOf(nums1, result);
	}
}

// 7 ms
class Solution {
	public int[] intersect(int[] n1, int[] n2) {
		// int n1[] = { 1, 2, 2, 1 }, n2[] = { 2, 2 };
		// int n1[] = { 4, 9, 5 }, n2[] = { 9, 4, 9, 8, 4 };
		ArrayList<Integer> l = new ArrayList<>();
		if (n2.length < n1.length) {
			for (int i = 0; i < n2.length; i++) {
				for (int j = 0; j < n1.length; j++) {
					if (n2[i] == n1[j]) {
						l.add(n2[i]);
						n1[j] = -1;
						break;
					}
				}
			}
		} else {
			for (int i = 0; i < n1.length; i++) {
				for (int j = 0; j < n2.length; j++) {
					if (n1[i] == n2[j]) {
						l.add(n1[i]);
						n2[j] = -1;
						break;
					}
				}
			}
		}
		// System.out.println(l);
		int r[] = new int[l.size()];
		for (int i = 0; i < r.length; i++) {
			r[i] = l.get(i);
		}
		return r;
	}
}