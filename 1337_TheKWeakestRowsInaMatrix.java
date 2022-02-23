class Solution {
	public int[] kWeakestRows(int[][] mat, int k) {
		int a[] = new int[k];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			int sum = 0;
			for (int j = 0; j < mat[i].length; j++) {
				sum += mat[i][j];
			}
			hm.put(i, sum);
		}
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
		Collections.sort(list, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));
		for (int i = 0; i < a.length && i < k; i++) {
			a[i] = list.get(i).getKey();
		}
		return a;
	}
}

// ============================

class Solution {
	public int[] kWeakestRows(int[][] mat, int k) {
		if (mat == null || k < 0 || mat.length < k)
			throw new IllegalArgumentException("Input is invalid");
		// Max Heap
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]));
		for (int i = 0; i < mat.length; i++) {
			queue.offer(new int[] { i, getSoldierCount(mat[i]) });
			if (queue.size() > k)
				queue.poll();
		}
		int[] result = new int[k];
		while (!queue.isEmpty())
			result[--k] = queue.poll()[0];
		return result;
	}

	private int getSoldierCount(int[] row) {
		if (row[0] == 0)
			return 0;
		if (row[row.length - 1] == 1)
			return row.length;
		int start = 0;
		int end = row.length; // Number of solder can be maximum row.length. Thus end needs to be row.length
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (row[mid] == 1)
				start = mid + 1;
			else
				end = mid;
		}
		return end;
	}
}