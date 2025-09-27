/*
Structure of a Doubly LinkList
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
    public Node delPos(Node head, int x) {
        // code here
        if(x==1){
            if(Objects.nonNull(head.next)){
                head.next.prev=null;
            }
            return head.next;
        }
        Node curr = head;
        int pos=1;
        while(Objects.nonNull(curr)){
            if(pos==x){
                curr.prev.next=curr.next;
                if(Objects.nonNull(curr.next)){
                    curr.next.prev=curr.prev;
                }
                break;
            }
            pos++;
            curr = curr.next;
        }
        return head;
    }
}