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

public class Codec {
     
    StringBuilder b = new StringBuilder();
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        System.out.println(b.toString());
        return b.toString();
    }

    public void dfs(TreeNode root) {
        if(root == null){
            b.append("N");
            b.append(",");
            return;          
        }
        b.append(String.valueOf(root.val));
        b.append(",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        return deserializeDfs(parts);
    }


    public TreeNode deserializeDfs(String[] parts) { 
        System.out.println(i +" - " + parts[i]);
        if(parts[i].equals("N")){
            i+=1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(parts[i]));
        i+=1;
        System.out.println(i +" - " + parts[i] + "  go left");
        node.left = deserializeDfs(parts);
        System.out.println(i +" - " + parts[i] + "  go right");
        node.right = deserializeDfs(parts);
        return node;
    }
}
