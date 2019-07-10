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
    //方法2: prev法, 使用中序遍历时可以多用这个方法
    //prev指针: 保证对于root节点, prev总是遍历序列中root节点的前一位
    //本题中, 进行中序遍历, prev总是与root差值最小的节点, 因此只需求prev与root的值差, 对ans进行更新即可
    
    //缺点: 有些不满足要求的路径也遍历了, 但是在该题中没有影响
    TreeNode prev;
    int ans;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        inorder(root);
        return ans;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        
        inorder(root.left);
        //如果左子树不空的话, prev是root左子树的最大值点
        if(prev!=null){
            ans = Math.min(ans, Math.abs(prev.val - root.val));
        }
        prev = root;
        inorder(root.right);
    }
    
}