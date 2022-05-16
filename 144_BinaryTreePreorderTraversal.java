/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		traverse(root, l);
		return l;
	}

	void traverse(TreeNode root, List<Integer> l) {
		if (root != null) {
			l.add(root.val);
			traverse(root.left, l);
			traverse(root.right, l);
		}
	}
}

// =========================================

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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.push(curr);
				res.add(curr.val);
				curr = curr.left;
			}
			curr = s.pop();
			curr = curr.right;
		}
		return res;
	}
}