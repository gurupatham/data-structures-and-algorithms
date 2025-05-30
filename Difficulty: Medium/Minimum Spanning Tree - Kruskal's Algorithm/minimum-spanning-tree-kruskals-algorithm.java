// User function Template for Java

class DisjointSet{
    int[] size;
    int[] parent;
    
    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        Arrays.fill(size,1);
    }
    
    public int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
    
    
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u==ulp_v){
            return;
        }
        if(size[ulp_u]<size[ulp_v]){
            size[ulp_v]+=size[ulp_u];
            parent[ulp_u] = ulp_v;
        }
        else{
            size[ulp_u]+=size[ulp_v];
            parent[ulp_v]=ulp_u;
        }
    }
    
    public boolean isCyclic(int u,int v){
        if(findParent(u)==findParent(v)){
            return true;
        }
        unionBySize(u,v);
        return false;
    }
    
    
}

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        DisjointSet dis = new DisjointSet(V);
        int ans=0;
        Arrays.sort(edges,(a,b)-> a[2]-b[2]);
        // System.out.println("arr is "+Arrays.deepToString(edges));
        for(int[] each : edges){
            if(!dis.isCyclic(each[0],each[1])){
                ans+=each[2];
            }
        }
        return ans;
    }
}
