// User function Template for Java


class DisjointSet{
    int[] size;
    int[] parent;
    
    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        
        Arrays.fill(size,1);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    
    int getParent(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=getParent(parent[x]);
    }
    
    void unionBySize(int u,int v){
        int ulp_u = getParent(u);
        int ulp_v = getParent(v);
        
        if(ulp_u==ulp_v){
            return;
        }
        
        if(size[ulp_u] < size[ulp_v]){
            size[ulp_v]+=size[ulp_u];
            parent[ulp_u]=ulp_v;
        }
        else{
            size[ulp_u]+=size[ulp_v];
            parent[ulp_v]=ulp_u;
        }
        
    }
    
    
}

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int ans=0;
        DisjointSet d = new DisjointSet(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j) == 1){
                    d.unionBySize(i,j);
                }
            }
        }
        
        for(int i=0;i<V;i++){
            if(d.parent[i]==i){
                ans++;
            }
        }
        
        
        return ans;
    }
};