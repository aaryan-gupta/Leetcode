// 2 ms
class Solution {

	Map<String, Boolean> map = new HashMap<String, Boolean>();

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0)
			return true;
		if (map.containsKey(s) && !map.get(s))
			return false;
		for (String str : wordDict) {
			int len = str.length();
			if (s.indexOf(str) == 0) {
				if (wordBreak(s.substring(len), wordDict)) {
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}
}

// =============================================

// 6 ms
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>();
		for (String e : wordDict) {
			set.add(e);
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		// i is actually a right bound, 0 is the left bound, j is the middle pointer
		// j is to find where dp[j] = true, so that we can check substring[j+1,i]
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				// if dp[j] is found true in the dictionary
				if (dp[j] == true) {
					// we just need to take a look at the right side substring [j+1, i]
					if (set.contains(s.substring(j, i))) {
						dp[i] = true;
						break; // we break because there is no need to continue looping
					}
				}
			}
		}
		return dp[dp.length - 1];
	}
}