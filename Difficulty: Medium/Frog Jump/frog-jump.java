//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    
    int process(int[] arr,int idx,int[] dp){
        if(idx==0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int prev = process(arr,idx-1,dp) + Math.abs(arr[idx]-arr[idx-1]);
        int prev1 = Integer.MAX_VALUE;
        if(idx>1){
            prev1=process(arr,idx-2,dp) + Math.abs(arr[idx]-arr[idx-2]);
        }
        return dp[idx]=Math.min(prev,prev1);
    }
    
    int minCost(int[] height) {
        // code here
        
        int[] dp = new int[height.length];
        for(int i=0;i<height.length;i++){
            dp[i]=-1;
        }
        dp[0]=0;
        return process(height,height.length-1,dp);
    }
}

//{ Driver Code Starts.

// } Driver Code Ends