/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	int sum = 0;

	public int deepestLeavesSum(TreeNode root) {
		sum(root, height(root));
		return sum;
	}

	int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	void sum(TreeNode root, int height) {
		if (root == null)
			return;
		if (height == 1)
			sum += root.val;
		else {
			sum(root.left, height - 1);
			sum(root.right, height - 1);
		}
	}
}