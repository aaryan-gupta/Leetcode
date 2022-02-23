/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<>();
		if (root == null)
			return l;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> currentList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode currentNode = q.poll();
				currentList.add(currentNode.val);
				if (currentNode.left != null)
					q.add(currentNode.left);
				if (currentNode.right != null)
					q.add(currentNode.right);
			}
			l.add(currentList);
		}
		return l;
	}
}