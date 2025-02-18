//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    
    
    public int nthFibonacci(int n) {
        // code here
        if(n<=1){
            return n;
        }
        int prev=1,prev1=0,ans=0;
        for(int i=2;i<=n;i++){
            ans=prev+prev1;
            prev1=prev;
            prev=ans;
        }
        return ans;
    }
}