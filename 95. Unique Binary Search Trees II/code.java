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
    //返回值为树的List
    public List<TreeNode> generateTrees(int n) {
          return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int m, int n){
        List<TreeNode> treeList = new ArrayList<>();
        if(n-m < 0){return treeList;}
        for(int i=m;i<=n;i++){
            List<TreeNode> leftList = generateTrees(m, i-1);
            List<TreeNode> rightList = generateTrees(i+1, n);
            int leftsize = leftList.size(); if(leftsize==0) leftsize+=1;
            int rightsize = rightList.size(); if(rightsize==0) rightsize+=1;
            for(int j=0;j<leftsize;j++){
                for(int k=0;k<rightsize;k++){
                    TreeNode root = new TreeNode(i);
                    if(leftList.size() > 0){
                        root.left = leftList.get(j);
                    }
                    if(rightList.size() > 0){
                        root.right = rightList.get(k);
                    }
                    treeList.add(root);
                }
            }
        }
        return treeList;
    }
}