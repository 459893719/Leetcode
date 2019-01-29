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
    public int findTilt(TreeNode root) {
        //1. 把每个节点的值变成对以该节点为根的树的所有节点值的和
        //2. 将每个节点的tilt赋值到数组里
        getSum(root);
        int[] result = new int[1];
        getTilt(root, result);
        return result[0];
    }
    
    public void getSum(TreeNode root){
        if(root == null){
            return;
        }
        else{
            getSum(root.left);
            getSum(root.right);
            if(root.left != null){
                root.val += root.left.val; 
            }
            if(root.right != null){
                root.val += root.right.val;
            }
            
        }
    }
    
    //将树的所有节点的tilt加到result, 并返回根节点的tilt值
    public int getTilt(TreeNode root, int[] result){
        if(root == null){
            return 0;
        }
        else{
            getTilt(root.left, result);
            getTilt(root.right, result);
            int leftSum = 0;
            if(root.left != null){
                leftSum = root.left.val;
            }
            int rightSum = 0;
            if(root.right != null){
                rightSum = root.right.val;
            }
            int rootTilt = Math.abs(leftSum - rightSum);
            result[0] += rootTilt;
            return rootTilt;
        }
    }
}