/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	int level = 0;
	TreeNode savedParent = null;

	public boolean isCousins(TreeNode root, int x, int y) {
		return isCousins(root, x, y, 0, null);
	}

	public boolean isCousins(TreeNode root, int x, int y, int depth, TreeNode parent) {
		if (root.val == x || root.val == y) {
			if (savedParent != null && savedParent != parent && level == depth)
				return true;
			level = depth;
			savedParent = parent;
		}
		if (root.left != null && isCousins(root.left, x, y, depth + 1, root))
			return true;
		if (root.right != null && isCousins(root.right, x, y, depth + 1, root))
			return true;
		return false;
	}
}