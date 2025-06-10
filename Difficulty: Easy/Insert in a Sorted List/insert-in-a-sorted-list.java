/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
        // Add your code here.
        Node node = new Node(key);
        if(Objects.isNull(head)){
            return node;
        }
        if(head.data>key){
            node.next=head;
            return node;
        }
        Node prev=head,curr=head.next;
        while(curr!=null){
            if(prev.data<key && curr.data>=key){
                prev.next=node;
                node.next=curr;
                return head;
            }
            prev=curr;
            curr = curr.next;
        }
         prev.next=node;
         return head;
    }
}