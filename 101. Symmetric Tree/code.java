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
    //递归法
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        else{
            if(root.left==null&&root.right==null){
                return true;
            }
            else{
                //判断左右子树是否为镜像关系
                return ismirror(root.left, root.right);
            }
        }
    }
    public static boolean ismirror(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        else if(root1!=null&&root2!=null){
            //判断是否为镜像关系: 根节点值相等, 1右子树与2左子树镜像, 2左子树与1右子树镜像
            return root1.val==root2.val
                &&ismirror(root1.right,root2.left)
                &&ismirror(root1.left,root2.right);
        }
        else{
            return false;
        }
    }
}