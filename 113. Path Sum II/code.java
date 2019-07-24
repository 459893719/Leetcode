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
    List<List<Integer>> result;
    List<Integer> curpath;
    int cursum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        cursum = 0;
        curpath = new ArrayList<>();
        result = new ArrayList<>();
        pathFind(root, sum);
        return result;
    }
    public void pathFind(TreeNode root, int sum){
        if(root==null) return;
        
        cursum += root.val;
        curpath.add(root.val);
        if(root.left==null&&root.right==null&&cursum == sum){
            List<Integer> temp = new ArrayList<>();
            for(Integer i: curpath){
                temp.add(i);
            }
            result.add(temp);
        }
        else{
            pathFind(root.left, sum);
            pathFind(root.right, sum);
        }
        curpath.remove(curpath.size() - 1);
        cursum -= root.val;
    }
}