class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int maxArea = 0;
		int dp[] = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
			maxArea = Math.max(maxArea, largestRectangleArea(dp));
		}
		return maxArea;
	}

	int largestRectangleArea(int[] arr) {
		int rb[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);
		rb[arr.length - 1] = arr.length;
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[i] <= arr[st.peek()])
				st.pop();
			if (st.size() == 0)
				rb[i] = arr.length;
			else
				rb[i] = st.peek();
			st.push(i);
		}
		int lb[] = new int[arr.length];
		st = new Stack<>();
		st.push(0);
		lb[0] = -1;
		for (int i = 0; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] <= arr[st.peek()])
				st.pop();
			if (st.size() == 0)
				lb[i] = -1;
			else
				lb[i] = st.peek();
			st.push(i);
		}
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			int width = rb[i] - lb[i] - 1;
			int area = arr[i] * width;
			if (area > maxArea)
				maxArea = area;
		}
		return maxArea;
	}
}