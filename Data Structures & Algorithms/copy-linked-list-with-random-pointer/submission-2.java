/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node curr=head;
        //create inplace linkedList
        while(curr!=null){
            Node copy = new Node(curr.val);
            copy.next=curr.next;
            curr.next=copy;
            curr=copy.next;
        }
        //fill in random pointer
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
             curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        //seperate list
        curr=head;
        Node newHead=head.next;
        Node newcurr=newHead;
        while(curr!=null){
            curr.next=newcurr.next;
            curr=curr.next;
            if(curr!=null){
                newcurr.next=curr.next;
                newcurr=curr.next;
            }
        }
        return newHead;
    }
}
