// 1 ms
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int l = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> levelList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node != null) {
					levelList.add(node.val);
					q.add(node.left);
					q.add(node.right);
				}
			}
			if (!levelList.isEmpty()) {
				if (l % 2 == 1)
					Collections.reverse(levelList);
				result.add(levelList);
			}
			l++;
		}
		return result;
	}
}

// 0 ms
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> op = new LinkedList<>();
		if (root == null)
			return op;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean odd = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> res = new LinkedList<>();
			for (int i = 1; i <= size; i++) {
				TreeNode node = queue.poll();
				if (odd)
					res.add(node.val);
				else
					res.addFirst(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			op.add(res);
			odd = !odd;
		}
		return op;
	}
}

// 0 ms
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList();
		travel(res, 0, root);
		return res;
	}

	private void travel(List<List<Integer>> res, int level, TreeNode cur) {
		if (cur == null)
			return;
		if (res.size() <= level)
			res.add(new ArrayList<Integer>());
		if (level % 2 == 0)
			res.get(level).add(cur.val);
		else
			res.get(level).add(0, cur.val);
		travel(res, level + 1, cur.left);
		travel(res, level + 1, cur.right);
	}
}