class Solution {
	public int wateringPlants(int[] plants, int capacity) {
		int n = 0, temp = capacity;
		for (int i = 0; i < plants.length; i++) {
			if (plants[i] <= capacity) {
				temp -= plants[i];
				n++;
			}
			if (i != plants.length - 1 && plants[i + 1] > temp) {
				n += 2 * (i + 1);
				temp = capacity;
			}
		}
		return n;
	}
}