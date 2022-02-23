/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, Integer> cache = new HashMap<>();
    public int rob(TreeNode root) {
        if(cache.containsKey(root)) return cache.get(root);
        if(root == null) return 0;
        else {
            int llgc = 0, rlgc = 0, lrgc = 0, rrgc = 0;
            if(root.left != null) {
                llgc = rob(root.left.left);
                lrgc = rob(root.left.right);
            }
            if(root.right != null) {
                rlgc = rob(root.right.left);
                rrgc = rob(root.right.right);
            }
            int includingRoot = root.val + llgc + rlgc + lrgc + rrgc;
            int lc = rob(root.left);
            int rc = rob(root.right);
            int excludingRoot = lc + rc;
            cache.put(root, Math.max(includingRoot, excludingRoot));
            return cache.get(root);
        }
    }
}