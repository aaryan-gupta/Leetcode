/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		/*
		 * while(!q.isEmpty()) { int size = q.size(); if(size == 0) break; while(size--
		 * > 0) { TreeNode node = q.poll(); if(node == null) { sb.append("# ");
		 * continue; } sb.append(node.val + " "); q.add(node.left); q.add(node.right); }
		 * }
		 */

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node == null) {
				sb.append("# ");
				continue;
			}
			sb.append(node.val + " ");
			q.add(node.left);
			q.add(node.right);
		}

		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == "")
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		String a[] = data.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(a[0]));
		q.add(root);
		for (int i = 1; i < a.length; i++) {
			TreeNode parent = q.poll();
			if (!a[i].equals("#")) {
				TreeNode left = new TreeNode(Integer.parseInt(a[i]));
				parent.left = left;
				q.add(left);
			}
			if (!a[++i].equals("#")) {
				TreeNode right = new TreeNode(Integer.parseInt(a[i]));
				parent.right = right;
				q.add(right);
			}
		}
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));