class Solution {
	public int minMutation(String start, String end, String[] b) {
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		int depth = 0;
		HashSet<String> bank = new HashSet<>();
		for (String t : b)
			bank.add(t);
		HashSet<String> visited = new HashSet<>();
		visited.add(start);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				if (word.equals(end))
					return depth;
				for (int j = 0; j < word.length(); j++) {
					for (char c : new char[] { 'A', 'C', 'G', 'T' }) {
						String temp = word.substring(0, j) + c + word.substring(j + 1);
						if (bank.contains(temp) && !visited.contains(temp)) {
							queue.add(temp);
							visited.add(temp);
						}
					}
				}
			}
			depth++;
		}
		return -1;
	}
}