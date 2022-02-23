class Solution {
	public int[][] kClosest(int[][] points, int k) {
		Arrays.sort(points, (a, b) -> squaredDistance(a) - squaredDistance(b));
		return Arrays.copyOf(points, k);
	}

	public int squaredDistance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}

// ==============================

class Solution {
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a, b) -> (-((a[1] * a[1] + a[0] * a[0]) - (b[1] * b[1] + b[0] * b[0]))));
		for (int pt[] : points) {
			pq.offer(pt);
			if (pq.size() > k) {
				pq.poll();
				// break;
			}
		}
		int result[][] = new int[pq.size()][2];
		int count = 0;
		while (!pq.isEmpty())
			result[count++] = pq.poll();
		return result;
	}
}

// ==============================

class Solution {
	public int[][] kClosest(int[][] points, int k) {
		Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		for (int i = 0; i < points.length; i++) {
			int[] entry = { squaredDistance(points[i]), i };
			if (maxPQ.size() < k)
				maxPQ.add(entry);
			else if (entry[0] < maxPQ.peek()[0]) {
				maxPQ.poll();
				maxPQ.add(entry);
			}
		}
		int[][] answer = new int[k][2];
		for (int i = 0; i < k; i++) {
			int entryIndex = maxPQ.poll()[1];
			answer[i] = points[entryIndex];
		}
		return answer;
	}

	private int squaredDistance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
};