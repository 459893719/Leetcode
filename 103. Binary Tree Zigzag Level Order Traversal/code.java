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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){return result;}
        
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()){
            int num = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<num;i++){
                TreeNode curnode = q.poll();
                temp.add(curnode.val);
                if(curnode.left!=null) q.offer(curnode.left);
                if(curnode.right!=null) q.offer(curnode.right);
            }
            if(depth%2==1){
                Collections.reverse(temp);
            }
            result.add(temp);
            depth++;
        }
        return result;
    }
}