//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // code here
        if(Objects.isNull(head)){
            return head;
        }
        Node zeroHead=null,zeroTemp=null,oneHead=null,oneTemp=null,twoHead=null,twoTemp=null,temp = head;
        while(temp!=null){
            if(temp.data==0){
                if(zeroHead==null){
                    zeroHead=zeroTemp=temp;
                }
                else{
                    zeroTemp.next = temp;
                    zeroTemp = zeroTemp.next;
                }
            }
            else if(temp.data==1){
                if(oneHead==null){
                    oneHead=oneTemp=temp;
                }
                else{
                    oneTemp.next = temp;
                    oneTemp = oneTemp.next;
                }
            }
            else{
                if(twoHead==null){
                    twoHead=twoTemp=temp;
                }
                else{
                    twoTemp.next =temp;
                    twoTemp = twoTemp.next;
                }
            }
            temp = temp.next;
        }
        Node fin=null;
        if(Objects.nonNull(zeroHead)){
            fin=zeroHead;
            if(Objects.nonNull(oneHead)){
                zeroTemp.next = oneHead;
            }
            else if(Objects.nonNull(twoHead)){
                zeroTemp.next = twoHead;
            }
        }
        if(Objects.nonNull(oneHead)){
            if(Objects.isNull(fin)){
                fin = oneHead;
            }
            if(Objects.nonNull(twoHead)){
                oneTemp.next=twoHead;
            }
            else{
                oneTemp.next = null;
            }
        }
        if( Objects.nonNull(twoHead)){
            if(Objects.isNull(fin)){
                fin = twoHead;
            }
            if(Objects.nonNull(twoTemp)){
                twoTemp.next=null;
            }
        }
        
        return fin;
        
    }
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends