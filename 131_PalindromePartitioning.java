class Solution {
	public List<List<String>> partition(String s) {
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		List<List<String>> result = new ArrayList<>();
		dfs(result, s, 0, new ArrayList<>(), dp);
		return result;
	}

	void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
		if (start >= s.length())
			result.add(new ArrayList<>(currentList));
		for (int end = start; end < s.length(); end++) {
			if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
				dp[start][end] = true;
				currentList.add(s.substring(start, end + 1));
				dfs(result, s, end + 1, currentList, dp);
				currentList.remove(currentList.size() - 1);
			}
		}
	}
}

// ==========================================

class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if (s == null || s.length() == 0)
			return res;
		helper(res, new ArrayList<>(), s);
		return res;
	}

	void helper(List<List<String>> res, List<String> currentList, String inputString) {
		if (inputString.length() == 0) {
			res.add(new ArrayList<>(currentList));
			return;
		}
		for (int i = 0; i < inputString.length(); i++) {
			String prefix = inputString.substring(0, i + 1);
			String ros = inputString.substring(i + 1);
			if (isPalindrome(prefix)) {
				currentList.add(prefix);
				helper(res, currentList, ros);
				currentList.remove(currentList.size() - 1);
			}
		}
	}

	boolean isPalindrome(String s) {
		String reversedStr = new StringBuilder(s).reverse().toString();
		return s.equals(reversedStr);
	}
}