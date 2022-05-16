class Solution {
	public boolean possibleBipartition(int N, int[][] dislikes) {
		if (dislikes.length == 0)
			return true;
		HashMap<Integer, List<Integer>> edgeList = new HashMap<>();
		int[] color = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			edgeList.put(i, new ArrayList<>());
		for (int[] dislike : dislikes) {
			edgeList.get(dislike[0]).add(dislike[1]);
			edgeList.get(dislike[1]).add(dislike[0]);
		}
		for (int index = 1; index <= N; index++) {
			if (color[index] == 0) {
				q.add(index);
				color[index] = 1;
				while (!q.isEmpty()) {
					int size = q.size();
					for (int i = 0; i < size; i++) {
						int person = q.poll();
						int nextColor = color[person] == 1 ? 2 : 1;
						List<Integer> dislikePeople = edgeList.get(person);
						for (int j = 0; j < dislikePeople.size(); j++) {
							int dislikePerson = dislikePeople.get(j);
							if (color[dislikePerson] == color[person])
								return false;
							if (color[dislikePerson] == 0) {
								color[dislikePerson] = nextColor;
								q.add(dislikePerson);
							}
						}
					}
				}
			}
		}
		return true;
	}
}