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
    List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null){
            return List.of();
        }
        dq.addLast(root);
        while(!dq.isEmpty()){
            List<Integer> t = new ArrayList();
            int size = dq.size();
            for(int i=0;i<size;i++){
                TreeNode v1 = dq.removeFirst();
                if(v1 != null){
                   t.add(v1.val);
                   if(v1.left != null) {
                     dq.addLast(v1.left);
                    }

                    if (v1.right != null) {
                      dq.addLast(v1.right);
                    }
                }
            }
            if(t.size() != 0){
               results.add(t);
            }
        }
        return results;
    }
}
