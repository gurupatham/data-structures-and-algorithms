
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
        if(x==parent[x]){
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }
    
    void unionBySize(int u,int v){
        int ulp_u = getParent(u);
        int ulp_v = getParent(v);
        if(ulp_u==ulp_v){
            return;
        }
        if(size[ulp_u]<size[ulp_v]){
            size[ulp_v]+=size[ulp_u];
            parent[ulp_u]=ulp_v;
        }
        else{
            size[ulp_u]+=size[ulp_v];
            parent[ulp_v]=ulp_u;
        }
    }
    
    boolean isCyclic(int u,int v){
        if(getParent(u)==getParent(v)){
            return true;
        }
        unionBySize(u,v);
        return false;
    }
    
}

class Solution {

    public static class DisjointSet {
		private List<Integer> rank = new ArrayList<>();
		private List<Integer> parent = new ArrayList<>();
		private List<Integer> size = new ArrayList<>();

		public DisjointSet(int n) {
			for (int i = 0; i <= n; i++) {
				this.rank.add(0);
				this.parent.add(i);
				this.size.add(1);
			}
		}

		public int findParent(int u) {
			if (u == parent.get(u)) {
				return u;
			}
			int ulp = findParent(parent.get(u));
			parent.set(u, ulp);
			return parent.get(u);
		}

		public void unionByRank(int u, int v) {
			int ulp_u = findParent(u);
			int ulp_v = findParent(v);
			if (ulp_u == ulp_v) {
				return;
			}
			if (rank.get(ulp_u) < rank.get(ulp_v)) {
				parent.set(ulp_u, ulp_v);
			} else if (rank.get(ulp_v) < rank.get(ulp_u)) {
				parent.set(ulp_v, ulp_u);
			} else {
				parent.set(ulp_v, ulp_u);
				int rankU = rank.get(ulp_u);
				rank.set(ulp_u, rankU + 1);
			}
		}

		public void unionBySize(int u, int v) {
			int ulp_u = findParent(u);
			int ulp_v = findParent(v);
			if (ulp_u == ulp_v) {
				return;
			}
			if (size.get(ulp_u) < size.get(ulp_v)) {
				parent.set(ulp_u, ulp_v);
				size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
			} else {
				parent.set(ulp_v, ulp_u);
				size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
			}
		}
	}

	public int Solve(int n, int[][] edge) {
	    DisjointSet ds = new DisjointSet(n);
		int extraEdges = 0;
		int m = edge.length;
		for (int i = 0; i < m; i++) {
			int u = edge[i][0];
			int v = edge[i][1];
			if (ds.findParent(u) == ds.findParent(v)) {
				extraEdges++;
			} else {
				ds.unionByRank(u, v);
			}
		}
		int numberOfComponents = 0;
		for (int i = 0; i < n; i++) {
			if (ds.findParent(i) == i) {
				numberOfComponents++;
			}
		}
		int ans = numberOfComponents - 1;
		return extraEdges >= ans ? ans : -1;
	}
}