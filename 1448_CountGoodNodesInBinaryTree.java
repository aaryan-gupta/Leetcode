/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	int good;

	public int goodNodes(TreeNode root) {
		good = 0;
		preOrder(root, Integer.MIN_VALUE);
		return good;
	}

	void preOrder(TreeNode root, int max) {
		if (root == null)
			return;
		if (root.val >= max)
			good++;
		max = Math.max(max, root.val);
		preOrder(root.left, max);
		preOrder(root.right, max);
	}
}