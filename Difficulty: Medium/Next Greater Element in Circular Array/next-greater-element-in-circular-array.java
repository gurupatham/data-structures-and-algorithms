class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=(arr.length*2)-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i%n]){
                stack.pop();
            }
            if(i<n){
                ans.add(stack.isEmpty()?-1:stack.peek());
            }
            stack.push(arr[i%n]);
        }
        Collections.reverse(ans);
        return ans;
    }
}