/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.data-b.data);
        int k = arr.size();
        for(int i=0;i<k;i++){
            Node node = arr.get(i);
            pq.offer(node);
        }
        Node ans = new Node(-1);
        Node dummy = ans;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            dummy.next=node;
            dummy = dummy.next;
            if(Objects.nonNull(node.next)){
                pq.offer(node.next);
            }
        }
        return ans.next;
    }
}