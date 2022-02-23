class Solution {
	class Destination {
		int v;
		boolean artificial;

		Destination(int v, boolean artificial) {
			this.v = v;
			this.artificial = artificial;
		}
	}

	public int minReorder(int n, int[][] connections) {
		HashMap<Integer, ArrayList<Destination>> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(i, new ArrayList<>());
		for (int e[] : connections) {
			int u = e[0], v = e[1];
			map.get(v).add(new Destination(u, false));
			map.get(u).add(new Destination(v, true));
		}
		int cost = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean visited[] = new boolean[n];
		visited[0] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (Destination i : map.get(temp)) {
				if (visited[i.v])
					continue;
				if (i.artificial)
					cost++;
				q.add(i.v);
				visited[i.v] = true;
			}
		}
		return cost;
	}
}