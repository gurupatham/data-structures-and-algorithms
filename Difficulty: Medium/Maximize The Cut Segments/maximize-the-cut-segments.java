// User function Template for Java

class Solution {
    // Function to find the maximum number of cuts.
    
    int fn(int n, int x, int y, int z, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        if (dp[n] != -10) return dp[n];
        
        /*
        int xLen = fn(n-x, x, y, z, dp) + 1;
        int yLen = fn(n-y, x, y, z, dp) + 1;
        int zLen = fn(n-z, x, y, z, dp) + 1;
        
        return dp[n] = Math.max(xLen, Math.max(yLen, zLen));
        */
        
        int max = -1;
        
        int xLen = fn(n - x, x, y, z, dp);
        if (xLen != -1) max = Math.max(max, xLen + 1);

        int yLen = fn(n - y, x, y, z, dp);
        if (yLen != -1) max = Math.max(max, yLen + 1);

        int zLen = fn(n - z, x, y, z, dp);
        if (zLen != -1) max = Math.max(max, zLen + 1);
        
        return dp[n] = max;
    }
    
    public int maximizeCuts(int n, int x, int y, int z) {
        // Your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -10);
        int ans = fn(n, x, y, z, dp);
        return Math.max(ans, 0);
    }
}
