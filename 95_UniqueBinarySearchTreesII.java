/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
public class Solution {
	public List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
			List<TreeNode> rightSubTrees = generateTrees(i + 1, end);
			for (TreeNode left : leftSubTrees) {
				for (TreeNode right : rightSubTrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					result.add(root);
				}
			}
		}
		return result;
	}
}