/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
	public List<Integer> preorder(Node root) {
		List<Integer> l = new ArrayList<>();
		traverse(root, l);
		return l;
	}

	void traverse(Node node, List<Integer> l) {
		if (node != null) {
			l.add(node.val);
			for (int i = 0; i < node.children.size(); i++)
				traverse(node.children.get(i), l);
		}
	}
}