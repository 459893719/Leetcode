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
    //最值问题, 使用全局变量是关键
    //需要求出所有节点的path最大值
    //root的path需要使用递归来求
    //通过使用全局变量, 能够保证ans为左右子树节点的path最大值, 这样只需要将ans与root的path比较即可
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)return 0;
        
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode root){
        
        int left, right;
        int twosidepath = 0;
        int arrowLeft = 0, arrowRight = 0;
        if(root.left!=null){
            left = arrowLength(root.left);
            if(root.left.val==root.val){
                twosidepath += left + 1;
                arrowLeft = left + 1;
            }
        }
        if(root.right!=null){
            right = arrowLength(root.right);
            if(root.right.val==root.val){
                twosidepath += right + 1;
                arrowRight = right + 1;
            }
        }
        ans = Math.max(ans, twosidepath);
        return Math.max(arrowLeft, arrowRight);
    }
}