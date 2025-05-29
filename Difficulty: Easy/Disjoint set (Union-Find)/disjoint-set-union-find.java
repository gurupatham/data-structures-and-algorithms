/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        // add code here.
        if(par[x]==x){
            return x;
        }
        return par[x] = find(par,par[x]);
    }

    void unionSet(int par[], int x, int z) {
        // add code here.
        int x_root = find(par,x);
        int z_root = find(par,z);
        if(x_root != z_root){
            par[x_root] = z_root;
        }
    }
}