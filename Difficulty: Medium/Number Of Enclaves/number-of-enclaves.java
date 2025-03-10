//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int x,y;
    
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}


class Solution {
    
    int ans;
    int[] dx = {0,0,1,-1},dy={1,-1,0,0};
    
    
    
    void process(Deque<Pair> q,boolean[][] vis,int[][] grid){
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int x = pair.x,y=pair.y;
            for(int i=0;i<dx.length;i++){
                if(isValid(x+dx[i],y+dy[i],grid) && vis[x+dx[i]][y+dy[i]]==false){
                    vis[x+dx[i]][y+dy[i]]=true;
                    q.offer(new Pair(x+dx[i],y+dy[i]));
                }
            }
            
        }
    }
    
    boolean isValid(int x,int y,int[][] grid){
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length){
            return grid[x][y] == 1;
        }
        return false;
    }
    

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int row = grid.length,col=grid[0].length;
        boolean[][] vis = new boolean[row][col];
        Deque<Pair> q = new ArrayDeque<>();
        for(int i=0;i<col;i++){
            if(grid[0][i]==1){
                vis[0][i]=true;
                q.offer(new Pair(0,i));
            }
            if(grid[row-1][i]==1){
                vis[row-1][i]=true;
                q.offer(new Pair(row-1,i));
            }
        }
        
        for(int i=1;i<row;i++){
            if(grid[i][0]==1){
                vis[i][0]=true;
                q.offer(new Pair(i,0));
            }
            if(grid[i][col-1]==1){
                vis[i][col-1]=true;
                q.offer(new Pair(i,col-1));
            }
        }
        
        process(q,vis,grid);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    ans++;
                }
            }
        }
        return ans;
    }
}