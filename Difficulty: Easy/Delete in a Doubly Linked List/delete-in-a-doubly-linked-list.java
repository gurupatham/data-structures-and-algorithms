/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if(Objects.isNull(head)){
            return head;
        }
        if(x==1){
            Node temp = head.next;
            if(Objects.nonNull(temp)){
                head.next.prev=null;
                // head.next=null;
            }
            return temp;
        }
        int c=1;
        Node curr=head,prev=null;
        while(Objects.nonNull(curr) && c<x){
            prev = curr;
            curr = curr.next;
            c++;
        }
        if(Objects.isNull(curr)){
            return head;
        }
        prev.next = curr.next;
        if(Objects.nonNull(curr.next)){
            curr.next.prev=prev;
        }
        
        return head;
    }
}