/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    void process(Node node,ArrayList<Integer> ans){
        if(Objects.isNull(node)){
            return;
        }
        process(node.left,ans);
        process(node.right,ans);
        ans.add(node.data);
    }
    
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        process(root,ans);
        return ans;
    }
}