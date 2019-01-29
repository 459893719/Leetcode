/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //每一次对一位进行加法运算
        //p每次循环都指向刚算好的节点
        //ListNode p = l1;
        ListNode p1 = l1, p2 = l2;
        ListNode p=null;
        int c = 0;
        while(p1!=null&&p2!=null){
            int num = p1.val + p2.val + c;
            p1.val = num%10;
            c = num/10;
            p=p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        //表长不一样时, 继续算
        if(p2!=null){
            p.next = p2;
            while(p2!=null){
                int num = p2.val+c;
                p2.val = num%10;
                c=num/10;
                p=p2;
                p2=p2.next;
            }
        }
        while(p1!=null){
            int num = p1.val+c;
            p1.val = num%10;
            c=num/10;
            p=p1;
            p1=p1.next;
        }
        if(c==1){
            ListNode newnode = new ListNode(1);
            p.next = newnode;
        }
        return l1;
    }
}