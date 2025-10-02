class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            int val = stack.isEmpty() ? i+1: i-stack.peek();
            ans.add(val);
            stack.push(i);
        }
        return ans;
    }
}