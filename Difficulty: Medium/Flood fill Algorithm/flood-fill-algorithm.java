//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Pair{
    private final int x;
    private final int y;
    
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    int getX(){
        return x;
    }
    
    int getY(){
        return y;
    }
    
}


class Solution {
    
    
    
    void process(Pair src,int newColor,int[][] image,int[][] temp){
         boolean[][] vis = new boolean[image.length][image[0].length];
          Deque<Pair> q = new ArrayDeque<>();
          q.offer(src);
          vis[src.getX()][src.getY()]=true;
          temp[src.getX()][src.getY()] = newColor;
          int original = image[src.getX()][src.getY()];
          int[] dx = {1,0,-1,0};
          int[] dy = {0,1,0,-1};
          while(!q.isEmpty()){
              Pair pair = q.poll();
              int x = pair.getX();
              int y = pair.getY();
              for(int i=0;i<dx.length;i++){
                      if(isNeighbour(x+dx[i],y+dy[i],image,original) && vis[x+dx[i]][y+dy[i]]==false){
                          q.offer(new Pair(x+dx[i],y+dy[i]));
                          vis[x+dx[i]][y+dy[i]]=true;
                          temp[x+dx[i]][y+dy[i]]=newColor;
                      }
              }
              
          }
    }
    
    boolean isNeighbour(int x,int y,int[][] image,int original){
        if(x>=0 && x<image.length && y>=0 && y<image[0].length){
            return image[x][y]==original;
        }
        return false;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int row = image.length,col=image[0].length;
        int[][] temp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                temp[i][j] = image[i][j];
            }
        }
        process(new Pair(sr,sc),newColor,image,temp);
        return temp;
       
        
        
    }
}