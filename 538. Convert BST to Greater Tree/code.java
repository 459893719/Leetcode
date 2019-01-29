/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxvalue = 0;
    public TreeNode convertBST(TreeNode root) {
        //RDL遍历
        if(root == null){
            return null;
        }
        else{
            convertBST(root.right);
            root.val += maxvalue;
            maxvalue = root.val;
            convertBST(root.left);
            return root;
        }
    }
}