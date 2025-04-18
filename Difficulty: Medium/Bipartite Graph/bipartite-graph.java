//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            S = br.readLine().trim().split(" ");
            int E = Integer.parseInt(S[0]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(adj);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    
    
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int size = adj.size();
        int[] vis = new int[size];
        Arrays.fill(vis,-1);
        vis[0]=0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        
        while(!q.isEmpty()){
            Integer parent = q.poll();
            int parValue = vis[parent];
            int childValue = (parValue==0)?1:0;
            for(int each : adj.get(parent)){
                if(vis[each]==parValue){
                    return false;
                }
                if(vis[each]==-1){
                    vis[each]=childValue;
                    q.offer(each);
                }
            }
            
        }
        return true;
        
    }
}