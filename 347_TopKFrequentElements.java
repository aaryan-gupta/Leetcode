class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i : nums)
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> hm.get(n1) - hm.get(n2));
		for (int i : hm.keySet()) {
			pq.add(i);
			if (pq.size() > k)
				pq.poll();
		}
		int a[] = new int[k];
		for (int i = 0; i < k; i++)
			a[i] = pq.poll();
		return a;
	}
}