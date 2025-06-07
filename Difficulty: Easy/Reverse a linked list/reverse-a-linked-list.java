// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    Node reverseList(Node head) {
        // code here
        if(Objects.isNull(head)){
            return head;
        }
        Node prev=null,curr=head;
        while(Objects.nonNull(curr)){
            Node nex = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }
}