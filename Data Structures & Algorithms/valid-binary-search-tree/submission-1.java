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
    boolean isValid = false;
    public boolean isValidBST(TreeNode root) {
        return isValidDfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidDfs(TreeNode root, Integer left , Integer right) {
        if(root == null){
            return true;
        }
        if(!(root.val < right && root.val > left)){
            return false;
        }
        return (isValidDfs(root.left, left, root.val)
         && isValidDfs(root.right, root.val, right));
    }
}
