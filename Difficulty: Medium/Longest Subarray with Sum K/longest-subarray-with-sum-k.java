// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int ans=0,curr=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(curr,-1);
        for(int i=0;i<arr.length;i++){
            curr+=arr[i];
            if(map.containsKey(curr-k)){
                ans = Math.max(ans,i-map.get(curr-k));
            }
            map.merge(curr,i,Integer::min);
        }
        return ans;
    }
}
