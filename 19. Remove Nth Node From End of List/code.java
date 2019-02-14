
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        很多链表的算法中都使用了双指针(Two Pointers)
        加一个头结点更方便
        思路 两个指针p1,p2, p2首先走n步, 然后p1, p2同时往后遍历链表
        当p2指向尾节点时, p1即指向要删除结点的前驱
        java中没有delete关键词, 可以通过将相应对象指针赋值为null实现
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode p1 = newhead, p2 = newhead;
        for(int i=0;in;i++){
            p2=p2.next;
        }
        while(p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode deletenode = p1.next;
        p1.next = deletenode.next;
        deletenode = null;
        return newhead.next;
    }
}