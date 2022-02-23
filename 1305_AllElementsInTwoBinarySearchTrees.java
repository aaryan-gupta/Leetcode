/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> l = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        helper(root1);
        helper(root2);
        Collections.sort(l);
        return l;
    }

    void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        l.add(root.val);
        helper(root.right);
    }
}

// ===================================================

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> resList = new ArrayList<>();
        if (root1 == null && root2 == null)
            return resList;
        Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        dfs(root1, heap);
        dfs(root2, heap);
        while (!heap.isEmpty())
            resList.add(heap.poll());
        return resList;
    }

    private void dfs(TreeNode root, Queue heap) {
        if (root == null)
            return;
        dfs(root.left, heap);
        heap.add(root.val);
        dfs(root.right, heap);
    }
}