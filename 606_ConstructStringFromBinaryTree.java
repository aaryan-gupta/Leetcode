// 31 ms
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	static String s = "";

	public String tree2str(TreeNode root) {
		if (root == null)
			return "";
		s = "";
		covert2String(root);
		return s;
	}

	void covert2String(TreeNode root) {
		if (root == null)
			return;
		s += root.val;
		if (root.left == null && root.right == null)
			return;
		s += "(";
		covert2String(root.left);
		s += ")";
		if (root.right != null) {
			s += "(";
			covert2String(root.right);
			s += ")";
		}
	}
}

// 1 ms
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public String tree2str(TreeNode root) {
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		covert2String(root, sb);
		return sb.toString();
	}

	void covert2String(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.val);
		if (root.left == null && root.right == null)
			return;
		sb.append("(");
		covert2String(root.left, sb);
		sb.append(")");
		if (root.right != null) {
			sb.append("(");
			covert2String(root.right, sb);
			sb.append(")");
		}
	}
}