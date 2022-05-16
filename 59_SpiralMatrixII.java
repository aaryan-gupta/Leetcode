class Solution {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int cnt = 1;
		for (int layer = 0; layer < (n + 1) / 2; layer++) {
			// direction 1 - traverse from left to right
			for (int ptr = layer; ptr < n - layer; ptr++)
				result[layer][ptr] = cnt++;
			// direction 2 - traverse from top to bottom
			for (int ptr = layer + 1; ptr < n - layer; ptr++)
				result[ptr][n - layer - 1] = cnt++;
			// direction 3 - traverse from right to left
			for (int ptr = layer + 1; ptr < n - layer; ptr++)
				result[n - layer - 1][n - ptr - 1] = cnt++;
			// direction 4 - traverse from bottom to top
			for (int ptr = layer + 1; ptr < n - layer - 1; ptr++)
				result[n - ptr - 1][layer] = cnt++;
		}
		return result;
	}
}

// ==================================

public class Solution {
	public int[][] generateMatrix(int n) {
		int[][] rs = new int[n][n];
		int top = 0, bottom = n - 1, left = 0, right = n - 1, num = 1;
		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++)
				rs[top][i] = num++;
			top++;
			for (int i = top; i <= bottom; i++)
				rs[i][right] = num++;
			right--;
			for (int i = right; i >= left; i--)
				rs[bottom][i] = num++;
			bottom--;
			for (int i = bottom; i >= top; i--)
				rs[i][left] = num++;
			left++;
		}
		return rs;
	}
}