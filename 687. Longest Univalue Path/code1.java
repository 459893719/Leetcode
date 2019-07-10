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
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){return 0;}
        
        int leftpath = longestUnivaluePath(root.left);
        int rightpath = longestUnivaluePath(root.right);
        int twosidepath = 0;
        if(root.left!=null&&root.left.val == root.val){
            twosidepath += (findLongestPath(root.left)+1);
        }
        if(root.right!=null&&root.right.val == root.val){
            twosidepath += (findLongestPath(root.right)+1);
        }
        
        return Math.max(Math.max(leftpath,rightpath),twosidepath);
    }
    public int findLongestPath(TreeNode root){
        if(root==null) return -1;
        int left = -1,right = -1;
        if(root.left!=null&&root.left.val == root.val){
            left = findLongestPath(root.left);
        }
        if(root.right!=null&&root.right.val == root.val){
            right = findLongestPath(root.right);
        }

        return Math.max(left+1, right+1);
    }
}