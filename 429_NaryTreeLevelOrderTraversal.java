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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();

        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            while (size-- > 0) {
                Node node = q.remove();
                level.add(node.val);
                q.addAll(node.children);
            }
            traversal.add(level);
        }
        return traversal;
    }
}

// ================================================================

/*
 * // Definition for a Node. class Node { public int val; public List<Node>
 * children;
 * 
 * public Node() {}
 * 
 * public Node(int _val) { val = _val; }
 * 
 * public Node(int _val, List<Node> _children) { val = _val; children =
 * _children; } };
 */

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        // if rootnode is null
        if (root == null)
            return result;
        // we have use queue as insertion occurs at first and deletion from last
        // A queue of node type will be created for storing the root node
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        // traverse until the queue is not empty
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            while (size > 0) {
                // remove the rootnode node and add all its children to queue
                Node currentNode = q.remove();
                ans.add(currentNode.val);
                for (Node child : currentNode.children)
                    q.add(child);
                size--;
            }
            result.add(ans);
        }
        return result;
    }
}