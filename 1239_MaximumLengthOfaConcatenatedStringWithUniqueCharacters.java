class Solution {
	public int maxLength(List<String> arr) {
		return findMax(arr, 0, 0);
	}

	int findMax(List<String> arr, int currentIndex, int mask) {
		if (currentIndex == arr.size())
			return Integer.bitCount(mask);
		// Skip the current item, and analyze the next one
		int count = findMax(arr, currentIndex + 1, mask);
		// Now look at the current item so far and see if any of the characters in the
		// mask overlap.
		var item = arr.get(currentIndex);
		int newMask = mask;
		for (var c : item.toCharArray()) {
			// return the previous count if you see any characters that are present in the
			// map
			if ((newMask & (1 << c - 'a')) != 0)
				return count;
			// otherwise modify the mask and set the appropriate bit for the character index
			newMask |= (1 << (c - 'a'));
		}
		// the max count is the max of both the count determined by skipping the current
		// element, and the count from including the element.
		return Math.max(count, findMax(arr, currentIndex + 1, newMask));
	}
}