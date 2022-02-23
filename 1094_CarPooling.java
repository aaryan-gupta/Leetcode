class Solution {
	public boolean carPooling(int[][] trips, int capacity) {
		int occupancy[] = new int[1001];
		for (int i = 0; i < trips.length; i++) {
			occupancy[trips[i][1]] += trips[i][0];
			occupancy[trips[i][2]] -= trips[i][0];
		}
		int c = 0;
		for (int i = 0; i < occupancy.length; i++) {
			c += occupancy[i];
			if (c > capacity)
				return false;
		}
		return true;
	}
}