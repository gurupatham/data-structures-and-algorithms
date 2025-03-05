//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Pair{
    private final int x;
    private final int y;
    
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
}

class Solution {
    
    int[] xOffset = {-1,0,1};
    int[] yOffset = {-1,0,1};
    
    void process(int row,int col,char[][] grid,boolean[][] vis,Deque<Pair> q){
        Pair pair = new Pair(row,col);
        q.offer(pair);
        vis[row][col]=true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.getX();
            int y = p.getY();
            for(int i=0;i<xOffset.length;i++){
                for(int j=0;j<yOffset.length;j++){
                    if(i==1 && j==1){
                        continue;
                    }
                    if(isNeighbour(grid,x+xOffset[i],y+yOffset[j]) && vis[x+xOffset[i]][y+yOffset[j]]==false){
                        vis[x+xOffset[i]][y+yOffset[j]] = true;
                        q.offer(new Pair(x+xOffset[i],y+yOffset[j]));
                    }
                    
                }
            }
        }
        
    }
    
    boolean isNeighbour(char[][] grid,int x,int y){
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length){
            return grid[x][y]=='1';
        }
        return false;
    }
    
    public int numIslands(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length,ans=0;
        boolean[][] vis = new boolean[row][col];
        Deque<Pair> q = new ArrayDeque<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    ans++;
                    process(i,j,grid,vis,q);
                }
            }
        }
        return ans;
        
    }
}