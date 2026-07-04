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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }

    public int dfs(TreeNode curr){
        if(curr == null){
            return 0;
        }
        int left = dfs(curr.left);
        int right = dfs(curr.right);
        if(Math.abs(left - right) > 1 && balanced){
            balanced= false;
        }
        System.out.println(curr.val + " " + left  +" " + right + " " + balanced);
        return 1 + Math.max(left ,right);
    }
}
