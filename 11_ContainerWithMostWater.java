class Solution {
	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1, temp = 0, area = 0;
		while (i < j) {
			if (height[i] <= height[j]) {
				temp = height[i] * (j - i);
				i++;
			} else {
				temp = height[j] * (j - i);
				j--;
			}
			area = Math.max(area, temp);
		}
		return area;
	}
}