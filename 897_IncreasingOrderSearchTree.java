/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	TreeNode r;

	public TreeNode increasingBST(TreeNode root) {
		TreeNode answer = new TreeNode(0);
		r = answer;
		helper(root);
		return answer.right;
	}

	void helper(TreeNode root) {
		if (root == null)
			return;
		helper(root.left);
		root.left = null;
		r.right = root;
		r = root;
		helper(root.right);
	}
}