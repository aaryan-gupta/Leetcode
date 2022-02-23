class Solution {
	// record the required maximum difference
	int result = 0;

	public int maxAncestorDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}
		result = 0;
		helper(root, root.val, root.val);
		return result;
	}

	void helper(TreeNode node, int curMax, int curMin) {
		if (node == null) {
			return;
		}
		// update `result`
		int possibleResult = Math.max(Math.abs(curMax - node.val), Math.abs(curMin - node.val));
		result = Math.max(result, possibleResult);
		// update the max and min
		curMax = Math.max(curMax, node.val);
		curMin = Math.min(curMin, node.val);
		helper(node.left, curMax, curMin);
		helper(node.right, curMax, curMin);
		return;
	}
}

// ==========================================

class Solution {
	public int maxAncestorDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root, root.val, root.val);
	}

	public int helper(TreeNode node, int curMax, int curMin) {
		// if encounter leaves, return the max-min along the path
		if (node == null) {
			return curMax - curMin;
		}
		// else, update max and min
		// and return the max of left and right subtrees
		curMax = Math.max(curMax, node.val);
		curMin = Math.min(curMin, node.val);
		int left = helper(node.left, curMax, curMin);
		int right = helper(node.right, curMax, curMin);
		return Math.max(left, right);
	}
}