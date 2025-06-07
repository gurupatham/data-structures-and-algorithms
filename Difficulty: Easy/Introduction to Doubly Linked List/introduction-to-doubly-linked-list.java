// User function Template for Java

class Solution {
    
   
    
    Node constructDLL(int arr[]) {
        // Code here
        Node head=null;
        Node temp=null;
        for(int each : arr){
            Node node = new Node(each);
            if(Objects.isNull(head)){
                head=temp=node;
            }
            else{
                node.prev=temp;
                temp.next = node;
                temp = temp.next;
            }
        }
        
        return head;
    }
}