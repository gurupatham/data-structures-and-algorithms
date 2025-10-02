class Solution {
    static ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            ans.add(stack.isEmpty() ? -1:stack.peek());
            stack.push(arr[i]);
        }
        return ans;
    }
}