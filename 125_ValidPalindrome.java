class _125_ValidPalindrome {
	public static void main(String a[]) {
		String s = "race a car";
		s = s.toLowerCase();
		s = s.replace(" ", "");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))
				sb.append(s.charAt(i));
		}
		String a1 = sb.toString();
		String b1 = sb.reverse().toString();
		// System.out.println(s);
		// System.out.println(sb);
		// System.out.println(sb.reverse());
		// System.out.println(sb.reverse().toString().equals(sb.toString()));
		System.out.println(a1 == b1);
	}
}