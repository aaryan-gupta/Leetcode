// 6 ms
class Solution {
	public String complexNumberMultiply(String num1, String num2) {
		int r1 = Integer.parseInt(num1.substring(0, num1.indexOf("+")));
		int r2 = Integer.parseInt(num2.substring(0, num2.indexOf("+")));
		int i1 = Integer.parseInt(num1.substring(num1.indexOf("+") + 1, num1.length() - 1));
		int i2 = Integer.parseInt(num2.substring(num2.indexOf("+") + 1, num2.length() - 1));
		return ((r1 * r2) + (i1 * i2 * -1)) + "+" + ((r1 * i2) + (i1 * r2)) + "i";
	}
}

// 0 ms
class Solution {
	public String complexNumberMultiply(String num1, String num2) {
		StringBuilder s = new StringBuilder();
		int r1 = Integer.parseInt(num1.substring(0, num1.indexOf("+")));
		int r2 = Integer.parseInt(num2.substring(0, num2.indexOf("+")));
		int i1 = Integer.parseInt(num1.substring(num1.indexOf("+") + 1, num1.length() - 1));
		int i2 = Integer.parseInt(num2.substring(num2.indexOf("+") + 1, num2.length() - 1));
		s.append(r1 * r2 - i1 * i2);
		s.append("+");
		s.append(r1 * i2 + i1 * r2);
		s.append("i");
		return s.toString();
	}
}