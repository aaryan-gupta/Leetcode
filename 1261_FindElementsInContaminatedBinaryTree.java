/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class FindElements {
	Set<Integer> set = new HashSet<>();

	void solve(TreeNode root, int NodeVal) {
		if (root == null)
			return;
		set.add(NodeVal);
		solve(root.left, (NodeVal << 1) + 1);
		solve(root.right, (NodeVal << 1) + 2);
	}

	public FindElements(TreeNode root) {
		solve(root, 0);
	}

	public boolean find(int target) {
		return set.contains(target);
	}
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root); boolean param_1 =
 * obj.find(target);
 */