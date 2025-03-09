//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Pair{
    int x;
    int y;
    int distance;
    
    Pair(int x,int y,int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    
    void process(Deque<Pair> q,int[][] grid,boolean[][] vis,int[][] distance){
        int[] dx = {0,0,1,-1},dy={1,-1,0,0};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int x = pair.x,y=pair.y,dist = pair.distance;
            distance[x][y]=dist;
            for(int i=0;i<dx.length;i++){
                if(isValid(x+dx[i],y+dy[i],grid) && vis[x+dx[i]][y+dy[i]]==false){
                    vis[x+dx[i]][y+dy[i]] = true;
                    q.offer(new Pair(x+dx[i],y+dy[i],dist+1));
                }
            }
        }
    }
    
    boolean isValid(int x,int y,int[][] grid){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
    
    
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int row = grid.length,col=grid[0].length;
        int[][] distance = new int[row][col];
        boolean[][] vis = new boolean[row][col];
        Deque<Pair> q = new ArrayDeque<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        process(q,grid,vis,distance);
        return distance;
        
    }
}