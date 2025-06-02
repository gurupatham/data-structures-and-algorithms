class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int low=0,high=arr.length-1,ans=-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            // System.out.println("mid is "+mid);
             if(arr[mid]>=k){
                 if(arr[mid]==k){
                     ans=mid;
                 }
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}