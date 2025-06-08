/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        if(Objects.isNull(head)){
            return head;
        }
        DLLNode curr=head,temp=null;
        while(Objects.nonNull(curr)){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if(Objects.nonNull(temp)){
            head = temp.prev;
        }
        return head;
    }
}