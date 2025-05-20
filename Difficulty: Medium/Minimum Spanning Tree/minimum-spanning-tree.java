// User function Template for Java


class Pair{
    int weight;
    int node;
    
    Pair(int weight,int node){
        this.weight = weight;
        this.node = node;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.weight-b.weight);
        int ans=0;
        boolean[] vis = new boolean[V];
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            if(vis[pair.node]){
                continue;
            }
            vis[pair.node]=true;
            ans+=pair.weight;
            for(int[] each : adj.get(pair.node)){
                if(vis[each[0]]){
                    continue;
                }
                pq.offer(new Pair(each[1],each[0]));
            }
        }
        return ans;
    }
}