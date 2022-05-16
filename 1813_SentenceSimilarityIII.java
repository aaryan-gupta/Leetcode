class Solution {
	public boolean areSentencesSimilar(String s1, String s2) {
		// Just to make s1 always bigger in size
		if (s1.length() < s2.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		// making array of every word
		String[] arr1 = s1.split(" ");
		String[] arr2 = s2.split(" ");
		int i1 = 0, i2 = 0, j1 = arr1.length - 1, j2 = arr2.length - 1;
		// iterating from start as well as from last
		while (i2 <= j2) {
			if (arr1[i1].equals(arr2[i1])) {
				i1++;
				i2++;
			} else if (arr1[j1].equals(arr2[j2])) {
				j1--;
				j2--;
			} else {
				return false;
			}
		}
		return true;
	}
}