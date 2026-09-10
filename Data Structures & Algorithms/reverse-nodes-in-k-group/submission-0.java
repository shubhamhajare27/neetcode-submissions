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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next= head;
        ListNode groupPrev=dummy;

        while(true){
            // Step 1: check if node remains from groupPrev
            ListNode kth = groupPrev;
            for(int i=0;i<k;i++){
                kth = kth.next;
                if(kth == null){
                    return dummy.next; //fewer than k nodes left
                }
            }

            ListNode groupNext= kth.next; //node of the next group

            // Step 2: reverese the group [groupPrev.next ....k]
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while(curr != groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: Reconnect
            ListNode newGroupHead = groupPrev.next;// this is tail of the group
            groupPrev.next=kth;
            groupPrev=newGroupHead;

        }
    }
}
