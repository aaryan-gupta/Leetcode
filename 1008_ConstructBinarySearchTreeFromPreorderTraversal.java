/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode helper(int preorder[], int s, int e) {
        if (i >= preorder.length || preorder[i] < s || preorder[i] > e)
            return null;
        int val = preorder[i++];
        TreeNode n = new TreeNode(val);
        n.left = helper(preorder, s, val);
        n.right = helper(preorder, val, e);
        return n;
    }
}