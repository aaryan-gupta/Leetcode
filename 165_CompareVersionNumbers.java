class Solution {
	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");

		int n = s1.length > s2.length ? s1.length : s2.length;
		for (int i = 0; i < n; i++) {
			String x = "";
			String y = "";
			if (i < s1.length) {
				x = s1[i];
				if (x.contains("0"))
					x = helper(x);
			}
			if (i < s2.length) {
				y = s2[i];
				if (y.contains("0"))
					y = helper(y);
			}
			if (x.length() == 0 && y.length() == 0)
				continue;
			if (x.length() == 0)
				return -1;
			if (y.length() == 0)
				return 1;
			if (Integer.parseInt(x) > Integer.parseInt(y))
				return 1;
			if (Integer.parseInt(x) < Integer.parseInt(y))
				return -1;
		}
		return 0;
	}

	String helper(String s) {
		int i = 0;
		while (i < s.length()) {
			if (!(s.charAt(i) == '0'))
				break;
			i++;
		}
		return s.substring(i);
	}
}

// ============================================

class Solution {
	public int compareVersion(String version1, String version2) {
		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");
		int max = Math.max(str1.length, str2.length);
		for (int i = 0; i < max; i++) {
			int num1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]);
			int num2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]);
			if (num1 < num2)
				return -1;
			if (num1 > num2)
				return 1;
		}
		return 0;
	}
}