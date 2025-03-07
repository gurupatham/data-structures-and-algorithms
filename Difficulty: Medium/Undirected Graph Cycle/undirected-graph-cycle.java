//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Pair{
    int ele;
    int parent;
    
    Pair(int ele,int parent){
        this.ele = ele;
        this.parent = parent;
    }
    
}


class Solution {
    
    boolean isCycle(int src,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[src]=true;
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(src,-1));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int parent = pair.parent;
            for(int each : adj.get(pair.ele)){
                if(vis[each]==false){
                    vis[each]=true;
                    q.offer(new Pair(each,pair.ele));
                }
                else if(each !=parent){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int count = adj.size();
        // System.out.println("count is "+count);
        boolean[] vis = new boolean[count];
        for(int i=0;i<count;i++){
            if(vis[i] == false && isCycle(i,adj,vis)){
                return true;
            }
        }
        
        return false;
        
    }
}