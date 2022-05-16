/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
	public Node connect(Node root) {
		if (root == null)
			return root;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		root.next = null;
		while (!q.isEmpty()) {
			int c = q.size();
			for (int i = 0; i < c; i++) {
				Node x = q.remove();
				if (i < c - 1)
					x.next = q.peek();
				if (x.left != null)
					q.offer(x.left);
				if (x.right != null)
					q.offer(x.right);
			}
		}
		return root;
	}
}