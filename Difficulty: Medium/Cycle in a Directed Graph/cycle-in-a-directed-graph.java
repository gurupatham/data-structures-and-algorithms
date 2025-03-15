//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    boolean isCyclic(int start,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] path){
        vis[start] = true;
        path[start] = true;
        for(int each : adj.get(start)){
            if((!vis[each]) && isCyclic(each,adj,vis,path)){
                return true;
            }
            if(path[each]){
                return true;
            }
        }
        path[start]=false;
        return false;
    }
    
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int size = adj.size();
        boolean[] vis = new boolean[size];
        boolean[] path = new boolean[size];
        for(int i=0;i<size;i++){
            if((!vis[i]) && isCyclic(i,adj,vis,path)){
                return true;
            }
        }
        return false;
    }
}