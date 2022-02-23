/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		traverse(root, l);
		return l;
	}

	void traverse(TreeNode root, List<Integer> l) {
		if (root != null) {
			traverse(root.left, l);
			traverse(root.right, l);
			l.add(root.val);
		}
	}
}