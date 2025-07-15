class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int max=-1,ans=Integer.MIN_VALUE;
        for(int each : arr){
            if(each>max){
                ans=max;
                max=each;
                continue;
            }
            if(each>ans && each<max){
                // System.out.println("Inside sec if "+each);
                ans = each;
            }
        }
        return ans;
    }
}