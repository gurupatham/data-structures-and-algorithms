//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Static method to find the longest palindromic substring
    static String longestPalindrome(String s) {
        // code here
        int n = s.length(),ans=-1,start=0,end=0;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=0,j=1;j<n;i++,j++){
            if(s.charAt(i)==s.charAt(j)){
                dp[i][j]=1;
            }
        }
        int length=2;
        while(length<n){
            for(int i=0,j=length;j<n;i++,j++){
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j]=1;
                }
            }
            length++;
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(dp[i][j]==1 && ((j-i)>ans)){
                    start=i;
                    end=j;
                    ans=j-i;
                }
            }
        }
        return ans==-1?"":s.substring(start,end+1);
    }
}