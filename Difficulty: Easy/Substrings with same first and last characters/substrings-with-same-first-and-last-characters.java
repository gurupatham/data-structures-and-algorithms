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
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        // code here
        int[] dict = new int[26];
        for(int i=0;i<s.length();i++){
            dict[s.charAt(i)-'a']++;
        }
        int ans=s.length();
        for(int i=0;i<s.length();i++){
            dict[s.charAt(i)-'a']--;
            ans+=dict[s.charAt(i)-'a'];
        }
        
        return ans;
    }
}