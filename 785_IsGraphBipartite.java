class Solution {
	class Pair {
		int v;
		int level;

		Pair(int v, int level) {
			this.v = v;// for vertex
			this.level = level;
		}
	}

	public boolean isBipartite(int[][] graph) {
		ArrayList<Integer>[] graph1 = new ArrayList[graph.length];
		for (int i = 0; i < graph1.length; i++)
			graph1[i] = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++)
				graph1[i].add(graph[i][j]);
		}
		int[] visited = new int[graph1.length];
		Arrays.fill(visited, -1);
		for (int i = 0; i < graph1.length; i++) {
			if (visited[i] == -1) {
				boolean res = checkComponentForBipartiteness(graph1, i, visited);
				if (res == false)
					return false;// if result is false then it will return false
			}
		}
		return true;
	}

	public boolean checkComponentForBipartiteness(ArrayList<Integer>[] graph1, int v, int[] visited) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.addFirst(new Pair(v, 0));// v-->vertex,0-->level
		while (q.size() != 0) {
			Pair rem = q.remove();
			if (visited[rem.v] != -1) {
				// that means it is visited and we have to make sure now the levels of that
				// element which is currently visited and the one which has visited it before
				// are not same.If not same then we will return false
				if (visited[rem.v] != rem.level)
					return false;
			} else
				visited[rem.v] = rem.level;
			for (Integer e : graph1[rem.v]) {
				if (visited[e] == -1) {// that means not visited
					q.add(new Pair(e, rem.level + 1));// adding its children(i.e. neighbour)
				}
			}
		}
		return true;
	}
}