class Solution {
	public String convert(String s, int numRows) {
		StringBuilder sb[] = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++)
			sb[i] = new StringBuilder();
		int index = 0;
		while (index < s.length()) {
			for (int j = 0; j < numRows && index < s.length(); j++)
				sb[j].append(s.charAt(index++));
			for (int j = numRows - 2; j > 0 && index < s.length(); j--)
				sb[j].append(s.charAt(index++));
		}
		StringBuilder res = sb[0];
		for (int i = 1; i < numRows; i++)
			res.append(sb[i].toString());
		return res.toString();
	}
}