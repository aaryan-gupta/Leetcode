class Solution {
	public String multiply(String num1, String num2) {
		if (num1.length() == 0 || num2.length() == 0 || "0".equals(num1) || "0".equals(num2))
			return "0";
		if ("1".equals(num1))
			return num2;
		if ("1".equals(num2))
			return num1;
		int a[] = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				product += a[i + j + 1];
				a[i + j + 1] = product % 10;
				a[i + j] += product / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : a) {
			if (sb.length() == 0 && i == 0)
				continue;
			sb.append(i);
		}
		return sb.toString();
	}
}