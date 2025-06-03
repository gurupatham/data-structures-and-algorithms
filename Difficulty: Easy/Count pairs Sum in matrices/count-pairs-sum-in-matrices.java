class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n = mat1.length;
        int left=0,right=(n*n)-1;
        int ans=0;
        while(left<(n*n) && right>=0){
            int lr=left/n;
            int lc=left%n;
            int rr=right/n;
            int rc=right%n;
            if(mat1[lr][lc]+mat2[rr][rc]==x){
                ans++;
                left++;
                right--;
            }
            else if(mat1[lr][lc]+mat2[rr][rc] < x){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}