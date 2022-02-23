/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	List<Integer> result = new ArrayList<>();

	public List<Integer> rightSideView(TreeNode root) {
		rightView(root, 0);
		return result;
	}

	void rightView(TreeNode root, int depth) {
		if (root == null)
			return;
		if (depth == result.size())
			result.add(root.val);
		rightView(root.right, depth + 1);
		rightView(root.left, depth + 1);
	}
}