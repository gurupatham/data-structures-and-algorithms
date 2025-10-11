class Solution {
    
    int fn(int i, int[] coins, int val, int[][] dp) {
        if (val == 0) {
            return 1;
        }
        if (i >= coins.length || val < 0) {
            return 0;
        }
        if (dp[i][val] != -1) return dp[i][val];
        return dp[i][val] = fn(i, coins, val - coins[i], dp) + fn(i + 1, coins, val, dp);
    }
    
    
    public int count(int coins[], int sum) {
        // code here
        int n = coins.length;
        int[][] dp = new int[n][sum+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fn(0, coins, sum, dp);

    }
}