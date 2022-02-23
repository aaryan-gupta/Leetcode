class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int indegree[] = new int[numCourses];
		HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
		for (int i = 0; i < numCourses; i++)
			hm.put(i, new HashSet<>());
		for (int preReq[] : prerequisites) {
			int course = preReq[0];
			int dependingCourse = preReq[1];
			hm.get(dependingCourse).add(course);
			indegree[course]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}
		List<Integer> result = new ArrayList<>();
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int head = q.poll();
				if (indegree[head] == 0)
					result.add(head);
				for (Integer children : hm.get(head)) {
					indegree[children]--;
					if (indegree[children] == 0)
						q.offer(children);
				}
			}
		}
		int i = 0;
		int ans[] = new int[result.size()];
		for (Integer e : result)
			ans[i++] = e;
		if (result.size() != numCourses)
			return new int[] {};
		return ans;
	}
}