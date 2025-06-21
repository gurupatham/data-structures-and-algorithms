class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int i=0,j=0,ans=0,n=arr.length;
        while(i<n && j<n){
            while(i<n && arr[i]=='P'){
                i++;
            }
            while(j<n && arr[j]=='T'){
                j++;
            }
            if(i<n && j<n && Math.abs(i-j)<=k){
                ans++;
                i++;
                j++;
            }
            else if(i<n && i<j){
                i++;
            }
            else if(j<n && j<i){
                j++;
            }
            
        }
        return ans;
    }
}