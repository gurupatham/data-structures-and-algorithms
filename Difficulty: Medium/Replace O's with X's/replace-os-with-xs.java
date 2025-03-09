//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            char mat[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S[] = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = S[j].charAt(0);
                }
            }

            Solution ob = new Solution();
            char[][] ans = ob.fill(mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int x;
    int y;
    
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}


class Solution {
    
    static void process(Deque<Pair> q,boolean[][] vis,char[][] mat){
        int[] dx = {0,0,1,-1},dy={1,-1,0,0};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int x = pair.x,y=pair.y;
            for(int i=0;i<dx.length;i++){
                if(isValid(x+dx[i],y+dy[i],mat) && vis[x+dx[i]][y+dy[i]]==false){
                    vis[x+dx[i]][y+dy[i]]=true;
                    q.offer(new Pair(x+dx[i],y+dy[i]));
                }
            }
            
        }
    }
    
    static boolean isValid(int x,int y,char[][] mat){
        if(x>=0 && x<mat.length && y>=0 && y<mat[0].length){
            return mat[x][y]=='O';
        }
        return false;
    }
    
    static char[][] fill(char mat[][]) {
        // code here
        int row = mat.length,col=mat[0].length;
        boolean[][] vis = new boolean[row][col];
        Deque<Pair> q = new ArrayDeque<>();
        for(int i=0;i<col;i++){
            if(mat[0][i]=='O'){
                vis[0][i]=true;
                q.offer(new Pair(0,i));
            }
            if(mat[row-1][i]=='O'){
                vis[row-1][i]=true;
                q.offer(new Pair(row-1,i));
            }
        }
        for(int i=1;i<row;i++){
            if(mat[i][0]=='O'){
                vis[i][0]=true;
                q.offer(new Pair(i,0));
            }
            if(mat[i][col-1]=='O'){
                vis[i][col-1]=true;
                q.offer(new Pair(i,col-1));
            }
        }
        process(q,vis,mat);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]=='O' && vis[i][j]==false){
                    mat[i][j] = 'X';
                }
            }
        }
        
        return mat;
        
    }
}