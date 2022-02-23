class Solution {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int a[] = new int[arr1.length];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			int count = 0;
			for (int j = 0; j < arr1.length; j++) {
				if (arr1[j] == arr2[i])
					hm.put(arr2[i], ++count);
			}
		}
		int x = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < hm.get(arr2[i]); j++) {
				a[x++] = arr2[i];
			}
		}
		int b[] = new int[arr1.length - x];
		int y = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (!hm.containsKey(arr1[i])) {
				b[y++] = arr1[i];
			}
		}
		Arrays.sort(b);
		for (int i = 0; i < b.length; i++) {
			a[x++] = b[i];
		}
		return a;
	}
}