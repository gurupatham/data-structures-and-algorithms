/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // code here
        if(Objects.isNull(head) || head.next==head){
            return head;
        }
        Node curr = head.next,prev=head,next=null;
        while(curr!=head){
            next = curr.next;
            curr.next=prev;
            // System.out.println("hai");
            prev=curr;
            curr=next;
        }
        head.next=prev;
        return prev;
    }
    
    private Node deleteHead(Node head){
        head.data = head.next.data;
        head.next=head.next.next;
        return head;
    }
    
    // private void print(Node node){
        
    // }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        
        // code here
        if(Objects.isNull(head) || (head.next==head && head.data==key)){
            return null;
        }
        if(head.data == key){
            return deleteHead(head);
        }
        Node curr=head,prev=null;
        while(curr.next!=head){
            if(curr.data==key){
                prev.next=curr.next;
                return head;
            }
            prev=curr;
            curr = curr.next;
        }
        return head;
        // return reverse(head);
        
        
    }
}