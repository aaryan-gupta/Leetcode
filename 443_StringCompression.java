class Solution {
	public int compress(char[] chars) {
		int i = 0;
		int j = 1;
		int freq = 1;
		char ch;
		String s;
		while (j <= chars.length) {
			if (j != chars.length && chars[j] == chars[j - 1]) {
				freq++;
			} else {
				chars[i++] = chars[j - 1];
				if (freq > 1) {
					s = String.valueOf(freq);
					for (int k = 0; k < s.length(); k++)
						chars[i++] = s.charAt(k);
				}
				freq = 1;
			}
			j++;
		}
		return i;
	}
}