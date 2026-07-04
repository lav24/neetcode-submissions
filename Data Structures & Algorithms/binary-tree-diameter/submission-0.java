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
    int s = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return s;
    }

    public int dfs(TreeNode curr){
        if (curr == null){
            return 0;
        }
        int l = dfs(curr.left);
        int r = dfs(curr.right);
        s = Math.max(s, l + r);
        return 1 + Math.max(l, r);
    }
}
