/* Linklist node structure
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    Node deleteNode(Node head, int x) {
        // code here
        if(Objects.isNull(head)){
            return null;
        }
        if(x==1){
            return head.next;
        }
        int c=1;
        Node prev=null,curr=head;
        while(curr!=null && c<x){
            prev=curr;
            curr = curr.next;
            c++;
        }
        if(Objects.isNull(curr)){
            return head;
        }
        prev.next = curr.next;
        return head;
    }
}