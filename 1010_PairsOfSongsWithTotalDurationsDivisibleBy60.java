class Solution {
	public int numPairsDivisibleBy60(int[] time) {
		int array[] = new int[60];
		int retVal = 0;
		for (int i : time) {
			int n = i % 60;
			retVal += array[n == 0 ? 0 : 60 - n];
			array[n]++;
		}
		return retVal;
	}
}

// =========================================

// TLE

class Solution {
	public int numPairsDivisibleBy60(int[] time) {
		int c = 0;
		for (int i = 0; i < time.length - 1; i++) {
			for (int j = i + 1; j < time.length; j++) {
				if ((time[i] + time[j]) % 60 == 0)
					c++;
			}
		}
		return c;
	}
}

// =================================================

class Solution {
	public int numPairsDivisibleBy60(int[] time) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int c = 0;
		for (int t : time) {
			if (t % 60 == 0)
				c += hm.getOrDefault(0, 0);
			else
				c += hm.getOrDefault(60 - t % 60, 0);
			hm.put(t % 60, hm.getOrDefault(t % 60, 0) + 1);
		}
		return c;
	}
}