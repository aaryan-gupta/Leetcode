/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		HashMap<Node, Node> hm = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		hm.put(node, new Node(node.val, new ArrayList<>()));
		q.add(node);
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (Node neighbour : n.neighbors) {
				if (!hm.containsKey(neighbour)) {
					hm.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
					q.add(neighbour);
				}
				hm.get(n).neighbors.add(hm.get(neighbour));
			}
		}
		return hm.get(node);
	}
}