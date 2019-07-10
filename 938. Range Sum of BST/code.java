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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null){return 0;}
        int leftsum, rightsum; 
        if(root.val<=L){
            leftsum = 0;
        }
        else{
            leftsum = rangeSumBST(root.left, L, R);
        }
        if(root.val>=R){
            rightsum = 0;
        }
        else{
            rightsum = rangeSumBST(root.right, L, R);
        }
        if(root.val>=L&&root.val<=R){
            return root.val+leftsum+rightsum;
        }
        else{
            return leftsum+rightsum;
        }
    }
}