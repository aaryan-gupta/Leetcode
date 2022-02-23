class Solution {
	public boolean halvesAreAlike(String s) {
		String a[] = new String[2];
		a[0] = s.substring(0, s.length() / 2);
		a[1] = s.substring(s.length() / 2);
		int v1 = 0, v2 = 0;
		String vowels = "AEIOUaeiou";
		for (int i = 0; i < a[0].length(); i++) {
			if (vowels.contains(String.valueOf(a[0].charAt(i))))
				v1++;
		}
		for (int i = 0; i < a[1].length(); i++) {
			if (vowels.contains(String.valueOf(a[1].charAt(i))))
				v2++;
		}
		return v1 == v2;
	}
}