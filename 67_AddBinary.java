class Solution {
	public String addBinary(String s1, String s2) {
		int i = s1.length() - 1, j = s2.length() - 1, carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += s1.charAt(i--) - '0';
			if (j >= 0)
				sum += s2.charAt(j--) - '0';
			carry = sum > 1 ? 1 : 0;
			sb.append(sum % 2);
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}