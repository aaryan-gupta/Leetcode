class Solution {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> list = new ArrayList<>();
		int max = candies[0];
		for (int i = 1; i < candies.length; i++) {
			if (max < candies[i])
				max = candies[i];
		}
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= max)
				list.add(true);
			else
				list.add(false);
		}
		System.out.println(max);
		return list;
	}
}

// ========================================

class Solution {
	public List<Boolean> kidsWithCandies(int[] candies, int k) {
		int min = Integer.MIN_VALUE;
		for (int c : candies)
			min = Math.max(min, c);
		List<Boolean> l = new ArrayList<>();
		for (int c : candies) {
			if (c + k >= min)
				l.add(true);
			else
				l.add(false);
		}
		return l;
	}
}