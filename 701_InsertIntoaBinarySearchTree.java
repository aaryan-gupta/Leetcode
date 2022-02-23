/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		else if (root.val > val)
			root.left = insertIntoBST(root.left, val);
		else
			root.right = insertIntoBST(root.right, val);
		return root;
	}
}

// ======================================

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		TreeNode curr = root, prev = null;
		while (curr != null) {
			prev = curr;
			if (val > curr.val) {
				curr = curr.right;
				continue;
			} else {
				curr = curr.left;
				continue;
			}
		}
		if (val > prev.val)
			prev.right = new TreeNode(val);
		else
			prev.left = new TreeNode(val);
		return root;
	}
}

// ========================================

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		TreeNode cur = root;
		while (true) {
			if (val <= cur.val) {
				if (cur.left != null)
					cur = cur.left;
				else {
					cur.left = new TreeNode(val);
					break;
				}
			} else {
				if (cur.right != null)
					cur = cur.right;
				else {
					cur.right = new TreeNode(val);
					break;
				}
			}
		}
		return root;
	}
}