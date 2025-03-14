//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
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
    
    public int hashCode(){
        return Objects.hash(this.x,this.y);
    }
    
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(!(o instanceof Pair)){
            return false;
        }
        Pair p = (Pair) o;
        return (p.x==this.x) && (p.y==this.y);
    }
    
}

class Solution {
    
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    void process(List<Pair> list,int[][] grid,boolean[][] vis,Deque<Pair> q ){
        Pair parent = q.peek();
        int parX=parent.x,parY=parent.y;
       while(!q.isEmpty()){
           Pair p = q.poll();
           int x = p.x,y=p.y;
           for(int i=0;i<dx.length;i++){
               if(isValid(x+dx[i],y+dy[i],grid) && vis[x+dx[i]][y+dy[i]] == false){
                   q.offer(new Pair(x+dx[i],y+dy[i]));
                   vis[x+dx[i]][y+dy[i]] = true;
                   list.add(new Pair(x+dx[i]-parX,y+dy[i]-parY));
               }
           }
       }
    }
    
    boolean isValid(int x,int y,int[][] grid){
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length){
            return grid[x][y] ==1;
        }
        return false;
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<List<Pair>> ans = new HashSet<>();
        int row = grid.length,col=grid[0].length;
        boolean[][] vis = new boolean[row][col];
        Deque<Pair> q = new ArrayDeque<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    // System.out.println("hai");
                    List<Pair> list = new ArrayList<>();
                    vis[i][j]=true;
                    q.offer(new Pair(i,j));
                    list.add(new Pair(0,0));
                    process(list,grid,vis,q);
                    ans.add(list);
                }
            }
        }
        return ans.size();
    }
}
