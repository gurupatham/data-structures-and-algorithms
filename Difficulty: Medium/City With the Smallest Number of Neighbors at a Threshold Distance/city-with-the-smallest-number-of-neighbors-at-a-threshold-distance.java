//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int[][] adj = new int[n][n];
        for(int[] each : adj ){
            Arrays.fill(each,100_000_000);
        }
        for(int i=0;i<n;i++){
            adj[i][i]=0;
        }
        for(int[] each : edges){
            adj[each[0]][each[1]] = each[2];
            adj[each[1]][each[0]] = each[2];
        }
        
        int via=0;
        while(via<n){
            for(int i=0;i<adj.length;i++){
                for(int j=0;j<adj[0].length;j++){
                    if(adj[i][via] == 100_000_000 || adj[via][j] == 100_000_000){
                        continue;
                    }
                    adj[i][j] = Math.min(adj[i][j], adj[i][via] + adj[via][j]);
                }
            }
            via++;
        }
        
        int min=n+1,ans=0;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(adj[i][j]<=distanceThreshold){
                    c++;
                }
            }
            if(c<=min){
                    min=c;
                    ans=i;
            }
        }
        return ans;
        
    }
}
