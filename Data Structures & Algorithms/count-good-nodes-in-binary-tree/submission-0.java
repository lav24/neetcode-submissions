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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);     
    }

    public int dfs(TreeNode root , int currMax){
        if(root == null){
            return 0;
        }
        int res = root.val >= currMax ? 1 : 0;
        currMax = Math.max(root.val, currMax);
        res+= dfs(root.left, currMax);
        res+= dfs(root.right, currMax);
        return res;
    }
}
