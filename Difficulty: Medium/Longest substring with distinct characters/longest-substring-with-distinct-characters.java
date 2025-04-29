//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int ans=0;
        HashSet<Character> set = new HashSet<>();
        for(int l=0,r=0;r<s.length();){
            if(set.contains(s.charAt(r))){
                while(l<=r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r++));
            }
            else{
                set.add(s.charAt(r));
                ans = Math.max(ans,r-l+1);
                r++;
            }
        }
        return ans;
    }
}