//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {

            int V = Integer.parseInt(read.readLine().trim());
            int E = Integer.parseInt(read.readLine().trim());

            int[][] edges = new int[E][3];

            for (int i = 0; i < E; i++) {
                String[] parts = read.readLine().trim().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);

                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = w;
            }

            // Read source vertex
            int S = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            int[] ptr = ob.bellmanFord(V, edges, S);

            // Print the result
            for (int i = 0; i < ptr.length; i++) {
                System.out.print(ptr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] bellmanFord(int n, int[][] edges, int src) {
        // code here
        int[] ans = new int[n];
        Arrays.fill(ans,(int)(1e8));
        ans[src]=0;
        int i=0;
        while(i<n){
            for(int[] each : edges){
                int u = each[0],v=each[1],w=each[2];
                if((ans[u]!=1_000_000_00) && (ans[u]+w < ans[v])){
                    ans[v] = ans[u]+w;
                }
            }
            i++;
        }
        
        for(int[] each : edges){
            int u = each[0],v=each[1],w=each[2];
            if((ans[u]!=1_000_000_00) && (ans[u]+w < ans[v])){
                return new int[]{-1};
            }
        }
        return ans;
    }
}
