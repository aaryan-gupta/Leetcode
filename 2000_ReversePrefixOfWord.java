class Solution {
	public String reversePrefix(String word, char ch) {
		StringBuilder sb = new StringBuilder();
		for (int i = word.indexOf(String.valueOf(ch)); i >= 0; i--)
			sb.append(word.charAt(i));
		sb.append(word.substring(word.indexOf(String.valueOf(ch)) + 1));
		return sb.toString();
	}
}