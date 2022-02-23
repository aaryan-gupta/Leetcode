class Solution {
	public int minJumps(int[] arr) {
		if (arr.length == 1)
			return 0;
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		int step = 0;
		for (int i = 0; i < arr.length; i++)
			hm.computeIfAbsent(arr[i], l -> new ArrayList()).add(i);
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		while (!q.isEmpty()) {
			step++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int j = q.poll();
				if (j - 1 >= 0 && hm.containsKey(arr[j - 1]))
					q.offer(j - 1);
				if (j + 1 < arr.length && hm.containsKey(arr[j + 1])) {
					if (j + 1 == arr.length - 1)
						return step;
					q.offer(j + 1);
				}
				if (hm.containsKey(arr[j])) {
					for (int k : hm.get(arr[j])) {
						if (k != j) {
							if (k == arr.length - 1)
								return step;
							q.offer(k);
						}
					}
				}
				hm.remove(arr[j]);
			}
		}
		return step;
	}

}

// ===============================================

class Solution {
	public int minJumps(int[] arr) {
		int n = arr.length;
		if (arr.length == 1)
			return 0;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int step = 0;
		for (int i = 0; i < arr.length; i++)
			map.computeIfAbsent(arr[i], l -> new ArrayList()).add(i);
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[arr.length];
		q.offer(0);
		while (!q.isEmpty()) {
			step++;
			int size = q.size();
			while (size-- > 0) {
				int j = q.poll();
				if (j - 1 >= 0 && map.containsKey(arr[j - 1]) && !vis[j - 1])
					q.offer(j - 1);
				if (j + 1 < n && map.containsKey(arr[j + 1])) {
					if (j + 1 == n - 1)
						return step;
					q.offer(j + 1);
				}
				if (map.containsKey(arr[j])) {
					for (int k : map.get(arr[j])) {
						if (k != j && !vis[k]) {
							if (k == n - 1)
								return step;
							q.offer(k);
						}
					}
				}
				map.remove(arr[j]);
				vis[j] = true;
			}
		}
		return step;
	}
}