// 3 ms
class Solution {
	public int trap(int[] A) {
		if (A == null)
			return 0;
		Stack<Integer> s = new Stack<Integer>();
		int i = 0, maxWater = 0, maxBotWater = 0;
		while (i < A.length) {
			if (s.isEmpty() || A[i] <= A[s.peek()]) {
				s.push(i++);
			} else {
				int bot = s.pop();
				maxBotWater = s.isEmpty() ? // empty means no il
						0 : (Math.min(A[s.peek()], A[i]) - A[bot]) * (i - s.peek() - 1);
				maxWater += maxBotWater;
			}
		}
		return maxWater;
	}
}

// 1 ms
class Solution {
	public int trap(int[] height) {
		int len = height.length;
		if (len == 0)
			return 0;
		int[] maxleft = new int[len];
		int[] maxright = new int[len];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			if (height[i] > max)
				max = height[i];
			maxleft[i] = max;
		}
		max = Integer.MIN_VALUE;
		for (int i = len - 1; i >= 0; i--) {
			if (height[i] > max)
				max = height[i];
			maxright[i] = max;
		}
		int ret = 0;
		for (int i = 0; i < len; i++) {
			int diff = Math.min(maxleft[i], maxright[i]) - height[i];
			if (diff > 0)
				ret += diff;
		}
		return ret;
	}
}

// 1 ms

class Solution {
	public int trap(int[] input) {
		if (input.length < 2)
			return 0;
		int outPutSum = 0;
		int n = input.length;
		int[] leftMax = new int[input.length];
		int[] rightMax = new int[input.length];
		leftMax[0] = input[0];
		for (int i = 1; i < input.length; i++)
			leftMax[i] = Math.max(leftMax[i - 1], input[i]);
		rightMax[n - 1] = input[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], input[i]);
			outPutSum += Math.min(leftMax[i], rightMax[i]) - input[i];
		}
		return outPutSum;
	}
}