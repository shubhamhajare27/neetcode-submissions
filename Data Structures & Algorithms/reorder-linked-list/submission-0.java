/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return;
        }
        //find mid
        ListNode slow=head;
        ListNode fast=slow;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newList=slow.next;
        slow.next=null;
        //reverse logic
        ListNode prev=null;
        ListNode curr=newList;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode t1=head;
        ListNode t2=prev;
        while(t2!=null){
            ListNode n1=t1.next;
            ListNode n2=t2.next;
            t1.next=t2;
            t2.next=n1;
            t1=n1;
            t2=n2;
        }
    }
}
