/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public int sumRootToLeaf(TreeNode root) {
		return preorder(root, 0);
	}

	public int preorder(TreeNode root, int sum) {
		if (root == null)
			return 0;
		sum = (2 * sum) + root.val;
		if (root.left == null && root.right == null)
			return sum;
		return preorder(root.left, sum) + preorder(root.right, sum);
	}
}

// ======================================

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
	int sum = 0;

	public int sumRootToLeaf(TreeNode root) {
		helper(root, 0);
		return sum;
	}

	void helper(TreeNode root, int currentNumber) {
		if (root == null)
			return;
		currentNumber = currentNumber * 2 + root.val;
		if (root.left == null && root.right == null)
			sum += currentNumber;
		helper(root.left, currentNumber);
		helper(root.right, currentNumber);
	}
}