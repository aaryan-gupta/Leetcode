class Solution {
	public int maxNumberOfBalloons(String text) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('b', 0);
		map.put('a', 0);
		map.put('l', 0);
		map.put('o', 0);
		map.put('n', 0);

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'b')
				map.put('b', map.get('b') + 1);
			if (text.charAt(i) == 'a')
				map.put('a', map.get('a') + 1);
			if (text.charAt(i) == 'l')
				map.put('l', map.get('l') + 1);
			if (text.charAt(i) == 'o')
				map.put('o', map.get('o') + 1);
			if (text.charAt(i) == 'n')
				map.put('n', map.get('n') + 1);
		}

		int ans = Integer.MAX_VALUE;

		ans = Math.min(ans, map.get('b'));
		ans = Math.min(ans, map.get('a'));
		ans = Math.min(ans, map.get('l') / 2);
		ans = Math.min(ans, map.get('o') / 2);
		ans = Math.min(ans, map.get('n'));

		return ans;
	}
}