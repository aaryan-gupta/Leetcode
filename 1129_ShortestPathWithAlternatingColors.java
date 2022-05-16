class Solution {
	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

		List<Integer>[] redMap = reformArray(redEdges, n);
		List<Integer>[] blueMap = reformArray(blueEdges, n);
		int[] r1 = alternatingPath(n, redMap, blueMap);
		int[] r2 = alternatingPath(n, blueMap, redMap);
		for (int i = 0; i < n; i++) {
			r1[i] = Math.min(r1[i], r2[i]);
			if (r1[i] == Integer.MAX_VALUE) {
				r1[i] = -1;
			}
		}
		return r1;
	}

	private int[] alternatingPath(int n, List<Integer>[] redMap, List<Integer>[] blueMap) {
		boolean redFirst = true;
		int[] r = new int[n];
		Arrays.fill(r, Integer.MAX_VALUE);
		r[0] = 0;
		boolean[] redSet = new boolean[n];
		boolean[] blueSet = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		int level = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Integer c = q.poll();
				List<Integer>[] map = redFirst ? redMap : blueMap;
				boolean[] set = redFirst ? redSet : blueSet;
				List<Integer> list = map[c];
				if (list != null) {
					for (Integer num : list) {
						if (r[num] == Integer.MAX_VALUE) {
							r[num] = level;
						}
						if (!set[num]) {
							q.offer(num);
							set[num] = true;
						}
					}
				}
			}
			redFirst = !redFirst;
			level++;
		}
		return r;
	}

	private List<Integer>[] reformArray(int[][] edges, int n) {
		List<Integer>[] map = new List[n];
		for (int[] edge : edges) {
			List<Integer> list = map[edge[0]];
			if (list == null) {
				list = new ArrayList<>();
				map[edge[0]] = list;
			}
			list.add(edge[1]);
		}
		return map;
	}
}