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
    int max = 0;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfsMaxWithoutASplit(root);
        return max;
    }

    public int dfsMaxWithoutASplit(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftMax= dfsMaxWithoutASplit(root.left);
        int rightMax= dfsMaxWithoutASplit(root.right);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        max = Math.max(max, leftMax + rightMax + root.val);
        return root.val + Math.max(leftMax, rightMax);
    }
}
