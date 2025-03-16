//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    boolean isCycle(int vertex,List<List<Integer>> adj,boolean[] vis,boolean[] pathVis,boolean[] check){
        vis[vertex] = true;
        pathVis[vertex] = true;
        
        for(int each : adj.get(vertex)){
            if((!vis[each]) && isCycle(each,adj,vis,pathVis,check)){
                return true;
            }
            else if(pathVis[each]){
                return true;
            }
        }
        check[vertex] = true;
        pathVis[vertex] = false;
        return false;
    }
    

    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {

        // Your code here
        boolean[] vis = new boolean[v];
        boolean[] pathVis = new boolean[v];
        boolean[] check = new boolean[v];
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<v;i++){
            if(!vis[i]){
                isCycle(i,adj,vis,pathVis,check);
            }
        }
        
        for(int i=0;i<v;i++){
            if(check[i]){
                ans.add(i);
            }
        }
        
        return ans;
        
    }
}
