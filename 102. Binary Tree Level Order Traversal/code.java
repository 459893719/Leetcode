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
    class Node{
        TreeNode treenode;
        int level;
        Node(TreeNode treenode, int level){
            this.treenode = treenode;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS 用队列
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        int nowlevel = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 1));
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.level != nowlevel){
                result.add(new ArrayList<>());
                nowlevel = node.level;
            }
            result.get(result.size()-1).add(node.treenode.val);
            if(node.treenode.left!=null){
                q.offer(new Node(node.treenode.left, node.level+1));
            }
            if(node.treenode.right!=null){
                q.offer(new Node(node.treenode.right, node.level+1));
            }
        }
        return result;
    }
}