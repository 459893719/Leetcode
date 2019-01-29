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
    public int widthOfBinaryTree(TreeNode root) {
        //思路:
        //定义一个结构, 封装一个结点的深度和位置(用堆下标表示)
        //使用bfs算法, 用left和right标记本层的左右两个端点
        
        //重点是堆下标在求宽度时的使用
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 1));
        int curDepth = 0, left = 1, right = 1, ans = 0;
        while(!queue.isEmpty()){
            AnnotatedNode a = queue.poll();
            if(a.node != null){
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if(curDepth != a.depth){
                    curDepth = a.depth;
                    ans = Math.max(ans, right - left + 1);
                    left = right = a.pos;
                }
                else{
                    right = a.pos;
                }
            }
        }
        ans = Math.max(ans, right - left + 1);
        return ans;
    }
}

class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}