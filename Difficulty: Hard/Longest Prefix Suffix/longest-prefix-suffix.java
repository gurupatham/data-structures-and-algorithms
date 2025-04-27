//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestPrefixSuffix(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int longestPrefixSuffix(String s) {
        // code here
        int ans=0,i=1,len=0,n=s.length();
        int[] lps = new int[s.length()];
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                lps[i++]=++len;
            }
            else{
                if(len==0){
                    lps[i++]=0;
                }
                else{
                    len = lps[len-1];
                }
            }
        }
        ans = lps[n-1];
        if(ans==n){
            ans = lps[ans-1];
        }
        return ans;
    }
}