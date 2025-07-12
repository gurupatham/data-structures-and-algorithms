class Solution {
    public int maxGold(int[][] mat) {
        // code here
        int ans=0,row=mat.length,col=mat[0].length;
        int[][] temp = new int[row][col];
        for(int i=0;i<row;i++){
            temp[i][0]= mat[i][0];
        }
        for(int i=1;i<col;i++){
            for(int j=0;j<row;j++){
                temp[j][i] = Math.max(temp[j][i],mat[j][i]+temp[j][i-1]);
                if((j-1>=0)){
                    temp[j][i] = Math.max(temp[j][i],mat[j][i]+temp[j-1][i-1]);
                }
                if((j+1<row)){
                    temp[j][i] = Math.max(temp[j][i],mat[j][i]+temp[j+1][i-1]);
                }
                ans= Math.max(ans,temp[j][i]);
                
            }
        }
        return ans;
    }
}