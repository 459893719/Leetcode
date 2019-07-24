/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    //使用lastnow和lastnext
    //分别标记现在这一层最后的节点以及下一层最后的节点
    //每遍历一个child, lastnext都会更新
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node lastnow, lastnext=null;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null){return result;}
        //把root放进根节点
        queue.offer(root);
        lastnow = root;
        while(!queue.isEmpty()){
            Node front = queue.poll();
            temp.add(front.val);
            for(Node child:front.children){
                //System.out.println(child.val);
                queue.offer(child);
                lastnext=child;
            }
            if(front==lastnow){
                lastnow = lastnext;
                result.add(temp);
                temp = new ArrayList<>();
            }
        }
        return result;
    }
}