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
    //思路: 在递归函数中, 分别求出root值与左子树最大值和右子树最小值的差值, 对ans进行更新
    //缺点: 一个递归函数返回值有两个, 而且递归函数中需要记住四个变量, 占内存
    int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        minAndMax(root);
        return ans;
    }
    public int[] minAndMax(TreeNode root){
        int minDifference = Integer.MAX_VALUE;
        int[] leftresult = {root.val, root.val};
        int[] rightresult = {root.val, root.val};
        if(root.left!=null){
            leftresult = minAndMax(root.left);
            minDifference = Math.abs(leftresult[1] - root.val);
        }
        if(root.right!=null){
            rightresult = minAndMax(root.right);
            minDifference = Math.min(minDifference, Math.abs(rightresult[0] - root.val));
        }
        ans = Math.min(ans, minDifference);
        int[] res = {leftresult[0], rightresult[1]};
        return res;
    }
    
}