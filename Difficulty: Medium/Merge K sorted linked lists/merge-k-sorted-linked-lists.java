/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        // code here
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data-b.data);
        Node ans = new Node(-1);
        Node temp = ans;
        for(Node each : arr){
            pq.offer(each);
        }
        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            temp.next = currNode;
            temp = temp.next;
            if(Objects.nonNull(currNode.next)){
                pq.offer(currNode.next);
            }
        }
        return ans.next;
    }
}