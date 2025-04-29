//{ Driver Code Starts
//Initial Template for Java

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
            String str = br.readLine().trim();
            Solution obj = new Solution();
            long ans = obj.findRank(str);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    long fact(int n){
        long ans=1;
        for(int i=1;i<=n;i++){
            ans*=i;
        }
        return ans;
    }
    
    public long findRank(String s) {
        // Code here
        long ans=1,mul = fact(s.length());
        int[] count = new int[256];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        for(int i=1;i<256;i++){
            count[i]+=count[i-1];
        }
        for(int i=0;i<s.length();i++){
            mul = mul/(s.length()-i);
            ans+=(mul*count[s.charAt(i)-1]);
            for(int k=s.charAt(i);k<256;k++){
                count[k]--;
            }
        }
        
        return ans;
    }
}