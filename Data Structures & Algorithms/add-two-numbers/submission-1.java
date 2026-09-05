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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead= new ListNode(-1);
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode newTemp=newHead;
        int sum=0;
        while(temp1!=null || temp2!=null){
            int val1=0;
            int val2=0;
            if(temp1!=null){
                val1=temp1.val;
            }
            if(temp2!=null){
                val2=temp2.val;
            }
            sum=val1+val2+sum;
            newTemp.next = new ListNode(sum%10);
            newTemp=newTemp.next;
            if(sum>9){
                sum=1;
            }else{
                sum=0;
            }
            if(temp1!=null)
             temp1=temp1.next;
            if(temp2!=null)
             temp2=temp2.next;
        }
        if(sum==1){
            newTemp.next=new ListNode(1);
            newTemp.next.next=null;
        }else{
            newTemp.next=null;
        }
        return newHead.next;
    }
}
