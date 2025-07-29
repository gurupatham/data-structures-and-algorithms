class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        if(k==0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0,ans=0;
        map.put(0,1);
        for(int each : arr){
            sum+=each;
            map.merge(sum,1,Integer::sum);
            ans+=map.getOrDefault(sum-k,0);
        }
        return ans;
    }
}