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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return List.of();
        }
        TreeNode curr = root;
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(curr);
        while(!d.isEmpty()){
            TreeNode rightNode = null;
            int size = d.size();
            for(int i=0;i<size;i++){
                TreeNode leftNode = d.removeFirst();
                if(leftNode != null){
                    rightNode = leftNode;
                    if(leftNode.left != null){
                        d.addLast(leftNode.left);
                    }
                    if(leftNode.right != null){
                        d.addLast(leftNode.right);
                    }
                }
            }
            if(rightNode != null){
                res.add(rightNode.val);
            }
        }
        return res;
    }
}
