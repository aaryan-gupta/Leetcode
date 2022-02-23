/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	HashSet<Integer> hs = new HashSet<>();

	public boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;
		if (hs.contains(k - root.val))
			return true;
		hs.add(root.val);
		return findTarget(root.left, k) || findTarget(root.right, k);
	}
}

// ===============================================

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public boolean findTarget(TreeNode root, int k) {
		ArrayList<Integer> l = new ArrayList();
		inorder(root, l);
		int left = 0, right = l.size() - 1;
		while (left < right) {
			if (l.get(left) + l.get(right) == k)
				return true;
			else if (l.get(left) + l.get(right) < k)
				left++;
			else
				right--;
		}
		return false;
	}

	void inorder(TreeNode root, ArrayList<Integer> l) {
		if (root == null)
			return;
		inorder(root.left, l);
		l.add(root.val);
		inorder(root.right, l);
	}
}