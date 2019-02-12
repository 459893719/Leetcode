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
    //算法以先序遍历为基础
    //定义全局变量last指针, 表示对于root树, 根节点root在整个树中的父节点是什么
    TreeNode last=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        last=root;
        flatten(root.left);
        //对左子树调用函数之后, last指向了左子树最后一个结点, 因此可以进行连接
        TreeNode temp = root.right;
        root.right = root.left;
        last.right = temp;
        root.left = null;
        flatten(last.right);
    }
}