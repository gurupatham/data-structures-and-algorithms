//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Node{
    int stop;
    int dest;
    int cost;
    
    Node(int stop,int dest,int cost){
        this.stop = stop;
        this.dest = dest;
        this.cost = cost;
    }
}


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] each : flights){
            adj.get(each[0]).add(each);
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0,src,0));
        dis[src]=0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int stop = node.stop;
            int currDest = node.dest;
            int cost = node.cost;
            if((stop+1)>(k+1)){
                continue;
            }
            for(int[] each : adj.get(currDest)){
                if(each[2]+cost < dis[each[1]]){
                    dis[each[1]] = each[2]+cost;
                    q.offer(new Node(stop+1,each[1],each[2]+cost));
                }
            }
        }
        return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];
    }
}