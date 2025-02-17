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
    
    int process(int n,int[] arr){
        if(n<=1){
            return arr[n];
        }
        if(arr[n]!=-1){
            return arr[n];
        }
        arr[n] = process(n-1,arr) + process(n-2,arr);
        return arr[n];
    }
    
    
    public int nthFibonacci(int n) {
        // code here
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);
        arr[0]=0;
        if(n>0){
            arr[1]=1;
        }
        process(n,arr);
        return arr[n];
    }
}