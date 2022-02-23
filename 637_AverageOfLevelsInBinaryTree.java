/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public List<Double> averageOfLevels(TreeNode root) {
		ArrayList<Double> l = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while (true) {
				int count = q.size();
				if (count == 0)
					break;
				double sum = 0;
				int n = 0;
				while (count-- > 0) {
					TreeNode temp = q.peek();
					int d = q.remove().val;
					sum += d;
					n++;
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
				}
				l.add(sum / n);
			}
		}
		return l;
	}
}