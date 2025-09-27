/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        // Your code here
        if(Objects.isNull(head) || Objects.isNull(head.next)){
            return head;
        }
        Node curr=head;
        while(Objects.nonNull(curr) && Objects.nonNull(curr.next)){
            if(curr.data==curr.next.data){
                curr.next = curr.next.next;
                continue;
            }
            curr= curr.next;
        }
        return head;
    }
}