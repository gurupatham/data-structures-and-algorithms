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

    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {

        // Your code here
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<v;i++){
            revAdj.add(new ArrayList<>());
        }
        int[] inDegree = new int[v];
        for(int i=0;i<v;i++){
            for(int each : adj.get(i)){
                revAdj.get(each).add(i);
                inDegree[i]++;
            }
        }
        for(int i=0;i<v;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int vertex = q.poll();
            ans.add(vertex);
            for(int each : revAdj.get(vertex)){
                inDegree[each]--;
                if(inDegree[each]==0){
                    q.offer(each);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
