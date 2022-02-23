/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	int dia = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		height(root);
		return dia;
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int lh = height(root.left), rh = height(root.right), mydia = lh + rh;
		if (mydia > dia)
			dia = mydia;
		return 1 + Math.max(lh, rh);
	}
}