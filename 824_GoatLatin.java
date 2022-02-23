class Solution {
	public String toGoatLatin(String sentence) {
		String[] s = sentence.split(" ");
		for (int i = 0; i < s.length; i++) {
			StringBuilder sb = new StringBuilder(s[i]);
			if (!(s[i].charAt(0) == 'a' || s[i].charAt(0) == 'e' || s[i].charAt(0) == 'i' || s[i].charAt(0) == 'o'
					|| s[i].charAt(0) == 'u' || s[i].charAt(0) == 'A' || s[i].charAt(0) == 'E' || s[i].charAt(0) == 'I'
					|| s[i].charAt(0) == 'O' || s[i].charAt(0) == 'U')) {
				char x = s[i].charAt(0);
				sb.deleteCharAt(0);
				sb.append(x);
			}
			sb.append("ma" + String.join("", Collections.nCopies(i + 1, "a")));
			s[i] = sb.toString();
			// System.out.println(s[i] + "\t" + sb);
		}
		// return String.join(" ",s);
		// System.out.println(String.join(" ", s));
		return String.join(" ", s);
	}
}