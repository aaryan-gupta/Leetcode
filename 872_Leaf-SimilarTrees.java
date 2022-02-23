/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		return getLeaves(root1, l1).equals(getLeaves(root2, l2));
	}

	ArrayList<Integer> getLeaves(TreeNode root, ArrayList<Integer> l) {
		if (root == null)
			return l;
		if (root.left == null && root.right == null)
			l.add(root.val);
		getLeaves(root.left, l);
		getLeaves(root.right, l);
		return l;
	}
}