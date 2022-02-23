/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public List<Integer> largestValues(TreeNode root) {
		ArrayList<Integer> l = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while (true) {
				int count = q.size();
				if (count == 0)
					break;
				int max = Integer.MIN_VALUE;
				while (count-- > 0) {
					TreeNode temp = q.peek();
					max = Math.max(max, q.remove().val);
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
				}
				l.add(max);
			}
		}
		return l;
	}
}