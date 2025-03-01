//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    static void bfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Deque<Integer> q){
        vis[node]=true;
        q.offer(node);
        while(!q.isEmpty()){
            Integer ele = q.poll();
            for(int i=0;i<adj.size();i++){
                if(adj.get(ele).get(i)==1 && vis[i]==false){
                    q.offer(i);
                    vis[i]=true;
                }
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int ans=0;
        boolean[] vis = new boolean[V];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                ans++;
                bfs(i,adj,vis,q);
            }
        }
        return ans;
    }
};