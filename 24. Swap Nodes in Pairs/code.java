/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){return head;}
        ListNode p0,p1,p2;
        ListNode newhead = new ListNode(0);
        p0 = newhead;
        p0.next = head;
        p1 = head;
        p2 = head.next;
        while(true){
            p1.next = p2.next;
            p2.next = p1;
            p0.next = p2;
            //System.out.println(p1.val + " " + p2.val);
            
            p0 = p1;
            p1 = p1.next;
            if(p1 == null || p1.next == null){break;}
            p2 = p1.next;
        }
        return newhead.next;
    }
}