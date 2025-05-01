//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findMaximum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




//User function Template for Java



class Solution {
    int findMaximum(int[] arr) {
        // code here
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(mid==arr.length-1){
                return arr[mid];
            }
            if((arr[mid]>arr[mid+1]) && (mid>0 && arr[mid]>arr[mid-1])){
                return arr[mid];
            }
            if(arr[mid]>arr[mid+1]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return 0;
    }
}