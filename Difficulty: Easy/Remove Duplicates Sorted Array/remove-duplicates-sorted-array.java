class Solution {
    // Function to remove duplicates from the given array
    public int removeDuplicates(int[] arr) {
        // Code Here
        int res=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[res]){
                arr[++res] = arr[i];
            }
        }
        return res+1;
    }
}